package enums;

public enum UmsRoleStatusEnum {
    DISABLED(0),
    ENABLED(1);

    UmsRoleStatusEnum(int status) {
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
