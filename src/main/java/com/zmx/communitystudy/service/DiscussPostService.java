package com.zmx.communitystudy.service;

import com.zmx.communitystudy.dao.DiscussPostMapper;
import com.zmx.communitystudy.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zmx
 * @create 2022-06-20 21:01
 */
@Service
public class DiscussPostService {
    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> selectDiscussPosts(Integer userId, int offset, int limit){
        return discussPostMapper.selectDiscussPosts(userId,offset,limit);
    }

    public Integer getDiscussPostRows(Integer userId){
        return discussPostMapper.getDiscussPostRows(userId);

    }

}
