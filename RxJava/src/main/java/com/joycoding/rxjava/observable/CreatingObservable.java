package com.joycoding.rxjava.observable;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import rx.*;
import rx.functions.Func1;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CreatingObservable {

    public Observable<String> just(String val) {
        return Observable.just(val);
    }

    public Observable<String> from(List<String> values) {
        return Observable.from(values);
    }

    public Observable<String> repeat(String val, Long count) {
        return Observable.just(val).repeat(count);
    }

    public Observable<String> create(List<String> values) {
        return Observable.create((Observable.OnSubscribe<String>) (subscriber) -> {
            for (String val : values) {
                subscriber.onNext(val);
            }
            subscriber.onCompleted();
        });
    }

    public Observable<String> defer() {
        Observable<String> observable1 = Observable.defer(() -> {
            Observable<String> stringObservable = Observable.from(Lists.newArrayList("a", "b", "c"));
            return stringObservable;
        });

        return observable1;
    }

    public Observable<Integer> range(int start, int count) {
        return Observable.range(start, count);
    }

    // 모지? 독립적으로 사용할 수 없나 보군.
    public Observable<Long> interval(int interval, TimeUnit timeUnit) {
        return Observable.interval(interval, timeUnit);
    }

    public Observable<Long> timer(int delay, TimeUnit timeUnit) {
        return Observable.timer(delay, timeUnit);
    }

    public Observable<String> empty() {
        return Observable.empty();
    }

    public Observable<String> error() {
        return Observable.error(new Exception("Error!!!"));
    }

    public Observable<String> never() {
        return Observable.never();
    }


}
