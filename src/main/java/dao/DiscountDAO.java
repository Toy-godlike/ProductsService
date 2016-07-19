package dao;

import entity.Discount;

import java.util.List;

/**
 * Created by Administrator on 2016/7/18.
 */
public interface DiscountDAO {
    public void addDiscount(Discount discount);
    public void deleteDiscount(int d_num);
    public void updateDiscount(Discount discount);
    public Discount getDiscount(int d_num);
    public Discount getDiscountByShapcode(String shapcode);
    public List getDiscounts();
}
