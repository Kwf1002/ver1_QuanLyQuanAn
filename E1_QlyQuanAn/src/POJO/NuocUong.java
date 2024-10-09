/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author SONDAY
 */
public class NuocUong {

    @Override
    public String toString() {
        return "NuocUong{" + "maDoUong=" + maDoUong + ", tenDoUong=" + tenDoUong + ", giaTien=" + giaTien + '}';
    }

    public String getMaDoUong() {
        return maDoUong;
    }

    public void setMaDoUong(String maDoUong) {
        this.maDoUong = maDoUong;
    }

    public String getTenDoUong() {
        return tenDoUong;
    }

    public void setTenDoUong(String tenDoUong) {
        this.tenDoUong = tenDoUong;
    }

    public Integer getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Integer giaTien) {
        this.giaTien = giaTien;
    }

    public NuocUong() {
    }

    public NuocUong(String maDoUong, String tenDoUong, Integer giaTien) {
        this.maDoUong = maDoUong;
        this.tenDoUong = tenDoUong;
        this.giaTien = giaTien;
    }
    private String maDoUong, tenDoUong;
    private Integer giaTien;
}
