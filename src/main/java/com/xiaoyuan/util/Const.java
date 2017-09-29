package com.xiaoyuan.util;

/**
 * Created by dnys on 2017/9/12.
 */
public class Const {
    public enum DepthArray{

        ONE(1,"一级菜单"),
        TWO(2,"二级菜单");

        private int code;
        private String name;

        private DepthArray(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }
        public void setCode(int code) {
            this.code = code;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
    public enum NianjiArray{

        ONE(1,"高中一年级"),
        TWO(2,"高中二年级"),
        Three(3,"高中三年级");

        private int code;
        private String name;

        private NianjiArray(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }
        public void setCode(int code) {
            this.code = code;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
    public enum BanjiTypeArray{

        COMMON(1,"普通班"),
        IMPORTANCE(2,"重点班"),
        SUPERIMPORTANCE(3,"超重点班");

        private int code;
        private String name;

        private BanjiTypeArray(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }
        public void setCode(int code) {
            this.code = code;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
    public static  DepthArray[] getDepthArray(){
        return Const.DepthArray.values();
    }
    public static NianjiArray[] getNianjiArray(){return Const.NianjiArray.values();}
    public static BanjiTypeArray[] getBanjiTypeArray(){return Const.BanjiTypeArray.values();}


    /**静态文件*/
    public static final String[] RESOURCES =  new String[] { "jpg", "png", "gif", "css","js", "swf", "ttf", "woff","mp4","webm" };
    public static String[] arr_sex = {"", "男", "女"};

    public String[] getArr_sex() {
        return arr_sex;
    }

    public void setArr_sex(String[] arr_sex) {
        this.arr_sex = arr_sex;
    }
    public static  final Integer PAGE_SIZE=2;
}