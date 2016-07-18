package entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/7/13.
 */
@Entity
@Table(name = "Discount")
public class Discount implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Dnum",nullable = false,length = 1)
    private int d_num;
    //private String shapcode;
    @Column(name = "Disc",nullable = false,length = 1)
    private float disc;
    @Column(name = "BeginDate",nullable = false)
    private Date beginDate;
    @Column(name = "EndDate",nullable = false)
    private Date endDate;

    @OneToOne(targetEntity = Products.class)
    @JoinColumn(name = "Shapcode",nullable = false)
    @Cascade(CascadeType.ALL)
    private Products products;

    public Discount() {
    }

    public Discount(int d_num, float disc, Date beginDate, Date endDate, Products products) {
        this.d_num = d_num;
        this.disc = disc;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.products = products;
    }

    public int getD_num() {
        return d_num;
    }

    public void setD_num(int d_num) {
        this.d_num = d_num;
    }

//    public String getShapcode() {
//        return shapcode;
//    }
//
//    public void setShapcode(String shapcode) {
//        this.shapcode = shapcode;
//    }

    public float getDisc() {
        return disc;
    }

    public void setDisc(float disc) {
        this.disc = disc;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
