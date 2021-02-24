package com.ThePirats.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchResponse {

    private static String status;

    public static String Open(String time, String date, List<String> entityTime, ArrayList entityDate) {

        // SimpleDateFormat format1 = new SimpleDateFormat( "EE:HH:mm:ss");
        // 요일 출력
        String day = time.substring(0, 3);

        System.out.println("day");
        System.out.println(day);

        // 23:49
        String times = time.substring(4, 9);

        System.out.println("times");
        System.out.println(times);




        List<String> strStream1 = entityTime.stream()//.filter(a -> a.contains("Thu")) //day
                .map(s -> s.substring(s.length() - 7, s.length() - 2)).collect(Collectors.toList());

        List<String> strStream2 = entityTime.stream()//.filter(a -> a.contains("Thu")) //day
                .map(s -> s.substring(2, 7)).collect(Collectors.toList());

        int index = entityDate.indexOf(date);

        for (int i = 0; i < strStream1.size(); i++) {
           // if(index==-1) {
                int open = time.compareTo(strStream1.get(i));
                int close = time.compareTo(strStream2.get(i));

                if (open >= 0 && close < 0) {
                    status = "OPEN";
                } else {
                    status = "CLOSE";
                }
//                System.out.println(open);
//                System.out.println(close);
//                System.out.println(status);
//            }else{
//                status="HOLIDAY";
//               // System.out.println(status);
//            }
        }
        return status;
    }
}
