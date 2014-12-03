package com.joycoding.rxjava.observable;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;

import java.util.List;

import static org.fest.assertions.Assertions.*;

@Slf4j
public class CreatingObservableTest {

    private CreatingObservable creatingObservable;
    @Before
    public void setUp() throws Exception {
        creatingObservable = new CreatingObservable();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testJust() throws Exception {
        String val = "test";
        Observable<String> observable = creatingObservable.just(val);

        Subscription subscription = observable.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                log.info("call onCompleted...");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                log.info("call onNext...");
                assertThat(s).isEqualTo(val);
            }
        });

        subscription.unsubscribe();;
    }

    @Test
    public void testFrom() throws Exception {
        List<String> values = Lists.newArrayList("1", "2", "3");
        Observable<String> observable = creatingObservable.from(values);

        Subscription subscription = observable.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                log.info("call onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                log.info("Element is {}", s);
                System.out.println("Element is "+ s);
                assertThat(s).isIn(values);
            }
        });

        subscription.unsubscribe();
    }

    @Test
    public void testRepeat() {
        long count = 5L;
        String val = "value";

        Observable<String> observable = creatingObservable.repeat(val, count);
        Subscription subscription = observable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                log.info("call onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                log.info("Element is {}", s);
                assertThat(s).isEqualTo(val);
            }
        });

        subscription.unsubscribe();
    }
}
