package com.joycoding.rxjava.observable;


import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import rx.Observable;
import rx.Subscriber;
import static com.joycoding.rxjava.util.SubscribeTestUtil.*;

public class FilteringObservableTest {

    private Observable<Integer> intObservable;
    private Observable<String> strObservable;

    @Before
    public void setup() {
        intObservable = Observable.from(Lists.newArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        strObservable = Observable.from(Lists.newArrayList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j"));
    }



    @Test
    public void testFilter() {
        intObservable.filter(integer -> integer % 2 == 0)
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        printCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        printOnError(e);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        printOnNext(integer);
                    }
                });
    }

    @Test
    public void testTakeLast() {
        strObservable.takeLast(2).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                printCompleted();
            }

            @Override
            public void onError(Throwable e) {
                printOnError(e);
            }

            @Override
            public void onNext(String s) {
                printOnNext(s);
            }
        });
    }

    @Test
    public void testLast() {
        strObservable.last().subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                printCompleted();
            }

            @Override
            public void onError(Throwable e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onNext(String s) {
                printOnNext(s);
            }
        });
    }

    @Test
    public void testLastOrDefault() {
        strObservable.lastOrDefault("z").subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                printCompleted();
            }

            @Override
            public void onError(Throwable e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onNext(String s) {
                printOnNext(s);
            }
        });
    }
}
