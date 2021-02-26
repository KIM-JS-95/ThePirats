package com.ThePirats.function;


import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class SearchResponseTest {

    private static String status;

    public static void main(String[] args) {

        List<String> arr = new ArrayList<>();
        arr.add("1,23:00,Tuesday,13:00,1");
        arr.add("2,18:00,Wednesday,09:00,1");
        arr.add("3,23:00,Thursday,09:00,1");
        arr.add("4,23:00,Friday,09:00,1");


        List<String> strStream1 = arr.stream()//.filter(a -> a.contains("Thu")) //day
                    .map(s -> s.substring(s.length() - 7, s.length() - 2)).collect(Collectors.toList());

        List<String> strStream2 = arr.stream()//.filter(a -> a.contains("Thu")) //day
                .map(s -> s.substring(2, 7)).collect(Collectors.toList());

//            System.out.println("stream");
//            for (String i : strStream2) {
//                System.out.println(i);
//                // System.out.println(i.substring(i.length() - 7, i.length() - 2));
//            }


        String t1 = "17:00"; //now
        String date = "2021-02-26";

//        System.out.println(t1.compareTo(t2)); //open
//       System.out.println(t1.compareTo(t3)); //close
//        System.out.println(times1.compareTo(times3)); //close

        String[] holidays={"2021-01-21", "2021-01-22"};

        int index = Arrays.binarySearch(holidays,date);

        //System.out.println(index);


            for (int i = 0; i < strStream1.size(); i++) {
                if(index<0) {
                int open = t1.compareTo(strStream1.get(i));
                int close = t1.compareTo(strStream2.get(i));
//휴가 넣어야함
                if (open >= 0 && close < 0) {
                    status = "OPEN";
                } else {
                    status = "CLOSE";
                }
                System.out.println(open);
                System.out.println(close);
                System.out.println(status);
            }else{
                    status="HOLIDAY";
                    System.out.println(status);
                }
        }
    }
}

