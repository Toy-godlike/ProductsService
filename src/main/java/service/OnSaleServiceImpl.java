package service;

import dao.DiscountDAO;
import dao.OnSaleDAO;
import dao.ProductsDAO;
import entity.Discount;
import entity.OnSale;
import entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

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

    @Autowired
    private ProductsDAO productsDAO;

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

    public void saveDiscount() {
/*        Products products = new Products();
        products = productsDAO.getProducts("3333");
        Discount discount  = new Discount();
        discount.setD_num(5);
        discount.setDisc(0.8f);
        discount.setBeginDate(new Date());
        discount.setEndDate(new Date());
        discount.setProducts(products);
        discountDAO.addDiscount(discount);*/

        Products products = productsDAO.getProducts("3333");
        Set<Discount> set = products.getDiscountSet();
        Iterator<Discount> ite = set.iterator();
        while (ite.hasNext()){
            System.out.println(ite.next().getDisc());
        }

    }

    public int getAnum(String shapcode) {
        int temp = onSaleDAO.getAnum(shapcode);
        return temp;
    }
}
