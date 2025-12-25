package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ExportReceiptDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private ExportReceipt receipt;

    @ManyToOne
    private Product product;

    private int quantity;

    public ExportReceiptDetail() {
    }

    public ExportReceiptDetail(ExportReceipt receipt, Product product, int quantity) {
        this.receipt = receipt;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ExportReceipt getReceipt() {
        return receipt;
    }

    public void setReceipt(ExportReceipt receipt) {
        this.receipt = receipt;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
