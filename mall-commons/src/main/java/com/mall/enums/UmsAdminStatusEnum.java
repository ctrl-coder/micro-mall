package com.mall.enums;

public enum UmsAdminStatusEnum {
    LOCKED(0),
    ENABLED(1);

    UmsAdminStatusEnum(int status) {
        this.status = status;
    }

    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
