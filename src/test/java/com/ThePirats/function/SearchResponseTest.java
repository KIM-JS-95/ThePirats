package com.ThePirats.function;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class SearchResponseTest  {
public static void main(String[] args) {
    List<String> arr = new ArrayList();
    arr.add("1,23:00,Tuesday,13:00,1");
    arr.add("2,18:00,Wednesday,09:00,1");
    arr.add("3,23:00,Thursday,09:00,1");
    arr.add("4,23:00,Friday,09:00,1");

    List<String> strStream1 = arr.stream().filter(a -> a.contains("Thu")) //day
                    .map(s -> s.substring(s.length()-7,s.length()-2)).collect(Collectors.toList());


    String compare = strStream1.get(0);
    System.out.println(compare);

    System.out.println("stream");
    for (String i :  strStream1) {
        System.out.println(i);
       // System.out.println(i.substring(i.length() - 7, i.length() - 2));
    }
}
}