/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author SONDAY
 */
public class HoaDon {

    @Override
    public String toString() {
        return "HoaDon{" + "maHD=" + maHD + ", maDatBan=" + maDatBan + ", maNV=" + maNV + ", ngayLap=" + ngayLap + ", tongTien=" + tongTien + '}';
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaDatBan() {
        return maDatBan;
    }

    public void setMaDatBan(String maDatBan) {
        this.maDatBan = maDatBan;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public Integer getTongTien() {
        return tongTien;
    }

    public void setTongTien(Integer tongTien) {
        this.tongTien = tongTien;
    }

    public HoaDon() {
    }

    public HoaDon(String maHD, String maDatBan, String maNV, String ngayLap, Integer tongTien) {
        this.maHD = maHD;
        this.maDatBan = maDatBan;
        this.maNV = maNV;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
    }

    
    private String maHD, maDatBan, maNV, ngayLap;
    private Integer tongTien;
}
