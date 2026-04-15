package org.example;

import org.example.domain.system.SystemController;
import org.example.domain.wiseSaying.WiseSayingController;
import org.example.global.Rq;

import java.util.Scanner;

public class App {
    private final Scanner scanner;

    public App() {
        this.scanner = AppContext.scanner;
    }

    public void run () {
        SystemController systemController = AppContext.systemController;
        WiseSayingController wiseSayingController = new WiseSayingController();


        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();
            String actionName = cmd.split("\\?")[0];

            Rq rq = new Rq(cmd);

            switch (actionName) {
                case "등록" -> wiseSayingController.actionWrite();
                case "목록" -> wiseSayingController.actionList(rq);
                case "삭제" -> wiseSayingController.actionDelete(rq);
                case "수정" -> wiseSayingController.actionModify(rq);
                case "종료" -> {
                    systemController.exit();
                    return;
                }
            }
        }
    }
}
