package com.jidy.searchbook.utils;

import com.upublic.vo.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jidy on 2017/5/16.
 */

public class KeyWordRed<T> {
    public List<T> replacearry(List<T> strSource, String []strFrom){
        List<T> list =new ArrayList<T>();
        List<T> listBook =new ArrayList<T>();
        list.addAll(strSource);
        for(int j=0;j<strFrom.length;j++){
            list=replace(strSource,strFrom[j],"<font color='red'><b>"+strFrom[j]+"</b></font>");
            listBook.addAll(list);
        }
        return listBook;

    }

    List<T> replace(List<T> strSource, String strFrom, String strTo) {
        List<T> list=new ArrayList<T>();
        Pattern p = Pattern.compile("xzzx");
        //Matcher m = p.matcher(list.get(0));
        strSource.get(0);
        return list;
    }
}
