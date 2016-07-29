package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/7/13.
 */
@Entity
@Table(name = "Sold")
public class Sold implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Snum")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int s_num;
    @Column(name = "Rfid",nullable = false,length = 50)
    private String rfid;
    @Column(name = "Sdate",nullable = false)
    private Date s_date;
    @Column(name = "Oprice",nullable = false,length = 10)
    private double o_price;
    @Column(name = "Sprice",nullable = false,length = 10)
    private double s_price;
    @Column(name = "Shapcode",nullable = false,length = 20)
    private String shapcode;

    public Sold() {
    }

    public Sold(String rfid, Date s_date, double o_price, double s_price, String shapcode) {
        this.rfid = rfid;
        this.s_date = s_date;
        this.o_price = o_price;
        this.s_price = s_price;
        this.shapcode = shapcode;
    }

    public int getS_num() {
        return s_num;
    }

    public void setS_num(int s_num) {
        this.s_num = s_num;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public Date getS_date() {
        return s_date;
    }

    public void setS_date(Date s_date) {
        this.s_date = s_date;
    }

    public double getO_price() {
        return o_price;
    }

    public void setO_price(double o_price) {
        this.o_price = o_price;
    }

    public double getS_price() {
        return s_price;
    }

    public void setS_price(double s_price) {
        this.s_price = s_price;
    }

    public String getShapcode() {
        return shapcode;
    }

    public void setShapcode(String shapcode) {
        this.shapcode = shapcode;
    }
}
