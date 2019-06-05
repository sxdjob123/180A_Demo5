package com.example.ch.android1.presenter;

import com.example.ch.android1.base.BaseCallBack;
import com.example.ch.android1.base.BasePresenter;
import com.example.ch.android1.bean.IBean;
import com.example.ch.android1.model.IModel;
import com.example.ch.android1.view.IView;

import java.util.List;

/**
 * Created by 76165
 * on 2019/6/5
 */
public class IPresenter extends BasePresenter<IModel, IView> {
    public void getData() {
        if (myModel != null) {
            myModel.getData(new BaseCallBack<List<IBean.ResultsEntity>>() {
                @Override
                public void onSuccess(List<IBean.ResultsEntity> resultsEntities) {
                    if (myView != null) {
                        myView.onSuccess(resultsEntities);
                    }
                }

                @Override
                public void onFail(String error) {
                    if (myView != null) {
                        myView.onFail(error);
                    }
                }
            });
        }
    }
}
