package com.lanou.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MyUtil {
    public String  md5(String password) {
        //加密
        Md5Hash md5Hash = new Md5Hash(password,"123",2);
        return md5Hash.toString();
    }
}
