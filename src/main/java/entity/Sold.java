package entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/7/13.
 */
public class Sold implements Serializable{

    private static final long serialVersionUID = 1L;

    private int s_num;
    private String rfid;
    private Date s_date;
    private int d_num;

    public Sold() {
    }

    public Sold(int s_num, String rfid, Date s_date, int d_num) {
        this.s_num = s_num;
        this.rfid = rfid;
        this.s_date = s_date;
        this.d_num = d_num;
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

    public int getD_num() {
        return d_num;
    }

    public void setD_num(int d_num) {
        this.d_num = d_num;
    }
}
