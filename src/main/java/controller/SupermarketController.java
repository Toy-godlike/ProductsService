package controller;

import entity.Area;
import entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import service.SupermarketService;
import util.DiscountForTrans;
import util.OnSaleForTrans;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
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


    @RequestMapping("/addPro")
    public void addProduct(@RequestParam("shapcode") String shapcode,@RequestParam("pname") String pname,
                           @RequestParam("price") double price,@RequestParam("picture") MultipartFile[] myfiles,
                           HttpServletRequest request,HttpServletResponse response){
        Products products = new Products();
        products.setShapcode(shapcode);
        products.setPname(pname);
        products.setPrice(price);
        String picture = "";
        for(MultipartFile myfile : myfiles){
            if(myfile.isEmpty()){
                System.out.println("文件未上传");
            }else{
                System.out.println("文件名:" + myfile.getName());
                try {
                    // 保存的文件路径(如果用的是Tomcat服务器，文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\upload\\文件夹中  )
                    String filePath = request.getSession().getServletContext()
                            .getRealPath("/") + "upload/" + myfile.getOriginalFilename();
                    picture = "http://139.129.28.167/ProductService/upload/" + myfile.getOriginalFilename();
                    System.out.println(filePath);
                    File saveDir = new File(filePath);
                    if (!saveDir.getParentFile().exists())
                        saveDir.getParentFile().mkdirs();
                    myfile.transferTo(saveDir);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        products.setPicture(picture);
        boolean result = supermarketService.saveProduct(products);
        String resp = "";
        if (result){
            resp = "商品存储成功！";
        }else
            resp = "商品存储失败！";
        try {
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/addDis")
    public void addDis(@ModelAttribute DiscountForTrans discountForTrans,HttpServletResponse response){
        boolean result = supermarketService.saveDiscount(discountForTrans);
        System.out.println("------------------add---------");
        String resp = "";
        if (result){
            resp = "打折信息存储成功！";
        }else
            resp = "打折信息存储失败！";
        try {
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/addOnSale")
    public void addOnSale(@ModelAttribute OnSaleForTrans onSaleForTrans,HttpServletResponse response){
        boolean result = supermarketService.saveOnSale(onSaleForTrans);
        String resp = "";
        if (result){
            resp = "商品上架成功！";
        }else
            resp = "商品上架失败！";
        try {
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
