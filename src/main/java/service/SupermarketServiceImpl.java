package service;

import dao.DiscountDAO;
import dao.OnSaleDAO;
import entity.Area;
import entity.Discount;
import entity.OnSale;
import entity.Products;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by Administrator on 2016/7/19.
 */
public class SupermarketServiceImpl implements SupermarketService {

    @Autowired
    private OnSaleDAO onSaleDAO;

    @Autowired
    private DiscountDAO discountDAO;

    public boolean saveOnSale(OnSale onSale) {
        try {
            onSaleDAO.addOnSale(onSale);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean saveDiscount(Discount discount) {
        try {
            discountDAO.addDiscount(discount);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean saveArea(Area area) {
        return false;
    }

    public boolean saveProduct(Products products) {
        return false;
    }

    public List<OnSale> getOnSales() {
        return null;
    }

    public List<Discount> getDiscounts() {
        return null;
    }

    public List<Products> getProductsAll() {
        return null;
    }

    public List<Area> getAreas() {
        return null;
    }
}
