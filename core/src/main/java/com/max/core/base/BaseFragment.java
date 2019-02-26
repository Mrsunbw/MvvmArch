package com.max.core.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.silencedut.router.Router;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment implements BaseViewInit {
    protected FragmentActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = getActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        initBeforeOnCreate();
        super.onCreate(savedInstanceState);
        Router.instance().register(this);
        initBeforeView();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getContentViewId(), container, false);
        ButterKnife.bind(this, rootView);
        initViews();
        initDataObserver();
        return rootView;
    }

    @Override
    public void initBeforeOnCreate() {

    }

    @Override
    public void initBeforeView() {

    }

    protected void initDataObserver() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Router.instance().unregister(this);
    }
}