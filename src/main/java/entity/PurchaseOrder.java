package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/10/12.
 */
@Entity
@Table(name="PurchaseOrder")
public class PurchaseOrder implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Id",length = 10)
    private int id;
    @Column(name = "UserId",nullable = false,length = 20)
    private String userId;
    @Column(name = "Detail",nullable = false,length = 65533)
    private String detail;
    @Column(name = "Cost",nullable = false)
    private double cost;
    @Column(name = "Date",nullable = false)
    private Date date;
    @Column(name = "Count",nullable = false)
    private int count;

    public PurchaseOrder() {
    }

    public PurchaseOrder(int id, String userId, String detail, double cost, Date date, int count) {
        this.id = id;
        this.userId = userId;
        this.detail = detail;
        this.cost = cost;
        this.date = date;
        this.count = count;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
