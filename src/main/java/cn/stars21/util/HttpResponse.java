package cn.stars21.util;

public class HttpResponse <T> {

    private Integer resultCode;
    private String message;
    private T data;
    private Object accessory;
    public HttpResponse(Integer resultCode){
        this.resultCode = resultCode;
    }
    public HttpResponse(){
        this(Constant.RESULT_SUCCESS);
    }
    public HttpResponse(String errorMessage){
        setErrorMessage(errorMessage);
    }

    public HttpResponse setErrorMessage(String message){
        return setErrorMessage(Constant.RESULT_FAILURE, message);
    }

    public HttpResponse setErrorMessage(Integer errorCode,String message){
        this.resultCode = errorCode;
        this.message = message;
        return this;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public HttpResponse setResultCode(Integer resultCode){
        this.resultCode = resultCode;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public HttpResponse setData(T data){
        this.data = data;
        return this;
    }

    public Object getAccessory() {
        return accessory;
    }

    public void setAccessory(Object accessory) {
        this.accessory = accessory;
    }

}