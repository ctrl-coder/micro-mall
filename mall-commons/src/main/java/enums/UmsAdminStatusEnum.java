package enums;

public enum UmsAdminStatusEnum {
    LOCK(0),
    ENABLE(1);

    private UmsAdminStatusEnum(int status) {
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
