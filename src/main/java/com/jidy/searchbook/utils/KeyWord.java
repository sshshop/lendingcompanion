package com.jidy.searchbook.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by jidy on 2017/5/17.
 */
public class KeyWord {
    public String replace(String[] str, String string, String str1){
        Pattern p = Pattern.compile(string);
        Matcher m;
        StringBuffer stringBuffer=new StringBuffer();
        StringBuffer myStr=new StringBuffer();
            for (int i=0;i<str.length;i++){
                m=p.matcher(str[i]);
                while(m.find()) {
                    stringBuffer.append(str[i].substring(0,m.start()));
                    stringBuffer.append(str1);
                    stringBuffer.append(str[i].substring(m.end()));
                }
        }
        return stringBuffer.toString();
    }
}
