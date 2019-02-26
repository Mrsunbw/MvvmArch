package com.max.core.viewmodel;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.annotation.MainThread;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

/**
 * 所有的ViewModel在此获取，便于方便管理
 */
public class ModelProvider {

    @MainThread
    public static <T extends BaseViewModel> T getModel(Context activity, Class<T> viewmodel) {
        if (!(activity instanceof FragmentActivity)) {
            throw new RuntimeException("context must a FragmentActivity instance");
        }
        FragmentActivity fragmentActivity = (FragmentActivity) activity;
        return ViewModelProviders.of(fragmentActivity).get(viewmodel).attachLifecycleOwner(fragmentActivity);
    }

    @MainThread
    public static <T extends BaseViewModel> T getModel(Fragment fragment, Class<T> viewmodel) {
        return ViewModelProviders.of(fragment).get(viewmodel).attachLifecycleOwner(fragment);
    }
}