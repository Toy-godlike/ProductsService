package dao;

import entity.Products;

import java.util.List;

/**
 * Created by Administrator on 2016/7/15.
 */
public interface ProductsDAO {
    public void addProducts(Products products);
    public Products getProducts(String shapcode);
    public void deleteProducts(String shapcode);
    public void updateProducts(Products products);
    public List getProductsAll();
}
