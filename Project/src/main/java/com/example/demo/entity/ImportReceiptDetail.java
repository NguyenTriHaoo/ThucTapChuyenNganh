package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "import_receipt_detail")
public class ImportReceiptDetail {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private int quantity;
        private float price;

        @ManyToOne
        @JoinColumn(name = "receipt_id", nullable = false)
        private ImportReceipt receipt;

        @ManyToOne
        @JoinColumn(name = "product_id", nullable = false)
        private Product product;


    public ImportReceiptDetail() {
    }

    public ImportReceiptDetail(int quantity, float price, ImportReceipt receipt, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.receipt = receipt;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ImportReceipt getReceipt() {
        return receipt;
    }

    public void setReceipt(ImportReceipt receipt) {
        this.receipt = receipt;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
