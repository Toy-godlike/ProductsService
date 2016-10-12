package service;

import org.springframework.stereotype.Service;
import util.PurchaseOrdeDetail;

import java.util.List;

/**
 * Created by Administrator on 2016/10/12.
 */

public interface PurchaseOrderService {
    public boolean savePurchaseOrder(String detail,double cost,int count);
    public List<PurchaseOrdeDetail> getDetail(int id);
}
