package com.dzq.follow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dzq.follow.MainActivity;
import com.dzq.follow.R;
import com.dzq.follow.bean.SplashBean;
import com.dzq.follow.net.RetrofitHelper;
import com.dzq.follow.presenter.implPersenter.SplashPersenterImpl;
import com.dzq.follow.presenter.implView.ISplash;
import com.dzq.follow.util.ImageLoader;


/**
 * Created by dzq on 2016/9/6.
 */
public class SplashActivity extends BaseActivity implements ISplash {


    private TextView copyrightTv;
    private ImageView splashImgView;
    private SplashPersenterImpl splashPersenterImpl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        copyrightTv = (TextView) findViewById(R.id.tv_copyright);
        splashImgView = (ImageView) findViewById(R.id.iv_splash_img);

        splashPersenterImpl = new SplashPersenterImpl(this, new RetrofitHelper(this));
        splashPersenterImpl.getSplashInfo();
    }

    @Override
    public void showSplash(SplashBean splashBean) {
        Log.i("dzq", "splashBean.img" + splashBean.img);
        ImageLoader.load(this, splashBean.img, splashImgView);
        copyrightTv.setText(Html.fromHtml("&copy;") + splashBean.text);
    }

    @Override
    public void goMainUi() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        splashPersenterImpl.stopLoadSplash();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Glide.clear(splashImgView);
        splashPersenterImpl.unsubscribe();
    }
}
