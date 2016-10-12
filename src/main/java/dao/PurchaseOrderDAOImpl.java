package dao;

import entity.PurchaseOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/10/12.
 */
@Repository
public class PurchaseOrderDAOImpl implements PurchaseOrderDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void addPurchaseOrder(PurchaseOrder purchaseOrder) {
        getCurrentSession().save(purchaseOrder);
    }

    public PurchaseOrder getPurchaseOrder(int id) {
        PurchaseOrder purchaseOrder = (PurchaseOrder) getCurrentSession().get(PurchaseOrder.class,id);
        return purchaseOrder;
    }

    public List<PurchaseOrder> getPurchaseOrderByUser(String userId) {
        return getCurrentSession().createQuery("from PurchaseOrder where userId =: key1").setString("key1",userId)
                .list();
    }
}
