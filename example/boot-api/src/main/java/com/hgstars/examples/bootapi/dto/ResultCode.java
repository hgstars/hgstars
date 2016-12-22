package com.hgstars.examples.bootapi.dto;

/**
 * Created by yujindong on 16/12/7.
 */
public enum ResultCode {
    /*
        错误码规划
            1xxxx 成功相关提示
            2xxxx 用户相关
            5xxxx 系统相关

    */

    SUCCESS(10000, "数据返回成功"),
    SYSTEM_ERROR(50000, "系统错误"),
    USER_NOT_FOUND(11001, "用户不存在");

    public int code;
    public String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
