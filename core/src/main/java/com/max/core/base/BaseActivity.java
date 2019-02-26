package com.max.core.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.silencedut.router.Router;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements BaseViewInit {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initBeforeOnCreate();
        super.onCreate(savedInstanceState);
        initBeforeView();
        Router.instance().register(this);
        setContentView(getContentViewId());
        ButterKnife.bind(this);
        initViews();
        initDataObserver();
    }

    protected void initDataObserver(){

    }

    @Override
    public void initBeforeOnCreate() {

    }

    @Override
    public void initBeforeView() {

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Router.instance().unregister(this);
    }
}