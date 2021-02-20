package com.ThePirats.function;

import com.ThePirats.Entity.businessTimes;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchResponse {

    private static String status;

    public static String Open(String time, List<String> arr, Long id){

       // SimpleDateFormat format1 = new SimpleDateFormat( "EE:HH:mm:ss");
        // 요일 출력
        String day=time.substring(0,3);

        System.out.println("day");
        System.out.println(day);

        // 23:49
        String times=time.substring(4,9);

        System.out.println("times");
        System.out.println(times);

        try{
            List<String> strStream1 = arr.stream().filter(a ->a.contains(day)) //day
                    .map(s -> s.substring(s.length()-7,s.length()-2)).collect(Collectors.toList());

            System.out.println("stream");
            for (String i : arr)
                System.out.println(i);

        int compare = strStream1.get(0).compareTo(times);

            System.out.println("compare");
        System.out.println(compare);

        if(compare <=0 ) {
           status = "OPEN";
        }else{
            status ="CLOSE";
        }

        }catch (Exception e){
            return "occurred bug";
        }

        return status;
    }
}
