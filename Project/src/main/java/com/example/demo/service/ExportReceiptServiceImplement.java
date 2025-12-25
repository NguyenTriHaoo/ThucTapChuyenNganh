package com.example.demo.service;

import com.example.demo.dao.ExportReceiptDao;
import com.example.demo.entity.ExportReceipt;
import com.example.demo.entity.ExportReceiptDetail;
import com.example.demo.entity.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ExportReceiptServiceImplement implements ExportReceiptService{
    @Autowired
    private ExportReceiptDao exportReceiptDao;

    @Autowired
    private InventoryService inventoryService;

    @Override
    public java.util.List<ExportReceipt> findAll() {
        return exportReceiptDao.findAll();
    }

    @Override
    public java.util.Optional<ExportReceipt> findById(int id) {
        return exportReceiptDao.findById(id);
    }

    @Override
    public ExportReceipt save(ExportReceipt receipt) {
        return exportReceiptDao.save(receipt);
    }

    @Override
    public void approve(int receiptId) {

        ExportReceipt receipt = exportReceiptDao.findById(receiptId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phiếu xuất"));

        if (receipt.getStatus() == 1) {
            throw new RuntimeException("Phiếu xuất đã được duyệt");
        }

        for (ExportReceiptDetail d : receipt.getDetails()) {
            Inventory inv = inventoryService.findByProduct(d.getProduct());

            if (d.getQuantity() > inv.getQuantity()) {
                throw new RuntimeException(
                        "Không đủ tồn kho cho sản phẩm: " + d.getProduct().getTitle()
                );
            }
        }

        for (ExportReceiptDetail d : receipt.getDetails()) {
            inventoryService.decrease(d.getProduct(), d.getQuantity());
        }

        receipt.setStatus(1);
        exportReceiptDao.save(receipt);
    }
}
