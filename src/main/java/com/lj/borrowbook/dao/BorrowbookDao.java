package com.lj.borrowbook.dao;

import com.upublic.vo.Borrowbook;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * Created by CD on 2017/5/7.
 */
public interface BorrowbookDao {
    @Insert("INSERT INTO borrowbook(uid,bid,btime,rtime,bstatus,ttime,money)values(#{borrowbook.uid},#{borrowbook.bid},now(),#{borrowbook.rtime},1,#{borrowbook.ttime},0)")
    void insertBorrowdbook(@Param("borrowbook") Borrowbook borrowbook);
}
