package com.max.core.base;

public interface BaseViewInit {
    /**
     * 返回布局id
     * @return R.Layout.*
     */
    int getContentViewId();

    /**
     * 初始化View
     */
    void initViews();

    /**
     * setContentView()之前调用
     */
    void initBeforeView();

    /**
     * onCreate()里面 super.onCreate()之前调用
     */
    void initBeforeOnCreate();
}
