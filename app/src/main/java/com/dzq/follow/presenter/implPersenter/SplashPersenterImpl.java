package com.dzq.follow.presenter.implPersenter;

import android.os.Handler;

import com.dzq.follow.bean.SplashBean;
import com.dzq.follow.net.RetrofitHelper;
import com.dzq.follow.presenter.ISplashPersenter;
import com.dzq.follow.presenter.implView.ISplash;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dzq on 2016/9/23.
 */

public class SplashPersenterImpl extends BasePersenterImpl implements ISplashPersenter {

    private ISplash iSplash;
    private RetrofitHelper mRetrofitHelper;
    private static final String RES = "1080*1776";

    public SplashPersenterImpl(ISplash iSplash, RetrofitHelper retrofitHelper){
        this.iSplash = iSplash;
        this.mRetrofitHelper = retrofitHelper;
    }

    private Handler handler = new Handler();

    private Runnable goNextUiRunnable = new Runnable() {
        @Override
        public void run() {
            iSplash.goMainUi();
        }
    };

    @Override
    public void getSplashInfo() {
        mRetrofitHelper.getSplashInfo(RES)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SplashBean>() {
                    @Override
                    public void onCompleted() {
                        handler.postDelayed(goNextUiRunnable, 3000);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iSplash.goMainUi();
                    }

                    @Override
                    public void onNext(SplashBean splashBean) {
                        iSplash.showSplash(splashBean);
                    }
                });
    }

    @Override
    public void stopLoadSplash() {
        handler.removeCallbacks(goNextUiRunnable);
    }

}
