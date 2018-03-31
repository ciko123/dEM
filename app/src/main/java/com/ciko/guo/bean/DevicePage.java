package com.ciko.guo.bean;

import com.ciko.guo.base.Bean;

import java.util.List;

/**
 * 创建时间: 2018/3/29 下午4:25
 * 类描述:
 *
 * @author Ciko
 */
public class DevicePage  extends Bean {

    /**
     * curPage : 1
     * pageList : [{"commSerialNumber":"2018-351245","commType":1,"createTime":1521128376000,"id":4,"isAppShow":"y","latitude":"30.225182","longitude":"120.076328","mark":"这是4号设备","modelId":1,"modelName":"类型/模板1","modifyTime":1521184961000,"name":"大锅炉004","orderNo":"20180004","projectId":0,"projectIdNoBind":0,"runtime":0,"serialNumber":"2018-351245","status":3,"typeId":0,"userId":4,"username":"很好"}]
     * pageSize : 1000
     * totalNum : 2
     * totalPage : 1
     */

    private int curPage;
    private int pageSize;
    private int totalNum;
    private int totalPage;
    private List<Device> pageList;

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

    public List<Device> getPageList() {
        return pageList;
    }

    public void setPageList(List<Device> pageList) {
        this.pageList = pageList;
    }
}
