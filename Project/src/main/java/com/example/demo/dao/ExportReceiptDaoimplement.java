package com.example.demo.dao;

import com.example.demo.entity.ExportReceipt;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ExportReceiptDaoimplement implements ExportReceiptDao{
    @Autowired
    private EntityManager em;

    @Override
    public List<ExportReceipt> findAll() {
        return em.createQuery(
                "SELECT r FROM ExportReceipt r ORDER BY r.id DESC",
                ExportReceipt.class
        ).getResultList();
    }

    @Override
    public Optional<ExportReceipt> findById(int id) {
        return Optional.ofNullable(em.find(ExportReceipt.class, id));
    }

    @Override
    public ExportReceipt save(ExportReceipt receipt) {
        return em.merge(receipt);
    }
}
