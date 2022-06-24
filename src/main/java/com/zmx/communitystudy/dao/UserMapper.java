package com.zmx.communitystudy.dao;

import com.zmx.communitystudy.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zmx
 * @create 2022-06-19 17:58
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户Id查询用户信息
     */
    User selectUserById(Integer userId);

}
