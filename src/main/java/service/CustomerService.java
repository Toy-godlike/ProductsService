package service;

import entity.Discount;
import util.ProductInfo;

import java.util.List;

/**
 * Created by Administrator on 2016/7/19.
 */
public interface CustomerService {

    public ProductInfo getProductInfo(String rfid);
    public Discount getDiscountInfo(String shapcode);
    public List getDiscounts();
    public boolean saveSold(int s_num,String shapcode,String rfid,String s_date,double s_price,double o_price);
    public List getProductLoc(String pname);
    public List getProductByArea(int a_num);
//    public boolean saveSolds(Sold[] solds);
//    public boolean saveSoldtest(Sold sold);
}
