package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="about")
public class About {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String mota1;
    private String mota2;
    private String mota3;
    private String mota4;
    private String mota5;
    private String mota6;
    private String anh;

    public About(String mota1, String mota2, String mota3, String mota4, String mota5, String mota6, String anh) {
        this.mota1 = mota1;
        this.mota2 = mota2;
        this.mota3 = mota3;
        this.mota4 = mota4;
        this.mota5 = mota5;
        this.mota6 = mota6;
        this.anh = anh;
    }

    public About() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMota1() {
        return mota1;
    }

    public void setMota1(String mota1) {
        this.mota1 = mota1;
    }

    public String getMota2() {
        return mota2;
    }

    public void setMota2(String mota2) {
        this.mota2 = mota2;
    }

    public String getMota3() {
        return mota3;
    }

    public void setMota3(String mota3) {
        this.mota3 = mota3;
    }

    public String getMota4() {
        return mota4;
    }

    public void setMota4(String mota4) {
        this.mota4 = mota4;
    }

    public String getMota5() {
        return mota5;
    }

    public void setMota5(String mota5) {
        this.mota5 = mota5;
    }

    public String getMota6() {
        return mota6;
    }

    public void setMota6(String mota6) {
        this.mota6 = mota6;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
}
