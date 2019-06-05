package com.example.ch.android1.base;

/**
 * Created by 76165
 * on 2019/6/5
 */
public abstract class BaseMvpActivity<P extends BasePresenter, M extends BaseModel, V extends BaseView> extends BaseActivity {

    protected P myPresenter;

    @Override
    protected void initMvp() {
        myPresenter = initMvpPresenter();
        if (myPresenter != null) {
            myPresenter.initModel(initMvpModel());
            myPresenter.attachView(initMvpView());
        }
    }

    protected abstract V initMvpView();

    protected abstract M initMvpModel();

    protected abstract P initMvpPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (myPresenter != null) {
            myPresenter.clear();
            myPresenter = null;
        }
    }
}
