package com.ciko.guo.utils;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建时间: 2017/9/2 下午12:45
 * 类描述:
 *
 * @author 木棉
 */
public class FragmentUtils {

    private Map<String, Fragment> fragmentMap = new HashMap<>();

    private FragmentManager fragmentManager;

    private int containerViewId;

    public FragmentUtils(Activity activity, int containerViewId) {
        this.containerViewId = containerViewId;
        fragmentManager = activity.getFragmentManager();
    }

    public void add(Fragment fragment) {
        String key = fragment.getClass().getSimpleName();
        if (!fragmentMap.containsKey(key)) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(containerViewId, fragment);
            transaction.commitAllowingStateLoss();
            fragmentMap.put(key, fragment);
        }
    }

    public void show(Class<?> cls) {
        String key = cls.getSimpleName();
        hideAll();
        if (fragmentMap.containsKey(key)) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.show(fragmentMap.get(key));
            transaction.commitAllowingStateLoss();
        }
    }

    private void hideAll() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        for (Fragment fragment : fragmentMap.values()) {
            transaction.hide(fragment);
        }
        transaction.commitAllowingStateLoss();
    }


}
