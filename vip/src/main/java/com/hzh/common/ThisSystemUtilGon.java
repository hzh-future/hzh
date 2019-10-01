package com.hzh.common;

import org.springframework.util.DigestUtils;

public class ThisSystemUtilGon {
    //盐，用于混交md5
    private static final String slat = "&%5123***&&%%$$#@";

    public static String md5(String str) {
        String base = str +"/"+slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    public static void main(String[] args) {
        System.out.println(md5("123"));
    }

}
