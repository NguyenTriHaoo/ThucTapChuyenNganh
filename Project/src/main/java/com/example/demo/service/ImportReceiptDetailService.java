package com.example.demo.service;

import com.example.demo.entity.ImportReceiptDetail;

import java.util.List;
import java.util.Optional;

public interface ImportReceiptDetailService {
    ImportReceiptDetail save(ImportReceiptDetail detail);
    ImportReceiptDetail update(ImportReceiptDetail detail);
    void deleteById(int id);
}
