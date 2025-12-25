package com.example.demo.service;

import com.example.demo.dao.ExportReceiptDetailDao;
import com.example.demo.entity.ExportReceiptDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExportReceiptDetailServiceImplement implements ExportReceiptDetailService{
    @Autowired
    private ExportReceiptDetailDao exportReceiptDetailDao;

    @Override
    public List<ExportReceiptDetail> findByReceiptId(int receiptId) {
        return exportReceiptDetailDao.findByReceiptId(receiptId);
    }

}
