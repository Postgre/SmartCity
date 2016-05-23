package com.smartcity.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/4/26.
 */
public class Circle_PeopleBean implements Serializable{

    /**
     * total : 4
     * code : 1
     * msg : null
     * data : [{"personId":8,"personCircleId":4,"personUserId":55,"personVipId":1,"personJob":2,"personIsVip":1,"personNewsNodisturb":1,"personLoginName":"巫瑞轩","personMorefield1":null,"personMorefield2":null,"personMorefield3":null,"scSysUser":{"id":null,"usercode":null,"username":"巫瑞轩","password":null,"userpic":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/sysImg/01.jpg","usersex":null,"userbirth":null,"residence":null,"signature":null,"salt":null,"locked":null,"isdel":null,"ismerchant":null,"isadmin":null,"createtime":null,"lasttime":null,"operation":null,"version":null},"sStartpage":null,"sPagerows":null},{"personId":20,"personCircleId":4,"personUserId":17,"personVipId":null,"personJob":2,"personIsVip":1,"personNewsNodisturb":1,"personLoginName":"15912345678","personMorefield1":null,"personMorefield2":null,"personMorefield3":null,"scSysUser":{"id":null,"usercode":null,"username":"admin","password":null,"userpic":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/sysImg/01.jpg","usersex":null,"userbirth":null,"residence":null,"signature":null,"salt":null,"locked":null,"isdel":null,"ismerchant":null,"isadmin":null,"createtime":null,"lasttime":null,"operation":null,"version":null},"sStartpage":null,"sPagerows":null},{"personId":21,"personCircleId":4,"personUserId":61,"personVipId":null,"personJob":2,"personIsVip":1,"personNewsNodisturb":1,"personLoginName":"admin","personMorefield1":null,"personMorefield2":null,"personMorefield3":null,"scSysUser":{"id":null,"usercode":null,"username":"huyuanhao","password":null,"userpic":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/sysImg/01.jpg","usersex":null,"userbirth":null,"residence":null,"signature":null,"salt":null,"locked":null,"isdel":null,"ismerchant":null,"isadmin":null,"createtime":null,"lasttime":null,"operation":null,"version":null},"sStartpage":null,"sPagerows":null},{"personId":29,"personCircleId":4,"personUserId":60,"personVipId":null,"personJob":2,"personIsVip":1,"personNewsNodisturb":1,"personLoginName":null,"personMorefield1":null,"personMorefield2":null,"personMorefield3":null,"scSysUser":{"id":null,"usercode":null,"username":"admin","password":null,"userpic":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/sysImg/01.jpg","usersex":null,"userbirth":null,"residence":null,"signature":null,"salt":null,"locked":null,"isdel":null,"ismerchant":null,"isadmin":null,"createtime":null,"lasttime":null,"operation":null,"version":null},"sStartpage":null,"sPagerows":null}]
     */

    private int total;
    private int code;
    private Object msg;
    /**
     * personId : 8
     * personCircleId : 4
     * personUserId : 55
     * personVipId : 1
     * personJob : 2
     * personIsVip : 1
     * personNewsNodisturb : 1
     * personLoginName : 巫瑞轩
     * personMorefield1 : null
     * personMorefield2 : null
     * personMorefield3 : null
     * scSysUser : {"id":null,"usercode":null,"username":"巫瑞轩","password":null,"userpic":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/sysImg/01.jpg","usersex":null,"userbirth":null,"residence":null,"signature":null,"salt":null,"locked":null,"isdel":null,"ismerchant":null,"isadmin":null,"createtime":null,"lasttime":null,"operation":null,"version":null}
     * sStartpage : null
     * sPagerows : null
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

    public static class DataBean implements Serializable{
        private int personId;
        private int personCircleId;
        private int personUserId;
        private int personVipId;
        private int personJob;
        private int personIsVip;
        private int personNewsNodisturb;
        private String personLoginName;
        private Object personMorefield1;
        private Object personMorefield2;
        private Object personMorefield3;
        /**
         * id : null
         * usercode : null
         * username : 巫瑞轩
         * password : null
         * userpic : http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/sysImg/01.jpg
         * usersex : null
         * userbirth : null
         * residence : null
         * signature : null
         * salt : null
         * locked : null
         * isdel : null
         * ismerchant : null
         * isadmin : null
         * createtime : null
         * lasttime : null
         * operation : null
         * version : null
         */

        private ScSysUserBean scSysUser;
        private Object sStartpage;
        private Object sPagerows;

        public int getPersonId() {
            return personId;
        }

