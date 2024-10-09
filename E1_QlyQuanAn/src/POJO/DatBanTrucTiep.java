/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author SONDAY
 */


public class DatBanTrucTiep {

    
    private String maDatBan, maBan, ngayDatBan, tenKH;
    private Integer soKhach;

    public DatBanTrucTiep(String maDatBan, String maBan, String ngayDatBan, String tenKH, Integer soKhach) {
        this.maDatBan = maDatBan;
        this.maBan = maBan;
        this.ngayDatBan = ngayDatBan;
        this.tenKH = tenKH;
        this.soKhach = soKhach;
    }

    public DatBanTrucTiep() {
    }

    public String getMaDatBan() {
        return maDatBan;
    }

    public void setMaDatBan(String maDatBan) {
        this.maDatBan = maDatBan;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public String getNgayDatBan() {
        return ngayDatBan;
    }

    public void setNgayDatBan(String ngayDatBan) {
        this.ngayDatBan = ngayDatBan;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public Integer getSoKhach() {
        return soKhach;
    }

    public void setSoKhach(Integer soKhach) {
        this.soKhach = soKhach;
    }

    @Override
    public String toString() {
        return "DatBanTrucTiep{" + "maDatBan=" + maDatBan + ", maBan=" + maBan + ", ngayDatBan=" + ngayDatBan + ", tenKH=" + tenKH + ", soKhach=" + soKhach + '}';
    }

}
