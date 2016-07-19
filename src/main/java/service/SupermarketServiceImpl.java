package service;

import dao.DiscountDAO;
import dao.OnSaleDAO;
import entity.Discount;
import entity.OnSale;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;

/**
 * Created by Administrator on 2016/7/19.
 */
@WebService
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
}
