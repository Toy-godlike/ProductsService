package service;

import entity.Discount;
import entity.OnSale;
import entity.Sold;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by Administrator on 2016/7/19.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserService {

    @WebMethod
    public OnSale getProductInfo(@WebParam(name="rfid")String rfid);
    @WebMethod
    public Discount getDiscountInfo(@WebParam(name="shapcode")String shapcode);
    @WebMethod
    public boolean saveSold(Sold sold);
    @WebMethod
    public String testHello();
}
