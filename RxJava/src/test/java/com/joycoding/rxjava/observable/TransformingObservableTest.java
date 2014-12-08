package com.joycoding.rxjava.observable;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;
import rx.functions.Func1;

import java.util.List;


public class TransformingObservableTest {

    private TransformingObservable tfObservable;
    List<Integer> values;

    @Before
    public void setup() {
        tfObservable = new TransformingObservable();
        values = Lists.newArrayList(1, 2, 3, 4, 5);
    }

    @Test
    public void testMap() throws Exception {
        Func1<Integer, Integer> func1 = (o) -> {
            return o * o;
        };

        Observable<Integer> observable = tfObservable.map(values, func1);

        observable.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext : result = " + integer);
            }
        });
    }

    @Test
    public void testFlatMap() {
        Func1<Integer, Observable<Integer>> onNext = (o) -> {
            return Observable.from(Lists.newArrayList(o * 2, o * 3));
        };

        Func1<Integer, String> onError = (o) -> {
            return "Error!";
        };

        Func0<String> onCompleted = () -> {
            System.out.println("onCompleted1");
            return "onCompleted";
        };

        tfObservable.flatMap(values, onNext, onError, onCompleted).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted2");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext : result="+integer);
            }
        });
    }

    @Test
    public void testConcatMap() {
        Func1<Integer, Observable<Integer>> func1 = (o) -> {
            return Observable.from(o +1, o+2, o+3);
        };

        tfObservable.concatMap(values, func1).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext : result="+integer);
            }
        });
    }
}
