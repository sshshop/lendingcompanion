package com.jidy.utils;


/**
 * Created by jidy on 2017/5/13.
 */
public class SearchRegex {
    String chinaeseRegex="[\u4e00-\u9fa5]";
    String regex="[` _~!@#$^&*()=+|{}':;',\\\\[\\\\].<>/?~！@#￥……&*（）\\-《》——|{}【】‘；：”“'。，、？]+";

    /*
    * 第一次接收前台字符串，将特殊字符去除
    *
    * 返回结果为查询关键字
    * */
    public String searchMaster(String inputInfo){
        if(inputInfo==null){
            return "";
        }
        else {
            inputInfo=inputInfo.trim();
            String regexSearch=inputInfo.replaceAll(regex,"+");
            return regexSearch;
        }
    }

    /*
    * 如果第一次查询为空则匹配第二次
    *
    * 将前台输入字符串按特殊符号分割为多个关键字进行查询
    * 返回结果为查询关键字的数组
    *
    * */

    public String[] searchFinal(String inputInfo) {
        inputInfo = inputInfo.trim();
        String str[]=inputInfo.split(regex);
        return str;
    }


}
