package com.example.demo.dao;

import com.example.demo.entity.ImportReceipt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ImportReceiptDaoimplement implements ImportReceiptDao{

    private EntityManager em;

    @Autowired
    public ImportReceiptDaoimplement(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<ImportReceipt> findAll() {
        TypedQuery<ImportReceipt> query =
                em.createQuery("FROM ImportReceipt", ImportReceipt.class);
        return query.getResultList();
    }

    @Override
    public Optional<ImportReceipt> findById(int id) {
        return Optional.ofNullable(em.find(ImportReceipt.class, id));
    }

    @Override
    public ImportReceipt save(ImportReceipt receipt) {
        return em.merge(receipt);
    }

    @Override
    public void deleteById(int id) {
        ImportReceipt receipt = em.find(ImportReceipt.class, id);
        if (receipt != null) {
            em.remove(receipt);
        }
    }
}
