package cn.liontalk;

import org.junit.Test;
import org.junit.runner.RunWith;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class BooklabApplicationTests {


	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Test
	public void contextLoads() {
	}


	@Test
	public void testLog(){
		logger.trace("I am trace log.");
		logger.debug("I am debug log.");
		logger.warn("I am warn log.");
		logger.info("I am warn log.");
		logger.error("I am error log.");
		System.out.println("测试LOG结束！");
	}
}
