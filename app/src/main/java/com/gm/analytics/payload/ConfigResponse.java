package com.gm.analytics.payload;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ConfigResponse implements Parcelable {

    public static final Creator<ConfigResponse> CREATOR = new Creator<ConfigResponse>() {
        @Override
        public ConfigResponse createFromParcel(Parcel in) {
            return new ConfigResponse(in);
        }

        @Override
        public ConfigResponse[] newArray(int size) {
            return new ConfigResponse[size];
        }
    };

    @SerializedName("analyticsEnabled")
    public boolean analyticsEnabled;

    @SerializedName("itemsToSync")
    public String itemsToSync;

    @SerializedName("timeToSync")
    public String timeToSync;

    @SerializedName("firstTimeToSync")
    public String firstTimeToSync;

    @SerializedName("analyticsURL")
    public String analyticsURL;

    @SerializedName("maxRetries")
    public String maxRetries;

    @SerializedName("timeToRetry")
    public String timeToRetry;

    @SerializedName("maxQueues")
    public String maxQueues;

    @SerializedName("vinPart")
    public String vinPart;

    @SerializedName("guid")
    public String guid;

    @SerializedName("vin")
    public String vin;

    @SerializedName("sid")
    public String sid;

    public ConfigResponse(Parcel in){
        analyticsEnabled = in.readInt()!=0;
        itemsToSync = in.readString();
        timeToSync = in.readString();
        firstTimeToSync = in.readString();
        analyticsURL = in.readString();
        maxRetries=in.readString();
        timeToRetry=in.readString();
        maxQueues=in.readString();
        vinPart=in.readString();
        guid=in.readString();
        vin=in.readString();
        sid=in.readString();
    }

    public ConfigResponse(){

    }

    public boolean getAnayticsEnabled(){
        return analyticsEnabled;
    }

    public void setAnalyticsEnabled(boolean analyticsEnabled){ this.analyticsEnabled = analyticsEnabled; }

    public String getItemsToSync(){
        return itemsToSync;
    }

    public void setItemsToSync(String itemsToSync){
        this.itemsToSync = itemsToSync;
    }

    public String getTimeToSync(){
        return timeToSync;
    }

    public void setTimeToSync(String timeToSync){
        this.timeToSync = timeToSync;
    }

    public String getFirstTimeToSync(){
        return firstTimeToSync;
    }

    public void setFirstTimeToSync(String firstTimeToSync){ this.firstTimeToSync = firstTimeToSync; }

    public String getAnalyticsURL(){
        return analyticsURL;
    }

    public void setAnalyticsURL(String analyticsURL){
        this.analyticsURL = analyticsURL;
    }

    public String getTimeToRetry(){
        return timeToRetry;
    }

    public void setTimeToRetry(String timeToRetry){
        this.timeToRetry = timeToRetry;
    }

    public String getMaxRetries(){
        return maxRetries;
    }

    public void setMaxRetries(String maxRetries) { this.maxRetries = maxRetries; }

    public String getMaxQueues(){
        return maxQueues;
    }

    public void setMaxQueues(String maxQueues){
        this.maxQueues = maxQueues;
    }

    public String getVinPart(){
        return vinPart;
    }

    public void setVinPart(String vinPart){
        this.vinPart = vinPart;
    }

    public String getGuid(){
        return guid;
    }

    public void setGuid(String guid){
        this.guid = guid;
    }

    public String getVin(){
        return vin;
    }

    public void setVin(String vin){
        this.vin = vin;
    }

    public String getSid(){
        return sid;
    }

    public void setSid(String sid){
        this.sid = sid;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(analyticsEnabled ? 1 : 0);
        dest.writeString(itemsToSync);
        dest.writeString(timeToSync);
        dest.writeString(firstTimeToSync);
        dest.writeString(maxRetries);
        dest.writeString(timeToRetry);
        dest.writeString(maxQueues);
        dest.writeString(vinPart);
        dest.writeString(guid);
        dest.writeString(vin);
        dest.writeString(sid);


    }
}