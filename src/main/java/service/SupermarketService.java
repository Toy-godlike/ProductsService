package service;

import entity.*;
import util.DiscountForTrans;
import util.OnSaleForTrans;
import util.ProductForTrans;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Administrator on 2016/7/19.
 */
public interface SupermarketService {

    public boolean saveOnSale(OnSaleForTrans onSaleForTrans);
    public boolean saveDiscount(DiscountForTrans discountForTrans);
    public boolean saveArea(Area area);
    public boolean saveProduct(Products products);
    public List<OnSaleForTrans> getOnSales();
    public List<DiscountForTrans> getDiscounts();
    public List<ProductForTrans> getProductsAll();
    public List<Area> getAreas();
    public List<Sold> getSolds();
}
