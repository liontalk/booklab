package cn.liontalk.util.exception;

import java.text.MessageFormat;

/**
 * @author: 周哲
 * @package: cn.liontalk.util.exception
 * @description: 自定义异常
 * @date: 2018/3/27 21:29
 * @version: V1.0
 */
public class MyException extends RuntimeException {

    private String exceptionCode;

    private String exceptionMsg;


    public MyException(String message) {
        super(message);
    }

    public MyException(Throwable cause) {
        super(cause);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }


}
