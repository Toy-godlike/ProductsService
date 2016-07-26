package service;

import entity.Discount;
import entity.OnSale;
import entity.Sold;

import java.util.List;

/**
 * Created by Administrator on 2016/7/19.
 */
public interface CustomerService {

    public OnSale getProductInfo(String rfid);
    public Discount getDiscountInfo(String shapcode);
    public List<Discount> getDiscounts();
    public boolean saveSold(Sold sold);
}
