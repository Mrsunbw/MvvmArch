package com.max.core.viewmodel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.silencedut.router.Router;

public abstract class BaseViewModel extends ViewModel implements LifecycleOwner {
    private LifecycleOwner mLifecycleOwner;

    <T extends BaseViewModel> T attachLifecycleOwner(LifecycleOwner lifecycleOwner) {
        T currentModel = (T) this;
        if (mLifecycleOwner != null) {
            return currentModel;
        }
        this.mLifecycleOwner = lifecycleOwner;
        //注册时不影响性能
        Router.instance().register(this);
        onCreate();
        return currentModel;
    }

    protected abstract void onCreate();

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleOwner.getLifecycle();
    }

    /**
     * called when attached activity or fragment onDestroy called
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        Router.instance().unregister(this);
    }
}