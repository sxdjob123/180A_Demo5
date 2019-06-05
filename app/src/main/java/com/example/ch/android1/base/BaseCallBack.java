package com.example.ch.android1.base;

/**
 * Created by 76165
 * on 2019/6/5
 */
public interface BaseCallBack<T> {

    void onSuccess(T t);

    void onFail(String error);
}
