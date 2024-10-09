/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author SONDAY
 */
public class BanAn {

    @Override
    public String toString() {
        return "BanAn{" + "maBan=" + maBan + ", tenBan=" + tenBan + ", trangThai=" + trangThai + ", sucChua=" + sucChua + '}';
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Integer getSucChua() {
        return sucChua;
    }

    public void setSucChua(Integer sucChua) {
        this.sucChua = sucChua;
    }

    public BanAn(String maBan, String tenBan, String trangThai, Integer sucChua) {
        this.maBan = maBan;
        this.tenBan = tenBan;
        this.trangThai = trangThai;
        this.sucChua = sucChua;
    }

    public BanAn() {
    }
    private String maBan, tenBan, trangThai;
    private Integer sucChua;

    
    
    
    
}
