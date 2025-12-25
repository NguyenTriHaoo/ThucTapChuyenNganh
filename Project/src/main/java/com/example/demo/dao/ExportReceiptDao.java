package com.example.demo.dao;

import com.example.demo.entity.ExportReceipt;

import java.util.List;
import java.util.Optional;

public interface ExportReceiptDao {
    List<ExportReceipt> findAll();
    Optional<ExportReceipt> findById(int id);
    ExportReceipt save(ExportReceipt receipt);
}
