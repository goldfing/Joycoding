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
import java.util.concurrent.TimeUnit;

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

    @Test
    public void testCreate() {
        List<String> values = Lists.newArrayList("1", "2", "3");

        Observable<String> observable = creatingObservable.create(values);

        Subscription subscription = observable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String val) {
                System.out.println("onNext : val = " + val);
            }
        });
        subscription.unsubscribe();
    }

    @Test
    public void testDefer() {
        Observable<String> observable1 = creatingObservable.defer();

        // make subscription
        Subscription subscription1 = observable1.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted1");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext1 : s = "+ s);
            }
        });
        System.out.println("subscription1 : "+ subscription1.toString());
        subscription1.unsubscribe();

        // make another subscription
        Subscription subscription2 = observable1.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted2");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext2 : s = "+ s);
            }
        });
        System.out.println("subscription2 : "+ subscription2.toString());
        subscription2.unsubscribe();
    }

    @Test
    public void testRange() {
        int start = 0;
        int count = 10;

        Observable<Integer> observable = creatingObservable.range(start, count);
        Subscription subscription = observable.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext : integer = " + integer);
            }
        });

        subscription.unsubscribe();
    }

    @Test
    public void testInterval() {
        Observable<Long> observable = creatingObservable.interval(2, TimeUnit.SECONDS);
        Subscription subscription = observable.subscribe(new Subscriber<Long>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onNext(Long aLong) {
                System.out.println("onNext : aLong = "+ aLong);
            }
        });

        subscription.unsubscribe();
    }

    @Test
    public void testTimer() {
        Observable<Long> observable = creatingObservable.timer(2, TimeUnit.SECONDS);
        Subscription subscription = observable.subscribe(new Subscriber<Long>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onNext(Long aLong) {
                System.out.println("onNext : aLong = "+ aLong);
            }
        });

        subscription.unsubscribe();
    }

    @Test
    public void testEmpty() {
        Observable<String> observable = creatingObservable.empty();
        Subscription subscription = observable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext : s = " + s);
            }
        });

        subscription.unsubscribe();
    }

    @Test
    public void testError() {
        Observable<String> observable = creatingObservable.error();
        Subscription subscription = observable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError : e = " + e.getMessage());
            }

            @Override
            public void onNext(String s) {
                System.out.print("onNext : s = " + s);
            }
        });
        subscription.unsubscribe();
    }

    @Test
    public void testNever() {
        Observable<String> observable = creatingObservable.never();
        Subscription subscription = observable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError : e = " + e.getMessage());
            }

            @Override
            public void onNext(String s) {
                System.out.print("onNext : s = " + s);
            }
        });
        subscription.unsubscribe();
    }
}
