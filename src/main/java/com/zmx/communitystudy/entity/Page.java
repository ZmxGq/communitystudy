package com.zmx.communitystudy.entity;

import lombok.Data;

/**
 * @author zmx
 * @create 2022-06-20 22:06
 */
@Data
public class Page {
    //当前页码
    private Integer current = 1;
    //每页显示的数据
    private Integer limit = 10;
    //总记录数
    private Integer rows;
    //获取当前页面的路径
    private String path;

    public void setCurrent(Integer current) {
        if(current > 0)
            this.current = current;
    }

    public void setLimit(Integer limit) {
        if(limit > 0 && limit <= 100)
            this.limit = limit;
    }

    public void setRows(Integer rows) {
        if(rows >= 0)
            this.rows = rows;
    }

    /**
     * 获取当前页面的起始行,位置偏移量
     */
    public int getOffSet(){
        return (current - 1) * limit;
    }

    /**
     * 获取总的页数
     */
    public int getTotal(){
        if(rows % limit == 0){
            return rows / limit;
        }else{
            return rows / limit + 1;
        }
    }

    /**
     * 获取分页的起始页
     */
    public int getFrom(){
        int from = current - 2;
        return from > 0 ? from : 1;
    }

    /**
     * 获取分页的最终页面
     */
    public int getTo(){
        int to = current + 2;
        return getTotal() > to ? to : getTotal();
    }
}
