package com.lj.dao;
import org.apache.ibatis.annotations.Select;
import com.lj.vo.User;


/**
 * Created by Rabit on 2017/5/6.
 */
public interface UserDao {
   @Select("select * from tuser t where t.id = #{id}")
   public User selectById(String id);
}
