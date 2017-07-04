package oracle.huwl.com.appmanager;

import android.graphics.drawable.Drawable;

/**
 * Created by aierxuan on 2017/7/4.
 */

public class AppInfo {
    private Drawable icon;
    private String appName;
    private String packageName;

    public AppInfo(Drawable icon, String appName, String packageName) {
        this.icon = icon;
        this.appName = appName;
        this.packageName = packageName;
    }

    public AppInfo() {
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "icon=" + icon +
                ", appName='" + appName + '\'' +
                ", packageName='" + packageName + '\'' +
                '}';
    }
}
