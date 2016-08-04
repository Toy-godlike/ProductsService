package service;

import entity.Area;
import entity.Discount;
import entity.OnSale;
import entity.Products;
import util.DiscountForTrans;
import util.OnSaleForTrans;

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
    public List<OnSale> getOnSales();
    public List<Discount> getDiscounts();
    public List<Products> getProductsAll();
    public List<Area> getAreas();
}
