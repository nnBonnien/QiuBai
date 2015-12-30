package com.jianda.qiubai.utils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 15-12-30.
 */
public class Video {
    private long userId;
    private String userIcon;
    private String userName;
    private String content;
    private String image;
    private int down;
    private int up;
    private int comments;
    private int share;
    private String type;

    public Video(JSONObject object) throws JSONException {
        if(! object.isNull("user")){
            userId = object.getJSONObject("user").getLong("id");
            userIcon = object.getJSONObject("user").getString("icon");
            userName = object.getJSONObject("user").getString("login");
        }
        content = object.getString("content");
        image = object.getString("pic_url");
        up = object.getJSONObject("votes").getInt("up");
        down = object.getJSONObject("votes").getInt("down");
        comments = object.getInt("comments_count");
        share = object.getInt("share_count");
        if (!object.isNull("type")) {
            type = object.getString("type");
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
