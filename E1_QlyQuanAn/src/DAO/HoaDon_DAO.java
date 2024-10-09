/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author SONDAY
 */
import java.sql.*;
import java.util.ArrayList;
import POJO.HoaDon;
import POJO.ChiTietHD;
import POJO.MonAn;
import POJO.NuocUong;
import POJO.DatBanTrucTiep;

public class HoaDon_DAO {

    public static ArrayList<HoaDon> LayThongTinHoaDon() {
        ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
        try {
            String sql = "SELECT * FROM admin1.HOADON";
            ConnectionDB conn = new ConnectionDB();
            conn.GetConnect();

            ResultSet rs = conn.executeQuery(sql);
            while (rs.next()) {
                String mahdd = rs.getString("MaHD");
                String madatbann = rs.getString("MaDatBan");
                String manvv = rs.getString("MaNV");
                String ngaylapp = rs.getString("NgayLap");
                Integer tongtienn = rs.getInt("TongTien");

                Connection connection = conn.GetConnect(); // Lấy đối tượng Connection

                HoaDon hd = new HoaDon(mahdd, madatbann, manvv, ngaylapp, tongtienn);
                dshd.add(hd);
                System.out.println("Lay du lieu hoa don thanh cong!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dshd;
    }

    public static int ThemXoaSuaHoaDon(String sql) {
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

    public static ArrayList<String> getMaHDList() {
        ArrayList<String> maHDList = new ArrayList<>();
        try {
            String sql = "SELECT DISTINCT MaHD FROM HoaDon";
            ConnectionDB conn = new ConnectionDB();
            conn.GetConnect();
            ResultSet rs = conn.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString("MaHD").trim();
                maHDList.add(maHD);
            }
        } catch (Exception e) {
            System.err.println("Không thể lấy dữ liệu mã hoá đơn" + e.getMessage());
        }
        return maHDList;
    }

    public static ArrayList<ChiTietHD> LayThongTinCTHD() {
        ArrayList<ChiTietHD> dscthd = new ArrayList<ChiTietHD>();
        try {
            String sql = "SELECT * FROM admin1.CHITIETHOADON";
            ConnectionDB conn = new ConnectionDB();
            conn.GetConnect();

            ResultSet rs = conn.executeQuery(sql);
            while (rs.next()) {
                String macthdd = rs.getString("MaCTHD");
                String mahdd = rs.getString("MaHD");
                String mamonn = rs.getString("MaMon");
                String madouongg = rs.getString("MaDoUong");
                Integer soluongg = rs.getInt("SoLuong");
                Integer thanhtienn = rs.getInt("ThanhTien");

                Connection connection = conn.GetConnect(); // Lấy đối tượng Connection

                ChiTietHD cthd = new ChiTietHD(macthdd, mahdd, mamonn, madouongg, soluongg, thanhtienn);
                dscthd.add(cthd);
                System.out.println("Lay du lieu chi tiet hoa don thanh cong!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dscthd;
    }

    public static int ThemXoaSuaChiTietHD(String sql) {
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

//    public static ArrayList<HoaDon> get_DSHD() {
//        ArrayList<HoaDon> ds_hd = new ArrayList<HoaDon>();
//        try {
//            String sql = "select *from hoadon";
//            ConnectionDB cn = new ConnectionDB();
//            cn.getCn();
//            ResultSet rs = cn.executeQuery(sql);
//            while (rs.next()) {
//                HoaDon hd = new HoaDon(rs.getString("MaHD").trim(), rs.getString("MaDatBan").trim(), rs.getString("MaNV").trim(), rs.getString("NgayLap").trim(), rs.getInt("TongTien"));
//
//                ds_hd.add(hd);
//            }
//            // cn.close();
//        } catch (Exception e) {
//            System.err.println("Không thể lấy dữ liệu hoá đơn" + e.getMessage());
//        }
//
//        return ds_hd;
//    }
//
//    public static ArrayList<HoaDon> get_DSMaHD() {
//        ArrayList<HoaDon> ds_hd = new ArrayList<HoaDon>();
//        try {
//            String sql = "SELECT MaHD FROM HoaDon";
//            ConnectionDB cn = new ConnectionDB();
//            cn.getCn();
//            ResultSet rs = cn.executeQuery(sql);
//            while (rs.next()) {
//                HoaDon hd = new HoaDon(rs.getString("MaHD").trim(), rs.getString("MaDatBan").trim(), rs.getString("MaNV").trim(), rs.getString("NgayLap").trim(), rs.getInt("TongTien"));
//
//                ds_hd.add(hd);
//            }
//            cn.close();
//        } catch (Exception e) {
//            System.err.println("Không thể lấy dữ liệu hoá đơn" + e.getMessage());
//        }
//        return ds_hd;
//    }
//    
//    
//
//    public static int ThemXoaSuaHoaDon(String sql) {
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
//    
//    
//
//    public static int ThemHoaDonPROC(String sql, ArrayList<Object> a) {
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
