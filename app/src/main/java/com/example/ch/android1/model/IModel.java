package com.example.ch.android1.model;

import com.example.ch.android1.api.MyService;
import com.example.ch.android1.base.BaseCallBack;
import com.example.ch.android1.base.BaseModel;
import com.example.ch.android1.bean.IBean;
import com.example.ch.android1.net.BaseObserver;
import com.example.ch.android1.net.HttpUtils;
import com.example.ch.android1.net.RxUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by 76165
 * on 2019/6/5
 */
public class IModel extends BaseModel {
    public void getData(final BaseCallBack<List<IBean.ResultsEntity>> baseCallBack) {
        MyService myService = HttpUtils.getHttpUtils().getData(MyService.BASE_URL, MyService.class);

        Observable<IBean> observable = myService.getPost();

        observable.compose(RxUtils.<IBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<IBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(IBean iBean) {
                        if (iBean != null) {
                            baseCallBack.onSuccess(iBean.getResults());
                        }
                    }
                });
    }
}
