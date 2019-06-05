package com.example.ch.android1.view;

import com.example.ch.android1.base.BaseView;
import com.example.ch.android1.bean.IBean;

import java.util.List;

/**
 * Created by 76165
 * on 2019/6/5
 */
public interface IView extends BaseView {
    void onSuccess(List<IBean.ResultsEntity> resultsEntities);

    void onFail(String error);
}
