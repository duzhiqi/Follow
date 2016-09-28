package com.dzq.follow.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.IntDef;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.dzq.follow.R;

/**
 * Created by dzq on 2016/9/22.
 */

public class StateLayout extends FrameLayout {
    public static final int NULL_STATE = -1;
    private static final int STATE_COUNTS = 4;
    public static final int EMPTY_LAYOUT_STATE = 0;
    public static final int ERROR_LAYOUT_STATE = 1;
    public static final int SUCCESS_LAYOUT_STATE = 2;
    public static final int LOADING_LAYOUT_STATE = 3;

    @IntDef({EMPTY_LAYOUT_STATE, ERROR_LAYOUT_STATE, SUCCESS_LAYOUT_STATE, LOADING_LAYOUT_STATE, NULL_STATE})
    @interface StateLayoutState {
    }

    public StateLayout(Context context) {
        this(context, null);
    }

    public StateLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StateLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.StateLayout);
        for (int i = 0; i < STATE_COUNTS; i++) {
            int layout = typedArray.getResourceId(i, 0);
            setStateLayout(i, layout);
        }
        typedArray.recycle();
    }

    private int[] layouts = new int[STATE_COUNTS];
    private String[] texts = {"没有数据", "加载出错", "加载成功", "正在加载"};

    public void setStateLayout(int state, @LayoutRes int layout) {
        layouts[state] = layout;
        if (layout == 0) {
            TextView tv = new TextView(getContext());
            tv.setText(texts[state]);
            setStateView(state, tv);
        } else {
            setStateView(state, View.inflate(getContext(), layouts[state], null));
        }
    }

    private int curState = NULL_STATE;
    View[] views = new View[STATE_COUNTS];

    public void setStateView(@StateLayoutState int state, @NonNull View view) {
        if (views[state] != null) {
            removeView(views[state]);
        }
        views[state] = view;
        addView(views[state]);
        view.setVisibility(state == curState ? VISIBLE : GONE);
    }

    @NonNull
    public View getStateView(int state) {
        return views[state];
    }

    public void setState(@StateLayoutState int state) {
        if (curState >= 0) {
            views[curState].setVisibility(GONE);
        }
        views[state].setVisibility(INVISIBLE);
        curState = state;
    }

    @StateLayoutState
    public int getState() {
        return curState;
    }
}
