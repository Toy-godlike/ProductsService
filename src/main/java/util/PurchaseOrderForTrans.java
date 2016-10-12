package util;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/10/12.
 */
public class PurchaseOrderForTrans implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;
    private int id;
    private double cost;
    private int count;
    private Date date;

    public PurchaseOrderForTrans() {
    }

    public PurchaseOrderForTrans(String userId, int id, double cost, int count, Date date) {
        this.userId = userId;
        this.id = id;
        this.cost = cost;
        this.count = count;
        this.date = date;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
