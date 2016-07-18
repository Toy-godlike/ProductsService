package dao;

import entity.OnSale;

import java.util.List;

/**
 * Created by Administrator on 2016/7/15.
 */
public interface OnSaleDAO {

    public void addOnSale(OnSale onSale);
    public void deleteOnSale(String rfid);
    public void updateOnSale(OnSale onSale);
    public OnSale getOnSale(String rfid);
    public List getOnSales();
}
