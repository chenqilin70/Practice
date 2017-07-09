package oracle.huwl.com.blacklist;

/**
 * Created by aierxuan on 2017/7/9.
 */

public class PhoneNum {
    private Integer _id;
    private String num;

    public PhoneNum(Integer _id, String num) {
        this._id = _id;
        this.num = num;
    }

    public PhoneNum() {
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "PhoneNum{" +
                "_id=" + _id +
                ", num='" + num + '\'' +
                '}';
    }
}
