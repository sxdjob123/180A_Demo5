package com.example.ch.android1.base;

/**
 * Created by 76165
 * on 2019/6/5
 */
public class BasePresenter<M extends BaseModel, V extends BaseView> {

    protected M myModel;
    protected V myView;

    public void initModel(M m) {
        this.myModel = m;
    }

    public void attachView(V v) {
        this.myView = v;
    }

    public void clear() {
        if (myModel!=null) {
            myModel.clear();
        }

        if (myModel != null) {
            myModel = null;
        }

        if (myView != null) {
            myView = null;
        }
    }
}
