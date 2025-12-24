package com.example.demo.controller;

import com.example.demo.dao.ImportReceiptDao;
import com.example.demo.dao.ImportReceiptDetailDao;
import com.example.demo.dao.ProductDAO;
import com.example.demo.entity.ImportReceipt;
import com.example.demo.entity.ImportReceiptDetail;
import com.example.demo.entity.Product;
import com.example.demo.service.ImportReceiptDetailService;
import com.example.demo.service.ImportReceiptService;
import com.example.demo.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class ImportReceiptController {
    @Autowired
    private ImportReceiptService importReceiptService;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private ImportReceiptDetailDao importReceiptDetailDao;
    //ds phieu nhap
    @GetMapping("admin/Storage-main/import-receipt-list")
    public String list(Model model){
        List<ImportReceipt> receipts = importReceiptService.findAll();
        model.addAttribute("receipts", receipts);
        return "admin/Storage-main/import-receipt-list";
    }

    // from tao phieu nhap
    @GetMapping("admin/Storage-main/import-receipt-list-create")
    public String createForm(Model model) {
        model.addAttribute("receipt", new ImportReceipt());
        model.addAttribute("products", productDAO.findAll());
        return "admin/Storage-main/import-receipt-list-create";
    }

    //luu phieu nhap nhung chua cong ton kho
    @PostMapping("admin/Storage-main/import-receipt-list-save")
    public String save(@ModelAttribute ImportReceipt receipt,
                       @RequestParam("productId[]") List<Integer> productIds,
                       @RequestParam("quantity[]") List<Integer> quantities,
                       @RequestParam("price[]") List<Float> prices) {

        for (int i = 0; i < productIds.size(); i++) {
            Product product = productDAO.findById(productIds.get(i));
            ImportReceiptDetail detail = new ImportReceiptDetail();
            detail.setProduct(product);
            detail.setQuantity(quantities.get(i));
            detail.setPrice(prices.get(i));
            detail.setReceipt(receipt);
            receipt.getDetails().add(detail);
        }

        importReceiptService.save(receipt);
        return "redirect:/admin/Storage-main/import-receipt-list";
    }


    @GetMapping("admin/Storage-main/import-receipt-list-approve/{id}")
        public String approve(@PathVariable int id){
            ImportReceipt receipt = importReceiptService.findById(id).orElseThrow();
            if(receipt.getStatus()==0){
                receipt.getDetails().forEach(d->inventoryService.increase(d.getProduct(),d.getQuantity()));
                receipt.setStatus(1);
                importReceiptService.save(receipt);
            }
            return "redirect:/admin/Storage-main/import-receipt-list";
        }

    @GetMapping("admin/Storage-main/import-receipt-list-detail/{id}")
    public String viewDetail(@PathVariable("id") int id, Model model) {
        ImportReceipt receipt = importReceiptService.findById(id)
                .orElseThrow(() -> new RuntimeException("Phiếu nhập không tồn tại"));

        List<ImportReceiptDetail> details = importReceiptDetailDao.findByReceiptId(id);
        model.addAttribute("receipt", receipt);
        model.addAttribute("details", details);
        return "admin/Storage-main/import-receipt-list-detail";
    }
}
