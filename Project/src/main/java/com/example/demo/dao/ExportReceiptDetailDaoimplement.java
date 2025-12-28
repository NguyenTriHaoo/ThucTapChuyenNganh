package com.example.demo.dao;

import com.example.demo.entity.ExportReceiptDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExportReceiptDetailDaoimplement implements ExportReceiptDetailDao{

    @Autowired
    private EntityManager em;

    @Override
    public List<ExportReceiptDetail> findByReceiptId(int receiptId) {
        return em.createQuery("SELECT d FROM ExportReceiptDetail d WHERE d.receipt.id = :rid",
                        ExportReceiptDetail.class)
                .setParameter("rid", receiptId)
                .getResultList();
    }
}
