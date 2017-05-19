package com.jidy.searchbook.utils;

import com.upublic.vo.Book;

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
        String regex="[` _~!@#$^&*()=+|{}':;',\\\\[\\\\].<>/?~！@#￥……&*（）\\-《》——|{}【】‘；：”“'。，、？]+";
        inputInfo = inputInfo.trim();
        String[] strFrom=inputInfo.split(regex);
        List<T> list =new ArrayList<T>();
        List<T> listBook =new ArrayList<T>();
        list.addAll(strSource);
        for(int j=0;j<strFrom.length;j++){
            if (!strFrom[j].equals(" ")){
                try {
                    list=replace(list,strFrom[j],"<font color='red'><b>"+strFrom[j]+"</b></font>");
                    list=replace_1(list,strFrom[j],"<font color='red'><b>"+strFrom[j]+"</b></font>");
                    list=replace_2(list,strFrom[j],"<font color='red'><b>"+strFrom[j]+"</b></font>");
                    list=replace_3(list,strFrom[j],"<font color='red'><b>"+strFrom[j]+"</b></font>");
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
            try {
                fields = strSource.get(i).getClass().getDeclaredField("bname");
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
                    stringBuffer.append(str.substring(0,m.start()));
                    stringBuffer.append(strTo);
                    stringBuffer.append(str.substring(m.end()));
                }
                int length=stringBuffer.length();
                if (length!=0){
                    str= stringBuffer.toString();
                    stringBuffer.delete(0,length);
                }
                fields.set(oi,str);
            }
        return strSource;
        }

    List<T> replace_2(List<T> strSource, String strFrom, String strTo) throws IllegalAccessException {
        StringBuffer stringBuffer=new StringBuffer();
        Pattern p = Pattern.compile(strFrom,Pattern.CASE_INSENSITIVE);
        Matcher m;
        for (int i = 0; i < strSource.size(); i++) {
            Field fields = null;
            try {
                fields = strSource.get(i).getClass().getDeclaredField("bnum");
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
                stringBuffer.append(str.substring(0,m.start()));
                stringBuffer.append(strTo);
                stringBuffer.append(str.substring(m.end()));
            }
            int length=stringBuffer.length();
            if (length!=0){
                str= stringBuffer.toString();
                stringBuffer.delete(0,length);
            }
            fields.set(oi,str);
        }
        return strSource;
    }
    List<T> replace_3(List<T> strSource, String strFrom, String strTo) throws IllegalAccessException {
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
                stringBuffer.append(str.substring(0,m.start()));
                stringBuffer.append(strTo);
                stringBuffer.append(str.substring(m.end()));
            }
            int length=stringBuffer.length();
            if (length!=0){
                str= stringBuffer.toString();
                stringBuffer.delete(0,length);
            }
            fields.set(oi,str);
        }
        return strSource;
    }

    List<T> replace_1(List<T> strSource, String strFrom, String strTo) throws IllegalAccessException {
        StringBuffer stringBuffer=new StringBuffer();
        Pattern p = Pattern.compile(strFrom,Pattern.CASE_INSENSITIVE);
        Matcher m;
        for (int i = 0; i < strSource.size(); i++) {
            Field fields = null;
            try {
                fields = strSource.get(i).getClass().getDeclaredField("badr");
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
                stringBuffer.append(str.substring(0,m.start()));
                stringBuffer.append(strTo);
                stringBuffer.append(str.substring(m.end()));
            }
            int length=stringBuffer.length();
            if (length!=0){
                str= stringBuffer.toString();
                stringBuffer.delete(0,length);
            }
            fields.set(oi,str);
        }
        return strSource;
    }
}
