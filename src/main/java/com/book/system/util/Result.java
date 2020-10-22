package com.book.system.util;

import lombok.Data;

/**
 * Author: Vlan
 * Date: 2020/10/22 9:50
 */
@Data
public class Result<T> {

    public Result(boolean success, int code) {
        this.setSuccess(success);
        this.setCode(code);
    }

    public Result(boolean success, int code, T data) {
        this.setSuccess(success);
        this.setCode(code);
        this.setData(data);
    }
    /**
     * 请求是否成功
     * true:成功
     * false：失败
     */
    private boolean success;

    /**
     * 状态码
     * 成功：200
     * 失败：其他
     */
    private int code;

    /**
     * 请求数据的结果
     */
    private T data;


    public static <T> Result<T> success() {
        return new Result<T>(true, 200);
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(true, 200, data);
    }

    public static <T> Result<T> fail(){
        return new Result<>(false,400);
    }

    public static <T> Result<T> fail(T data){
        return new Result<T>(false,400,data);
    }

}
