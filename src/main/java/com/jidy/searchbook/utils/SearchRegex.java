package com.jidy.searchbook.utils;


/**
 * Created by jidy on 2017/5/13.
 */
public class SearchRegex {
    String chinaeseRegex="[\u4e00-\u9fa5]";
    String regex="[` _~!@#$^&*()=+|{}':;',\\\\[\\\\].<>/?~！@#￥……&*（）\\-《》——|{}【】‘；：”“'。，、？]+";

    public String searchMaster(String inputInfo){
        inputInfo=inputInfo.trim();
        String regexSearch=inputInfo.replaceAll(regex,"+");
        return regexSearch;
    }

    public String[] searchFinal(String inputInfo) {
        inputInfo = inputInfo.trim();
        String str[] = new String[6];
        String str1[]=inputInfo.split(regex,6);
        for (int i=0;i<6;i++){
            if (i<str1.length){
                str[i]=str1[i];
            }else{
                str[i]=" ";
            }
        }
        return str;
    }
}
