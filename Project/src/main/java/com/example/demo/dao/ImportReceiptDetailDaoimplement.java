package com.example.demo.dao;

import com.example.demo.entity.ImportReceipt;
import com.example.demo.entity.ImportReceiptDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ImportReceiptDetailDaoimplement implements ImportReceiptDetailDao{
    private EntityManager em;
    @Autowired
    public ImportReceiptDetailDaoimplement(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<ImportReceiptDetail> findByReceiptId(int receiptId) {
        TypedQuery<ImportReceiptDetail> query = em.createQuery(
                "SELECT d FROM ImportReceiptDetail d WHERE d.receipt.id = :rid",
                ImportReceiptDetail.class
        );
        query.setParameter("rid", receiptId);
        return query.getResultList();
    }

    @Override
    public ImportReceiptDetail save(ImportReceiptDetail detail) {
        return em.merge(detail);
    }

    @Override
    public void deleteById(int id) {
        ImportReceiptDetail detail = em.find(ImportReceiptDetail.class, id);
        if (detail != null) {
            em.remove(detail);
        }
    }
}
