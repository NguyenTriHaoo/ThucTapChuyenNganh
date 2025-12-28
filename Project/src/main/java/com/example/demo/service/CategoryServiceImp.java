package com.example.demo.service;

import com.example.demo.dao.CategoryDAO;
import com.example.demo.dao.ProductDAO;
import com.example.demo.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImp implements CategoryService{
    private ProductDAO productDAO;
    private CategoryDAO categoryDAO;
    @Autowired
    public CategoryServiceImp(CategoryDAO categoryDAO,ProductDAO productDAO) {
        this.categoryDAO = categoryDAO;
        this.productDAO = productDAO;
    }

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryDAO.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryDAO.save(category);
    }

    @Override
    public void deleteById(int id) {
        long productCount = productDAO.countByCategoryId(id);

        if (productCount > 0) {
            throw new RuntimeException(
                    "Danh mục đang có " + productCount + " sản phẩm, không thể xóa"
            );
        }

        categoryDAO.deleteById(id);
    }
    public long countAll() {
        return categoryDAO.countAll();
    }
}
