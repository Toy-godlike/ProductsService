package controller;

import entity.Area;
import entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import service.SupermarketService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/8/2.
 */
@Controller
@RequestMapping("/supermarket")
public class SupermarketController {

    private SupermarketService supermarketService;

    @Autowired
    private void setSupermarketService(SupermarketService supermarketService){
        this.supermarketService = supermarketService;
    }

    @RequestMapping("/main")
    public String StartSys(){
        return "index";
    }

    @RequestMapping("/addArea")
    public void addArea(@ModelAttribute Area area,HttpServletResponse response){
        boolean result = supermarketService.saveArea(area);
        String resp = "";
        if (result){
            resp = "区域存储成功！";
        }else
            resp = "区域存储失败！";
        try {
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("addPro")
    public void addProduct(@ModelAttribute Products products,HttpServletResponse response){

    }

}
