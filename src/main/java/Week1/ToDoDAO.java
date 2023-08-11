package Week1;

import java.util.HashMap;
import java.util.Scanner;

public class ToDoDAO {
        int id = 1;
        HashMap<Integer, String> hm = new HashMap<>();
    public void add() {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        hm.put(id, text);
        System.out.println("할 일이 추가 되었습니다. ID: " + id);
        id++;
    }

    public void remove(int id) {
         if(hm.remove(id) == null){
             System.out.println("해당 ID의 할 일이 없습니다.");
         } else {
             System.out.println("할 일이 삭제되었습니다. ID: " + id);
         }

    }



    public void select(int id) {
        String getTodo =  hm.get(id);
        if(getTodo == null){
            System.out.println("해당 ID의 할 일이 없습니다.");
        } else{
            System.out.println("할 일 ID:" + id + " 내용:" + getTodo);
        }

    }
}
