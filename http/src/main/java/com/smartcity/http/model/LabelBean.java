package com.smartcity.http.model;

import java.util.List;

/**
 * Created by Administrator on 2016/5/13.
 */
public class LabelBean extends BaseModel {

    /**
     * markId : 1
     * markContent : 搞笑
     * markTime : 2016-05-03 17:17:55
     * markBusiness : null
     * markIsdel : null
     * markMorefield1 : null
     * markMorefield2 : null
     * markMorefield3 : null
     * sStartpage : null
     * sPagerows : null
     * pagination : null
     * markUsetimes : 0
     * iIsHot : null
     */

    private List<DataEntity> data;

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity {
        private int markId;
        private String markContent;
        private String markTime;
        private Object markBusiness;
        private Object markIsdel;
        private Object markMorefield1;
        private Object markMorefield2;
        private Object markMorefield3;
        private Object sStartpage;
        private Object sPagerows;
        private Object pagination;
        private int markUsetimes;
        private Object iIsHot;

        public int getMarkId() {
            return markId;
        }

        public void setMarkId(int markId) {
            this.markId = markId;
        }

        public String getMarkContent() {
            return markContent;
        }

        public void setMarkContent(String markContent) {
            this.markContent = markContent;
        }

        public String getMarkTime() {
            return markTime;
        }

        public void setMarkTime(String markTime) {
            this.markTime = markTime;
        }

        public Object getMarkBusiness() {
            return markBusiness;
        }

        public void setMarkBusiness(Object markBusiness) {
            this.markBusiness = markBusiness;
        }

        public Object getMarkIsdel() {
            return markIsdel;
        }

        public void setMarkIsdel(Object markIsdel) {
            this.markIsdel = markIsdel;
        }

        public Object getMarkMorefield1() {
            return markMorefield1;
        }

        public void setMarkMorefield1(Object markMorefield1) {
            this.markMorefield1 = markMorefield1;
        }

        public Object getMarkMorefield2() {
            return markMorefield2;
        }

        public void setMarkMorefield2(Object markMorefield2) {
            this.markMorefield2 = markMorefield2;
        }

        public Object getMarkMorefield3() {
            return markMorefield3;
        }

        public void setMarkMorefield3(Object markMorefield3) {
            this.markMorefield3 = markMorefield3;
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

        public Object getPagination() {
            return pagination;
        }

        public void setPagination(Object pagination) {
            this.pagination = pagination;
        }

        public int getMarkUsetimes() {
            return markUsetimes;
        }

        public void setMarkUsetimes(int markUsetimes) {
            this.markUsetimes = markUsetimes;
        }

        public Object getIIsHot() {
            return iIsHot;
        }

        public void setIIsHot(Object iIsHot) {
            this.iIsHot = iIsHot;
        }
    }
}
