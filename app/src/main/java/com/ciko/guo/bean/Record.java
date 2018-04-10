package com.ciko.guo.bean;

/**
 * 创建时间: 2018/4/10 下午4:18
 * 类描述:
 *
 * @author Ciko
 */
public class Record {

    /**
     * createTime : 1522089012000
     * state : 1
     * stateName : 待受理
     */

    private long createTime;
    private int state;
    private String stateName;

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    
}
