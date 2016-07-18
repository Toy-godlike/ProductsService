package dao;

import entity.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/7/15.
 */
@Repository
public class ProductsDAOImpl implements ProductsDAO{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void addProducts(Products products) {
        getCurrentSession().save(products);
    }

    public Products getProducts(String shapcode) {
        Products products = (Products) getCurrentSession().get(Products.class,shapcode);
        return products;
    }

    public void deleteProducts(String shapcode) {
        Products products = getProducts(shapcode);
        if(products != null) {
            getCurrentSession().delete(products);
        }
    }

    public void updateProducts(Products products) {
        Products productsToUpdate = getProducts(products.getShapcode());
        productsToUpdate.setPname(products.getPname());
        productsToUpdate.setPrice(products.getPrice());
        productsToUpdate.setPicture(products.getPicture());
        getCurrentSession().update(productsToUpdate);
    }

    @SuppressWarnings("unchecked")
    public List getProductsAll() {
        return getCurrentSession().createQuery("from Products").list();
    }
}
