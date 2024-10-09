/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author SONDAY
 */
public class MonAn {

    private String maMon, tenMon;
    private Integer giaTien;

    public MonAn() {
    }

    public MonAn(String maMon, String tenMon, int giaTien) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.giaTien = giaTien;
    }

    public String getMaMon() {
        return maMon;
    }

    public String getTenMon() {
        return tenMon;
    }



    public Integer getGiaTien() {
        return giaTien;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }



    public void setGiaTien(Integer giaTien) {
        this.giaTien = giaTien;
    }

    @Override
    public String toString() {
        return "MonAn{" + "maMon=" + maMon + ", tenMon=" + tenMon + ", giaTien=" + giaTien + '}';
    }

}
