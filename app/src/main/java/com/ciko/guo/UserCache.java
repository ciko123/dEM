package com.ciko.guo;

import com.ciko.guo.bean.User;

/**
 * 创建时间: 2018/3/29 下午1:10
 * 类描述:
 *
 * @author Ciko
 */
public class UserCache {

    private static UserCache userCache;

    private User user;

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

    public int getUserId() {
        return 1;
    }


}

