package controller;

import entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.SupermarketService;

import java.util.List;

/**
 * Created by Administrator on 2016/8/4.
 */
@Controller
@RequestMapping("/info")
public class InfoProviderController {

    private SupermarketService supermarketService;

    @Autowired
    private void setSupermarketService(SupermarketService supermarketService){
        this.supermarketService = supermarketService;
    }

    @RequestMapping(value="/area",method= RequestMethod.GET)
    @ResponseBody
    public List<Area> getAreaInfo(){
        List<Area> list = supermarketService.getAreas();
        return list;
    }
}
