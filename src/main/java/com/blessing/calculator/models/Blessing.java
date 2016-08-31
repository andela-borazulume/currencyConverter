package com.blessing.calculator.models;

/**
 * Created by blessingorazulume on 7/14/16.
 */
public class Blessing {
    //pattern is MVVM Model View View Model
    private String name;
    private String address;
    //yes
    private boolean hot;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public boolean isHot() {
        return hot;
    }
}
