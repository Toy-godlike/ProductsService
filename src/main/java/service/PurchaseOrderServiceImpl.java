package service;

import dao.ProductsDAO;
import dao.PurchaseOrderDAO;
import dao.SoldDAO;
import entity.OnSale;
import entity.Products;
import entity.PurchaseOrder;
import entity.Sold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.PurchaseOrdeDetail;
import util.PurchaseOrderForTrans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/10/12.
 */
@Service("purchaseOrderService")
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderDAO purchaseOrderDAO;

    @Autowired
    private SoldDAO soldDAO;

    @Autowired
    private ProductsDAO productsDAO;

    public boolean savePurchaseOrder(String detail, double cost, int count) {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setUserId("001");
        purchaseOrder.setId(1);
        purchaseOrder.setDetail(detail);
        purchaseOrder.setCost(cost);
        purchaseOrder.setCount(count);
        Date date = new Date();
        purchaseOrder.setDate(date);

        try {
            purchaseOrderDAO.addPurchaseOrder(purchaseOrder);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<PurchaseOrderForTrans> showOrder(String userId){
        List<PurchaseOrder> list = purchaseOrderDAO.getPurchaseOrderByUser(userId);
        List<PurchaseOrderForTrans> listForTrans = new ArrayList<PurchaseOrderForTrans>();
        for (int i = 0;i < list.size();i++){
            PurchaseOrderForTrans purchaseOrderForTrans = new PurchaseOrderForTrans();
            purchaseOrderForTrans.setId(list.get(i).getId());
            purchaseOrderForTrans.setUserId(list.get(i).getUserId());
            purchaseOrderForTrans.setCost(list.get(i).getCost());
            purchaseOrderForTrans.setCount(list.get(i).getCount());
            purchaseOrderForTrans.setDate(list.get(i).getDate());
            listForTrans.add(purchaseOrderForTrans);
        }
        return listForTrans;
    }

    public List<PurchaseOrdeDetail> getDetail(int id) {
        PurchaseOrder purchaseOrder = purchaseOrderDAO.getPurchaseOrder(id);
        String detail = purchaseOrder.getDetail();
        List<PurchaseOrdeDetail> list = new ArrayList<PurchaseOrdeDetail>();
        String[] purchase = detail.split(";");
        for (int i = 0;i < purchase.length;i++){
            Sold sold = soldDAO.getSoldByRfid(purchase[i]);
            Products products = productsDAO.getProducts(sold.getShapcode());
            PurchaseOrdeDetail purchaseOrdeDetail = new PurchaseOrdeDetail();
            purchaseOrdeDetail.setName(products.getPname());
            purchaseOrdeDetail.setPrice(sold.getS_price());
            list.add(purchaseOrdeDetail);
        }
        return list;
    }
}
