package com.smartcity.http.model;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: UserInfo.java
 * @author: fengliang
 * @date: 2016-04-29 15:16
 */
public class UserInfo extends BaseModel {
    private static final String TAG = "UserInfo";


    /**
     * apikey : 1460443564343
     * scSysUser : {"id":27,"usercode":"13657236021","username":"Yancy","password":"67c1951cdd28d9a72425a2fd685e7463","userpic":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/sysImg/01.jpg","usersex":"ç\u0094·","userbirth":"2016/04/07","residence":null,"signature":null,"salt":"7d72599d28144bcf2e181a809ef22450","locked":0,"isdel":0,"ismerchant":0,"isadmin":0,"createtime":"2016-04-09 14:49:53","lasttime":"2016-04-09 14:49:53","operation":null,"version":1}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String apikey;
        /**
         * id : 27
         * usercode : 13657236021
         * username : Yancy
         * password : 67c1951cdd28d9a72425a2fd685e7463
         * userpic : http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/sysImg/01.jpg
         * usersex : ç·
         * userbirth : 2016/04/07
         * residence : null
         * signature : null
         * salt : 7d72599d28144bcf2e181a809ef22450
         * locked : 0
         * isdel : 0
         * ismerchant : 0
         * isadmin : 0
         * createtime : 2016-04-09 14:49:53
         * lasttime : 2016-04-09 14:49:53
         * operation : null
         * version : 1
         */

        private ScSysUserBean scSysUser;

        public String getApikey() {
            return apikey;
        }

        public void setApikey(String apikey) {
            this.apikey = apikey;
        }

        public ScSysUserBean getScSysUser() {
            return scSysUser;
        }

        public void setScSysUser(ScSysUserBean scSysUser) {
            this.scSysUser = scSysUser;
        }

        public static class ScSysUserBean {
            private int id;
            private String usercode;
            private String password;
            private String username;
            private String userpic;
            private String usersex;
            private String userbirth;
            private String residence;
            private String signature;
            private String salt;
            private int locked;
            private int isdel;
            private int ismerchant;
            private int isadmin;
            private String createtime;
            private String lasttime;
            private String operation;
            private int version;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUsercode() {
                return usercode;
            }

            public void setUsercode(String usercode) {
                this.usercode = usercode;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getUserpic() {
                return userpic;
            }

            public void setUserpic(String userpic) {
                this.userpic = userpic;
            }

            public String getUsersex() {
                return usersex;
            }

            public void setUsersex(String usersex) {
                this.usersex = usersex;
            }

            public String getUserbirth() {
                return userbirth;
            }

            public void setUserbirth(String userbirth) {
                this.userbirth = userbirth;
            }

            public String getResidence() {
                return residence;
            }

            public void setResidence(String residence) {
                this.residence = residence;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getSalt() {
                return salt;
            }

            public void setSalt(String salt) {
                this.salt = salt;
            }

            public int getLocked() {
                return locked;
            }

            public void setLocked(int locked) {
                this.locked = locked;
            }

            public int getIsdel() {
                return isdel;
            }

            public void setIsdel(int isdel) {
                this.isdel = isdel;
            }

            public int getIsmerchant() {
                return ismerchant;
            }

            public void setIsmerchant(int ismerchant) {
                this.ismerchant = ismerchant;
            }

            public int getIsadmin() {
                return isadmin;
            }

            public void setIsadmin(int isadmin) {
                this.isadmin = isadmin;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getLasttime() {
                return lasttime;
            }

            public void setLasttime(String lasttime) {
                this.lasttime = lasttime;
            }

            public String getOperation() {
                return operation;
            }

            public void setOperation(String operation) {
                this.operation = operation;
            }

            public int getVersion() {
                return version;
            }

            public void setVersion(int version) {
                this.version = version;
            }

            @Override
            public String toString() {
                return "ScSysUserBean{" +
                        "id=" + id +
                        ", usercode='" + usercode + '\'' +
                        ", username='" + username + '\'' +
                        ", userpic='" + userpic + '\'' +
                        ", usersex='" + usersex + '\'' +
                        ", userbirth='" + userbirth + '\'' +
                        ", residence='" + residence + '\'' +
                        ", signature='" + signature + '\'' +
                        ", salt='" + salt + '\'' +
                        ", locked=" + locked +
                        ", isdel=" + isdel +
                        ", ismerchant=" + ismerchant +
                        ", isadmin=" + isadmin +
                        ", createtime='" + createtime + '\'' +
                        ", lasttime='" + lasttime + '\'' +
                        ", operation='" + operation + '\'' +
                        ", version=" + version +
                        '}';
            }
        }
    }
}
