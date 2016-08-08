import dao.DiscountDAO;
import entity.Area;
import entity.Discount;
import entity.OnSale;
import entity.Products;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.OnSaleService;

/**
 * Created by Administrator on 2016/7/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-hibernate.xml","classpath:spring.xml"})
public class TestHibernate {

    @Autowired
    private OnSaleService onSaleService;

    /*
    @Test
    public void testOnSale(){
        String rfid = "11111111";
        OnSale obj1 = onSaleService.getOnSale(rfid);
        Products obj2 = obj1.getProducts();
        Area obj3 = obj1.getArea();
        System.out.println(obj1.getRfid());
        System.out.println(obj2.getShapcode());
        System.out.println(obj2.getPname());
        System.out.println(obj3.getA_name());
        System.out.println(obj3.getLocation());

        Products products = new Products("0002","可乐",3.5);
        OnSale onSale = new OnSale("22222222",products,obj3);
        onSaleService.addOnSale(onSale);
    }*/

//    @Autowired
//    private DiscountDAO discountDAO;

    @Test
    public void testDiscount(){
        int temp = onSaleService.getAnum(1);
        System.out.println("--------------------" + temp);
    }
}
