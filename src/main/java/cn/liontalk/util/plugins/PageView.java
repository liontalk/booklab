package cn.liontalk.util.plugins;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: smile
 * @date: 2017-11-01
 */
public class PageView implements Serializable{
	
	private static final long serialVersionUID = -33585790212387399L;
	
	/**
	 * 默认的当前页的前后margin
	 */
	public static final int DEFAULT_PAGE_MARGIN = 2;
	
	/**
	 * 当前页码
	 */
	private int page = 1;
	
	/**
	 * 每页显示多少条
	 */
	private int pageSize = 10;
	
	/**
	 * 查询总记录数
	 */
	private int total = 0;
	
	/**
	 * 可分多少页
	 */
	private int totalPageCount = 0;
	// 下一页页码
	private int nextPage = 1;
	// 上一页页码
	private int prePage = 1;
	// 是否存在上一页
	private boolean hasPrePage;
	// 是否存在下一页
	private boolean hasNextPage;
	
	public static int defaultPage = 1;
	public static int defaultPageSize = 10;
	
	private Object rows;
	
	public Object getRows() {
		return rows;
	}
	
	public void setRows(Object rows) {
		this.rows = rows;
	}
	
	/**
	 * 分页页码列表 例如: [1,2,3,4,5,null,10] 其中null代表省略号...
	 */
	private transient List<Integer> pageItems;
	
	private transient int pageMargin = DEFAULT_PAGE_MARGIN;
	
	public PageView() {
		super();
	}
	
	public PageView(Integer page, Integer pageSize) {
		super();
		if (pageSize != null && pageSize > 0) {
			this.pageSize = pageSize;
		}
		if (page != null && page > 0) {
			this.page = page;
		}
	}
	
	//
	// public Pager(int currentPage, int pageSize, int totalRowCount) {
	// super();
	// this.currentPage = currentPage;
	// this.pageSize = pageSize;
	// this.totalRowCount = totalRowCount;
	// }
	
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getTotalPageCount() {
		if (total <= 0) {
			totalPageCount = 0;
		} else {
			totalPageCount = total % pageSize == 0 ? total / pageSize : (total / pageSize) + 1;
		}
		return totalPageCount;
	}
	
	public List<Integer> getPageItems() {
		return pageItems;
	}
	
	public void setPageItems(List<Integer> pageItems) {
		this.pageItems = pageItems;
	}
	
	public int getPageMargin() {
		return pageMargin;
	}
	
	public void setPageMargin(int pageMargin) {
		this.pageMargin = pageMargin;
	}
	
	
	public boolean isHasPrePage() {
		if (this.page == 1) {
			return false;
		} else {
			return true;
		}
	}
	
	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}
	
	public boolean isHasNextPage() {
		if (this.page == this.totalPageCount || this.totalPageCount == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	
	public int getNextPage() {
		if (this.page == this.totalPageCount) {
			return this.page;
		}
		
		return this.page + 1;
	}
	
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	
	public int getPrePage() {
		if (this.page > 1) {
			return this.page - 1;
		}
		return 1;
	}
	
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	
	@Override
	public String toString() {
		return "PageView{" +
				"page=" + page +
				", pageSize=" + pageSize +
				", total=" + total +
				", totalPageCount=" + totalPageCount +
				", nextPage=" + nextPage +
				", prePage=" + prePage +
				", hasPrePage=" + hasPrePage +
				", hasNextPage=" + hasNextPage +
				", rows=" + rows +
				", pageItems=" + pageItems +
				", pageMargin=" + pageMargin +
				'}';
	}
}
