package com.hzh.common;

public class ThisSystemUtil {

    public static String asserNotBlank(String message,String target){
        if(target == null ||(target.trim()).length() == 0){
            throw new ThisSystemException(message);
        }
        return  target;
    }

    public static  String $(String message,String target){
        return asserNotBlank(message,target);
    }

    public static void assertNotNull(String message,Object o){
        if(o == null){
            throw new ThisSystemException(message);
        }
    }

    public static void assertIntNull(String message,int o){
        if(o == 0){
            throw new ThisSystemException(message);
        }
    }

    public static void assertNull(String message,Object o){
        if(o != null){
            throw new ThisSystemException(message);
        }
    }

    public static void assertEquals(String message,Object a,Object  b){
        if (!(a == null? a==b:a.equals(b))){
            throw new ThisSystemException(message);
        }
    }

    public static void assertNotEquals(String message,Object a,Object b){
        if(a==null?a==b:a.equals(b)){
            throw new ThisSystemException(message);
        }
    }

    /**判断等级*/
    public static String Grade(int money){
        if(money<100){
            return "不是会员";
        }
        else if(100<=money && money<1000){
            return "普通VIP";
        }
        else if(1000<=money && money<5000){
            return "黄金VIP";
        }
        else if(5000<=money && money<10000){
            return "白金VIP";
        }
        else if(10000<=money && money<20000){
            return "砖石VIP";
        }
        else{
            return "终身VIP";
        }
    }

    /**判断距离下一等级还差多少积分*/
    public static int UpGrade(int money){
        if(100>money){
            return 100-money;
        }
        else if(100<=money && money<1000){
            return 1000-money;
        }
        else if(1000<=money && money<5000){
            return 5000-money;
        }
        else if(5000<=money && money<10000){
            return 10000-money;
        }
        else if(10000<=money && money<20000){
            return 20000-money;
        }
        else{
            return money;
        }

    }













}
