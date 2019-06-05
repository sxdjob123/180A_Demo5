package com.example.ch.android1.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by 76165
 * on 2019/6/5
 */
public class BaseModel {

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void clear() {
        compositeDisposable.clear();
    }
}
