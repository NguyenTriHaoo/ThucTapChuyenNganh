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
import com.example.demo.service.ProductService;
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
    private ProductService productService;
    @Autowired
    private InventoryService inventoryService;

    //ds phieu nhap
    @GetMapping("admin/Storage-main/import-receipt-list")
    public String list(Model model) {
        model.addAttribute("receipts", importReceiptService.findAll());
        return "admin/Storage-main/import-receipt-list";
    }

    // from tao phieu nhap
    @GetMapping("admin/Storage-main/import-receipt-list-create")
    public String createForm(Model model) {
        model.addAttribute("products", productService.findAll());
        return "admin/Storage-main/import-receipt-list-create";
    }

    //luu phieu nhap nhung chua cong ton kho
    @PostMapping("admin/Storage-main/import-receipt-list-save")
    public String save(
            @RequestParam String supplier,
            @RequestParam("productId[]") List<Integer> productIds,
            @RequestParam("quantity[]") List<Integer> quantities,
            @RequestParam("price[]") List<Float> prices)
    {
        importReceiptService.createReceipt(supplier, productIds, quantities, prices);
        return "redirect:/admin/Storage-main/import-receipt-list";
    }


    @PostMapping("admin/Storage-main/import-receipt-list-approve/{id}")
    public String approve(@PathVariable int id) {
        importReceiptService.approveReceipt(id);
        return "redirect:/admin/Storage-main/import-receipt-list";
    }

    @GetMapping("admin/Storage-main/import-receipt-list-detail/{id}")
    public String viewDetail(@PathVariable int id, Model model) {
        ImportReceipt receipt = importReceiptService.findById(id)
                .orElseThrow(() -> new RuntimeException("Phiếu nhập không tồn tại"));

        model.addAttribute("receipt", receipt);
        model.addAttribute("details", receipt.getDetails());
        return "admin/Storage-main/import-receipt-list-detail";
    }
}
