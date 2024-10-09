/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author SONDAY
 */
public class ChiTietHD {

    @Override
    public String toString() {
        return "ChiTietHD{" + "maCTHD=" + maCTHD + ", maHD=" + maHD + ", maMon=" + maMon + ", maDoUong=" + maDoUong + ", soLuong=" + soLuong + ", ThanhTien=" + ThanhTien + '}';
    }

    public String getMaCTHD() {
        return maCTHD;
    }

    public void setMaCTHD(String maCTHD) {
        this.maCTHD = maCTHD;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getMaDoUong() {
        return maDoUong;
    }

    public void setMaDoUong(String maDoUong) {
        this.maDoUong = maDoUong;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(Integer ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public ChiTietHD(String maCTHD, String maHD, String maMon, String maDoUong, Integer soLuong, Integer ThanhTien) {
        this.maCTHD = maCTHD;
        this.maHD = maHD;
        this.maMon = maMon;
        this.maDoUong = maDoUong;
        this.soLuong = soLuong;
        this.ThanhTien = ThanhTien;
    }

    public ChiTietHD() {
    }
    private String maCTHD, maHD, maMon, maDoUong;
    private Integer soLuong, ThanhTien;
}
