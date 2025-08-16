package com.back;

import java.util.Scanner;

public class App {
        Scanner sc = new Scanner(System.in);
        int lastId = 0,lastIndex=0;
        WiseSaying[] wiseSaying = new WiseSaying[100];

    public void run(){

        System.out.println("== 명언 앱 ==");

        while(true){
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            switch (cmd) {
                case "등록" ->{
                    actionWrite();
                }
                case "목록" ->{
                    actionList();
                }
                case "삭제?id=1" ->{
                    System.out.println("1번 명언이 삭제되었습니다.");
                }case "종료" ->{
                    return;
                }
            }
        }
    }

    public void actionWrite(){

        System.out.print("명언 : ");
        String saying = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = write(saying,author);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(lastId));
    }

    public WiseSaying write(String saying, String author){
        lastId++;
        return wiseSaying[lastIndex++] = new WiseSaying(lastId,saying,author);
    }

    public void actionList(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        WiseSaying[] wiseSayings = findListDesc();

        for(WiseSaying ws : wiseSayings){
            System.out.println("%d / %s / %s".formatted(ws.id,ws.author,ws.saying));
        }
    }

    public WiseSaying[] findListDesc(){

        WiseSaying[] resultList = new WiseSaying[lastIndex];
        int resultListIndex = 0;

        for(int i=lastIndex-1;i>=0;i--){
            resultList[resultListIndex++]=wiseSaying[i];
        }

        return resultList;
    }
}
