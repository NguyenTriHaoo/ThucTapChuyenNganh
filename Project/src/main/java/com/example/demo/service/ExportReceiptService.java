package com.example.demo.service;

import com.example.demo.entity.ExportReceipt;

import java.util.List;
import java.util.Optional;

public interface ExportReceiptService {
    List<ExportReceipt> findAll();
    Optional<ExportReceipt> findById(int id);
    ExportReceipt save(ExportReceipt receipt);

    void approve(int receiptId);
}
