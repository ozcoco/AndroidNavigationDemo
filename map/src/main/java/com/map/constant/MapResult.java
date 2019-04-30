package com.map.constant;

public enum MapResult {

    Success(0, "success"),
    Fail(1, "fail");

    public final int code;
    public final String msg;

    MapResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
