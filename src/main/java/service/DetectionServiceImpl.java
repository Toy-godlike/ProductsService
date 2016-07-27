package service;

import dao.SoldDAO;
import entity.Sold;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;

/**
 * Created by Administrator on 2016/7/19.
 */
//@WebService(endpointInterface = "service.DetectionService")
public class DetectionServiceImpl implements DetectionService {

    @Autowired
    private SoldDAO soldDAO;

    public boolean isPaid(String rfid) {
        Sold sold = soldDAO.getSoldByRfid(rfid);
        if (sold != null){
            return false;
        }else
            return true;
    }
}
