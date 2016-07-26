package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CustomerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/26.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    private static Logger log = LoggerFactory.getLogger(CustomerService.class);

    private CustomerService customerService;

    @Autowired
    private void setCustomerService(CustomerService customerService){
        this.customerService = customerService;
    }

    @RequestMapping(value="/getPro",method = RequestMethod.POST)
    public Map<String,Object> getProductInfo(HttpServletRequest request,HttpServletResponse response){

        Map<String, Object> modelMap = new HashMap<String, Object>(2);
        return modelMap;
    }
}
