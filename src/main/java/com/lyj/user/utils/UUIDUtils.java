package com.lyj.user.utils;

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
}
