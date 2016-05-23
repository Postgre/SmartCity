package com.smartcity.http.model;

import java.util.List;

/**
 * Created by Yancy on 2016/5/19.
 */
public class LifeClassifyModel extends BaseModel {
    /**
     * id : 1
     * categoryName : 日用洗护
     * categoryNameEn :
     * categoryLogo :
     * categoryDepath : 0
     * categoryStatus : 0
     * categoryType : 0
     * isHomeShow : 1
     * sequence : 11
     * createTime : 2016-04-15 14:19:14
     * createUser : 10000
     * modifyTime : 2016-05-18 11:13:58
     * modifyUser : 10000
     * pid : 0
     * state : closed
     * children : [{"id":45,"categoryName":"洗面奶","categoryNameEn":"ximainai","categoryLogo":"","categoryDepath":1,"categoryStatus":0,"categoryType":0,"isHomeShow":null,"sequence":99,"createTime":"2016-05-19 10:08:34","createUser":10000,"modifyTime":null,"modifyUser":null,"pid":1,"state":"closed","children":[]}]
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {

        private int id;
        private String categoryName;
        private String categoryNameEn;
        private String categoryLogo;
        private int categoryDepath;
        private int categoryStatus;
        private int categoryType;
        private int isHomeShow;
        private int sequence;
        private String createTime;
        private int createUser;
        private String modifyTime;
        private int modifyUser;
        private int pid;
        private String state;
        /**
         * id : 45
         * categoryName : 洗面奶
         * categoryNameEn : ximainai
         * categoryLogo :
         * categoryDepath : 1
         * categoryStatus : 0
         * categoryType : 0
         * isHomeShow : null
         * sequence : 99
         * createTime : 2016-05-19 10:08:34
         * createUser : 10000
         * modifyTime : null
         * modifyUser : null
         * pid : 1
         * state : closed
         * children : []
         */

        private List<ChildrenBean> children;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getCategoryNameEn() {
            return categoryNameEn;
        }

        public void setCategoryNameEn(String categoryNameEn) {
            this.categoryNameEn = categoryNameEn;
        }

        public String getCategoryLogo() {
            return categoryLogo;
        }

        public void setCategoryLogo(String categoryLogo) {
            this.categoryLogo = categoryLogo;
        }

        public int getCategoryDepath() {
            return categoryDepath;
        }

        public void setCategoryDepath(int categoryDepath) {
            this.categoryDepath = categoryDepath;
        }

        public int getCategoryStatus() {
            return categoryStatus;
        }

        public void setCategoryStatus(int categoryStatus) {
            this.categoryStatus = categoryStatus;
        }

        public int getCategoryType() {
            return categoryType;
        }

        public void setCategoryType(int categoryType) {
            this.categoryType = categoryType;
        }

        public int getIsHomeShow() {
            return isHomeShow;
        }

        public void setIsHomeShow(int isHomeShow) {
            this.isHomeShow = isHomeShow;
        }

        public int getSequence() {
            return sequence;
        }

        public void setSequence(int sequence) {
            this.sequence = sequence;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getCreateUser() {
            return createUser;
        }

        public void setCreateUser(int createUser) {
            this.createUser = createUser;
        }

        public String getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(String modifyTime) {
            this.modifyTime = modifyTime;
        }

        public int getModifyUser() {
            return modifyUser;
        }

        public void setModifyUser(int modifyUser) {
            this.modifyUser = modifyUser;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public List<ChildrenBean> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBean> children) {
            this.children = children;
        }

        public static class ChildrenBean {
            private int id;
            private String categoryName;
            private String categoryNameEn;
            private String categoryLogo;
            private int categoryDepath;
            private int categoryStatus;
            private int categoryType;
            private Object isHomeShow;
            private int sequence;
            private String createTime;
            private int createUser;
            private Object modifyTime;
            private Object modifyUser;
            private int pid;
            private String state;
            private List<?> children;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
            }

            public String getCategoryNameEn() {
                return categoryNameEn;
            }

            public void setCategoryNameEn(String categoryNameEn) {
                this.categoryNameEn = categoryNameEn;
            }

            public String getCategoryLogo() {
                return categoryLogo;
            }

            public void setCategoryLogo(String categoryLogo) {
                this.categoryLogo = categoryLogo;
            }

            public int getCategoryDepath() {
                return categoryDepath;
            }

            public void setCategoryDepath(int categoryDepath) {
                this.categoryDepath = categoryDepath;
            }

            public int getCategoryStatus() {
                return categoryStatus;
            }

            public void setCategoryStatus(int categoryStatus) {
                this.categoryStatus = categoryStatus;
            }

            public int getCategoryType() {
                return categoryType;
            }

            public void setCategoryType(int categoryType) {
                this.categoryType = categoryType;
            }

            public Object getIsHomeShow() {
                return isHomeShow;
            }

            public void setIsHomeShow(Object isHomeShow) {
                this.isHomeShow = isHomeShow;
            }

            public int getSequence() {
                return sequence;
            }

            public void setSequence(int sequence) {
                this.sequence = sequence;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getCreateUser() {
                return createUser;
            }

            public void setCreateUser(int createUser) {
                this.createUser = createUser;
            }

            public Object getModifyTime() {
                return modifyTime;
            }

            public void setModifyTime(Object modifyTime) {
                this.modifyTime = modifyTime;
            }

            public Object getModifyUser() {
                return modifyUser;
            }

            public void setModifyUser(Object modifyUser) {
                this.modifyUser = modifyUser;
            }

            public int getPid() {
                return pid;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public List<?> getChildren() {
                return children;
            }

            public void setChildren(List<?> children) {
                this.children = children;
            }

            @Override
            public String toString() {
                return "ChildrenBean{" +
                        "id=" + id +
                        ", categoryName='" + categoryName + '\'' +
                        ", categoryNameEn='" + categoryNameEn + '\'' +
                        ", categoryLogo='" + categoryLogo + '\'' +
                        ", categoryDepath=" + categoryDepath +
                        ", categoryStatus=" + categoryStatus +
                        ", categoryType=" + categoryType +
                        ", isHomeShow=" + isHomeShow +
                        ", sequence=" + sequence +
                        ", createTime='" + createTime + '\'' +
                        ", createUser=" + createUser +
                        ", modifyTime=" + modifyTime +
                        ", modifyUser=" + modifyUser +
                        ", pid=" + pid +
                        ", state='" + state + '\'' +
                        ", children=" + children +
                        '}';
            }
        }

    }

    @Override
    public String toString() {
        return "LifeClassifyModel{" +
                "data=" + data +
                '}';
    }
}
