package service;

import entity.OnSale;

/**
 * Created by Administrator on 2016/7/15.
 */
public interface OnSaleService {
    public void addOnSale(OnSale onSale);
    public OnSale getOnSale(String rfid);
}
