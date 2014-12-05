package com.joycoding.rxjava.observable;

import lombok.extern.slf4j.Slf4j;
import rx.*;
import rx.functions.Func1;

import java.util.List;

@Slf4j
public class CreatingObservable {

    public Observable<String> just(String val) {
        Observable<String> observable = Observable.just(val);
        return observable;
    }

    public Observable<String> from(List<String> values) {
        Observable<String> observable = Observable.from(values);
        return observable;
    }

    public Observable<String> repeat(String val, Long count) {
        Observable<String> observable = Observable.just(val);
        return observable.repeat(count);
    }

    public Observable<String> create(List<String> values) {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                for (String val : values) {
                    subscriber.onNext(val);
                }
                subscriber.onCompleted();
            }
        });

        return observable;
     }

}
