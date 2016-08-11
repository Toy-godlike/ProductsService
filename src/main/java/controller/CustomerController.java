package controller;

import entity.Area;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.CustomerService;
import util.DiscountForTrans;
import util.ProductForTrans;
import util.ProductInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
        ProductInfo productInfo = customerService.getProductInfo(rfid);
        Map<String, Object> modelMap = new HashMap<String, Object>(3);
        modelMap.put("product",productInfo.getProductForTrans());
        modelMap.put("area",productInfo.getAreaForTrans());
        modelMap.put("discount",productInfo.getDiscountForTrans());
        return modelMap;
    }

    @RequestMapping(value = "/getDis",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getDiscountInfo(){
        List list = customerService.getDiscounts();
        List<ProductForTrans> plist = new ArrayList<ProductForTrans>();
        List<DiscountForTrans> dlist = new ArrayList<DiscountForTrans>();
        for (int i = 0;i < list.size();i = i + 2){
            plist.add((ProductForTrans) list.get(i));
            dlist.add((DiscountForTrans) list.get(i + 1));
        }
        Map<String, Object> modelMap = new HashMap<String, Object>(2);
        modelMap.put("products",plist);
        modelMap.put("discounts",dlist);
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

    @RequestMapping(value="/search",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> searchProductLoc(HttpServletRequest request){
/*        String name = "";
        try {
            name = URLDecoder.decode(pname, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        String pname = request.getParameter("pname");
        try {
            pname = new String(pname.getBytes("ISO8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List list = customerService.getProductLoc(pname);
        List<ProductForTrans> plist = new ArrayList<ProductForTrans>();
        List<Area> alist = new ArrayList<Area>();
        for (int i = 0;i < list.size();i = i + 2){
            plist.add((ProductForTrans) list.get(i));
            alist.add((Area) list.get(i + 1));
        }
        Map<String, Object> modelMap = new HashMap<String, Object>(2);
        modelMap.put("products",plist);
        modelMap.put("locations",alist);
        return modelMap;
    }

    @RequestMapping(value="/claPro",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> searchProductLoc(@RequestParam("anum") int anum) {
        List list = customerService.getProductByArea(anum);
        List<ProductForTrans> plist = new ArrayList<ProductForTrans>();
        List<Area> alist = new ArrayList<Area>();
        alist.add((Area) list.get(0));
        for (int i = 1;i < list.size();i++){
            plist.add((ProductForTrans) list.get(i));
        }
        Map<String, Object> modelMap = new HashMap<String, Object>(2);
        modelMap.put("products",plist);
        modelMap.put("locations",alist);
        return modelMap;
    }
}
