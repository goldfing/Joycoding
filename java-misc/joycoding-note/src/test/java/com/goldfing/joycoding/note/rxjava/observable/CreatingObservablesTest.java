package com.goldfing.joycoding.note.rxjava.observable;

import org.junit.Before;
import org.junit.Test;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

import static org.fest.assertions.Assertions.*;

public class CreatingObservablesTest {

    private CreatingObservables creatingObservables;

    @Before
    public void setup() {
        creatingObservables = new CreatingObservables();

    }

    @Test
    public void testJust() throws Exception {
        final String val = "something string";
        Observable<String> observable = creatingObservables.just(val);
        Subscription subscription = observable.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                assertThat(s).isEqualTo(val);
            }
        });

        subscription.unsubscribe();
    }

}