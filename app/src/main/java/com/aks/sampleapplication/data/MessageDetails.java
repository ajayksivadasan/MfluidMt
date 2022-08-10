package com.aks.sampleapplication.data;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class MessageDetails {
    @SerializedName("sendBy")
    private String sendBy;
    @SerializedName("message")
    private String message;
    @SerializedName("time")
    private String time;

    public static MessageDetails objectFromData(String str) {
        return new Gson().fromJson(str, MessageDetails.class);
    }

    public String getSendBy() {
        return sendBy;
    }

    public void setSendBy(String sendBy) {
        this.sendBy = sendBy;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
