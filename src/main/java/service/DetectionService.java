package service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by Administrator on 2016/7/19.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface DetectionService {

    @WebMethod
    public boolean isPaid(@WebParam(name="rfid")String rfid);
}
