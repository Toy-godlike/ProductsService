package dao;

import entity.PurchaseOrder;

import java.util.List;

/**
 * Created by Administrator on 2016/10/12.
 */
public interface PurchaseOrderDAO {
    public void addPurchaseOrder(PurchaseOrder  purchaseOrder);
    public PurchaseOrder getPurchaseOrder(int id);
    public List< PurchaseOrder> getPurchaseOrderByUser(String userId);
}
