package com.aks.sampleapplication.data;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ReceiveMessage {

    @SerializedName("id")
    private String id;
    @SerializedName("messages")
    private List<MessageDetails> messages;

    public static ReceiveMessage objectFromData(String str) {

        return new Gson().fromJson(str, ReceiveMessage.class);
    }

    public static String dataFromObject(ReceiveMessage object) {
        return new Gson().toJson(object);
    }

    public static List<ReceiveMessage> arrayReceiveMessageFromData(String str) {

        Type listType = new TypeToken<ArrayList<ReceiveMessage>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<MessageDetails> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDetails> messages) {
        this.messages = messages;
    }

}
