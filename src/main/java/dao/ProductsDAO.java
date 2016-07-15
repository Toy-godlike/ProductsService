package dao;

import entity.Products;

/**
 * Created by Administrator on 2016/7/15.
 */
public interface ProductsDAO {
    public void addProducts(Products products);
    public Products getProducts(String shapcode);
}
