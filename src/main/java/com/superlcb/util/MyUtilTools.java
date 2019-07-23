package com.superlcb.util;

import java.util.stream.Stream;

/***
 * @author: lcb
 * @date: 2019-7-22 19:40
 * Description: 
 */
public class MyUtilTools {
    public static void myPrint(Object[] obs){
        Stream.of(obs).forEach(System.out::println);
    }
}
