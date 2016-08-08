package service;

import dao.*;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.AreaForTrans;
import util.DiscountForTrans;
import util.ProductForTrans;
import util.ProductInfo;

import javax.jws.WebService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private OnSaleDAO onSaleDAO;

    @Autowired
    private DiscountDAO discountDAO;

    @Autowired
    private SoldDAO soldDAO;

    @Autowired
    private ProductsDAO productsDAO;

    @Autowired
    private AreaDAO areaDAO;

    public ProductInfo getProductInfo(String rfid) {
        OnSale onSale = onSaleDAO.getOnSale(rfid);
        ProductForTrans productForTrans = new ProductForTrans();
        productForTrans.setShapcode(onSale.getProducts().getShapcode());
        productForTrans.setPname(onSale.getProducts().getPname());
        productForTrans.setPrice(onSale.getProducts().getPrice());
        productForTrans.setPicture(onSale.getProducts().getPicture());
        AreaForTrans areaForTrans = new AreaForTrans();
        areaForTrans.setA_num(onSale.getArea().getA_num());
        areaForTrans.setA_name(onSale.getArea().getA_name());
        areaForTrans.setLocation(onSale.getArea().getLocation());
        Discount discount = discountDAO.getDiscountByShapcode(onSale.getProducts().getShapcode());
        DiscountForTrans discountForTrans = new DiscountForTrans();
        discountForTrans.setShapcode(discount.getProducts().getShapcode());
        discountForTrans.setD_num(discount.getD_num());
        discountForTrans.setDisc(discount.getDisc());
        discountForTrans.setBeginDate(discount.getBeginDate());
        discountForTrans.setEndDate(discount.getEndDate());
        ProductInfo productInfo = new ProductInfo(productForTrans,areaForTrans,discountForTrans);
        return productInfo;
    }

    public Discount getDiscountInfo(String shapcode) {
        Discount discount = discountDAO.getDiscountByShapcode(shapcode);
        return discount;
    }

    public List getDiscounts() {
        List<Discount> list = discountDAO.getDiscounts();
        List dislist = new ArrayList();
        for (int i = 0;i < list.size();i++){
            ProductForTrans productForTrans = new ProductForTrans();
            productForTrans.setShapcode(list.get(i).getProducts().getShapcode());
            productForTrans.setPname(list.get(i).getProducts().getPname());
            productForTrans.setPrice(list.get(i).getProducts().getPrice());
            productForTrans.setPicture(list.get(i).getProducts().getPicture());
            DiscountForTrans discountForTrans = new DiscountForTrans();
            discountForTrans.setD_num(list.get(i).getD_num());
            discountForTrans.setShapcode(list.get(i).getProducts().getShapcode());
            discountForTrans.setDisc(list.get(i).getDisc());
            discountForTrans.setBeginDate(list.get(i).getBeginDate());
            discountForTrans.setEndDate(list.get(i).getEndDate());
            dislist.add(productForTrans);
            dislist.add(discountForTrans);
        }
        return dislist;
    }

    public boolean saveSold(int s_num,String shapcode,String rfid,String s_date,double s_price,double o_price) {
        Sold sold = new Sold();
        sold.setRfid(rfid);
        sold.setShapcode(shapcode);
        sold.setS_num(s_num);
        sold.setS_price(s_price);
        sold.setO_price(o_price);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date sdate = sdf.parse(s_date);
            sold.setS_date(sdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            soldDAO.addSold(sold);
            onSaleDAO.deleteOnSale(rfid);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List getProductLoc(String pname) {
        List<Products> productsList = productsDAO.searchProduct(pname);
        if (productsList.size() == 0){
            return null;
        }else {
            List loclist = new ArrayList();
            for (int i = 0; i < productsList.size(); i++) {
                ProductForTrans productForTrans = new ProductForTrans();
                productForTrans.setShapcode(productsList.get(i).getShapcode());
                productForTrans.setPname(productsList.get(i).getPname());
                productForTrans.setPrice(productsList.get(i).getPrice());
                productForTrans.setPicture(productsList.get(i).getPicture());
                int temp = onSaleDAO.getAnum(productsList.get(i).getShapcode());
                Area area = areaDAO.getArea(temp);
                loclist.add(productForTrans);
                loclist.add(area);
            }
            return loclist;
        }
    }

    public List getProductByArea(int a_num) {
        List<String> list = onSaleDAO.getShapcode(a_num);
        List plist = new ArrayList();
        plist.add(areaDAO.getArea(a_num));
        for (int i = 0;i < list.size();i++){
            Products products = productsDAO.getProducts(list.get(i));
            ProductForTrans productForTrans = new ProductForTrans();
            productForTrans.setShapcode(products.getShapcode());
            productForTrans.setPname(products.getPname());
            productForTrans.setPrice(products.getPrice());
            productForTrans.setPicture(products.getPicture());
            plist.add(productForTrans);
        }
        return plist;
    }

    /*public boolean saveSolds(Sold[] solds) {
        try {
            for (int i = 0; i < solds.length; i++) {
                soldDAO.addSold(solds[i]);
                onSaleDAO.deleteOnSale(solds[i].getRfid());
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveSoldtest(Sold sold) {
        try {
            soldDAO.addSold(sold);
            onSaleDAO.deleteOnSale(sold.getRfid());
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }*/
}
