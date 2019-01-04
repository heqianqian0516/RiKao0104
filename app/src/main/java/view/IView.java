package view;

public interface IView<T>  {
    void requestData(T data);
    void requestFail(T data);
}
