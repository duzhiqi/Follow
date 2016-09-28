package com.dzq.follow.fragment;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.dzq.follow.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dzq on 2016/9/27.
 */
public class BaseFragment extends Fragment{

    @BindView(R.id.frameLayout_container)
    FrameLayout frameLayout_container;
    protected View createView(LayoutInflater inflater, ViewGroup container){

        View contentView = inflater.inflate(R.layout.fragment_base, container, false);
        ButterKnife.bind(this, contentView);

        return contentView;
    }
}
