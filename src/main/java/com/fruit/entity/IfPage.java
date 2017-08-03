package com.fruit.entity;

import java.util.List;

/**
 * Created by tao on 2014/12/11.
 */
public class IfPage<T> {
    private int pageNum; //当前页
    private int pageTotal;//总页数
    private List<T> dates; //数据
    private String parameter;  //参数

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List<T> getDates() {
        return dates;
    }

    public void setDates(List<T> dates) {
        this.dates = dates;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}
