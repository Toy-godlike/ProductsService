package dao;

import entity.OnSale;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    public OnSale getOnSale(String rfid) {
        OnSale onSale = (OnSale) getCurrentSession().get(OnSale.class,rfid);
        return onSale;
    }
}
