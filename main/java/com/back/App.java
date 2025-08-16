package com.back;

import java.util.*;

public class App {
        private Scanner sc = new Scanner(System.in);
        private int lastId = 0;
        private List<WiseSaying> wiseSayings = new ArrayList<>();
        private Map<String , String> paramMap = new HashMap<>();

    public void run(){

        System.out.println("== 명언 앱 ==");

        while(true){
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            Rq rq = new Rq(cmd);
            String actionName = rq.getActionName();
            if (actionName.equals("등록")) {
                actionWrite();
            } else if (actionName.equals("목록")) {
                actionList();
            } else if (actionName.startsWith("삭제")) {
                actionDelete(rq);
            } else if (actionName.startsWith("수정")) {
                actionModify(rq);
            } else if (actionName.equals("종료")) {
                return;
            }
        }
    }

    private void actionModify(Rq rq) {


        int id = rq.getParamAsInt("id",-1);
        WiseSaying wiseSaying  = findByIdOrNull(id);

        if(wiseSaying == null){
            System.out.println("%d 명언은 존재하지 않습니다.".formatted(id));
            return;
        }


        System.out.println("명언(기존) : %s".formatted(wiseSaying.getSaying()));
        System.out.print("명언 :");
        String newSaying = sc.nextLine();
        System.out.println("작가(기존) : %s".formatted(wiseSaying.getAuthor()));
        System.out.print("작가 :");
        String newAuthor = sc.nextLine();

        modify(wiseSaying,newSaying,newAuthor);
    }

    private void modify(WiseSaying wiseSaying, String newSaying, String newAuthor) {
        wiseSaying.setSaying(newSaying);
        wiseSaying.setAuthor(newAuthor);
    }

    private WiseSaying findByIdOrNull(int id){
        return wiseSayings.stream()
                .filter(wiseSaying -> wiseSaying.getId() == id)
                .findFirst()
                .orElse(null);
    }

//    private int findIndexById(int id){
//        return IntStream.range(0, wiseSayings.size())
//                .filter(i -> wiseSayings.get(i).getId() == id)
//                .findFirst()
//                .orElse(-1);
//
//    }

    private void actionDelete(Rq rq) {

        int id =   rq.getParamAsInt("id",-1);
        boolean result = delete(id);

        if(result){
            System.out.println("1번 명언이 삭제되었습니다.");
        }
        else{
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
        }
    }

    private boolean delete(int id){
        //for문으로 break를 거는게 성능은 더좋다
        //removeIf를 사용하는 이유는 가독성 때문
        return wiseSayings.removeIf(w -> w.getId() == id);
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
        WiseSaying wiseSaying = new WiseSaying(lastId,saying,author);
        wiseSayings.add(wiseSaying);
        return wiseSaying;
    }

    private void actionList(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        List<WiseSaying> wiseSayings = findListDesc();

        for(WiseSaying wiseSaying : wiseSayings){
            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(),wiseSaying.getAuthor(),wiseSaying.getSaying()));
        }
    }

    private List<WiseSaying> findListDesc(){

        return wiseSayings.reversed();
    }
}
