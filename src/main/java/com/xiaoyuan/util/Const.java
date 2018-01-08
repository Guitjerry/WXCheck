package com.xiaoyuan.util;

/**
 * Created by dnys on 2017/9/12.
 */
public class Const {
    public enum JilvArray{

        ONE(1,"个人纪律"),
        TWO(2,"班级纪律");

        private int code;
        private String name;

        private JilvArray(int code, String name) {
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

        ONE(1,"七年级"),
        TWO(2,"八年级"),
        Three(3,"九年级");

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
    public static  JilvArray[] getJilvArray(){
        return Const.JilvArray.values();
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
    public static  final Integer PAGE_SIZE=10;
    public static final String ROLE_ADMIN = "admin";//管理员
    public static final String ROLE_BANZHUREN = "banzhuren";//班主任
    public static final String ROLE_XINGZHENG = "xingzheng";//行政人员
    public static final String ROLE_MANAGE = "manager";//校级管理员
    public static final String ROLE_TEACHER = "teacher";//科任教师
}
