package com.example.demo.controller;

import com.example.demo.dao.ExportReceiptDetailDao;
import com.example.demo.dao.ProductDAO;
import com.example.demo.entity.ExportReceipt;
import com.example.demo.entity.ExportReceiptDetail;
import com.example.demo.service.ExportReceiptService;
import com.example.demo.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ExportReceiptController {
    @Autowired
    private ExportReceiptService exportReceiptService;

    @Autowired
    private ExportReceiptDetailDao detailDao;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private InventoryService inventoryService;

    // danh sách
    @GetMapping("/admin/Storage-main/export-receipt-list")
    public String list(Model model) {
        model.addAttribute("receipts", exportReceiptService.findAll());
        return "admin/Storage-main/export-receipt-list";
    }
//tao phieu xuat
    @GetMapping("/admin/Storage-main/export-receipt-list-create")
    public String createForm(Model model) {
        model.addAttribute("receipt", new ExportReceipt());
        model.addAttribute("products", productDAO.findAll());
        return "admin/Storage-main/export-receipt-list-create";
    }

    // lưu
    @PostMapping("/admin/Storage-main/export-receipt-list-save")
    public String save(
            @ModelAttribute ExportReceipt receipt,
            @RequestParam("productId[]") List<Integer> productIds,
            @RequestParam("quantity[]") List<Integer> quantities)
        {
        for (int i = 0; i < productIds.size(); i++) {
            ExportReceiptDetail d = new ExportReceiptDetail();
            d.setProduct(productDAO.findById(productIds.get(i)));
            d.setQuantity(quantities.get(i));
            d.setReceipt(receipt);
            receipt.getDetails().add(d);
        }

        exportReceiptService.save(receipt);
        return "redirect:/admin/Storage-main/export-receipt-list";
    }

    // duyệt (TRỪ KHO)
    @PostMapping("/admin/Storage-main/export-receipt-list-approve/{id}")
    public String approve(@PathVariable int id, RedirectAttributes ra) {
        try {
            exportReceiptService.approve(id);
        } catch (RuntimeException e) {
            ra.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/admin/Storage-main/export-receipt-list";
    }


    // chi tiết
    @GetMapping("/admin/Storage-main/export-receipt-list-detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("receipt", exportReceiptService.findById(id).orElseThrow());
        model.addAttribute("details", detailDao.findByReceiptId(id));
        return "admin/Storage-main/export-receipt-list-detail";
    }
}
