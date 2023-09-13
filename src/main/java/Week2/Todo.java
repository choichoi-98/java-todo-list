package Week2;

import java.util.Date;

public class Todo {
    private String content;
    private StatusEnum status = StatusEnum.PROGRESS;//PROGRESS, DONE
    private Date createAt; //생성일 저장

    public Todo(String input) {
        this.content = input;
        this.createAt = new Date();//생성일 초기화
    }
    public void done(){

        this.status = StatusEnum.DONE;
    }
    public Date getCreatedAt(){
        return createAt;
    }

    public String getContent() {
        return content;
    }

    public StatusEnum getStatus(){
        return status;
    }
}
