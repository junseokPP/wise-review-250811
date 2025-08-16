package com.back;

import java.util.Scanner;

public class App {
        private Scanner sc = new Scanner(System.in);
        private int lastId = 0,lastIndex=0;
        private WiseSaying[] wiseSayings = new WiseSaying[100];

    public void run(){

        System.out.println("== 명언 앱 ==");

        while(true){
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if (cmd.equals("등록")) {
                actionWrite();
            } else if (cmd.equals("목록")) {
                actionList();
            } else if (cmd.startsWith("삭제")) {        // "삭제" 또는 "삭제?id=1" 모두 허용
                actionDelete(cmd);
            } else if (cmd.startsWith("수정")) {
                actionModify(cmd);
            } else if (cmd.equals("종료")) {
                return;
            }
        }
    }

    private void actionModify(String cmd) {
        String[] commandBits = cmd.split("=");

        if(commandBits.length < 2){
            System.out.println("번호를 입력해주세요.");
            return;
        }

        String idStr = commandBits[1];
        int id = Integer.parseInt(idStr);

        int modifyTargetIndex = findIndexById(id);

        if(modifyTargetIndex == -1){
            System.out.println("%d 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

        WiseSaying modifyTargetWiseSaying = wiseSayings[modifyTargetIndex];


        System.out.println("명언(기존) : %s".formatted(modifyTargetWiseSaying.getSaying()));
        System.out.print("명언 :");
        String newSaying = sc.nextLine();
        System.out.println("작가(기존) : %s".formatted(modifyTargetWiseSaying.getAuthor()));
        System.out.print("작가 :");
        String newAuthor = sc.nextLine();

        modify(modifyTargetWiseSaying,newSaying,newAuthor);
    }

    private void modify(WiseSaying modifyTargetWiseSaying, String newSaying, String newAuthor) {
        modifyTargetWiseSaying.setSaying(newSaying);
        modifyTargetWiseSaying.setAuthor(newAuthor);
    }

    private int findIndexById(int id){

        for(int i = 0; i < lastIndex; i++){
            if(wiseSayings[i].getId() == id){
                return i;
            }
        }

        return -1;
    }

    private void actionDelete(String cmd) {

        String[] commandBits = cmd.split("=");

        if(commandBits.length < 2){
            System.out.println("번호를 입력해주세요.");
            return;
        }

        String idStr = commandBits[1];
        int id = Integer.parseInt(idStr);

        boolean result = delete(id);

        if(result){
            System.out.println("1번 명언이 삭제되었습니다.");
        }
        else{
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
        }
    }

    private boolean delete(int id){

        int deleteTargetIndex = findIndexById(id);

        if(deleteTargetIndex == -1){
            return false;
        }

        for(int i = deleteTargetIndex; i < lastIndex; i++){
            wiseSayings[i] = wiseSayings[i+1];
        }

        lastIndex--;
        return true;
    }

    private void actionWrite(){

        System.out.print("명언 : ");
        String saying = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = write(saying,author);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
    }

    private WiseSaying write(String saying, String author){
        lastId++;
        return wiseSayings[lastIndex++] = new WiseSaying(lastId,saying,author);
    }

    private void actionList(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        WiseSaying[] wiseSayings = findListDesc();

        for(WiseSaying wiseSaying : wiseSayings){
            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(),wiseSaying.getAuthor(),wiseSaying.getSaying()));
        }
    }

    private WiseSaying[] findListDesc(){

        WiseSaying[] resultList = new WiseSaying[lastIndex];
        int resultListIndex = 0;

        for(int i=lastIndex-1;i>=0;i--){
            resultList[resultListIndex++]=wiseSayings[i];
        }

        return resultList;
    }
}
