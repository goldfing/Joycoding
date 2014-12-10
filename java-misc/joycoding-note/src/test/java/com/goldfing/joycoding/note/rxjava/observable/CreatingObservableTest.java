package com.goldfing.joycoding.note.rxjava.observable;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action1;

import java.util.List;

import static org.fest.assertions.Assertions.*;

public class CreatingObservableTest {

    private CreatingObservable creatingObservable;

    @Before
    public void setup() {
        creatingObservable = new CreatingObservable();

    }

    @Test
    public void testJust() throws Exception {
        final String val = "something string";
        Observable<String> observable = creatingObservable.just(val);
        Subscription subscription = observable.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                assertThat(s).isEqualTo(val);
            }
        });

        subscription.unsubscribe();
    }

    @Test
    public void testFrom() throws Exception {
        final List<String> strings = Lists.newArrayList("1", "2", "3", "4", "5");
        Subscription subscription = creatingObservable.from(strings).subscribe(new Subscriber<String>() {

            @Override
            public final void onNext(String args) {
                System.out.println("args : "+ args);
                assertThat(strings.contains(args)).isTrue();
            }

            @Override
            public final void onCompleted() {
                System.out.println("Subscribe completed.");
            }

            @Override
            public final void onError(Throwable e) {
                throw new OnErrorNotImplementedException(e);
            }
        });

        subscription.unsubscribe();
    }

    @Test
    public void testRepeat() throws Exception {
        final String val = "repeat";
        Subscription subscription = creatingObservable.repeat(val, 5L).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("Subscribe completed.");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
                assertThat(s).isEqualTo(val);
            }
        });
    }

}