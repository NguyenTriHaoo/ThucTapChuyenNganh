package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="import_receipt")
public class ImportReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="import_date")
    private LocalDateTime importDate;
    private int status;
    private String supplier;
    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ImportReceiptDetail> details = new ArrayList<>();

    public ImportReceipt() {
        this.importDate = LocalDateTime.now();
        this.status = 0;
    }

    public ImportReceipt(LocalDateTime importDate, int status, String supplier) {
        this.importDate = importDate;
        this.status = status;
        this.supplier = supplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDateTime importDate) {
        this.importDate = importDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ImportReceiptDetail> getDetails() {
        return details;
    }

    public void setDetails(List<ImportReceiptDetail> details) {
        this.details = details;
    }

    public String getImportDateStr() {
        return importDate != null ? importDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) : "-";
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
