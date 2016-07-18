package dao;

import entity.OnSale;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/7/15.
 */
@Repository
public class OnSaleDAOImpl implements OnSaleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void addOnSale(OnSale onSale) {
        getCurrentSession().save(onSale);
    }

    public void deleteOnSale(String rfid) {
        OnSale onSale = getOnSale(rfid);
        if (onSale != null) {
            getCurrentSession().delete(onSale);
        }
    }

    public void updateOnSale(OnSale onSale) {
        OnSale onSaleToUpdate = getOnSale(onSale.getRfid());
        onSaleToUpdate.setArea(onSale.getArea());
        onSaleToUpdate.setProducts(onSale.getProducts());
        getCurrentSession().update(onSaleToUpdate);
    }

    public OnSale getOnSale(String rfid) {
        OnSale onSale = (OnSale) getCurrentSession().get(OnSale.class,rfid);
        return onSale;
    }

    public List getOnSales() {
        return getCurrentSession().createQuery("from OnSale").list();
    }
}