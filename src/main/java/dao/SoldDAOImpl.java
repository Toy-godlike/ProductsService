package dao;

import entity.Sold;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/7/19.
 */
@Repository
public class SoldDAOImpl implements SoldDAO{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void addSold(Sold sold) {
        getCurrentSession().save(sold);
    }

    public void deleteSold(int s_num) {
        Sold sold = getSold(s_num);
        if(sold != null){
            getCurrentSession().delete(sold);
        }
    }

    public void updateSold(Sold sold) {
        Sold soldToUpdate = getSold(sold.getS_num());
        soldToUpdate.setRfid(sold.getRfid());
        soldToUpdate.setS_date(sold.getS_date());
        soldToUpdate.setO_price(sold.getO_price());
        soldToUpdate.setS_price(sold.getS_price());
        soldToUpdate.setShapcode(sold.getShapcode());
        getCurrentSession().update(soldToUpdate);
    }

    public Sold getSold(int s_num) {
        Sold sold = (Sold) getCurrentSession().get(Sold.class,s_num);
        return sold;
    }

    public Sold getSoldByRfid(String rfid) {
        Sold sold = (Sold) getCurrentSession().get(Sold.class,rfid);
        return sold;
    }

    public List getSolds() {
        return getCurrentSession().createQuery("from Sold order by s_num asc").list();
    }
}
