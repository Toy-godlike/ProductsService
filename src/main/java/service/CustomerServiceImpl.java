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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public boolean saveSold(String s_num,String s_name,String rfid,String s_date,String s_price,String o_price) {
        Sold sold = new Sold();
        sold.setS_name(s_name);
        sold.setRfid(rfid);
        int snum = Integer.parseInt(s_num);
        double sprice = Double.parseDouble(s_price);
        double oprice = Double.parseDouble(o_price);
        sold.setS_num(snum);
        sold.setS_price(sprice);
        sold.setO_price(oprice);
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
}
