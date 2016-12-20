package com.sung.demo.getrunningapplication;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.util.List;

/**
 * Created by sung on 2016/12/15.
 */

public class AppUtils {

    private List<ApplicationInfo> appList;

    public AppUtils(Context context) {
        // 通过包管理器，检索所有的应用程序
        PackageManager pm = context.getPackageManager();
        appList = pm
                .getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);
    }

    /**
     * 通过包名返回一个应用的Application对象
     *
     * @param pkgName
     * @return ApplicationInfo
     */
    public ApplicationInfo getApplicationInfo(String pkgName) {
        if (pkgName == null) {
            return null;
        }
        for (ApplicationInfo appinfo : appList) {
            if (pkgName.equals(appinfo.processName)) {
                return appinfo;
            }
        }
        return null;
    }

}