        public void setPersonId(int personId) {
            this.personId = personId;
        }

        public int getPersonCircleId() {
            return personCircleId;
        }

        public void setPersonCircleId(int personCircleId) {
            this.personCircleId = personCircleId;
        }

        public int getPersonUserId() {
            return personUserId;
        }

        public void setPersonUserId(int personUserId) {
            this.personUserId = personUserId;
        }

        public int getPersonVipId() {
            return personVipId;
        }

        public void setPersonVipId(int personVipId) {
            this.personVipId = personVipId;
        }

        public int getPersonJob() {
            return personJob;
        }

        public void setPersonJob(int personJob) {
            this.personJob = personJob;
        }

        public int getPersonIsVip() {
            return personIsVip;
        }

        public void setPersonIsVip(int personIsVip) {
            this.personIsVip = personIsVip;
        }

        public int getPersonNewsNodisturb() {
            return personNewsNodisturb;
        }

        public void setPersonNewsNodisturb(int personNewsNodisturb) {
            this.personNewsNodisturb = personNewsNodisturb;
        }

        public String getPersonLoginName() {
            return personLoginName;
        }

        public void setPersonLoginName(String personLoginName) {
            this.personLoginName = personLoginName;
        }

        public Object getPersonMorefield1() {
            return personMorefield1;
        }

        public void setPersonMorefield1(Object personMorefield1) {
            this.personMorefield1 = personMorefield1;
        }

        public Object getPersonMorefield2() {
            return personMorefield2;
        }

        public void setPersonMorefield2(Object personMorefield2) {
            this.personMorefield2 = personMorefield2;
        }

        public Object getPersonMorefield3() {
            return personMorefield3;
        }

        public void setPersonMorefield3(Object personMorefield3) {
            this.personMorefield3 = personMorefield3;
        }

        public ScSysUserBean getScSysUser() {
            return scSysUser;
        }

        public void setScSysUser(ScSysUserBean scSysUser) {
            this.scSysUser = scSysUser;
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

        public static class ScSysUserBean implements Serializable{
            private Object id;
            private Object usercode;
            private String username;
            private Object password;
            private String userpic;
            private Object usersex;
            private Object userbirth;
            private Object residence;
            private Object signature;
            private Object salt;
            private Object locked;
            private Object isdel;
            private Object ismerchant;
            private Object isadmin;
            private Object createtime;
            private Object lasttime;
            private Object operation;
            private Object version;

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public Object getUsercode() {
                return usercode;
            }

            public void setUsercode(Object usercode) {
                this.usercode = usercode;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public Object getPassword() {
                return password;
            }

            public void setPassword(Object password) {
                this.password = password;
            }

            public String getUserpic() {
                return userpic;
            }

            public void setUserpic(String userpic) {
                this.userpic = userpic;
            }

            public Object getUsersex() {
                return usersex;
            }

            public void setUsersex(Object usersex) {
                this.usersex = usersex;
            }

            public Object getUserbirth() {
                return userbirth;
            }

            public void setUserbirth(Object userbirth) {
                this.userbirth = userbirth;
            }

            public Object getResidence() {
                return residence;
            }

            public void setResidence(Object residence) {
                this.residence = residence;
            }

            public Object getSignature() {
                return signature;
            }

            public void setSignature(Object signature) {
                this.signature = signature;
            }

            public Object getSalt() {
                return salt;
            }

            public void setSalt(Object salt) {
                this.salt = salt;
            }

            public Object getLocked() {
                return locked;
            }

            public void setLocked(Object locked) {
                this.locked = locked;
            }

            public Object getIsdel() {
                return isdel;
            }

            public void setIsdel(Object isdel) {
                this.isdel = isdel;
            }

            public Object getIsmerchant() {
                return ismerchant;
            }

            public void setIsmerchant(Object ismerchant) {
                this.ismerchant = ismerchant;
            }

            public Object getIsadmin() {
                return isadmin;
            }

            public void setIsadmin(Object isadmin) {
                this.isadmin = isadmin;
            }

            public Object getCreatetime() {
                return createtime;
            }

            public void setCreatetime(Object createtime) {
                this.createtime = createtime;
            }

            public Object getLasttime() {
                return lasttime;
            }

            public void setLasttime(Object lasttime) {
                this.lasttime = lasttime;
            }

            public Object getOperation() {
                return operation;
            }

            public void setOperation(Object operation) {
                this.operation = operation;
            }

            public Object getVersion() {
                return version;
            }

            public void setVersion(Object version) {
                this.version = version;
            }
        }
    }
}
