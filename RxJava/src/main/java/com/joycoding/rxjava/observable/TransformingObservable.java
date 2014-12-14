package com.joycoding.rxjava.observable;


import rx.Observable;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observables.GroupedObservable;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    public Observable<String> scan(List<String> values, Func2 func2) {
        Observable<String> observable = Observable.from(values);
        return observable.scan(func2);
    }

    public Observable<List<String>> buffer(List<String> values) {
        Observable<String> observable = Observable.from(values);
        return observable.buffer(3);
    }

    public Observable<List<String>> buffer(List<String> values, int count, int skip) {
        Observable<String> observable = Observable.from(values);
        return observable.buffer(count, skip);
    }

    public Observable<List<List<String>>> bufferWithTimeSpan(List<String> values) {
        Observable<String> observable = Observable.from(values);
        return observable.buffer(2).buffer(10L, TimeUnit.SECONDS);
    }

    public Observable<Integer> cast(List<String> values) {
        Observable<String> observable = Observable.from(values);
        return observable.cast(Integer.class);
    }
}
