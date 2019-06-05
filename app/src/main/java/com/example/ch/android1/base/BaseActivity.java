package com.example.ch.android1.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by 76165
 * on 2019/6/5
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
        ButterKnife.bind(this);

        initMvp();
        initView();
        initData();
        initListener();
    }

    protected abstract int getLayoutId();

    protected void initMvp() {

    }

    protected void initView() {

    }

    protected void initData() {

    }

    protected void initListener() {

    }
}
