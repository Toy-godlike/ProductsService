package service;

import entity.Discount;
import entity.OnSale;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Administrator on 2016/7/19.
 */
@WebService
public interface SupermarketService {

    @WebMethod
    public boolean saveOnSale(OnSale onSale);
    @WebMethod
    public boolean saveDiscount(Discount discount);
}
