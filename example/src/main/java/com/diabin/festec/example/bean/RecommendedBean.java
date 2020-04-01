package com.diabin.festec.example.bean;

public class RecommendedBean {

    private int viewType;


    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    @Override
    public String toString() {
        return "RecommendedBean{" +
                "viewType=" + viewType +
                '}';
    }
}
