package com.example.demo.dao;

import com.example.demo.entity.ImportReceiptDetail;

import java.util.List;

public interface ImportReceiptDetailDao {
    List<ImportReceiptDetail> findByReceiptId(int receiptId);
    ImportReceiptDetail save(ImportReceiptDetail detail);
    void deleteById(int id);
}
