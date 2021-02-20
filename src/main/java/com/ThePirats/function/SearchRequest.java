package com.ThePirats.function;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SearchRequest {

     public static String nowTime() {
         //"yyyy-MM-dd HH:mm:ss"
        SimpleDateFormat format1 = new SimpleDateFormat( "EE:HH:mm:ss", new Locale("en", "US"));
        Date time = new Date();
        String time1 = format1.format(time);

        // print now time and we
        System.out.println(time1);
        return time1;
    }

}
