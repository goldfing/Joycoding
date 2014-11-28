package com.goldfing.joycoding.note.rxjava.observable;

import rx.Observable;

import java.util.List;


public class CreatingObservables {

    public Observable<String> just(String str) {
        return Observable.just(str);
    }

    public Observable<String> from(List<String> values) {
        return Observable.from(values);
    }
}
