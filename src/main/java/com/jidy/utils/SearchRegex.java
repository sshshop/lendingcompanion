package com.jidy.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jidy on 2017/5/13.
 */
public class SearchRegex {
    String chinaeseRegex="[\u4e00-\u9fa5]";
    String regex="[` _~!@#$^&*()（）=+|{}':;',\\\\[\\\\].<>/?~！@#￥……&*（）\\-《》——|{}【】‘；：”“'。，、？]+";

    /*
    * 第一次接收前台字符串，将特殊字符去除
    *
    * 返回结果为查询关键字
    * */
    public String searchMaster(String inputInfo){
        if(inputInfo==null){
            return "";
        }else {
            inputInfo=inputInfo.trim();
            String regexSearch=inputInfo.replaceAll(regex,"");
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
        inputInfo=inputInfo.replaceAll(regex," ").trim();
        String str[] = new String[6];
        String str1[]=inputInfo.split(" ",6);
        for (int i=0;i<6;i++){
            if (i<str1.length){
                str[i]=str1[i];
            }else{
                str[i]=" ";
            }
        }
        return str;
    }

    public String splitRed(String author){
        Pattern p = Pattern.compile("<font color='red'><b>");
        Matcher m;
        m=p.matcher(author);
        while (m.find()){
            System.out.println(m.group());
           author= m.replaceAll("").trim();
        }
        p=Pattern.compile("</b></font>");
        m=p.matcher(author);
        while (m.find()){
            author= m.replaceAll("").trim();
        }
        return author;
    }

}
