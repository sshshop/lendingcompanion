package com.lj.booktemp.dao;

import com.upublic.vo.Book;
import com.upublic.vo.Booktem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 图书临时表的dao操作
 * Created by CD on 2017/5/7.
 */
public interface BooktemDao {
    @Insert("INSERT INTO `lendingpartner`.`booktem` (`cid`, `btname`, `adr`, `num`, `cover`, `sequence`, `btcontent`, `idt`, `cobn`, `btauthor`, `time`, `money`) VALUES " +
            "(#{booktem.cid},#{booktem.btname}, #{booktem.adr}, #{booktem.num}, #{booktem.cover}, #{booktem.sequence},#{booktem.btcontent}, #{booktem.idt},#{booktem.cobn},#{booktem.btauthor}, NOW(), #{booktem.money})")
    int addBooktem(@Param("booktem") Booktem booktem);
    @Select("select * from book order by cid ASC")
    List<Book> findBookALL();

    @Select("SELECT COUNT(*) FROM subscription WHERE bid=#{bid}")
    int countSub(Integer bid);
    @Delete("DELETE FROM subscription WHERE bid=#{bid}")
    void delSub(Integer bid);

    @Select("SELECT COUNT(*) FROM bookcomment WHERE bid=#{bid}")
    int countComment(Integer bid);
    @Delete("DELETE FROM bookcomment WHERE bid=#{bid}")
    void delComment(Integer bid);

    @Select("SELECT COUNT(*) FROM borrowbook WHERE bid=#{bid}")
    int countBorrowed(Integer bid);
    @Delete("DELETE FROM borrowbook WHERE bid=#{bid}")
    void delBorrowed(Integer bid);

    @Select("SELECT COUNT(*) FROM booktem WHERE btid=#{btid}")
    int countbooktem(Integer bid);
    @Delete("DELETE FROM booktem WHERE btid=#{btid}")
    void delBook(Integer btid);
}
