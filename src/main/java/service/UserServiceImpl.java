package service;

import dao.DiscountDAO;
import dao.OnSaleDAO;
import dao.SoldDAO;
import entity.Discount;
import entity.OnSale;
import entity.Sold;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;

/**
 * Created by Administrator on 2016/7/19.
 */
@WebService(endpointInterface = "service.UserService")
public class UserServiceImpl implements UserService{

    @Autowired
    private OnSaleDAO onSaleDAO;

    @Autowired
    private DiscountDAO discountDAO;

    @Autowired
    private SoldDAO soldDAO;

    public OnSale getProductInfo(String rfid) {
        OnSale onSale = onSaleDAO.getOnSale(rfid);
        return onSale;
    }

    public Discount getDiscountInfo(String shapcode) {
        Discount discount = discountDAO.getDiscountByShapcode(shapcode);
        return discount;
    }

    public boolean saveSold(Sold sold) {
        try {
            soldDAO.addSold(sold);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String testHello() {
        String test = "success!";
        return test;
    }
}
