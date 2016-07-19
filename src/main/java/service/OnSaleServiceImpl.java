package service;

import dao.DiscountDAO;
import dao.OnSaleDAO;
import entity.Discount;
import entity.OnSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/7/15.
 */
@Service("onSaleService")
@Transactional
public class OnSaleServiceImpl implements OnSaleService {

    @Autowired
    private OnSaleDAO onSaleDAO;

    @Autowired
    private DiscountDAO discountDAO;

    public void addOnSale(OnSale onSale) {
        onSaleDAO.addOnSale(onSale);
    }

    public OnSale getOnSale(String rfid) {
        OnSale onSale = onSaleDAO.getOnSale(rfid);
        return onSale;
    }

    public Discount getDiscountByShapcode(String shapcode) {
        Discount discount = discountDAO.getDiscountByShapcode(shapcode);
        return discount;
    }
}
