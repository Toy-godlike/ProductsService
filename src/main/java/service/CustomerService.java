package service;

import entity.Area;
import entity.Discount;
import util.ProductForTrans;
import util.ProductInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
public interface CustomerService {

    public ProductInfo getProductInfo(String rfid);
    public Discount getDiscountInfo(String shapcode);
    public List getDiscounts();
    public boolean saveSold(int s_num,String shapcode,String rfid,String s_date,double s_price,double o_price);
    public List getProductLoc(String pname);
//    public boolean saveSolds(Sold[] solds);
//    public boolean saveSoldtest(Sold sold);
}
