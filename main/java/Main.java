import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int lastId = 0,lastIndex=0;
        String saying;
        String author;
        WiseSaying[] wiseSaying = new WiseSaying[100];

        System.out.println("== 명언 앱 ==");

       while(true){
           System.out.print("명령) ");
           String cmd = sc.nextLine();


           switch (cmd) {
               case "등록" ->{
                   System.out.print("명언 : ");
                   saying = sc.nextLine();
                   System.out.print("작가 : ");
                   author = sc.nextLine();
                   lastId++;

                   wiseSaying[lastIndex++] = new WiseSaying(lastId,saying,author);
                   System.out.println("%d번 명언이 등록되었습니다.".formatted(lastId));
               }
               case "목록" ->{
                   System.out.println("번호 / 작가 / 명언");
                   System.out.println("----------------------");
                   for(int i=0;i<lastIndex;i++){
                       WiseSaying ws = wiseSaying[i];
                       System.out.println("%d / %s / %s".formatted(ws.id,ws.author,ws.saying));
                   }
               }
               case "삭제?id=1" ->{
                   System.out.println("1번 명언이 삭제되었습니다.");
               }case "종료" ->{
                   return;
               }
           }
       }
    }
}
