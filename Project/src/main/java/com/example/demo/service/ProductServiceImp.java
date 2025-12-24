package com.example.demo.service;

import com.example.demo.dao.CategoryDAO;
import com.example.demo.dao.ProductDAO;
import com.example.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImp implements ProductService{
    private ProductDAO productDAO;
    @Autowired
    public ProductServiceImp(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productDAO.save(product);
    }

    @Override
    public void deleteById(int id) {
        productDAO.deleteById(id);
    }
    public long countAll() {
        return productDAO.countAll();
    }

    public long countActive() {
        return productDAO.countActive();
    }

    public long countInactive() {
        return productDAO.countInactive();
    }
}
