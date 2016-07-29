package entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Administrator on 2016/7/13.
 */
@Entity
@Table(name = "Products")
public class Products implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Shapcode",nullable = false,length = 20)
    private String shapcode;
    @Column(name = "Pname",nullable = false,length = 50)
    private String pname;
    @Column(name = "Price",nullable = false,length = 10)
    private double price;
    @Column(name = "Picture",length = 255)
    private String picture;

    @OneToMany(mappedBy = "products",targetEntity = Discount.class)
    @Cascade(CascadeType.ALL)
    private Set<Discount> discountSet;

    public Products() {
    }

    public Products(String shapcode, String pname, double price, String picture) {
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

    public Set<Discount> getDiscountSet() {
        return discountSet;
    }

    public void setDiscountSet(Set<Discount> discountSet) {
        this.discountSet = discountSet;
    }
}
