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

    public boolean saveSold(int s_num,String shapcode,String rfid,String s_date,double s_price,double o_price) {
        Sold sold = new Sold();
        sold.setRfid(rfid);
        sold.setShapcode(shapcode);
//        int snum = Integer.parseInt(s_num);
//        double sprice = Double.parseDouble(s_price);
//        double oprice = Double.parseDouble(o_price);
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

    public boolean saveSolds(Sold[] solds) {
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
    }
}
