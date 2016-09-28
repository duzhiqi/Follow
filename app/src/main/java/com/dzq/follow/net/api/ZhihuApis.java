package com.dzq.follow.net.api;

import com.dzq.follow.bean.SplashBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by dzq on 2016/9/22.
 */

public interface ZhihuApis {

    String BASE_URL = "http://news-at.zhihu.com/api/4/";

    /**
     * 启动界面图片
     */
    @GET("start-image/{res}")
    Observable<SplashBean> getSplashInfo(@Path("res") String res);
}
