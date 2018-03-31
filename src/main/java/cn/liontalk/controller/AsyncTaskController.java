package cn.liontalk.controller;

import cn.liontalk.task.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @author: 周哲
 * @package: cn.liontalk.controller
 * @description:  异步执行任务测试
 * @date: 2018/3/31 15:54
 * @version: V1.0
 */
@RestController
@RequestMapping(value = "/async")
public class AsyncTaskController {


    @Autowired
    private AsyncTask asyncTask;


    @RequestMapping(value = "/task")
    public String  asyncTaskDemo() throws InterruptedException {
        long start = System.currentTimeMillis();
        Future <Boolean> one = asyncTask.taskOne();
        Future <Boolean> two = asyncTask.taskTwo();
        Future <Boolean> three = asyncTask.taskThree();
        long end = System.currentTimeMillis();

        while (!one.isDone() || !two.isDone() || !three.isDone()) {
            if (one.isDone() && two.isDone() && three.isDone()) {
                break;
            }
        }
        System.out.println("任务结束花费时间：" + (end - start));
        return String.valueOf(end-start);
    }


}
