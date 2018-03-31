package cn.liontalk.task;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @author: 周哲
 * @package: cn.liontalk.task
 * @description:
 * @date: 2018/3/31 15:33
 * @version: V1.0
 */
@Component
public class TaskTest {

    private static final SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 定义每5秒执行一次任务
     */
    @Scheduled(fixedRate=5000)
    public void sayHello(){
        System.out.println("当前时间是："+simple.format(new Date()));
    }
}
