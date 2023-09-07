package Week2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TodoManager {
    Status status;
    private int todo_num = 1;
    private HashMap<Integer, String> todo_list = new HashMap<>();

    public void add(String text) {
        todo_list.put(todo_num, text );
        System.out.println("할 일이 추가 되었습니다. ID: " + todo_num );
        todo_num++;
    }

    public void remove(int todo_num) {
        if (todo_list.containsKey(todo_num)) {
            todo_list.remove(todo_num);
            System.out.println("할 일이 삭제되었습니다. ID: " + todo_num);
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }

    }

    public void select(int todo_num) {
        String getTodo = todo_list.getOrDefault(todo_num, "해당 ID의 할 일이 없습니다.");

            System.out.println("할 일 ID:" + todo_num + " 내용:" + getTodo);

    }

    public void done(int todo_num) {
        String todo = todo_list.get(todo_num); //기존의 키의 값(할 일)
        if(todo != null){
            String todo_done = todo + "[완료]";// 수정된 키의 값 (할 일 [완료])
            todo_list.put(todo_num, todo_done); //수정된 값 저장
        } else{
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }

    public void selectList() {


        if(!todo_list.isEmpty()){
            Set< Map.Entry<Integer,String>> todo_list_all = todo_list.entrySet();
            System.out.println("ID     할 일 ");
            for(Map.Entry<Integer,String> todo_list_all1 : todo_list_all){
                int key = todo_list_all1.getKey();
                String value = todo_list_all1.getValue();

                System.out.println(key + "   " + value);
            }
        }else{
            System.out.print("할 일이 없습니다.");
        }

    }
}
