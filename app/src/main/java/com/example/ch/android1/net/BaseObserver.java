package com.example.ch.android1.net;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by 76165
 * on 2019/6/5
 */
public abstract class BaseObserver<T> implements Observer<T> {

    private static final String TAG = "BaseObserver";

    @Override
    public void onError(Throwable e) {
        Log.d(TAG, "onError:" + e.getMessage());
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete:");
    }
}
