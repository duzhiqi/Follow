package com.dzq.follow.presenter.implPersenter;

import com.dzq.follow.presenter.IBasePersenter;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by dzq on 2016/9/11.
 */
public class BasePersenterImpl implements IBasePersenter {


    private CompositeSubscription mCompositeSubscription;

    public void addSubscrible(Subscription s) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(s);
    }

    @Override
    public void unsubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }
}
