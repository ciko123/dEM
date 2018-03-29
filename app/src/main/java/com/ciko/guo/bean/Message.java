package com.ciko.guo.bean;

/**
 * 创建时间: 2018/3/29 上午10:47
 * 类描述:
 *
 * @author Ciko
 */
public class Message {

    /**
     * account : admin
     * createTime : 1521607300000
     * id : 2
     * ipAddress : 192.168.0.7
     * name : 张三
     * question : 2222问题详情问题详情问题详情问题详情问题详情问题详情
     * status : 1
     * title : 这是问题标题22
     * type : 1
     * userId : 1
     */

    private String account;
    private long createTime;
    private int id;
    private String ipAddress;
    private String name;
    private String question;
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
