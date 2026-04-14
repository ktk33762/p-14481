package org.example;

import java.util.Scanner;

public class App {
    private final Scanner scanner;

    public App (Scanner scanner) {
        this.scanner = scanner;
    }

    public void run () {
        int lastId = 0;
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.println("명령) ");
            String cmd = scanner.nextLine().trim();

            switch (cmd) {
                case "등록" -> {
                    System.out.println("명언 : ");
                    String content = scanner.nextLine().trim();

                    System.out.println("작가 : ");
                    String author = scanner.nextLine().trim();

                    lastId++;
                    System.out.printf("%d번 명언이 등록되었습니다.\n", lastId);


                }
                case "종료" -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
            }
        }
    }
}
