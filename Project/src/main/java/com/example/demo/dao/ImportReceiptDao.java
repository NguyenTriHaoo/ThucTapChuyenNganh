package com.example.demo.dao;

import com.example.demo.entity.ImportReceipt;

import java.util.List;
import java.util.Optional;

public interface ImportReceiptDao {
    List<ImportReceipt> findAll();


    Optional<ImportReceipt> findById(int id);

    ImportReceipt save(ImportReceipt receipt);

    void deleteById(int id);
}
