package Week2;

import java.util.*;

public class TodoManager {
    StatusEnum status;
    private int todo_num = 1;
    private HashMap<Integer, Todo> todo_list = new HashMap<>();

    public void add(String text) {
        Todo todo = new Todo(text);
        todo_list.put(todo_num,todo);
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
        String getTodo = String.valueOf(todo_list.get(todo_num));
        if(todo_list.get(todo_num)==null){
            System.out.println("해당 ID의 할 일이 없습니다.");
        }else{
            System.out.println("할 일 ID:" + todo_num + " 내용:" + getTodo);
        }


    }

    public int done(int todo_num) {
        Todo todo = todo_list.get(todo_num);

        if (todo == null) {
            System.out.println("해당 ID의 할 일이 없습니다.");
        } else {
            if (todo.getStatus().isProgress()) {
                todo_list.get(todo_num).done();
                System.out.println("할 일 ID:" + todo_num + "를 완료 처리했습니다.");
            } else if (todo.getStatus().isDone()) {
                System.out.println("이미 완료한 할 일 입니다.");
            }
        }

        return todo_num;
    }

    public void selectList() {
        if (!todo_list.isEmpty()) {
            Set<Map.Entry<Integer, Todo>> todo_list_all = todo_list.entrySet();
            System.out.println("ID     할 일 ");
            for (Map.Entry<Integer, Todo> todo_list_all1 : todo_list_all) {
                int key = todo_list_all1.getKey();
                Todo value = todo_list_all1.getValue();
                String status = value.getStatus().getStatus();
                String content = value.getContent();

                System.out.println(key + "   " + content + status);
            }
        } else {
            System.out.print("할 일이 없습니다.");
        }
    }


    public void sortByOldest() {
        List<Map.Entry<Integer, Todo>> entries = new ArrayList<>(todo_list.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<Integer, Todo>>() {
            @Override
            public int compare(Map.Entry<Integer, Todo> entry1, Map.Entry<Integer, Todo> entry2) {
                return entry1.getValue().getCreatedAt().compareTo(entry2.getValue().getCreatedAt());
            }
        });

        LinkedHashMap<Integer, Todo> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Todo> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        todo_list = sortedMap;

        // 정렬된 결과를 출력
        System.out.println("오래된 순으로 정렬된 할 일 목록:");
        for (Map.Entry<Integer, Todo> entry : todo_list.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", 할 일: " + entry.getValue().getContent());
        }
    }

    // 최신 순으로 정렬
    public void sortByNewest() {
        List<Map.Entry<Integer, Todo>> entries = new ArrayList<>(todo_list.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<Integer, Todo>>() {
            @Override
            public int compare(Map.Entry<Integer, Todo> entry1, Map.Entry<Integer, Todo> entry2) {
                return entry2.getValue().getCreatedAt().compareTo(entry1.getValue().getCreatedAt());
            }
        });

        LinkedHashMap<Integer, Todo> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Todo> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        todo_list = sortedMap;

        // 정렬된 결과를 출력
        System.out.println("최신 순으로 정렬된 할 일 목록:");
        for (Map.Entry<Integer, Todo> entry : todo_list.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", 할 일: " + entry.getValue().getContent());
        }
    }

    public void search(String keyword) {
        boolean found = false;

        for(Map.Entry<Integer,Todo> entry : todo_list.entrySet()){
            int key = entry.getKey();
            Todo value = entry.getValue();

            if(value.getContent().contains(keyword)){
                String status = value.getStatus().getStatus();
                System.out.println("ID: " + key + ", 할 일 : " + value.getContent() + status);
                found = true;
            }

            if(!found){
                System.out.println("검색 결과가 없습니다.");
            }
        }
    }
}
