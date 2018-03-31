package cn.liontalk.task;

import com.sun.org.apache.xalan.internal.utils.FeatureManager;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author: 周哲
 * @package: cn.liontalk.task
 * @description:
 * @date: 2018/3/31 15:48
 * @version: V1.0
 */
@Component
public class AsyncTask {


    @Async
    public Future<Boolean> taskOne() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("任务执行时间是："+(end-start));
        return new AsyncResult <>(true);
    }


    @Async
    public Future<Boolean> taskTwo() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(700);
        long end = System.currentTimeMillis();
        System.out.println("任务执行时间是："+(end-start));
        return new AsyncResult <>(true);
    }


    @Async
    public Future<Boolean> taskThree() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(600);
        long end = System.currentTimeMillis();
        System.out.println("任务执行时间是："+(end-start));
        return new AsyncResult <>(true);
    }


}
