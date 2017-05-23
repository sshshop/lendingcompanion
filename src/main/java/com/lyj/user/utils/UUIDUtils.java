package com.lyj.user.utils;


import org.apache.struts2.convention.annotation.Action;

import java.util.UUID;

/**
 * Created by 盖世太保 on 2017/5/11.
 */
public class UUIDUtils {
    /**
     * 获得随机字符串
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
    @Action(value ="sendEmail")
    public  static String getNumber(){
        int code =(int)((Math.random()*9+1)*100000);
        String s=code+"";
        return s;
    }
}
