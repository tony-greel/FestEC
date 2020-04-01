package com.diabin.festec.example.bean;

import java.io.Serializable;
import java.util.List;

public class BaseBean<T> implements Serializable {

    private boolean success;

    private T result;

    private String message;

    public boolean getCode() {
        return success;
    }

    public void setCode(boolean code) {
        this.success = code;
    }
    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }



    @Override
    public String toString() {
        return "BaseBean{" +
                "code='" + success + '\'' +
                ", result=" + result +
                '}';
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
