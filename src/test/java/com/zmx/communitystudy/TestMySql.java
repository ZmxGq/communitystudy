package com.zmx.communitystudy;

import com.zmx.communitystudy.dao.DiscussPostMapper;
import com.zmx.communitystudy.dao.UserMapper;
import com.zmx.communitystudy.entity.DiscussPost;
import com.zmx.communitystudy.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author zmx
 * @create 2022-06-18 21:57
 */
@SpringBootTest
public class TestMySql {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DiscussPostMapper discussPostMapper;

    @Autowired
    UserMapper userMapper;

    /**
     * 测试数据库是否连接成功
     */
    @Test
    public void test1(){
//        String sql = "select * from discuss_post where id = 280";
//        List<Map<String, Object>> discussPost = jdbcTemplate.queryForList(sql);
//        System.out.println(discussPost);
//        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(149, 0, 10);
//        for (DiscussPost discussPost : discussPosts) {
//            System.out.println(discussPost);
//        }

        System.out.println(discussPostMapper.getDiscussPostRows(101));
    }

    @Test
    public void test2(){
        User user = userMapper.selectUserById(103);
        System.out.println(user.toString());
    }
}
