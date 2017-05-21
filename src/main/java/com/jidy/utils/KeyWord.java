package com.jidy.utils;


import com.upublic.vo.Book;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by jidy on 2017/5/17.
 *
 * 接收处理的后关键字
 * @SearchRegex
 */
public class KeyWord {
    Book book=new Book();

    /*
    * 用于第一次关键字查询
    * 初始化book，给book赋值
    *
    *返回查询关键字
    * */

    public Book bookInfoMaster(String search) {
        book.setBname(search);
        book.setInitials(search);
        book.setFight(search);
        book.setBnum(search);
        book.setBauthor(search);
        book.setBadr(search);
        return book;
    }

    /*
   * 用于第二次关键字查询
   * 初始化book，给book赋值
   *
   *返回查询关键字
   * */
    public Book bookInfoFinal(String[] search) {
        book.setBname(search[0]);
        book.setInitials(search[1]);
        book.setBauthor(search[2]);
        book.setFight(search[3]);
        book.setBadr(search[4]);
        book.setBnum(search[5]);
        return book;
    }

    /*
    * 去重并保持排序
    *
    * 返回结果list到前台页面
    *
    * */
    public List<Book> uniq(List<Book> list) {
        List<Book> listWithoutDup = new ArrayList(new LinkedHashSet(list));
        return listWithoutDup;
    }

}
