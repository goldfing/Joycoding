package com.joycoding.rxjava.observable;


import rx.Observable;
import rx.functions.Func0;
import rx.functions.Func1;

import java.util.List;

public class TransformingObservable {

    public Observable<Integer> map(List<Integer> values, Func1 func1) {
        Observable<Integer> observable = Observable.from(values);
        return observable.map(func1);
    }

    public Observable<Integer> flatMap(List<Integer> integers, Func1 onNext, Func1 onError, Func0 onCompleted) {
        Observable<Integer> observable = Observable.from(integers);
        return observable.flatMap(onNext, onError, onCompleted);
    }

    public Observable<Integer> concatMap(List<Integer> integers, Func1 func1) {
        Observable<Integer> observable = Observable.from(integers);
        return observable.concatMap(func1);
    }

    public Observable<Integer> switchMap(List<Integer> values, Func1 func1) {
        Observable<Integer> observable = Observable.from(values);
        return observable.switchMap(func1);
    }
}
