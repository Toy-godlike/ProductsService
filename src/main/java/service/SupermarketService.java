package service;

import entity.Area;
import entity.Discount;
import entity.OnSale;
import entity.Products;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Administrator on 2016/7/19.
 */
public interface SupermarketService {

    public boolean saveOnSale(OnSale onSale);
    public boolean saveDiscount(Discount discount);
    public boolean saveArea(Area area);
    public boolean saveProduct(Products products);
    public List<OnSale> getOnSales();
    public List<Discount> getDiscounts();
    public List<Products> getProductsAll();
    public List<Area> getAreas();
}
