package com.example.bogdan.vacanciedoumvp.base;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 13.04.2016
 */
public abstract class BasePrenter implements Presenter{

    private CompositeSubscription mCompositeSubscription;


    @Override
    public void onCreate() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {
        configureSubscription();
    }

    protected CompositeSubscription configureSubscription() {
        if (mCompositeSubscription == null || mCompositeSubscription.isUnsubscribed())
            mCompositeSubscription = new CompositeSubscription();

        return mCompositeSubscription;
    };

    @Override
    public void onDestroy() {
        unSubscribeAll();
    }

    protected void unSubscribeAll() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
            mCompositeSubscription.clear();
        }
    }

    protected <T> void subscribe(Observable<T> observable, Observer<T> observer) {
        Subscription subscription = observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.computation())
                .subscribe(observer);
        configureSubscription().add(subscription);
    }
}
