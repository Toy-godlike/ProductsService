package util;

/**
 * Created by Administrator on 2016/8/1.
 */
public class ProductInfo {

    private ProductForTrans productForTrans;
    private AreaForTrans areaForTrans;
    private DiscountForTrans discountForTrans;

    public ProductInfo(ProductForTrans productForTrans, AreaForTrans areaForTrans, DiscountForTrans discountForTrans) {
        this.productForTrans = productForTrans;
        this.areaForTrans = areaForTrans;
        this.discountForTrans = discountForTrans;
    }

    public ProductForTrans getProductForTrans() {
        return productForTrans;
    }

    public void setProductForTrans(ProductForTrans productForTrans) {
        this.productForTrans = productForTrans;
    }

    public AreaForTrans getAreaForTrans() {
        return areaForTrans;
    }

    public void setAreaForTrans(AreaForTrans areaForTrans) {
        this.areaForTrans = areaForTrans;
    }

    public DiscountForTrans getDiscountForTrans() {
        return discountForTrans;
    }

    public void setDiscountForTrans(DiscountForTrans discountForTrans) {
        this.discountForTrans = discountForTrans;
    }
}
