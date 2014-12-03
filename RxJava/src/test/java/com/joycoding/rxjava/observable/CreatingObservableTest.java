package com.joycoding.rxjava.observable;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import static org.fest.assertions.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * User: goldfing
 * Date: 12/3/14
 * Time: 10:36 PM
 * To change this template use File | Settings | File Templates.
 */
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
}
