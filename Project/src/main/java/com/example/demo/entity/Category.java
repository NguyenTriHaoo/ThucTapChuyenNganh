package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="category")
public class Category {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private int id;
        @Column(name="name")
        private String name;
        @Column(name="image")
        private String image;
        @Column(name="status")
        private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category() {
        }

        public Category(int status, String image, String name) {
            this.status = status;
            this.image = image;
            this.name = name;
        }


        public String getName() {
            return name;
        }

        public String getImage() {
            return image;
        }

        public int getStatus() {
            return status;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "Category{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", image='" + image + '\'' +
                    ", status=" + status +
                    '}';
        }
    }

