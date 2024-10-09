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
import POJO.BanAn;
import POJO.DatBanTrucTiep;

public class BanAn_DAO {

    public static ArrayList<BanAn> LayThongTinBanAn() {
        ArrayList<BanAn> dsba = new ArrayList<BanAn>();
        try {
            String sql = "SELECT * FROM admin1.BANAN";
            ConnectionDB conn = new ConnectionDB();
            conn.GetConnect();

            ResultSet rs = conn.executeQuery(sql);
            while (rs.next()) {
                String mabann = rs.getString("MaBan");
                String tenbann = rs.getString("TenBan");
                String trangthaii = rs.getString("TrangThai");
                Integer succhuaa = rs.getInt("SucChua");

                Connection connection = conn.GetConnect(); // Lấy đối tượng Connection

                BanAn ba = new BanAn(mabann, tenbann, trangthaii, succhuaa);
                dsba.add(ba);
                System.out.println("Lay du lieu ban an thanh cong!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsba;
    }

    public static int ThemXoaSuaBanAn(String sql) {
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

    public static ArrayList<String> getTrangThaiList() {
        ArrayList<String> trangThaiList = new ArrayList<>();
        try {
            String sql = "SELECT DISTINCT TrangThai FROM BanAn";
            ConnectionDB conn = new ConnectionDB();
            conn.GetConnect();
            ResultSet rs = conn.executeQuery(sql);
            while (rs.next()) {
                String trangThai = rs.getString("TrangThai").trim();
                trangThaiList.add(trangThai);
            }
        } catch (Exception e) {
            System.err.println("Không thể lấy dữ liệu trạng thái" + e.getMessage());
        }
        return trangThaiList;
    }

    public static ArrayList<String> getMaBanList() {
        ArrayList<String> maBanList = new ArrayList<>();
        try {
            String sql = "SELECT DISTINCT MaBan FROM DatBanTrucTiep";
            ConnectionDB conn = new ConnectionDB();
            conn.GetConnect();
            ResultSet rs = conn.executeQuery(sql);
            while (rs.next()) {
                String maBan = rs.getString("MaBan").trim();
                maBanList.add(maBan);
            }
        } catch (Exception e) {
            System.err.println("Không thể lấy dữ liệu mã bàn" + e.getMessage());
        }
        return maBanList;
    }

    public static ArrayList<String> getMaDatBanList() {
        ArrayList<String> maDatBanList = new ArrayList<>();
        try {
            String sql = "SELECT DISTINCT MaDatBan FROM DatBanTrucTiep";
            ConnectionDB conn = new ConnectionDB();
            conn.GetConnect();
            ResultSet rs = conn.executeQuery(sql);
            while (rs.next()) {
                String maDatBan = rs.getString("MaDatBan").trim();
                maDatBanList.add(maDatBan);
            }
        } catch (Exception e) {
            System.err.println("Không thể lấy dữ liệu mã đặt bàn" + e.getMessage());
        }
        return maDatBanList;
    }

    public static ArrayList<DatBanTrucTiep> LayThongTinDatBanTrucTiep() {
        ArrayList<DatBanTrucTiep> dsdbtt = new ArrayList<DatBanTrucTiep>();
        try {
            String sql = "SELECT * FROM admin1.DATBANTRUCTIEP";
            ConnectionDB conn = new ConnectionDB();
            conn.GetConnect();

            ResultSet rs = conn.executeQuery(sql);
            while (rs.next()) {
                String madatbann = rs.getString("MaDatBan");
                String mabann = rs.getString("MaBan");
                String ngaydatbann = rs.getString("NgayDatBan");
                String tenkhh = rs.getString("TenKH");
                Integer sokhachh = rs.getInt("SoKhach");

                Connection connection = conn.GetConnect(); // Lấy đối tượng Connection

                DatBanTrucTiep dbtt = new DatBanTrucTiep(madatbann, mabann, ngaydatbann, tenkhh, sokhachh);
                dsdbtt.add(dbtt);
                System.out.println("Lay du lieu dat ban truc tiep thanh cong!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsdbtt;
    }

    public static int ThemXoaSuaDatBanTrucTiep(String sql) {
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

//    public static ArrayList<BanAn> getDS_BanAn() {
//        ArrayList<BanAn> ds_ba = new ArrayList<BanAn>();
//        try {
//            String sql = "select *from banan";
//            ConnectionDB cn = new ConnectionDB();
//            cn.getCn();
//            ResultSet rs = cn.executeQuery(sql);
//            while (rs.next()) {
//                BanAn ba = new BanAn(rs.getString("MaBan").trim(), rs.getString("TenBan").trim(), rs.getString("TrangThai").trim(), rs.getInt("SucChua"));
//
//                ds_ba.add(ba);
//            }
//            // cn.close();
//        } catch (Exception e) {
//            System.err.println("Không thể lấy dữ liệu bàn ăn" + e.getMessage());
//        }
//
//        return ds_ba;
//    }
//
//    public static ArrayList<BanAn> getDS_MaBanAn() {
//        ArrayList<BanAn> ds_ba = new ArrayList<BanAn>();
//        try {
//            String sql = "SELECT MaBan FROM BanAn";
//            ConnectionDB cn = new ConnectionDB();
//            cn.getCn();
//            ResultSet rs = cn.executeQuery(sql);
//            while (rs.next()) {
//                BanAn ba = new BanAn(rs.getString("MaBan").trim(), rs.getString("TenBan").trim(), rs.getString("TrangThai").trim(), rs.getInt("SucChua"));
//
//                ds_ba.add(ba);
//            }
//            cn.close();
//        } catch (Exception e) {
//            System.err.println("Không thể lấy dữ liệu bàn ăn" + e.getMessage());
//        }
//        return ds_ba;
//    }
//
//    public static ArrayList<String> getTrangThaiList() {
//        ArrayList<String> trangThaiList = new ArrayList<>();
//        try {
//            String sql = "SELECT DISTINCT TrangThai FROM BanAn"; 
//            ConnectionDB cn = new ConnectionDB();
//            cn.getCn();
//            ResultSet rs = cn.executeQuery(sql);
//            while (rs.next()) {
//                String trangThai = rs.getString("TrangThai").trim();
//                trangThaiList.add(trangThai);
//            }
//            cn.close();
//        } catch (Exception e) {
//            System.err.println("Không thể lấy dữ liệu trạng thái" + e.getMessage());
//        }
//        return trangThaiList;
//    }
//    
//    public static ArrayList<String> getMaBanList() {
//        ArrayList<String> maBanList = new ArrayList<>();
//        try {
//            String sql = "SELECT DISTINCT MaBan FROM BanAn"; 
//            ConnectionDB cn = new ConnectionDB();
//            cn.getCn();
//            ResultSet rs = cn.executeQuery(sql);
//            while (rs.next()) {
//                String maBan = rs.getString("MaBan").trim();
//                maBanList.add(maBan);
//            }
//            cn.close();
//        } catch (Exception e) {
//            System.err.println("Không thể lấy dữ liệu mã bàn" + e.getMessage());
//        }
//        return maBanList;
//    }
//    
//    
//    
//
//    public static int ThemXoaSuaBanAn(String sql) {
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
//    public static int ThemBanAnPROC(String sql, ArrayList<Object> a) {
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
