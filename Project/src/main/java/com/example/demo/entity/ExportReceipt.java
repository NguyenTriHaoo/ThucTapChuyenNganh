package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ExportReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="export_date")
    private LocalDateTime exportDate = LocalDateTime.now();

    private String receiver;
    private int status=0;

    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL)
    private List<ExportReceiptDetail> details = new ArrayList<>();

    public ExportReceipt() {
        this.exportDate = LocalDateTime.now();
        this.status=0;
    }

    public ExportReceipt(String receiver) {
        this.receiver = receiver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getExportDate() {
        return exportDate;
    }

    public void setExportDate(LocalDateTime exportDate) {
        this.exportDate = exportDate;
    }

    public String getExportDateStr() {
        return exportDate != null ? exportDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) : "-";
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ExportReceiptDetail> getDetails() {
        return details;
    }

    public void setDetails(List<ExportReceiptDetail> details) {
        this.details = details;
    }
}
