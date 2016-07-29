package util;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/28.
 */
public class AreaForTrans implements Serializable{

    private static final long serialVersionUID = 1L;

    private int a_num;
    private String a_name;
    private String location;

    public AreaForTrans() {
    }

    public AreaForTrans(int a_num, String a_name, String location) {
        this.a_num = a_num;
        this.a_name = a_name;
        this.location = location;
    }

    public int getA_num() {
        return a_num;
    }

    public void setA_num(int a_num) {
        this.a_num = a_num;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
