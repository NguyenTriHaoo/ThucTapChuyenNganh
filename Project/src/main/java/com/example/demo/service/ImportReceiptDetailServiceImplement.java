package com.example.demo.service;

import com.example.demo.dao.ImportReceiptDetailDao;
import com.example.demo.entity.ImportReceiptDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ImportReceiptDetailServiceImplement implements ImportReceiptDetailService{
    @Autowired
    private ImportReceiptDetailDao importReceiptDetailService;

    @Override
    public ImportReceiptDetail save(ImportReceiptDetail detail) {
        return importReceiptDetailService.save(detail);
    }

    @Override
    public ImportReceiptDetail update(ImportReceiptDetail detail) {
        return importReceiptDetailService.save(detail);
    }

    @Override
    public void deleteById(int id) {
importReceiptDetailService.deleteById(id);
    }
}
