package controller;

import entity.Discount;
import entity.OnSale;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.CustomerService;
import util.AreaForTrans;
import util.ProductForTrans;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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

    @RequestMapping(value="/getPro",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getProductInfo(@RequestParam("rfid") String rfid){
        OnSale onSale = customerService.getProductInfo(rfid);
        ProductForTrans productForTrans = new ProductForTrans();
        productForTrans.setShapcode(onSale.getProducts().getShapcode());
        productForTrans.setPname(onSale.getProducts().getPname());
        productForTrans.setPrice(onSale.getProducts().getPrice());
        productForTrans.setPicture(onSale.getProducts().getPicture());
        AreaForTrans areaForTrans = new AreaForTrans();
        areaForTrans.setA_num(onSale.getArea().getA_num());
        areaForTrans.setA_name(onSale.getArea().getA_name());
        areaForTrans.setLocation(onSale.getArea().getLocation());
        Map<String, Object> modelMap = new HashMap<String, Object>(2);
        modelMap.put("product",productForTrans);
        modelMap.put("area",areaForTrans);
        return modelMap;
    }

    @RequestMapping(value = "/getDis",method = RequestMethod.GET)
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
    public Map<String,Object> saveSold(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        JSONArray reqarray = null;
        String reqMessage;
        boolean result = false;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    request.getInputStream(), "UTF-8"));
            StringBuffer sb = new StringBuffer("");
            String temp;
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
            }
            br.close();
            reqMessage = sb.toString();
            reqarray = new JSONArray(reqMessage);
            for (int i = 0;i < reqarray.length();i++){
                JSONObject jsonObject = reqarray.getJSONObject(i);
                result = customerService.saveSold(jsonObject.getInt("s_num"),jsonObject.getString("shapcode"),
                        jsonObject.getString("rfid"),jsonObject.getString("s_date"),jsonObject.getDouble("s_price"),
                        jsonObject.getDouble("o_price"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
 /*       JSONObject jsonObject = JSONObject.fromObject(jsonString);
        String rfid = jsonObject.getString("rfid");
        String s_name = jsonObject.getString("s_name");
        String s_price = jsonObject.getString("s_price");
        String o_price = jsonObject.getString("o_price");
        String s_num = jsonObject.getString("s_num");
        String s_date = jsonObject.getString("s_date");*/
        Map<String, Object> modelMap = new HashMap<String, Object>(1);
        modelMap.put("result",result);
        return modelMap;
    }
}
