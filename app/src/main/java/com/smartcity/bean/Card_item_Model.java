package com.smartcity.bean;

/**
 * Created by Administrator on 2016/5/5.
 */
public class Card_item_Model {


    /**
     * headerUrl : 192.168.0.1
     * type : 1
     * circleName : 骑行圈!
     */

    private String headerUrl;
    private int type;
    private String circleName;

    public Card_item_Model(String headerUrl, int type, String circleName) {
        this.headerUrl = headerUrl;
        this.type = type;
        this.circleName = circleName;
    }

    public String getHeaderUrl() {
        return headerUrl;
    }

    public void setHeaderUrl(String headerUrl) {
        this.headerUrl = headerUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }
}
