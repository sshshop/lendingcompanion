package com.jidy.searchbook.dao;

import com.upublic.vo.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by jidy on 2017/5/8.
 */
public interface BookDao {
    /*缩图、标题、作者、藏书量
    * 模糊查询：
    * name like CONCAT('%',#{name},'%')
    * SELECT a FROM foo WHERE b = 1 LIMIT 100,10;
    * */

    //查询总条数
    @Select("select count(*) from book " +
            "where bname REGEXP CONCAT('(',#{bname},')')" +
            "OR initials REGEXP CONCAT('(',#{initials},')') " +
            "OR fight REGEXP CONCAT('(',#{fight},')') " +
            "OR badr REGEXP CONCAT('(',#{badr},')') " +
            "OR bauthor REGEXP CONCAT('(',#{bauthor},')') ")
    int findByCount(@Param("bname") String bname,
                    @Param("initials") String initials,
                    @Param("fight") String fight,
                    @Param("badr") String badr,
                    @Param("bauthor") String bauthor);
    /*
    * SELECT a FROM foo WHERE b = 1 LIMIT 100,10;
    * #{begin,jdbcType=INTEGER},#{limit,jdbcType=INTEGER}
    * 查询页数
    * */
    @Select("select bid,bcover,bname,bauthor,nborrowed,badr,bcobn,bnum from book " +
            "where bname REGEXP CONCAT('(',#{bname},')')" +
            "OR initials REGEXP CONCAT('(',#{initials},')') " +
            "OR fight REGEXP CONCAT('(',#{fight},')') " +
            "OR badr REGEXP CONCAT('(',#{badr},')') " +
            "OR bauthor REGEXP CONCAT('(',#{bauthor},')') " +
            " LIMIT #{begin},#{limit}")
    List<Book> findByPage(@Param("bname") String bname,
                          @Param("initials") String initials,
                          @Param("fight") String fight,
                          @Param("badr") String badr,
                          @Param("bauthor") String bauthor,
                          @Param("begin") Integer begin,
                          @Param("limit") Integer limit);
    //第二次查询
    @Select("select count(*) from book " +
            "where bname REGEXP CONCAT('(',#{bname},')')" )
    int findByBnameCount(@Param("bname") String bname,
                         @Param("initials") String initials,
                         @Param("fight") String fight,
                         @Param("badr") String badr,
                         @Param("bauthor") String bauthor);

    @Select("select bcover,bname,bauthor,nborrowed,badr,bcobn,bnum from book " +
            "where bname REGEXP CONCAT('(',#{bname},')')" +
            "OR bname REGEXP CONCAT('(',#{initials},')') " +
            "OR bname REGEXP CONCAT('(',#{fight},')') " +
            "OR bname REGEXP CONCAT('(',#{badr},')') " +
            "OR bname REGEXP CONCAT('(',#{bauthor},')') " +
            " LIMIT #{begin},#{limit}")
    List<Book> findByBname(@Param("bname") String bname,
                           @Param("initials") String initials,
                           @Param("fight") String fight,
                           @Param("badr") String badr,
                           @Param("bauthor") String bauthor,
                           @Param("begin") Integer begin,
                           @Param("limit") Integer limit);
    /**
     * 查询最新书籍
     * @return
     */
    @Select("SELECT bid,bname,bcover,bauthor,nborrowed FROM book ORDER BY time DESC,nborrowed DESC,bid ASC LIMIT 12")
    @Results(id = "newbookresult", value = {
            @Result(property = "bid", column = "bid", id = true),
            @Result(property = "bname", column = "bname"),
            @Result(property = "bcover", column = "bcover"),
            @Result(property = "nborrowed",column = "nborrowed")
    })
    List<Book> findNewBook();

    /**
     * 查询最热门书籍，根据历史借阅量查询
     * @return 书籍信息集合
     */
    @Select("SELECT bid,bname,hborrowed FROM book ORDER BY hborrowed DESC LIMIT 10;")
    List<Book> findHotBook();



    /**
     * 通过图书id查询图书的详细信息，此处还关联查询了图书分类的信息
     * @param bid 图书id
     * @return 图书封装类
     */
    @Select("SELECT\n" +
            "book.bid,\n" +
            "book.cid,\n" +
            "book.bname,\n" +
            "book.badr,\n" +
            "book.bnum,\n" +
            "book.bcover,\n" +
            "book.bsequence,\n" +
            "book.bcontent,\n" +
            "book.bidt,\n" +
            "book.bcobn,\n" +
            "book.nborrowed,\n" +
            "book.bauthor,\n" +
            "book.hborrowed,\n" +
            "book.initials,\n" +
            "book.fight,\n" +
            "book.time,\n" +
            "book.money,\n" +
            "category.cname,\n" +
            "category.cid\n" +
            "FROM\n" +
            "book\n" +
            "INNER JOIN category ON book.cid = category.cid\n" +
            "WHERE\n" +
            "book.bid = #{bid}")
    @Results(value = {
            @Result(column = "cid", property = "cid"),
            @Result(column = "cid", property = "category", one = @One(select = "com.lj.category.dao.CategoryDao.findCategoryById"))
    })
    Book findBookById(Integer bid);


}
