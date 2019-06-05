package com.example.ch.android1.api;

import com.example.ch.android1.bean.IBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by 76165
 * on 2019/6/5
 */
public interface MyService {
    String BASE_URL = "http://gank.io/api/data/";

    @GET("福利/10/1")
    Observable<IBean> getPost();
}
