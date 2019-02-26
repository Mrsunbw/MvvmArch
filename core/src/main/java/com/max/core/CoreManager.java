package com.max.core;

import android.app.Application;

import com.max.core.api.ICoreApi;
import com.silencedut.hub.Hub;
import com.silencedut.hub.IHubActivity;

public class CoreManager {

    private static Application mContext;

    public static void init(Application context) {
        mContext = context;
        AppConfig.initialize(context);
    }

    public static Application getContext() {
        return mContext;
    }

    public static long getUid() {
        return 0;
    }

    public static <T extends ICoreApi> T getImpl(Class<T> api) {
        return Hub.getImpl(api);
    }

    /**
     * 查询接口的实现类是否存在，除非特殊情况，一般不需要，直接调用{@link #getImpl}就行了
     */
    public static <T extends ICoreApi> boolean implExist(Class<T> api) {
        return Hub.implExist(api);
    }

    public static <T extends IHubActivity> T getActivityRouter(Class<T> api) {
        return Hub.getActivity(api);
    }
}
