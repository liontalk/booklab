package cn.liontalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@SpringBootApplication

/**
 * 扫描所需要的一些包（包含一些工具类，所在的路径）
 */
@ComponentScan(value = "cn.liontalk")
/**
 * 开启定时任务
 */
//@EnableScheduling
//开启异步执行任务
@EnableAsync
public class BooklabApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooklabApplication.class, args);
	}
}
