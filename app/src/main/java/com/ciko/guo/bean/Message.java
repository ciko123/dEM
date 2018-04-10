package com.ciko.guo.bean;

import com.ciko.guo.base.Bean;

/**
 * 创建时间: 2018/3/29 上午10:47
 * 类描述:
 *
 * @author Ciko
 */
public class Message extends Bean {

    /**
     * account : 13375377890
     * createTime : 1522891147000
     * id : 12
     * ipAddress : 125.119.233.22
     * name : hh
     * question : 我的设备一直重启，不知道什么原因
     * reply : 又有意义有意义有意义呀
     * status : 2
     * title : 设备重启问题
     * type : 3
     * userId : 6
     */

    private String account;
    private long createTime;
    private int id;
    private String ipAddress;
    private String name;
    private String question;
    private String reply;
    private int status;
    private String title;
    private int type;
    private int userId;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
