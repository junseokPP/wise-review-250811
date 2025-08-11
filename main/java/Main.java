import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lastId = 0;
        System.out.println("== 명언 앱 ==");


       while(true){
           System.out.print("명령) ");
           String cmd = sc.nextLine();

           switch (cmd) {
               case "등록" ->{
                   System.out.print("명언 : ");
                   sc.nextLine();
                   System.out.print("작가 : ");
                   sc.nextLine();
                   lastId++;
                   System.out.println("%d번 명언이 등록되었습니다.".formatted(lastId));
               }
               case "종료" ->{
                   return;
               }
           }
       }
    }
}
