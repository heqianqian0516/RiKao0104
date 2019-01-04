package presenter;

import java.util.Map;

import callback.MyCallBack;

import model.ModelIpm;
import view.IView;

public class IPresenterImpl implements IPresenter {


    private ModelIpm model;
    private IView iView;

    public IPresenterImpl(IView iView){
        this.iView=iView;
        model = new ModelIpm();
    }
    @Override
    public void startRequestGet(String url, String params, Class clazz) {
        model.requestDataGet(url, params, clazz, new MyCallBack() {
            @Override
            public void onSuccess(Object data) {
                iView.requestData(data);
            }

            @Override
            public void onFail(Object data) {
               iView.requestFail(data);
            }
        });

    }

    @Override
    public void startRequestPost(String url, Map<String, String> params, Class clazz) {
         model.requestDataPost(url, params, clazz, new MyCallBack() {
             @Override
             public void onSuccess(Object data) {

             }

             @Override
             public void onFail(Object data) {

             }
         });

    }
    public void onDetach(){
        if (model!=null){
            model=null;
        }
        if (iView!=null){
            iView=null;
        }
    }
}
