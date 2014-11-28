package com.goldfing.joycoding.note.rxjava.observable;

import rx.Observable;

import java.util.List;


public class CreatingObservable {

    public Observable<String> just(String str) {
        return Observable.just(str);
    }

    public Observable<String> from(List<String> values) {
        return Observable.from(values);
    }

    public Observable<String> repeat(String val, long count) {
        Observable<String> observable = just(val);
        return observable.repeat(count);
    }

}
