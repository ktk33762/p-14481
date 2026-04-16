package org.example;

import org.example.domain.system.SystemController;
import org.example.domain.wiseSaying.WiseSayingController;
import org.example.domain.wiseSaying.WiseSayingFileRepository;
import org.example.domain.wiseSaying.WiseSayingRepository;
import org.example.domain.wiseSaying.WiseSayingService;

import java.util.Scanner;

public class AppContext {
    public static Scanner scanner;
    public static SystemController systemController;
    public static WiseSayingFileRepository wiseSayingFileRepository;
    public static WiseSayingController wiseSayingController;
    public static WiseSayingService wiseSayingService;
    public static WiseSayingRepository wiseSayingRepository;

    public static void renew (Scanner _scanner) {
        scanner = _scanner;
        systemController = new SystemController();
        wiseSayingRepository = new WiseSayingRepository();
        wiseSayingRepository = new WiseSayingRepository();
        wiseSayingService = new WiseSayingService();
        wiseSayingController = new WiseSayingController();
    }

    public static void renew () {
        renew(new Scanner(System.in));
    }
}
