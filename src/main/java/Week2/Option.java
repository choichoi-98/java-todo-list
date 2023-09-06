package Week2;

public enum Option {
    ADD("1"),
    DONE("2"),
    REMOVE("3"),
    SELECT("4"),
    QUIT("5"),
    INVALID("");

    private final String value;

    Option(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public static Option fromValue(String value){
        for(Option option : Option.values()){
            if(option.value.equals(value)){
                return option;
            }
        }
        return INVALID;
    }
}
