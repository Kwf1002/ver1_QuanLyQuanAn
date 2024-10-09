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
import POJO.NhanVien;
import POJO.DBA_SYS_PRIVS;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import java.sql.PreparedStatement;


public class NhanVien_DAO {

    public static ArrayList<NhanVien> LayThongTinNhanVien() {
        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
        try {
            String sql = "SELECT * FROM admin1.NHANVIEN";
            ConnectionDB conn = new ConnectionDB();
            conn.GetConnect();

            ResultSet rs = conn.executeQuery(sql);
            while (rs.next()) {
                String manvv = rs.getString("MaNV");
                String tennvv = rs.getString("TenNV");
                String gtt = rs.getString("GioiTinh");
                String dc = rs.getString("DiaChi");
                String sdt = rs.getString("SoDT");
                String emaill = rs.getString("Email");
                Integer luongg = rs.getInt("Luong");

                Connection connection = conn.GetConnect(); // Lấy đối tượng Connection

                NhanVien nv = new NhanVien(manvv, tennvv, gtt, dc, sdt, emaill, luongg);
                dsnv.add(nv);
                System.out.println("Lay du lieu nhan vien thanh cong!");
            }
        } catch (Exception e) {
            //System.err.println("Lay du lieu nhan vien that bai!");
            e.printStackTrace();
        }
        return dsnv;
    }

    public static ArrayList<DBA_SYS_PRIVS> LayThongTinNhanVien2() {
        ArrayList<DBA_SYS_PRIVS> dsp = new ArrayList<DBA_SYS_PRIVS>();
        try {
            String sql = "SELECT * FROM sys.DBA_SYS_PRIVS";
            ConnectionDB conn = new ConnectionDB();
            conn.GetConnect();
            ResultSet rs = conn.executeQuery(sql);
            while (rs.next()) {
                String GRANTEE = rs.getString("GRANTEE");
                String PRIVILEGE = rs.getString("PRIVILEGE");
                String ADMIN_OPTION = rs.getString("ADMIN_OPTION");
                String COMMON = rs.getString("COMMON");

                DBA_SYS_PRIVS ds = new DBA_SYS_PRIVS(GRANTEE, PRIVILEGE, ADMIN_OPTION, COMMON);
                dsp.add(ds);
                System.out.println("Lay du lieu nhan vien thanh cong!");
            }
        } catch (Exception e) {
            //System.err.println("Lay du lieu nhan vien that bai!");
            e.printStackTrace();
        }
        return dsp;
    }

    public static int ThemXoaSuaNhanVien(String sql) {
        int i = 0;
        try {

            ConnectionDB conn = new ConnectionDB();
            conn.GetConnect();
            i = conn.executeUpdate(sql);
//            conn.close();
            System.out.println("Chức năng thực hiện thành công");
        } catch (Exception e) {
            System.out.println("Chức năng thực hiện thất bại");
        }
        return i;
    }

    public static ArrayList<String> getMaNVList() {
        ArrayList<String> maNVList = new ArrayList<>();
        try {
            String sql = "SELECT DISTINCT MaNV FROM NhanVien";
            ConnectionDB conn = new ConnectionDB();
            conn.GetConnect();
            ResultSet rs = conn.executeQuery(sql);
            while (rs.next()) {
                String maNV = rs.getString("MaNV").trim();
                maNVList.add(maNV);
            }
        } catch (Exception e) {
            System.err.println("Không thể lấy dữ liệu mã nhân viên" + e.getMessage());
        }
        return maNVList;
    }

//    public ArrayList<String> getMaNVList() {
//        ArrayList<String> maNVList = new ArrayList<>();
//        try {
//            String sql = "SELECT DISTINCT MaNV FROM NhanVien";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                String maNV = rs.getString("MaNV").trim();
//                maNVList.add(maNV);
//            }
//        } catch (SQLException e) {
//            System.err.println("Không thể lấy dữ liệu mã nhân viên: " + e.getMessage());
//        }
//        return maNVList;
//    }
//
//    public int ThemXoaSuaNhanVien(String sql) {
//        int i = 0;
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            i = ps.executeUpdate();
//            System.out.println("Thêm/xóa/sửa thành công");
//        } catch (SQLException e) {
//            System.out.println("Thêm/xóa/sửa không thành công: " + e.getMessage());
//        }
//        return i;
//    }
}
