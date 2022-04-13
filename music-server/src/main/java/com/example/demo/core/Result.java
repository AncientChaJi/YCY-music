package com.example.demo.core;

import org.apache.commons.lang3.ObjectUtils;

import java.util.HashMap;

public class Result extends HashMap<String, Object> {

    private static final String CODE = "code";
    private static final String MSG = "msg";
    private static final String DATA = "data";

    public Result() {
    }

    public Result(int code, String msg) {
        super.put(CODE, code);
        super.put(MSG, msg);
    }

    public Result(int code, String mag, Object data) {
        super.put(CODE, code);
        super.put(MSG, mag);
        if (ObjectUtils.isNotEmpty(data)) {
            super.put(DATA, data);
        }
    }

    public static Result success() {
        return Result.success("操作成功");
    }

    public static Result success(Object data) {
        return Result.success("操作成功", data);
    }


    public static Result success(String msg) {
        return Result.success(msg, null);
    }

    public static Result success(String msg, Object data) {
        return new Result(200, msg, data);
    }

    public static Result error() {
        return Result.error("操作失败");
    }

    public static Result error(String msg) {
        return Result.error(msg, null);
    }

    public static Result error(String msg, Object data) {
        return new Result(500, msg, data);
    }

    public static Result error(int code, String msg) {
        return new Result(code, msg, null);
    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
