package util;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/28.
 */
public class ProductForTrans implements Serializable{

    private static final long serialVersionUID = 1L;

    private String shapcode;
    private String pname;
    private double price;
    private String picture;

    public ProductForTrans() {
    }

    public ProductForTrans(String shapcode, String pname, double price, String picture) {
        this.shapcode = shapcode;
        this.pname = pname;
        this.price = price;
        this.picture = picture;
    }

    public String getShapcode() {
        return shapcode;
    }

    public void setShapcode(String shapcode) {
        this.shapcode = shapcode;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
