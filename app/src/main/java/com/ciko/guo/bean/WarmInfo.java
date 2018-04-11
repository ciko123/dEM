package com.ciko.guo.bean;

/**
 * 创建时间: 2018/4/11 下午6:38
 * 类描述:
 *
 * @author Ciko
 */
public class WarmInfo {

    /**
     * content : MDS锅筒水位极高
     * deviceId : 0
     * deviceName : 皇爷食品厂10T蒸汽锅炉
     * name : MDS锅筒水位极高
     * projectName : 项目123
     * status : 1
     * value : 1
     */

    private String content;
    private int deviceId;
    private String deviceName;
    private String name;
    private String projectName;
    private int status;
    private String value;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
