package com.dzq.follow.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.dzq.follow.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dzq on 2016/9/27.
 */

public class PersonCenterFragment extends Fragment {

    @BindView(R.id.listView)
    ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_base, container, false);
        ButterKnife.bind(this, contentView);
        initView();
        return contentView;
    }

    private void initView() {
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 20;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null){
                    convertView = View.inflate(getActivity(), android.R.layout.simple_list_item_1, null);
                }

                TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
                tv.setText("123456");

                return convertView;
            }
        });
    }
}
