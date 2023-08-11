package Week1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        ToDoDAO td = new ToDoDAO();

        Scanner sc = new Scanner(System.in);
        int num;

        do{
            System.out.println("옵션을 선택하세요:1.추가, 2.삭제, 3.조회, 4.종료");
            num = sc.nextInt();

            switch (num){
                case 1: System.out.print("추가할 일을 입력하세요:  ");
                td.add();
                break;
                case 2: System.out.print("삭제할 일의 ID를 입력하세요:");
                td.remove(sc.nextInt());
                break;
                case 3: System.out.print("조회할 할 일의 ID를 입력하세요:");
                td.select(sc.nextInt());
                break;
                case 4: System.out.print("종료");
                break;
                default: System.out.print("잘못된 입력입니다.");
            }

        }while(num != 4);

    }
}
