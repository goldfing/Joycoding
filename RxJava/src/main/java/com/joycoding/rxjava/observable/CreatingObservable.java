package com.joycoding.rxjava.observable;

import rx.Observable;

/**
 * Created with IntelliJ IDEA.
 * User: goldfing
 * Date: 12/3/14
 * Time: 10:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreatingObservable {

    public Observable<String> just(String val) {
        Observable<String> observable = Observable.just(val);
        return observable;

    }
}
