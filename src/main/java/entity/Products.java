package entity;

/**
 * Created by Administrator on 2016/7/13.
 */
public class Products {

    private String shapcode;
    private String pname;
    private double price;

    public Products() {
    }

    public Products(String shapcode, String pname, double price) {
        this.shapcode = shapcode;
        this.pname = pname;
        this.price = price;
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
}
