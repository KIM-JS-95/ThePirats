package com.ThePirats.function;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class SearchResponseTest {

    private static String status;

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();


        List<String> answer = new ArrayList<>();

        arr.add("1,23:00,Tuesday,13:00,1");
        arr.add("2,18:00,Wednesday,09:00,1");
        arr.add("3,23:00,Thursday,09:00,1");
        arr.add("4,23:00,Friday,09:00,1");



            List<String> strStream1 = arr.stream()//.filter(a -> a.contains("Thu")) //day
                    .map(s -> s.substring(s.length() - 7, s.length() - 2)).collect(Collectors.toList());

            System.out.println("stream");


            for (String i : strStream1) {
                System.out.println(i);
                // System.out.println(i.substring(i.length() - 7, i.length() - 2));
            }


            for (int i = 0; i < strStream1.size(); i++) {

                String times = "09:00";
                int compare = strStream1.get(i).compareTo(times);
               // System.out.println(compare);
//                System.out.println("!!!!!!");
//                System.out.println(strStream1.get(0));

                if (compare <= 0) {
                    status = "OPEN";
                } else {
                    status = "CLOSE";
                }

                System.out.println(status);
                answer.add(status);

            }


//            catch(Exception e){
//                System.out.println("occurred bug");
//            }



    }
}

