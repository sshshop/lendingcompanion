package com.jidy.dao;

import com.upublic.vo.Book;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jidy on 2017/5/8.
 */
@Service(value = "bookDao")
public interface BookDao {
    /*缩图、标题、作者、藏书量*/
    @Select("select bcover,bname,bauthor,nborrowed from book where bname=#{bname} ")
    List<Book> searchBookInfo(String bname);
}
