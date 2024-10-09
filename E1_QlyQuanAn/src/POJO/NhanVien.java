/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author SONDAY
 */
public class NhanVien {

   

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    public NhanVien() {
    }
    

    public Integer getLuong() {
        return luong;
    }

    public void setLuong(Integer luong) {
        this.luong = luong;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "manv=" + manv + ", tennv=" + tennv + ", gioitinh=" + gioitinh + ", diachi=" + diachi + ", sodt=" + sodt + ", email=" + email + ", luong=" + luong + '}';
    }

    public NhanVien(String manv, String tennv, String gioitinh, String diachi, String sodt, String email, Integer luong) {
        this.manv = manv;
        this.tennv = tennv;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.sodt = sodt;
        this.email = email;
        this.luong = luong;
    }
    
    private String manv, tennv, gioitinh, diachi, sodt, email;
    private Integer luong;
}
