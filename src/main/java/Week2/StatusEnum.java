package Week2;

public enum StatusEnum {
    DONE("[완료]"),
    PROGRESS("[진행중]");

    private final String status;

    StatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public boolean isDone(){
        return this == DONE;
    }

    public boolean isProgress(){
        return this == PROGRESS;
    }

}
