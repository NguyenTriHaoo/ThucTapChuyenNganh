package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="title")
    private String title;
    @Column(name="image")
    private String image;

    @Column(name="description")
    private String description;

    @Column(name="content")
    private String content;

    @Column(name="price")
    private float price;

    @Column(name="id_cate")
    private int id_cate;

    @Column(name="status")
    private int status;

    public Product() {
    }

    public Product(String title, String image, String description, float price, String content, int id_cate, int status) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.price = price;
        this.content = content;
        this.id_cate = id_cate;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public int getId_cate() {
        return id_cate;
    }

    public float getPrice() {
        return price;
    }

    public int getStatus() {
        return status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setId_cate(int id_cate) {
        this.id_cate = id_cate;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", price=" + price +
                ", id_cate=" + id_cate +
                ", status=" + status +
                '}';
    }
}
