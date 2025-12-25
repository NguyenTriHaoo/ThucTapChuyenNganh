package com.example.demo.service;

import com.example.demo.entity.ImportReceipt;

import java.util.List;
import java.util.Optional;

public interface ImportReceiptService {
    ImportReceipt createReceipt(
            String supplier,
            List<Integer> productIds,
            List<Integer> quantities,
            List<Float> prices
    );

    void approveReceipt(int receiptId);

    List<ImportReceipt> findAll();

    Optional<ImportReceipt> findById(int id);
}
