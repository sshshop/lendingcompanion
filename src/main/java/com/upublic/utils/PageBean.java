package com.upublic.utils;

import java.util.List;

/**
 * 分页类的封装，通过构造函数实现大量分页代码覆写
 * Created by Rabit on 2017/5/16.
 * @author Rabit
 */
public class PageBean<T> {
    private int page;    // 当前页数
    private int totalCount; // 总记录数
    private int totalPage; // 总页数
    private int limit;    // 每页显示的记录数
    private List<T> list; // 每页显示数据的集合.
    private int begin;
    private PageParents pageParents;

    public PageBean() {
    }

    /*测试接口一*/
    public PageBean(int page, int totalCount, int limit, PageParents pageParents) {
        this.page = page;
        this.totalCount = totalCount;
        if (totalCount % limit == 0) {
            this.totalPage = totalCount / limit;
        } else {
            this.totalPage = totalCount / limit + 1;
        }
        this.limit = limit;
        this.begin = (page - 1) * limit;
      //  this.list = pageParents.findAll(begin, limit);
    }

    /*测试接口上三*/
    public PageBean(int page, int totalCount, int limit) {
        this.page = page;
        this.totalCount = totalCount;
        if (totalCount % limit == 0) {
            this.totalPage = totalCount / limit;
        } else {
            this.totalPage = totalCount / limit + 1;
        }
        this.limit = limit;
        this.begin = (page - 1) * limit;
    }

    /*测试接口四*/
    public PageBean(int page, int limit, PageParents pageParents) {
        this.page = page;
        if (totalCount % limit == 0) {
            this.totalPage = totalCount / limit;
        } else {
            this.totalPage = totalCount / limit + 1;
        }
        this.limit = limit;
        this.begin = (page - 1) * limit;
        this.totalCount = pageParents.finsCountALL();
   //     this.list = pageParents.findAll(begin, limit);

    }

    /**
     * 测试接口五,通过传入id查询分类
     * @param page 当前页数
     * @param limit  每页显示的数量
     * @param pageParents  dao层的父类
     * @param id  需要同一实体类的id
     */
    public PageBean(int page, int limit, PageParents pageParents,int id) {
        this.page = page;
        if (totalCount % limit == 0) {
            this.totalPage = totalCount / limit;
        } else {
            this.totalPage = totalCount / limit + 1;
        }
        this.limit = limit;
        this.begin = (page - 1) * limit;
        this.totalCount = pageParents.findCountByid(id);
        this.list = pageParents.findAll(id,begin, limit);

    }

    public PageParents getPageParents() {
        return pageParents;
    }

    public void setPageParents(PageParents pageParents) {
        this.pageParents = pageParents;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

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

