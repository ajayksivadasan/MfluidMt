package com.aks.sampleapplication.data;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BaseUserData {


    @SerializedName("username")
    private String username;
    @SerializedName("image")
    private String image;
    @SerializedName("lastMessage")
    private LastMessageModel lastMessage;
    @SerializedName("id")
    private String id;

    public static BaseUserData objectFromData(String str) {

        return new Gson().fromJson(str, BaseUserData.class);
    }

    public static String dataFromObject(BaseUserData object) {
        return new Gson().toJson(object);
    }

    public static List<BaseUserData> arrayBaseUserDataFromData(String str) {

        Type listType = new TypeToken<ArrayList<BaseUserData>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LastMessageModel getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(LastMessageModel lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static class LastMessageModel {
        @SerializedName("sendBy")
        private String sendBy;
        @SerializedName("message")
        private String message;
        @SerializedName("time")
        private String time;

        public static LastMessageModel objectFromData(String str) {

            return new Gson().fromJson(str, LastMessageModel.class);
        }

        public static String dataFromObject(LastMessageModel object) {
            return new Gson().toJson(object);
        }

        public static List<LastMessageModel> arrayLastMessageModelFromData(String str) {

            Type listType = new TypeToken<ArrayList<LastMessageModel>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
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
}
