package com.jidy.searchbook.dao;

import com.upublic.vo.Book;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by jidy on 2017/5/8.
 */
public interface BookDao {
    /*缩图、标题、作者、藏书量
    * 模糊查询：
    * name like CONCAT('%',#{name},'%')
    * */
    @Select("select bcover,bname,bauthor,nborrowed ,badr from book " +
            "where bname like CONCAT('%',#{bname},'%') " +
            "OR initials like CONCAT('%',#{initials},'%') " +
            "OR fight like CONCAT('%',#{fight},'%') " +
            "OR bnum like CONCAT('%',#{bnum},'%') " +
            "OR badr like CONCAT('%',#{badr},'%') " +
            "OR bauthor like CONCAT('%',#{bauthor},'%') ")

    List<Book> searchBookInfo(@Param("bname") String bname,
                              @Param("initials") String initials,
                              @Param("fight") String fight,
                              @Param("bnum") String bnum,
                              @Param("badr") String badr,
                              @Param("bauthor") String bauthor);

}
