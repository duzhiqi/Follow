package com.dzq.follow.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by dzq on 2016/9/27.
 */

public class HomeFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View contentView = createView(inflater, container);
        TextView tv = new TextView(getActivity());
        tv.setText("HomeFragment");
        frameLayout_container.addView(tv);

        return contentView;

    }
}
