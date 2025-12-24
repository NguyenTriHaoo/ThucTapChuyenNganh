package com.example.demo.service;

import com.example.demo.dao.ImportReceiptDao;
import com.example.demo.entity.ImportReceipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImportReceiptServiceImplement implements ImportReceiptService{
    @Autowired
    private ImportReceiptDao importReceiptDao;

    @Override
    public ImportReceipt save(ImportReceipt receipt) {
        return importReceiptDao.save(receipt);
    }

    @Override
    public ImportReceipt update(ImportReceipt receipt) {
        return importReceiptDao.save(receipt);
    }

    @Override
    public void deleteById(int id) {
        importReceiptDao.deleteById(id);
    }

    @Override
    public Optional<ImportReceipt> findById(int id) {
        return importReceiptDao.findById(id);
    }

    @Override
    public List<ImportReceipt> findAll() {
        return importReceiptDao.findAll();
    }
}
