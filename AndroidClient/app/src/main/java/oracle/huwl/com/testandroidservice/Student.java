package oracle.huwl.com.testandroidservice;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by aierxuan on 2017/7/14.
 */

public class Student implements Parcelable{
    private int id;
    private String name;
    private double price;

    public Student(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        Log.e("test","打包");
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeDouble(price);
    }
    public static final Creator<Student> CREATOR=new Creator<Student>(){
        @Override
        public Student createFromParcel(Parcel parcel) {
            Log.e("test","解析");
            int id=parcel.readInt();
            String name=parcel.readString();
            double price=parcel.readDouble();
            return new Student(id,name,price);
        }
        @Override
        public Student[] newArray(int i) {
            return new Student[i];
        }
    };
}
