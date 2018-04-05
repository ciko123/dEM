package com.ciko.guo.bean;

import com.ciko.guo.base.Bean;

import java.util.Map;

/**
 * 创建时间: 2018/4/3 下午7:34
 * 类描述:
 *
 * @author Ciko
 */
public class DeviceDetial extends Bean {

    /**
     * commType : 1
     * createTime : 1519667977000
     * dealerId : 0
     * id : 1
     * isAppShow : n
     * latitude : 23.5
     * longitude : 114.67
     * modelId : 1
     * modelName : REM301-中特云-蒸汽锅炉比调
     * modifyTime : 1522428400000
     * name : 设备2
     * orderNo : 20180001
     * picUrl : http://huanrun.yunzutai.com:22743/Uploads/Files/2018/2/26/0764045707da47958b2485b6371aca72.jpg
     * projectId : 0
     * projectIdNoBind : 0
     * runtime : 0
     * serialNumber : 123456789
     * state : 0
     * status : 1
     * typeId : 0
     * userId : 1
     * username : 冉匆匆
     */

    private int commType;
    private long createTime;
    private int dealerId;
    private int id;
    private String isAppShow;
    private String latitude;
    private String longitude;
    private int modelId;
    private String modelName;
    private long modifyTime;
    private String name;
    private String orderNo;
    private String picUrl;
    private int projectId;
    private int projectIdNoBind;
    private int runtime;
    private String serialNumber;
    private int state;
    private int status;
    private int typeId;
    private int userId;
    private String username;

    private Map<String, String> data;

    public int getCommType() {
        return commType;
    }

    public void setCommType(int commType) {
        this.commType = commType;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsAppShow() {
        return isAppShow;
    }

    public void setIsAppShow(String isAppShow) {
        this.isAppShow = isAppShow;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(long modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getProjectIdNoBind() {
        return projectIdNoBind;
    }

    public void setProjectIdNoBind(int projectIdNoBind) {
        this.projectIdNoBind = projectIdNoBind;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
