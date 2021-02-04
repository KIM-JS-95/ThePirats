package com.ThePirats.function;

import com.ThePirats.Entity.businessTimes;

import java.util.List;
import java.util.stream.Stream;

public class SearchResponse {

    //SimpleDateFormat format1 = new SimpleDateFormat( "EE:HH:mm:ss");
    public static String Open(String time, List<String> arr, Long id){

        // 요일 출력
        String day=time.substring(8,10);

        // 23:49
        String times=time.substring(4,9);

        // 스트림 활용할것
        // .forEach(System.out::println);
        Stream<String> strStream1 = arr.stream().filter(a ->a.contains("Thu"))
                .map(s -> s.substring(s.length()-6,s.length()-2));
        strStream1
                .map( if(strStream1)).forEach(System.out::println);







        return "gogo";
    }
}
