package com.ciko.guo;

import com.ciko.guo.bean.UserLogin;

/**
 * 创建时间: 2018/3/29 下午1:10
 * 类描述:
 *
 * @author Ciko
 */
public class UserCache {

    private static UserCache userCache;

    private static UserLogin user;

    public static UserCache getIns() {
        if (userCache == null) {
            synchronized (UserCache.class) {
                if (userCache == null) {
                    userCache = new UserCache();
                }
            }
        }
        return userCache;
    }

    public static void init(UserLogin userLogin) {
        user = userLogin;
    }

    public int getUserId() {
        return user.getId();
    }

    public String getAccount() {
        return user.getAccount();
    }

    public UserLogin getUser() {
        return user;
    }

    public String getPsw() {
        return user.getPassword();
    }

    public void clear() {
        userCache = null;
        user = null;
    }

    public UserLogin getUserTemp() {
        UserLogin userTemp = new UserLogin();
        userTemp.setAccount(user.getAccount());
        userTemp.setAddress(user.getAddress());
        userTemp.setBankAccount(user.getBankAccount());
        userTemp.setCellPhone(user.getCellPhone());
        userTemp.setCompanyName(user.getCompanyName());
        userTemp.setCreateTime(user.getCreateTime());
        userTemp.setDealerId(user.getDealerId());
        userTemp.setDepositBank(user.getDepositBank());
        userTemp.setEmail(user.getEmail());
        userTemp.setId(user.getId());
        userTemp.setInvoiceNumber(user.getInvoiceNumber());
        userTemp.setIsDelete(user.getIsDelete());
        userTemp.setLandLine(user.getLandLine());
        userTemp.setModifyTime(user.getModifyTime());
        userTemp.setName(user.getName());
        userTemp.setPassword(user.getPassword());
        userTemp.setSex(user.getSex());
        userTemp.setStatus(user.getStatus());
        userTemp.setToken(user.getToken());
        userTemp.setUserType(user.getUserType());
        return userTemp;
    }

}

