package com.aks.sampleapplication.data;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class BaseUserData {
    /**
     * username : Jaylan.Schultz81
     * image : https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/60.jpg
     * lastMessage : {"sendBy":"true","message":"Soluta enim et omnis id beatae illum dolorum sed quod.","time":"2082-03-15T07:48:37.740Z"}
     * id : 1
     */

    @SerializedName("username")
    private String username;
    @SerializedName("image")
    private String image;
    /**
     * sendBy : true
     * message : Soluta enim et omnis id beatae illum dolorum sed quod.
     * time : 2082-03-15T07:48:37.740Z
     */

    @SerializedName("lastMessage")
    private MessageDetails lastMessage;
    @SerializedName("id")
    private String id;

    public static BaseUserData objectFromData(String str) {

        return new Gson().fromJson(str, BaseUserData.class);
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

    public MessageDetails getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(MessageDetails lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
