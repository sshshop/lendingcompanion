package com.jidy.utils;

import java.util.List;
/**
 * Created by jidy on 2017/5/11.
 *
 * 分页类，处理后台分页
 */
public class PageBean<T> {
    private int page;	// 当前页数
    private int totalCount; // 总记录数
    private int totalPage; // 总页数
    private int limit;	// 每页显示的记录数

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    private int begin;
    private List<T> list; // 每页显示数据的集合.
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }
    public List<T> getList() {
        return list;
    }
    public void setList(List<T> list) {
        this.list = list;
    }
}

