package service;

import dao.DiscountDAO;
import dao.OnSaleDAO;
import dao.SoldDAO;
import entity.Discount;
import entity.OnSale;
import entity.Sold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
import java.util.List;

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

    public OnSale getProductInfo(String rfid) {
        OnSale onSale = onSaleDAO.getOnSale(rfid);
        return onSale;
    }

    public Discount getDiscountInfo(String shapcode) {
        Discount discount = discountDAO.getDiscountByShapcode(shapcode);
        return discount;
    }

    public List<Discount> getDiscounts() {
        return discountDAO.getDiscounts();
    }

    public boolean saveSold(Sold sold) {
        try {
            soldDAO.addSold(sold);
            String rfid = sold.getRfid();
            onSaleDAO.deleteOnSale(rfid);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
