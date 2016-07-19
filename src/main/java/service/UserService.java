package service;

import entity.Discount;
import entity.OnSale;
import entity.Sold;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Administrator on 2016/7/19.
 */
@WebService
public interface UserService {

    @WebMethod
    public OnSale getProductInfo(String rfid);
    @WebMethod
    public Discount getDiscountInfo(String shapcode);
    @WebMethod
    public boolean saveSold(Sold sold);
}
