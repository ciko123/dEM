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
                if (userCache == null) {//2
                    userCache = new UserCache();
                }
            }
        }
        return userCache;
    }

    public static void init(UserLogin userLogin){
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

}

