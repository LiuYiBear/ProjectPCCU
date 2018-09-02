package com.example.chih.myapplication;

import android.app.ListActivity;

public class store_data_listview extends ListActivity {


    private String storeName;
    private String storePhone;
    private String storeAddress;
    private String storeImage;
    public  store_data_listview(String storeNamem,String storePhone,String storeAddress,String storeImage){
        this.storeAddress=storeAddress;
        this.storeName=storeNamem;
        this.storePhone=storePhone;
        this.storeImage=storeImage;
    }
    public String getStoreName(){
        return storeName;
    }
    public void setStoreName(String getStoreName){
        this.storeName=getStoreName;
    }
    public String getStorePhone(){
        return storePhone;
    }
    public void setStorePhone(String storePhone){
        this.storePhone=storePhone;
    }
    public String getStoreAddress(){
        return storeAddress;
    }
    public void setStoreAddress(String storeAddress){
        this.storeAddress=storeAddress;
    }
    public String getStoreImage(){
        return storeImage;
    }
    public void setStoreImage(String storeImage){
        this.storeImage=storeImage;
    }
}
