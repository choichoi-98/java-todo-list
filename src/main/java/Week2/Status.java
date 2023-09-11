package Week2;

public enum Status {
    COMPLETE("[완료]"),
    IMCOMPLETE("[미완료]");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
