package com.neuedu.page;

import com.neuedu.entity.User;

import java.util.List;

public class Page {
    private Integer count;         //总条数
    private Integer pageCount=5;     //每个页面的条数
    private Integer pageNumber;     //每个页面的页数
    private Integer currentpage;    //当前页面，第几页
    private List content;           //内容


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        if (count%pageCount==0) {
            pageNumber=count/pageCount;
        }else {
            pageNumber=count/pageCount+1;
        }
        this.count=count;
    }

    public Integer getPageCount() {
        return pageCount;
    }


    public Integer getPageNumber() {
        return pageNumber;
    }


    public Integer getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(Integer currentpage) {
        this.currentpage = currentpage;
    }

    public List getContent() {
        return content;
    }

    public void setContent(List content) {
        this.content = content;
    }

}
