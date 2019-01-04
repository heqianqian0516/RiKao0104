package com.bwei.rikao0104;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import adapter.LinerAdapter;
import api.Apis;
import bean.ShowBean;
import presenter.IPresenterImpl;
import view.IView;

public class MainActivity extends AppCompatActivity implements IView {



    private IPresenterImpl presenter;
    private RecyclerView recyclerView;
    private LinerAdapter linerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recy);
        presenter = new IPresenterImpl(this);
        initView();
        loadView();
    }

    private void loadView() {
        presenter.startRequestGet(Apis.URL_COMMODITY_LIST_GET,null,ShowBean.class);
    }

    private void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        linerAdapter = new LinerAdapter(this);
        recyclerView.setAdapter(linerAdapter);
    }

    @Override
    public void requestData(Object data) {
        if (data instanceof ShowBean) {
            ShowBean bean = (ShowBean) data;
            if (bean == null || !bean.isSuccess()) {
                Toast.makeText(this, bean.getMessage(), Toast.LENGTH_LONG).show();
            }else{
                linerAdapter.setmData(bean.getResult().getMlss().get(0).getCommodityList());

            }
        }
    }

    @Override
    public void requestFail(Object data) {

    }
}
