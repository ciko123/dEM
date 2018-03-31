package com.ciko.guo.bean;

import java.util.List;

/**
 * 创建时间: 2018/3/31 下午11:37
 * 类描述:
 *
 * @author Ciko
 */
public class Page<T> {

    private int curPage;
    private int pageSize;
    private int totalNum;
    private int totalPage;

    private List<T> pageList;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }

}
