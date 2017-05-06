package com.lj.dao;

import com.lj.vo.User;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Rabit on 2017/5/6.
 */
public interface UserDao {
    @Select(" select * from TUSER t where t.id = #{id}" )
   public User selectById(String id);
}
