package Week2;

import java.util.HashMap;

public class TodoManager {
    private int todo_num = 1;
    private HashMap<Integer, String> todo_list = new HashMap<>();

    public void add(String text) {
        todo_list.put(todo_num, text);
        System.out.println("할 일이 추가 되었습니다. ID: " + todo_num);
        todo_num++;
    }

    public void remove(int todo_num) {
        if (todo_list.remove(todo_num) == null) {
            System.out.println("해당 ID의 할 일이 없습니다.");
        } else {
            System.out.println("할 일이 삭제되었습니다. ID: " + todo_num);
        }
    }

    public void select(int todo_num) {
        String getTodo = todo_list.get(todo_num);
        if (getTodo == null) {
            System.out.println("해당 ID의 할 일이 없습니다.");
        } else {
            System.out.println("할 일 ID:" + todo_num + " 내용:" + getTodo);
        }
    }
}