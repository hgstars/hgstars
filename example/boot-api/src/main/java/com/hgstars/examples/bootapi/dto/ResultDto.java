package com.hgstars.examples.bootapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by yujindong on 16/12/7.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultDto<T> {
    public int code;
    public String message;
    public T data;


    public ResultDto(T t) {
        this.data = t;
    }

    public ResultDto(T t, ResultCode errorCode) {
        this.data = t;
        this.code = errorCode.code;
        this.message = errorCode.message;
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
