package oracle.huwl.com.helloandroidstudio;

/**
 * Created by aierxuan on 2017/7/3.
 */

public class ShopInfo {
    private int icon;
    private String name,desc;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ShopInfo(int icon, String name, String desc) {
        this.icon = icon;
        this.name = name;
        this.desc = desc;
    }

    public ShopInfo() {
    }

    @Override
    public String toString() {
        return "ShopInfo{" +
                "icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
