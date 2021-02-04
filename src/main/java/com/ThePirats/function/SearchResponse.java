package com.ThePirats.function;

import com.ThePirats.Entity.businessTimes;

import java.util.List;
import java.util.stream.Stream;

public class SearchResponse {

    //SimpleDateFormat format1 = new SimpleDateFormat( "EE:HH:mm:ss");
    public static String Open(String time, List<String> arr, Long id){

        //스트림 활용할것
        Stream<String> strStream1 = arr.stream();

        strStream1.filter(a ->a.contains("Thu") ).forEach(System.out::println);





        return "gogo";
    }
}
