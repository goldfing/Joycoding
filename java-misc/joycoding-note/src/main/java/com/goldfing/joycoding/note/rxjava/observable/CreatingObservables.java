package com.goldfing.joycoding.note.rxjava.observable;

import rx.Observable;


public class CreatingObservables {

    public Observable<String> just(String str) {
        return Observable.just(str);
    }

}
