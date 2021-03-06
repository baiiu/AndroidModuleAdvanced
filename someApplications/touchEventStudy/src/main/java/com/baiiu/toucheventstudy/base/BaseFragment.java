package com.baiiu.toucheventstudy.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;

/**
 * author: baiiu
 * date: on 17/4/18 17:19
 * description:
 */
public abstract class BaseFragment extends Fragment {

    protected View mView;
    protected Context mContext;

    @Override public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(provideLayoutId(), container, false);
        }

        ButterKnife.bind(this, mView);
        initOnCreateView();


        return mView;
    }


    protected abstract int provideLayoutId();

    protected abstract void initOnCreateView();
}
