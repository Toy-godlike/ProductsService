package dao;

import entity.OnSale;
import entity.Products;
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

    public int getAnum(String shapcode) {
        Integer anum = (Integer) getCurrentSession().createQuery("select distinct area.a_num from OnSale where products.shapcode = :key1")
                .setString("key1",shapcode).uniqueResult();
        return anum;
    }

    public List getShapcode(int anum) {
        List<String> list = getCurrentSession().createQuery("select distinct products.shapcode from OnSale where area.a_num = :key1")
                .setInteger("key1",anum).list();
        return list;
    }
}
