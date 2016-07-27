package controller;

import entity.Discount;
import entity.OnSale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.CustomerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
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
    @ResponseBody
    public Map<String,Object> getProductInfo(HttpServletRequest request,HttpServletResponse response){
        String rfid = request.getParameter("rfid");
        OnSale onSale = customerService.getProductInfo(rfid);
        Map<String, Object> modelMap = new HashMap<String, Object>(2);
        modelMap.put("total","1");
        modelMap.put("rows",onSale);
        return modelMap;
    }

    @RequestMapping(value = "/getDis",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getDiscountInfo(){
        List<Discount> discountList = customerService.getDiscounts();
        Map<String, Object> modelMap = new HashMap<String, Object>(2);
        modelMap.put("total","1");
        modelMap.put("rows",discountList);
        return modelMap;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveSold(HttpServletRequest request,HttpServletResponse response){
        String rfid = request.getParameter("rfid");
        String s_name = request.getParameter("s_name");
        String s_price = request.getParameter("s_price");
        String o_price = request.getParameter("o_price");
        String s_num = request.getParameter("s_num");
        String s_date = request.getParameter("s_date");
        Map<String, Object> modelMap = new HashMap<String, Object>(2);
        modelMap.put("total","1");
        modelMap.put("rows",customerService.saveSold(s_num,s_name,rfid,s_date,s_price,o_price));
        return modelMap;
    }
}
