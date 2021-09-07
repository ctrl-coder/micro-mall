package com.mall.api;

public enum ErrorCode implements IErrorCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败");

    private long code;
    private String message;

    ErrorCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
