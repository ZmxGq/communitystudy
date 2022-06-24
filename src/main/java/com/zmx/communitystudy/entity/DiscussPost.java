package com.zmx.communitystudy.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zmx
 * @create 2022-06-18 21:45
 */
@Data
public class DiscussPost {

    private Integer id;
    private Integer userId;
    private String title;
    private String text;
    private Integer type;
    private Integer status;
    private Date createTime;
    private Integer commentCount;
    private Double score;
}
