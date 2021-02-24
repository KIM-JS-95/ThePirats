package com.ThePirats.function;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResponse {

    private static String status;

    public static String Open(String time, List<String> arr) {

        // SimpleDateFormat format1 = new SimpleDateFormat( "EE:HH:mm:ss");
        // 요일 출력
        String day = time.substring(0, 3);

        System.out.println("day");
        System.out.println(day);

        // 23:49
        String times = time.substring(4, 9);

        System.out.println("times");
        System.out.println(times);


        List<String> strStream1 = arr.stream()//.filter(a -> a.contains("Thu")) //day
                .map(s -> s.substring(s.length() - 7, s.length() - 2)).collect(Collectors.toList());



        for (int i = 0; i < strStream1.size(); i++) {
            int compare = strStream1.get(i).compareTo(times);

            if (compare <= 0) {
                status = "OPEN";
            } else {
                status = "CLOSE";
            }
        }
        return status;
    }
}
