package service;

import dao.AreaDAO;
import dao.DiscountDAO;
import dao.OnSaleDAO;
import dao.ProductsDAO;
import entity.Area;
import entity.Discount;
import entity.OnSale;
import entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.DiscountForTrans;
import util.OnSaleForTrans;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service("supermarketService")
@Transactional
public class SupermarketServiceImpl implements SupermarketService {

    @Autowired
    private OnSaleDAO onSaleDAO;

    @Autowired
    private DiscountDAO discountDAO;

    @Autowired
    private AreaDAO areaDAO;

    @Autowired
    private ProductsDAO productsDAO;

    public boolean saveOnSale(OnSaleForTrans onSaleForTrans) {
        Products products = productsDAO.getProducts(onSaleForTrans.getShapcode());
        Area area = areaDAO.getArea(onSaleForTrans.getA_num());
        OnSale onSale = new OnSale();
        onSale.setProducts(products);
        onSale.setArea(area);
        onSale.setRfid(onSaleForTrans.getRfid());
        try {
            onSaleDAO.addOnSale(onSale);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean saveDiscount(DiscountForTrans discountForTrans) {
        Products products = productsDAO.getProducts(discountForTrans.getShapcode());
        Discount discount = new Discount();
        discount.setD_num(discountForTrans.getD_num());
        discount.setProducts(products);
        discount.setDisc(discountForTrans.getDisc());
        discount.setBeginDate(discountForTrans.getBeginDate());
        discount.setEndDate(discountForTrans.getEndDate());
        try {
            discountDAO.addDiscount(discount);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean saveArea(Area area) {
        try {
            areaDAO.addArea(area);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveProduct(Products products) {
        try {
            productsDAO.addProducts(products);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<OnSale> getOnSales() {
        return onSaleDAO.getOnSales();
    }

    public List<Discount> getDiscounts() {
        return discountDAO.getDiscounts();
    }

    public List<Products> getProductsAll() {
        return productsDAO.getProductsAll();
    }

    public List<Area> getAreas() {
        return areaDAO.getAreas();
    }
}
