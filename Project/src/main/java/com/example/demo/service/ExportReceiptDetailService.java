package com.example.demo.service;

import com.example.demo.entity.ExportReceiptDetail;

import java.util.List;

public interface ExportReceiptDetailService {
    List<ExportReceiptDetail> findByReceiptId(int receiptId);
}
