package com.jidy.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jidy on 2017/5/16.
 */

public class KeyWordRed<T>{
    public List<T> replaceList(List<T> strSource, String inputInfo){
        String regex="[` _~!@#$^&*()（）=+|{}':;',\\\\[\\\\].<>/?~！@#￥……&*（）\\-《》——|{}【】‘；：”“'。，、？]+";
        inputInfo=inputInfo.replaceAll(regex," ").trim();
        String[] strFrom=inputInfo.split(" ");
        List<T> list =new ArrayList<T>();
        List<T> listBook =new ArrayList<T>();
        list.addAll(strSource);
        for(int j=0;j<strFrom.length;j++){
            if (!strFrom[j].equals(" ")){
                try {
                    list=replace(list,strFrom[j],"<font color='red'><b>"+strFrom[j]+"</b></font>");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            listBook.addAll(list);
        }
        return listBook;

    }

    List<T> replace(List<T> strSource, String strFrom, String strTo) throws IllegalAccessException {
        StringBuffer stringBuffer=new StringBuffer();
        Pattern p = Pattern.compile(strFrom,Pattern.CASE_INSENSITIVE);
        Matcher m;
        for (int i = 0; i < strSource.size(); i++) {
            Field fields = null;
            String string[]={"bname","bnum","bauthor","badr"};
            for (int j=0;j<4;j++){
                try {
                    fields = strSource.get(i).getClass().getDeclaredField(string[j]);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }

                Object oi = strSource.get(i);
                if(!fields.isAccessible()){
                    fields.setAccessible(true);
                }
                String str=fields.get(oi).toString();
                m=p.matcher(str);
                while(m.find()){
                    str=m.replaceAll(strTo);
                }
                fields.set(oi,str);
            }
        }
        return strSource;
    }

    public List<T> replaceListB(List<T> strSource, String inputInfo){
        inputInfo=inputInfo.trim();
        List<T> listBook =new ArrayList<T>();
        try {
            strSource=replaceB(strSource,inputInfo,"<font color='red'><b>"+inputInfo+"</b></font>");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        listBook.addAll(strSource);
        return listBook;

    }

    List<T> replaceB(List<T> strSource, String strFrom, String strTo) throws IllegalAccessException {
        StringBuffer stringBuffer=new StringBuffer();
        Pattern p = Pattern.compile(strFrom,Pattern.CASE_INSENSITIVE);
        Matcher m;
        for (int i = 0; i < strSource.size(); i++) {
            Field fields = null;
            try {
                fields = strSource.get(i).getClass().getDeclaredField("bauthor");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            Object oi = strSource.get(i);
                if(!fields.isAccessible()){
                    fields.setAccessible(true);
                }
                String str=fields.get(oi).toString();
                m=p.matcher(str);
                while(m.find()){
                    str=m.replaceAll(strTo);
                }
                fields.set(oi,str);
        }
        return strSource;
    }


}
