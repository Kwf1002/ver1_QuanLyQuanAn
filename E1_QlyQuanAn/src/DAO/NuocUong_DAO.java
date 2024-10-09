/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author SONDAY
 */
import POJO.NuocUong;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NuocUong_DAO {

    public static ArrayList<NuocUong> LayThongTinNuocUong() {
        ArrayList<NuocUong> dsnu = new ArrayList<NuocUong>();
        try {
            String sql = "SELECT * FROM admin1.NUOCUONG";
            ConnectionDB conn = new ConnectionDB();
            conn.GetConnect();

            ResultSet rs = conn.executeQuery(sql);
            while (rs.next()) {
                String madouongg = rs.getString("MaDoUong");
                String tendouongg = rs.getString("TenDoUong");
                Integer giatienn = rs.getInt("GiaTien");

                Connection connection = conn.GetConnect(); // Lấy đối tượng Connection

                NuocUong nu = new NuocUong(madouongg, tendouongg, giatienn);
                dsnu.add(nu);
                System.out.println("Lay du lieu do uong thanh cong!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsnu;
    }

    public static int ThemXoaSuaNuocUong(String sql) {
        int i = 0;
        try {

            ConnectionDB conn = new ConnectionDB();
            conn.GetConnect();
            i = conn.executeUpdate(sql);
            System.out.println("Chức năng thực hiện thành công");
        } catch (Exception e) {
            System.out.println("Chức năng thực hiện thất bại");
        }
        return i;
    }

    public static ArrayList<String> getMaDoUongList() {
        ArrayList<String> maDoUongList = new ArrayList<>();
        try {
            String sql = "SELECT DISTINCT MaDoUong FROM NuocUong";
            ConnectionDB conn = new ConnectionDB();
            conn.GetConnect();
            ResultSet rs = conn.executeQuery(sql);
            while (rs.next()) {
                String maDoUong = rs.getString("MaDoUong").trim();
                maDoUongList.add(maDoUong);
            }
        } catch (Exception e) {
            System.err.println("Không thể lấy dữ liệu mã đồ uống" + e.getMessage());
        }
        return maDoUongList;
    }

//    public static ArrayList<NuocUong> getDS_NuocUong() {
//        ArrayList<NuocUong> ds_nu = new ArrayList<NuocUong>();
//        try {
//            String sql = "select *from nuocuong";
//            ConnectionDB cn = new ConnectionDB();
//            cn.getCn();
//            ResultSet rs = cn.executeQuery(sql);
//            while (rs.next()) {
//                NuocUong nu = new NuocUong(rs.getString("MaDoUong").trim(), rs.getString("TenDoUong").trim(), rs.getInt("GiaTien"));
//
//                ds_nu.add(nu);
//            }
//            // cn.close();
//        } catch (Exception e) {
//            System.err.println("Không thể lấy dữ liệu nước uống" + e.getMessage());
//        }
//
//        return ds_nu;
//    }
//
//    public static ArrayList<NuocUong> getDS_MaNuocUong() {
//        ArrayList<NuocUong> ds_nu = new ArrayList<NuocUong>();
//        try {
//            String sql = "SELECT MaDoUong FROM NuocUong";
//            ConnectionDB cn = new ConnectionDB();
//            cn.getCn();
//            ResultSet rs = cn.executeQuery(sql);
//            while (rs.next()) {
//                NuocUong nu = new NuocUong(rs.getString("MaDoUong").trim(), rs.getString("TenDoUong").trim(), rs.getInt("GiaTien"));
//
//                ds_nu.add(nu);
//            }
//            cn.close();
//        } catch (Exception e) {
//            System.err.println("Không thể lấy dữ liệu nước uống" + e.getMessage());
//        }
//        return ds_nu;
//    }
//
//    public static int ThemXoaSuaNuocUong(String sql) {
//        int i = 0;
//        try {
//            ConnectionDB cn = new ConnectionDB();
//            cn.getCn();
//            i = cn.executeUpdate(sql);
//            cn.close();
//            System.out.println("Thêm/xóa/sửa thành công");
//
//        } catch (Exception e) {
//            System.out.println("Thêm/xóa/sửa không thành công");
//
//        }
//        return i;
//    }
//
//    public static int ThemNuocUongPROC(String sql, ArrayList<Object> a) {
//        int i = 0;
//        try {
//            ConnectionDB cn = new ConnectionDB();
//            cn.getCn();
//            i = cn.executeProc(sql, a);
//            cn.close();
//            System.out.println("Thêm/ thành công");
//
//        } catch (Exception e) {
//            System.out.println("Thêm/ không thành công");
//
//        }
//        return i;
//    }
}
