package service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Administrator on 2016/7/19.
 */
@WebService
public interface DetectionService {

    @WebMethod
    public boolean isPaid(String rfid);
}
