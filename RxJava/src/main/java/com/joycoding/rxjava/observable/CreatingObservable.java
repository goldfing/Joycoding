package com.joycoding.rxjava.observable;

import lombok.extern.slf4j.Slf4j;
import rx.Observable;

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
}
