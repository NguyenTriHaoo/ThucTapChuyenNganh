package com.example.demo.dao;

import com.example.demo.entity.ExportReceiptDetail;
import java.util.List;

public interface ExportReceiptDetailDao {
    List<ExportReceiptDetail> findByReceiptId(int receiptId);
}
