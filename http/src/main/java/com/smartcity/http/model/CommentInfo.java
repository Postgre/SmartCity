package com.smartcity.http.model;

import java.io.Serializable;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: CommentInfo.java
 * @author: fengliang
 * @date: 2016-05-13 10:56
 */
public class CommentInfo implements Serializable {
    private static final String TAG = "CommentInfo";

    private String title;

    private String date;

    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
