package com.smartcity.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/4/29.
 */
public class Talent {
        public String headerIcon;
        public String nickname;
        public String cityName;
        public String educationName;
        public String workYearName;
        private ArrayList<Data> data;

        public ArrayList<Data> getData() {
                return data;
        }

        public void setData(ArrayList<Data> data) {
                this.data = data;
        }

        public static class Data{
                public String img;
                public String title;
                public String name;
                public int join;

                public Data(String img,String title,String name,int join){
                        this.img = img;
                        this.title = title;
                        this.name = name;
                        this.join = join;
                }
        }
}
