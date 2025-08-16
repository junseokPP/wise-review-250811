package com.back.domain.wiseSaying;

import com.back.domain.wiseSaying.controller.SystemController;
import com.back.domain.wiseSaying.controller.WiseSayingController;

import java.util.*;

public class App {
        private Scanner sc = new Scanner(System.in);

        private Map<String , String> paramMap = new HashMap<>();
        private SystemController systemController = new SystemController();
        private WiseSayingController wiseSayingController = new WiseSayingController(sc);

    public void run(){

        System.out.println("== 명언 앱 ==");

        while(true){
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            Rq rq = new Rq(cmd);
            String actionName = rq.getActionName();
            if (actionName.equals("등록")) {
                wiseSayingController.actionWrite();
            } else if (actionName.equals("목록")) {
                wiseSayingController.actionList();
            } else if (actionName.startsWith("삭제")) {
                wiseSayingController.actionDelete(rq);
            } else if (actionName.startsWith("수정")) {
                wiseSayingController.actionModify(rq);
            } else if (actionName.equals("종료")) {
                systemController.exit();
                return;
            }
        }
    }


}
