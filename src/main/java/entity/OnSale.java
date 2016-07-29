package entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/13.
 */
@Entity
@Table(name="OnSale")
public class OnSale implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Rfid",nullable = false,length = 50)
    private String rfid;
//    @Column(name = "Shapcode",nullable = false,length = 20)
//    private String shapcode;
//    @Column(name = "Anum",nullable = false,length = 1)
//    private int a_num;

    @ManyToOne(targetEntity = Products.class)
    @JoinColumn(name = "Shapcode",nullable = false)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Products products;

    @ManyToOne(targetEntity = Area.class)
    @JoinColumn(name = "Anum",nullable = false)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Area area;

    public OnSale() {
    }

    public OnSale(String rfid, Products products, Area area) {
        this.rfid = rfid;
        this.products = products;
        this.area = area;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

//    public String getShapcode() {
//        return shapcode;
//    }
//
//    public void setShapcode(String shapcode) {
//        this.shapcode = shapcode;
//    }

//    public int getA_num() {
//        return a_num;
//    }
//
//    public void setA_num(int a_num) {
//        this.a_num = a_num;
//    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
