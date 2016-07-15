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

    @Test
    public void testOnSale(){
        String rfid = "11111111";
        OnSale obj1 = onSaleService.getOnSale(rfid);
        Products obj2 = obj1.getProducts();
        System.out.println(obj1.getRfid());
        System.out.println(obj2.getShapcode());
        System.out.println(obj2.getPname());
    }
}
