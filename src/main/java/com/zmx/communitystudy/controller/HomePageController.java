package com.zmx.communitystudy.controller;

import com.zmx.communitystudy.dao.DiscussPostMapper;
import com.zmx.communitystudy.dao.UserMapper;
import com.zmx.communitystudy.entity.DiscussPost;
import com.zmx.communitystudy.entity.Page;
import com.zmx.communitystudy.entity.User;
import com.zmx.communitystudy.service.DiscussPostService;
import com.zmx.communitystudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zmx
 * @create 2022-06-18 22:13
 */
@Controller
public class HomePageController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    /**
     * 开发社区首页，并显示前10个帖子
     * @param model
     * @param page
     * @return
     */
    @GetMapping("/index")
    public String toHomePage(Model model, Page page){

        //方法调用前，springMVC会自动实例化Model和Page,
        //并将Page注入到Model中
        //所以在thymeleaf中可以获取到page数据

        //设置页面的总记录数
        page.setRows(discussPostService.getDiscussPostRows(0));
        //设置页面的索引
        page.setPath("/index");

        //获取到所有的帖子
        List<DiscussPost> posts = discussPostService.selectDiscussPosts(0, page.getOffSet(), page.getLimit());
        //封装帖子，将帖子和对应的用户封装到一起，发送到前端
        List<Map<String,Object>> userAndPosts = new ArrayList<>();

        if(posts != null){
            //通过单独添加,使得userAndPosts里面都含有用户和帖子信息
            for (DiscussPost post : posts) {
                Map<String,Object> map = new HashMap<>();
                map.put("post",post);
                User user = userService.selectUserById(post.getUserId());
                map.put("user",user);
                userAndPosts.add(map);
            }
        }

        model.addAttribute("userAndPosts",userAndPosts);

        return "/index";



    }

}
