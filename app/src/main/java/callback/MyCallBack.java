package callback;

public interface MyCallBack<T> {
    void onSuccess(T data);
    void onFail(T data);
}
