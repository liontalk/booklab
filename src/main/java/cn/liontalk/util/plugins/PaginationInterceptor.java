package cn.liontalk.util.plugins;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: smile
 * @date: 2017-11-01
 */


import cn.liontalk.util.plugins.ReflectHelper;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;

import javax.xml.bind.PropertyException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import java.sql.Connection;

/**
 * Created by smile on 15/03/2017.
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class ,Integer.class}) })
public class PaginationInterceptor implements Interceptor {
	
	
	private static String dialect = null;// 数据库类型
	private static String pageSqlId = ""; // mybaits的数据库xml映射文件中需要拦截的ID(正则匹配)
	
	@Override
	public Object intercept(Invocation ivk) throws Throwable {
		if (ivk.getTarget() instanceof RoutingStatementHandler) {
			RoutingStatementHandler statementHandler = (RoutingStatementHandler) ivk
					.getTarget();
			BaseStatementHandler delegate = (BaseStatementHandler) ReflectHelper
					.getValueByFieldName(statementHandler, "delegate");
			MappedStatement mappedStatement = (MappedStatement) ReflectHelper
					.getValueByFieldName(delegate, "mappedStatement");
			/**
			 * 方法1：通过ＩＤ来区分是否需要分页．.*query.* 方法2：传入的参数是否有page参数，如果有，则分页，
			 */
			// if (mappedStatement.getId().matches(pageSqlId)) { // 拦截需要分页的SQL
			BoundSql boundSql = delegate.getBoundSql();
			Object parameterObject = boundSql.getParameterObject();// 分页SQL<select>中parameterType属性对应的实体参数，即Mapper接口中执行分页方法的参数,该参数不得为空
			if (parameterObject == null) {
				// throw new
				// NullPointerException("boundSql.getParameterObject() is null!");
				return ivk.proceed();
			} else {
				
				PageView pageView = null;
				if (parameterObject instanceof PageView) { // 参数就是Pages实体
					pageView = (PageView) parameterObject;
				} else if (parameterObject instanceof Map) {
					for (Map.Entry entry : (Set<Map.Entry>) ((Map) parameterObject)
							.entrySet()) {
						if (entry.getValue() instanceof PageView) {
							pageView = (PageView) entry.getValue();
							break;
						}
					}
				} else { // 参数为某个实体，该实体拥有Pages属性
					pageView = ReflectHelper.getValueByFieldType(
							parameterObject, PageView.class);
					if (pageView == null) {
						return ivk.proceed();
					}
				}
				if (pageView == null) {
					return ivk.proceed();
				}
				String sql = boundSql.getSql();
				Connection connection = (Connection) ivk.getArgs()[0];
				setPageParameter(sql, connection, mappedStatement, boundSql,
						parameterObject, pageView);
				String pageSql = generatePagesSql(sql, pageView);
				ReflectHelper.setValueByFieldName(boundSql, "sql", pageSql); // 将分页sql语句反射回BoundSql.
			}
			// }
		}
		return ivk.proceed();
	}
	
	/**
	 * setPageParameter(从数据库里查询总的记录数并计算总页数，回写进分页参数<code>PageParameter</code>,这样调用者就可用通过 分页参数<code>PageParameter</code>获得相关信息。)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 * TODO(这里描述这个方法的执行流程 – 可选)
	 * TODO(这里描述这个方法的使用方法 – 可选)
	 * TODO(这里描述这个方法的注意事项 – 可选)
	 *
	 * @Title: setPageParameter
	 * @Description: TODO
	 * @param @param sql
	 * @param @param connection
	 * @param @param mappedStatement
	 * @param @param boundSql
	 * @param @param parameterObject
	 * @param @param pageView
	 * @param @throws SQLException    设定文件
	 * @return void    返回类型
	 * @throws SQLException
	 */
	private void setPageParameter(String sql, Connection connection,
								  MappedStatement mappedStatement, BoundSql boundSql,
								  Object parameterObject, PageView pageView) throws SQLException {
		// 记录总记录数
		PreparedStatement countStmt = null;
		ResultSet rs = null;
		try {
			String countSql = "select count(1) from (" + sql + ") tmp_count"; // 记录统计
			countStmt = connection.prepareStatement(countSql);
			ReflectHelper.setValueByFieldName(boundSql, "sql", countSql);
			DefaultParameterHandler parameterHandler = new DefaultParameterHandler(
					mappedStatement, parameterObject, boundSql);
			parameterHandler.setParameters(countStmt);
			rs = countStmt.executeQuery();
			int count = 0;
			if (rs.next()) {
				count = ((Number) rs.getObject(1)).intValue();
			}
			pageView.setTotal(count);
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				countStmt.close();
			} catch (Exception e) {
			}
		}
		
	}
	
	/**
	 * generatePagesSql(根据数据库方言，生成特定的分页sql)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 * TODO(这里描述这个方法的执行流程 – 可选)
	 * TODO(这里描述这个方法的使用方法 – 可选)
	 * TODO(这里描述这个方法的注意事项 – 可选)
	 *
	 * @Title: generatePagesSql
	 * @Description: TODO
	 * @param @param sql
	 * @param @param page
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	private String generatePagesSql(String sql, PageView page) {
		if (page != null) {
			if ("mysql".equals(dialect)) {
				return buildPageSqlForMysql(sql, page).toString();
			} else if ("oracle".equals(dialect)) {
				return buildPageSqlForOracle(sql, page).toString();
			}
		}
		return sql;
	}
	
	/**
	 * buildPageSqlForMysql(mysql的分页语句)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 * TODO(这里描述这个方法的执行流程 – 可选)
	 * TODO(这里描述这个方法的使用方法 – 可选)
	 * TODO(这里描述这个方法的注意事项 – 可选)
	 *
	 * @Title: buildPageSqlForMysql
	 * @Description: TODO
	 * @param @param sql
	 * @param @param page
	 * @param @return    设定文件
	 * @return StringBuilder    返回类型
	 * @throws
	 */
	public StringBuilder buildPageSqlForMysql(String sql, PageView page) {
		StringBuilder pageSql = new StringBuilder(100);
		String beginrow = String.valueOf((page.getPage() - 1)
				* page.getPageSize());
		pageSql.append(sql);
		pageSql.append(" limit " + beginrow + "," + page.getPageSize());
		return pageSql;
	}
	
	/**
	 * buildPageSqlForOracle(参考hibernate的实现完成oracle的分页)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 * TODO(这里描述这个方法的执行流程 – 可选)
	 * TODO(这里描述这个方法的使用方法 – 可选)
	 * TODO(这里描述这个方法的注意事项 – 可选)
	 *
	 * @Title: buildPageSqlForOracle
	 * @Description: TODO
	 * @param @param sql
	 * @param @param page
	 * @param @return    设定文件
	 * @return StringBuilder    返回类型
	 * @throws
	 */
	public StringBuilder buildPageSqlForOracle(String sql, PageView page) {
		StringBuilder pageSql = new StringBuilder(100);
		String beginrow = String.valueOf((page.getPage() - 1)
				* page.getPageSize());
		String endrow = String.valueOf(page.getPage() * page.getPageSize());
		
		pageSql.append("select * from ( select temp.*, rownum row_id from ( ");
		pageSql.append(sql);
		pageSql.append(" ) temp where rownum <= ").append(endrow);
		pageSql.append(") where row_id > ").append(beginrow);
		return pageSql;
	}
	
	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}
	
	@Override
	public void setProperties(Properties p) {
		dialect = p.getProperty("dialect");
		if (isEmpty(dialect)) {
			try {
				throw new PropertyException(
						"dialectName or dialect property is not found!");
			} catch (PropertyException e) {
				e.printStackTrace();
			}
		}
		pageSqlId = p.getProperty("pageSqlId");// 根据id来区分是否需要分页
		if (isEmpty(pageSqlId)) {
			try {
				throw new PropertyException("pageSqlId property is not found!");
			} catch (PropertyException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * isEmpty(判断变量是否为空)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 * TODO(这里描述这个方法的执行流程 – 可选)
	 * TODO(这里描述这个方法的使用方法 – 可选)
	 * TODO(这里描述这个方法的注意事项 – 可选)
	 *
	 * @Title: isEmpty
	 * @Description: TODO
	 * @param @param s
	 * @param @return    设定文件
	 * @return boolean    返回类型
	 * @throws
	 */
	public boolean isEmpty(String s) {
		if (null == s || "".equals(s) || "".equals(s.trim())
				|| "null".equalsIgnoreCase(s)) {
			return true;
		} else {
			return false;
		}
	}
}
