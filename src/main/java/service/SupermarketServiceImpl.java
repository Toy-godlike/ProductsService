package service;

import dao.*;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.DiscountForTrans;
import util.OnSaleForTrans;
import util.ProductForTrans;

import java.util.ArrayList;
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

    @Autowired
    private SoldDAO soldDAO;

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

    public List<OnSaleForTrans> getOnSales() {
        List<OnSale> list = onSaleDAO.getOnSales();
        List<OnSaleForTrans> olist = new ArrayList<OnSaleForTrans>();
        for (int i = 0;i < list.size();i++){
            OnSaleForTrans onSaleForTrans = new OnSaleForTrans();
            onSaleForTrans.setRfid(list.get(i).getRfid());
            onSaleForTrans.setShapcode(list.get(i).getProducts().getShapcode());
            onSaleForTrans.setA_num(list.get(i).getArea().getA_num());
            olist.add(onSaleForTrans);
        }
        return olist;
    }

    public List<DiscountForTrans> getDiscounts() {
        List<Discount> list = discountDAO.getDiscounts();
        List<DiscountForTrans> dlist = new ArrayList<DiscountForTrans>();
        for (int i = 0;i < list.size();i++){
            DiscountForTrans discountForTrans = new DiscountForTrans();
            discountForTrans.setD_num(list.get(i).getD_num());
            discountForTrans.setShapcode(list.get(i).getProducts().getShapcode());
            discountForTrans.setDisc(list.get(i).getDisc());
            discountForTrans.setBeginDate(list.get(i).getBeginDate());
            discountForTrans.setEndDate(list.get(i).getEndDate());
            dlist.add(discountForTrans);
        }
        return dlist;
    }

    public List<ProductForTrans> getProductsAll() {
        List<Products> list = productsDAO.getProductsAll();
        List<ProductForTrans> plist = new ArrayList<ProductForTrans>();
        for (int i = 0;i < list.size();i++){
            ProductForTrans productForTrans = new ProductForTrans();
            productForTrans.setShapcode(list.get(i).getShapcode());
            productForTrans.setPname(list.get(i).getPname());
            productForTrans.setPrice(list.get(i).getPrice());
            productForTrans.setPicture(list.get(i).getPicture());
            plist.add(productForTrans);
        }
        return plist;
    }

    public List<Area> getAreas() {
        return areaDAO.getAreas();
    }

    public List<Sold> getSolds() {
        return soldDAO.getSolds();
    }
}
