package com.jidy.searchbook.utils;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * Created by jidy on 2017/5/15.
 */
public class SearchBookSqlProvider {

    public String findByBname(Map<String, Object> map, final int begin, final int limit){
        for (int i=0;i<map.size();i++) {
            String name= (String) map.get(i+"");
            System.out.println("name:"+name);
        }
        String bname= (String) map.get(0+"");
        String nameTwo=(String) map.get(1+"");
        return  new SQL(){{
            SELECT("bcover,bname,bauthor,nborrowed,badr,bcobn,bnum");
            FROM("book");
            WHERE("bname like CONCAT('%',#{nameOne},'%') " +
                    "OR bname like CONCAT('%',#{nameTwo},'%')");
        }}.toString();
    }

    public String findByBnameCount(Map map){
        for (int i=0;i<map.size();i++) {
            String name= (String) map.get(i+"");
            System.out.println("count:"+name);
        }
        final String name= (String) map.get("0");
        final String bname1=(String) map.get(1+"");
        return  new SQL(){{
            SELECT(" count(*) ");
            FROM("book");
            WHERE("bname REGEXP "+name);
        }}.toString();
    }
}
