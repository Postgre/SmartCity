package com.smartcity.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/4/29.
 */
public class Card_new {
        public String img;
        public String title;
        public String quanzi;
        public String ren;
        public String detail;
        private ArrayList<Data> data;

        public ArrayList<Data> getData() {
                return data;
        }

        public void setData(ArrayList<Data> data) {
                this.data = data;
        }

        public static class Data{
                public String img;
                public String group;

                public Data(String img,String group){
                        this.img = img;
                        this.group = group;
                }
        }
}
