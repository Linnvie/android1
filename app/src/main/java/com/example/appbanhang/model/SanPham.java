package com.example.appbanhang.model;

import java.io.Serializable;

public class SanPham implements Serializable {
    public int id;
    public String tenSP;
    public Integer giaSP;
    public Integer giaSale;
    public String hinhAnhSP;
    public String moTaSP;
    public String star1, star2, star3, star4, star5;
    public String heart;
    public int idLSP;
    public SanPham() {
    }

    public SanPham(int id, String tenSP, Integer giaSP, Integer giaSale, String hinhAnhSP, String moTaSP,
                   String star1, String star2, String star3, String star4, String star5, String heart, int idLSP) {
        this.id = id;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.giaSale = giaSale;
        this.hinhAnhSP = hinhAnhSP;
        this.moTaSP = moTaSP;
        this.star1 = star1;
        this.star2 = star2;
        this.star3 = star3;
        this.star4 = star4;
        this.star5 = star5;
        this.heart = heart;
        this.idLSP = idLSP;
    }

    public int getId() {
        return id;
    }
    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Integer getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(Integer giaSP) {
        this.giaSP = giaSP;
    }

    public Integer getGiaSale() {
        return giaSale;
    }

    public void setGiaSale(Integer giaSale) {
        this.giaSale = giaSale;
    }

    public String getHinhAnhSP() {
        return hinhAnhSP;
    }

    public void setHinhAnhSP(String hinhAnhSP) {
        this.hinhAnhSP = hinhAnhSP;
    }

    public String getMoTaSP() {
        return moTaSP;
    }

    public void setMoTaSP(String moTaSP) {
        this.moTaSP = moTaSP;
    }

    public String getStar1() {
        return star1;
    }

    public void setStar1(String star1) {
        this.star1 = star1;
    }

    public String getStar2() {
        return star2;
    }

    public void setStar2(String star2) {
        this.star2 = star2;
    }

    public String getStar3() {
        return star3;
    }

    public void setStar3(String star3) {
        this.star3 = star3;
    }

    public String getStar4() {
        return star4;
    }

    public void setStar4(String star4) {
        this.star4 = star4;
    }

    public String getStar5() {
        return star5;
    }

    public void setStar5(String star5) {
        this.star5 = star5;
    }

    public String getHeart() {
        return heart;
    }

    public void setHeart(String heart) {
        this.heart = heart;
    }

    public int getIdLSP() {
        return idLSP;
    }

    public void setIdLSP(int idLSP) {
        this.idLSP = idLSP;
    }
}
