package com.hzh.vip.entity;

public class ClientEntity {
    /**编号*/
    private int id;
    /**电话*/
    private String code;
    /**姓名*/
    private String name;
    /**目前总消费金额*/
    private int money;
    /**当前等级*/
    private String dengji;
    /**距离下一等级还差多少金额*/
    private int xia;

    public ClientEntity() {
         this.dengji = "普通会员";
         this.money = 0;
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getDengji() {
        return dengji;
    }

    public void setDengji(String dengji) {
        this.dengji = dengji;
    }

    public int getXia() {
        return xia;
    }

    public void setXia(int xia) {
        this.xia = xia;
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", dengji='" + dengji + '\'' +
                ", xia=" + xia +
                '}';
    }
}
