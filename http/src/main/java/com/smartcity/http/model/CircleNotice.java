package com.smartcity.http.model;

import java.util.List;

/**
 * Created by Administrator on 2016/5/18.
 */
public class CircleNotice {

    /**
     * total : 2
     * code : 1
     * msg : null
     * data : [{"informId":1,"informCircleId":4,"informUserId":61,"informTitle":"通知标题1","informContent":"通知内容1","informTime":"2016-05-17 18:02:54","informMorefield1":null,"informMorefield2":null,"informMorefield3":null,"sStartpage":null,"sPagerows":null,"sIds":null},{"informId":2,"informCircleId":4,"informUserId":56,"informTitle":"通知标题2","informContent":"通知内容2","informTime":"2016-05-17 18:03:17","informMorefield1":null,"informMorefield2":null,"informMorefield3":null,"sStartpage":null,"sPagerows":null,"sIds":null}]
     */

    private int total;
    private int code;
    private Object msg;
    /**
     * informId : 1
     * informCircleId : 4
     * informUserId : 61
     * informTitle : 通知标题1
     * informContent : 通知内容1
     * informTime : 2016-05-17 18:02:54
     * informMorefield1 : null
     * informMorefield2 : null
     * informMorefield3 : null
     * sStartpage : null
     * sPagerows : null
     * sIds : null
     */

    private List<DataBean> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int informId;
        private int informCircleId;
        private int informUserId;
        private String informTitle;
        private String informContent;
        private String informTime;
        private Object informMorefield1;
        private Object informMorefield2;
        private Object informMorefield3;
        private Object sStartpage;
        private Object sPagerows;
        private Object sIds;

        public int getInformId() {
            return informId;
        }

        public void setInformId(int informId) {
            this.informId = informId;
        }

        public int getInformCircleId() {
            return informCircleId;
        }

        public void setInformCircleId(int informCircleId) {
            this.informCircleId = informCircleId;
        }

        public int getInformUserId() {
            return informUserId;
        }

        public void setInformUserId(int informUserId) {
            this.informUserId = informUserId;
        }

        public String getInformTitle() {
            return informTitle;
        }

        public void setInformTitle(String informTitle) {
            this.informTitle = informTitle;
        }

        public String getInformContent() {
            return informContent;
        }

        public void setInformContent(String informContent) {
            this.informContent = informContent;
        }

        public String getInformTime() {
            return informTime;
        }

        public void setInformTime(String informTime) {
            this.informTime = informTime;
        }

        public Object getInformMorefield1() {
            return informMorefield1;
        }

        public void setInformMorefield1(Object informMorefield1) {
            this.informMorefield1 = informMorefield1;
        }

        public Object getInformMorefield2() {
            return informMorefield2;
        }

        public void setInformMorefield2(Object informMorefield2) {
            this.informMorefield2 = informMorefield2;
        }

        public Object getInformMorefield3() {
            return informMorefield3;
        }

        public void setInformMorefield3(Object informMorefield3) {
            this.informMorefield3 = informMorefield3;
        }

        public Object getSStartpage() {
            return sStartpage;
        }

        public void setSStartpage(Object sStartpage) {
            this.sStartpage = sStartpage;
        }

        public Object getSPagerows() {
            return sPagerows;
        }

        public void setSPagerows(Object sPagerows) {
            this.sPagerows = sPagerows;
        }

        public Object getSIds() {
            return sIds;
        }

        public void setSIds(Object sIds) {
            this.sIds = sIds;
        }
    }
}
