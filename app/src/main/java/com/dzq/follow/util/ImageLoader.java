package com.dzq.follow.util;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.dzq.follow.R;

/**
 * Created by dzq on 2016/9/23.
 */
public class ImageLoader {
    /**
     * splash界面加载
     */
    public static void load(final Context context, String url, final ImageView imageView) {
        Glide.with(context).load(url).crossFade().animate(R.anim.splash_img_enter).centerCrop().into(new GlideDrawableImageViewTarget(imageView) {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> animation) {
                super.onResourceReady(resource, animation);
                imageView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.splash_scale_anim));
            }
        });
    }
}
