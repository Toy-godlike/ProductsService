package dao;

import entity.Discount;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    public Discount getDiscountByShapcode(String shapcode) {
        //Discount discount = (Discount) getCurrentSession().get(Discount.class,shapcode);
        Date date = new Date();
        Query qy = getCurrentSession().createQuery("from Discount where products.shapcode = :key1 " +
                "and beginDate <= :key2 " +
                "and endDate >= :key3")
                .setString("key1",shapcode)
                .setDate("key2",date)
                .setDate("key3",date);
        Discount discount = (Discount) qy.uniqueResult();
        return discount;
    }

    public List getDiscounts() {
        Date date = new Date();
        return getCurrentSession().createQuery("from Discount where beginDate <= :key1 " +
                "and endDate >= :key2")
                .setDate("key1",date)
                .setDate("key2",date).list();
    }
}
