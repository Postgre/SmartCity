package com.smartcity.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/4/8.
 */
public class New implements Serializable{

    /**
     * total : 0
     * code : 1
     * msg : 查询成功!
     * data : {"ScCmsChannelList":[{"channelId":1004,"channelName":"时尚","parentChannelId":null,"channelPriority":47,"iconUrl":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/cms/2302041384-1.jpg","isRecommend":1,"isDisplay":1},{"channelId":1005,"channelName":"星座学","parentChannelId":null,"channelPriority":46,"iconUrl":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/cms/4040938795.png","isRecommend":1,"isDisplay":1},{"channelId":1006,"channelName":"体育","parentChannelId":null,"channelPriority":45,"iconUrl":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/cms/5319845831.png","isRecommend":1,"isDisplay":1},{"channelId":1007,"channelName":"健康","parentChannelId":null,"channelPriority":44,"iconUrl":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/cms/4875769775.png","isRecommend":1,"isDisplay":1},{"channelId":1008,"channelName":"育儿","parentChannelId":null,"channelPriority":43,"iconUrl":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/cms/5558435306.png","isRecommend":1,"isDisplay":1},{"channelId":1009,"channelName":"军事","parentChannelId":null,"channelPriority":42,"iconUrl":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/cms/5319951276.png","isRecommend":1,"isDisplay":1},{"channelId":1010,"channelName":"汽车","parentChannelId":null,"channelPriority":41,"iconUrl":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/cms/6724906255.png","isRecommend":1,"isDisplay":1},{"channelId":1011,"channelName":"游戏","parentChannelId":null,"channelPriority":40,"iconUrl":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/cms/1853725712.jpg","isRecommend":1,"isDisplay":1},{"channelId":1012,"channelName":"科学","parentChannelId":null,"channelPriority":39,"iconUrl":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/cms/7086699053.jpg","isRecommend":1,"isDisplay":1},{"channelId":1013,"channelName":"社会","parentChannelId":null,"channelPriority":38,"iconUrl":null,"isRecommend":1,"isDisplay":1},{"channelId":1014,"channelName":"科技","parentChannelId":null,"channelPriority":37,"iconUrl":null,"isRecommend":1,"isDisplay":1},{"channelId":1015,"channelName":"国际","parentChannelId":null,"channelPriority":36,"iconUrl":null,"isRecommend":1,"isDisplay":1},{"channelId":1016,"channelName":"美食","parentChannelId":null,"channelPriority":35,"iconUrl":null,"isRecommend":1,"isDisplay":1},{"channelId":1017,"channelName":"娱乐","parentChannelId":null,"channelPriority":34,"iconUrl":null,"isRecommend":1,"isDisplay":1},{"channelId":1018,"channelName":"家居","parentChannelId":null,"channelPriority":33,"iconUrl":null,"isRecommend":1,"isDisplay":1},{"channelId":1019,"channelName":"财经","parentChannelId":null,"channelPriority":32,"iconUrl":null,"isRecommend":1,"isDisplay":1},{"channelId":1020,"channelName":"动漫","parentChannelId":null,"channelPriority":30,"iconUrl":null,"isRecommend":1,"isDisplay":1},{"channelId":1021,"channelName":"女性","parentChannelId":null,"channelPriority":29,"iconUrl":null,"isRecommend":1,"isDisplay":1},{"channelId":10001,"channelName":"宠物","parentChannelId":null,"channelPriority":25,"iconUrl":null,"isRecommend":1,"isDisplay":0},{"channelId":10002,"channelName":"视频","parentChannelId":null,"channelPriority":25,"iconUrl":null,"isRecommend":1,"isDisplay":0},{"channelId":10003,"channelName":"段子","parentChannelId":null,"channelPriority":25,"iconUrl":null,"isRecommend":1,"isDisplay":0},{"channelId":10004,"channelName":"趣图","parentChannelId":null,"channelPriority":25,"iconUrl":null,"isRecommend":1,"isDisplay":0},{"channelId":10005,"channelName":"美女","parentChannelId":null,"channelPriority":25,"iconUrl":null,"isRecommend":1,"isDisplay":0},{"channelId":10006,"channelName":"正能量","parentChannelId":null,"channelPriority":25,"iconUrl":null,"isRecommend":1,"isDisplay":0},{"channelId":10007,"channelName":"特卖","parentChannelId":null,"channelPriority":25,"iconUrl":null,"isRecommend":1,"isDisplay":0},{"channelId":10008,"channelName":"房产","parentChannelId":null,"channelPriority":25,"iconUrl":null,"isRecommend":1,"isDisplay":0},{"channelId":10009,"channelName":"搞笑","parentChannelId":null,"channelPriority":25,"iconUrl":null,"isRecommend":1,"isDisplay":0}]}
     */

    private int total;
    private int code;
    private String msg;
    private DataBean data;

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * channelId : 1004
         * channelName : 时尚
         * parentChannelId : null
         * channelPriority : 47
         * iconUrl : http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/cms/2302041384-1.jpg
         * isRecommend : 1
         * isDisplay : 1
         */

        private List<ScCmsChannelListBean> ScCmsChannelList;

        public List<ScCmsChannelListBean> getScCmsChannelList() {
            return ScCmsChannelList;
        }

        public void setScCmsChannelList(List<ScCmsChannelListBean> ScCmsChannelList) {
            this.ScCmsChannelList = ScCmsChannelList;
        }

        public static class ScCmsChannelListBean {
            private int channelId;
            private String channelName;
            private Object parentChannelId;
            private int channelPriority;
            private String iconUrl;
            private int isRecommend;
            private int isDisplay;

            public int getChannelId() {
                return channelId;
            }

            public void setChannelId(int channelId) {
                this.channelId = channelId;
            }

            public String getChannelName() {
                return channelName;
            }

            public void setChannelName(String channelName) {
                this.channelName = channelName;
            }

            public Object getParentChannelId() {
                return parentChannelId;
            }

            public void setParentChannelId(Object parentChannelId) {
                this.parentChannelId = parentChannelId;
            }

            public int getChannelPriority() {
                return channelPriority;
            }

            public void setChannelPriority(int channelPriority) {
                this.channelPriority = channelPriority;
            }

            public String getIconUrl() {
                return iconUrl;
            }

            public void setIconUrl(String iconUrl) {
                this.iconUrl = iconUrl;
            }

            public int getIsRecommend() {
                return isRecommend;
            }

            public void setIsRecommend(int isRecommend) {
                this.isRecommend = isRecommend;
            }

            public int getIsDisplay() {
                return isDisplay;
            }

            public void setIsDisplay(int isDisplay) {
                this.isDisplay = isDisplay;
            }
        }
    }
}
