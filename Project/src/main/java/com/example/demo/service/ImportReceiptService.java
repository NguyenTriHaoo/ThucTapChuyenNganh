package com.example.demo.service;

import com.example.demo.entity.ImportReceipt;

import java.util.List;
import java.util.Optional;

public interface ImportReceiptService {
        ImportReceipt save(ImportReceipt receipt);
        ImportReceipt update(ImportReceipt receipt);
        void deleteById(int id);
        Optional<ImportReceipt> findById(int id);
        List<ImportReceipt> findAll();
}
