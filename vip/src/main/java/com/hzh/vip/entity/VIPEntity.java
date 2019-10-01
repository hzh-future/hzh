package com.hzh.vip.entity;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class VIPEntity {

    private int id;
    /** vip编号*/
    private String code;
    /**姓名*/
    private String name;
    /**消费时间*/
    private String x_date;
    /**消费项目*/
    private String x_project;
    /**消费金额*/
    private int x_je;
    public VIPEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getX_date() {
        return x_date;
    }

    public void setX_date(String x_date) {
        this.x_date = x_date;
    }

    public String getX_project() {
        return x_project;
    }

    public void setX_project(String x_project) {
        this.x_project = x_project;
    }

    public int getX_je() {
        return x_je;
    }

    public void setX_je(int x_je) {
        this.x_je = x_je;
    }

    @Override
    public String toString() {
        return "VIPEntity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", x_date=" + x_date +
                ", x_project='" + x_project + '\'' +
                ", x_je=" + x_je +
                '}';
    }

   /* public static void main(String[] args) {
        Date date = new Date();
        String fmt = "yyyy-MM-dd hh:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        String dateStr = sdf.format(date);
        System.out.println(dateStr.toString());
    }*/
}
