package com.example.demo.service;

import com.example.demo.dao.ImportReceiptDao;
import com.example.demo.dao.ProductDAO;
import com.example.demo.entity.ImportReceipt;
import com.example.demo.entity.ImportReceiptDetail;
import com.example.demo.entity.Product;
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

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private InventoryService inventoryService;

    @Override
    public ImportReceipt createReceipt(
            String supplier,
            List<Integer> productIds,
            List<Integer> quantities,
            List<Float> prices) {
        ImportReceipt receipt = new ImportReceipt(); // status = 0
        receipt.setSupplier(supplier);

        for (int i = 0; i < productIds.size(); i++) {
            if (quantities.get(i) <= 0 || prices.get(i) < 0) {
                throw new RuntimeException("Số lượng hoặc giá không hợp lệ");
            }

            Product product = productDAO.findById(productIds.get(i));
            if (product == null) {
                throw new RuntimeException("Sản phẩm không tồn tại");
            }

            ImportReceiptDetail detail = new ImportReceiptDetail();
            detail.setProduct(product);
            detail.setQuantity(quantities.get(i));
            detail.setPrice(prices.get(i));
            detail.setReceipt(receipt);

            receipt.getDetails().add(detail);
        }

        return importReceiptDao.save(receipt);
    }

    @Override
    public void approveReceipt(int receiptId) {
        ImportReceipt receipt = importReceiptDao.findById(receiptId)
                .orElseThrow(() -> new RuntimeException("Phiếu nhập không tồn tại"));

        // chỉ duyệt 1 lần
        if (receipt.getStatus() != 0) {
            return;
        }

        receipt.getDetails().forEach(d ->
                inventoryService.increase(d.getProduct(), d.getQuantity())
        );

        receipt.setStatus(1);
        importReceiptDao.save(receipt);
    }

    @Override
    public List<ImportReceipt> findAll() {
        return importReceiptDao.findAll();
    }

    @Override
    public Optional<ImportReceipt> findById(int id) {
        return importReceiptDao.findById(id);
    }
}
