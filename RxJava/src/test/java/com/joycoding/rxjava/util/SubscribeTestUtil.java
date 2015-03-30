package com.joycoding.rxjava.util;

public class SubscribeTestUtil {

    public static void printCompleted() {
        System.out.println("onCompleted");
    }

    public static void printOnNext(Object obj) {
        System.out.println("onNext : result = " + String.valueOf(obj));
    }

    public static void printOnError(Throwable e) {
        System.out.println("onError : message = "+ e.getMessage());
    }
}
