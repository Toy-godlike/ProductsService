package dao;

import entity.Discount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/7/18.
 */
@Repository
public class DiscountDAOImpl implements DiscountDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void addDiscount(Discount discount) {
        getCurrentSession().save(discount);
    }

    public void deleteDiscount(int d_num) {
        Discount discount = getDiscount(d_num);
        if (discount != null){
            getCurrentSession().delete(discount);
        }
    }

    public void updateDiscount(Discount discount) {
        Discount discountToUpdate = getDiscount(discount.getD_num());
        discountToUpdate.setDisc(discount.getDisc());
        discountToUpdate.setProducts(discount.getProducts());
        discountToUpdate.setBeginDate(discount.getBeginDate());
        discountToUpdate.setEndDate(discount.getEndDate());
        getCurrentSession().update(discountToUpdate);
    }

    public Discount getDiscount(int d_num) {
        Discount discount = (Discount) getCurrentSession().get(Discount.class,d_num);
        return discount;
    }

    public List getDiscounts() {
        return getCurrentSession().createQuery("from Discount ").list();
    }
}
