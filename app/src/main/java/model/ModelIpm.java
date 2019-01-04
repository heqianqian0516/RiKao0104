package model;

import com.google.gson.Gson;

import java.util.Map;

import api.RetrofitManager;
import callback.MyCallBack;

public class ModelIpm implements IModel {
    @Override
    public void requestDataGet(String url, String parms, final Class clazz, final MyCallBack myCallBack) {
        RetrofitManager.getInstance().get(url).result(new RetrofitManager.HttpListener() {
            @Override
            public void onSuccess(String data) {
                try {
                    Object o=new Gson().fromJson(data,clazz);
                    if (myCallBack!=null){
                        myCallBack.onSuccess(o);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    if (myCallBack!=null){
                        myCallBack.onFail(e.getMessage());
                    }
                }

            }

            @Override
            public void onFail(String error) {

            }
        });
    }

    @Override
    public void requestDataPost(String url, Map<String, String> parms, Class clazz, MyCallBack myCallBack) {

    }
}
