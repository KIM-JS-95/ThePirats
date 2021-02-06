package com.ThePirats.function;

import com.ThePirats.Entity.businessTimes;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchResponse {

    private static String status;
    //SimpleDateFormat format1 = new SimpleDateFormat( "EE:HH:mm:ss");
    public static String Open(String time, List<String> arr, Long id){

        // 요일 출력
        String day=time.substring(8,10);

        // 23:49
        String times=time.substring(4,9);

        // 스트림 활용할것
        // .forEach(System.out::println);
        try{
            List<String> strStream1 = arr.stream().filter(a ->a.contains("Mon")) //day
                    .map(s -> s.substring(s.length()-7,s.length()-2)).collect(Collectors.toList());



        //open
        //System.out.println(strStream1.get(0));

        int compare = strStream1.get(0).compareTo(times);

       // System.out.println(compare);

        if(compare <=0 ) {
           status = "OPEN";
        }else{
            status ="CLOSE";
        }

        }catch (Exception e){
            return "CLOSE";
        }

        return status;
    }
}
