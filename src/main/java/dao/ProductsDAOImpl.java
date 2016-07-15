package dao;

import entity.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
