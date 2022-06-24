package com.zmx.communitystudy.dao;

import com.zmx.communitystudy.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zmx
 * @create 2022-06-18 21:50
 */
@Mapper
public interface DiscussPostMapper {

    /**
     * 根据用户id查询帖子
     * @param userId
     * @param offset 分页查询起始页
     * @param limit 每页查询的数据
     * @return
     */
    List<DiscussPost> selectDiscussPosts(Integer userId, int offset, int limit);

    /**
     * 根据用户Id查询帖子的总数
     */
    Integer getDiscussPostRows(@Param("userId") Integer userId);







}
