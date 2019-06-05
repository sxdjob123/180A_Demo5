package com.example.ch.android1;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.ch.android1.base.BaseMvpActivity;
import com.example.ch.android1.bean.IBean;
import com.example.ch.android1.model.IModel;
import com.example.ch.android1.presenter.IPresenter;
import com.example.ch.android1.view.IView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseMvpActivity<IPresenter, IModel, IView> implements IView {

    private static final String TAG = "MainActivity";

    @BindView(R.id.rv)
    RecyclerView rv;
    private ArrayList<IBean.ResultsEntity> list;
    private RlvIAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected IView initMvpView() {
        return this;
    }

    @Override
    protected IModel initMvpModel() {
        return new IModel();
    }

    @Override
    protected IPresenter initMvpPresenter() {
        return new IPresenter();
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        rv.setLayoutManager(manager);

        adapter = new RlvIAdapter(this, list);
        rv.setAdapter(adapter);

    }

    @Override
    protected void initData() {
        myPresenter.getData();
    }

    @Override
    public void onSuccess(List<IBean.ResultsEntity> resultsEntities) {
        list.addAll(resultsEntities);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onFail: " + error);
    }
}
