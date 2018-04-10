package com.ciko.guo.bean;

import com.ciko.guo.base.Bean;

import java.util.List;

/**
 * 创建时间: 2018/4/5 下午9:26
 * 类描述:
 *
 * @author Ciko
 */
public class Order extends Bean {

    /**
     * createTime : 1522089012000
     * dealerId : 1
     * dealerName : 冉匆匆
     * deviceName : test
     * deviceNo : ce
     * deviceType : 4
     * id : 3
     * isDelete : n
     * modifyTime : 1522089012000
     * orderNo : 1522089012168
     * records : [{"createTime":1522089012000,"state":1,"stateName":"待受理"},{"createTime":1523092267000,"state":2,"stateName":"配件采购"},{"createTime":1523092399000,"state":3,"stateName":"图纸设计"}]
     * requireTime : 1522080000000
     * status : 3
     * typeName : 标准-承压热水比调
     * userId : 6
     * userName : hh
     */

    private long createTime;
    private int dealerId;
    private String dealerName;
    private String deviceName;
    private String deviceNo;
    private int deviceType;
    private int id;
    private String isDelete;
    private long modifyTime;
    private String orderNo;
    private long requireTime;
    private int status;
    private String typeName;
    private int userId;
    private String userName;
    private List<Record> records;

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getDealerId() {
        return dealerId;
    }

    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(long modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public long getRequireTime() {
        return requireTime;
    }

    public void setRequireTime(long requireTime) {
        this.requireTime = requireTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }
}
