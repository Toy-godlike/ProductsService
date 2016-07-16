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
    @Column(name = "Anum",nullable = false,length = 1)
    private int a_num;

    @ManyToOne(targetEntity = Products.class)
    @JoinColumn(name = "Shapcode",nullable = false)
    @Cascade(CascadeType.ALL)
    private Products products;

    public OnSale() {
    }

    public OnSale(String rfid, int a_num, Products products) {
        this.rfid = rfid;
        this.a_num = a_num;
        this.products = products;
    }

    //    public OnSale(String rfid, String shapcode, int a_num) {
//        this.rfid = rfid;
//        this.shapcode = shapcode;
//        this.a_num = a_num;
//    }

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

    public int getA_num() {
        return a_num;
    }

    public void setA_num(int a_num) {
        this.a_num = a_num;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
