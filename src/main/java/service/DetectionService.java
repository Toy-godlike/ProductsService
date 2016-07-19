package service;

import javax.jws.WebMethod;

/**
 * Created by Administrator on 2016/7/19.
 */
public interface DetectionService {

    @WebMethod
    public boolean isPaid(String rfid);
}
