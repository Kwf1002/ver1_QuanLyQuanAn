/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author SON
 */
import POJO.MonAn;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MonAn_DAO {

    public static ArrayList<MonAn> LayThongTinMonAn() {
        ArrayList<MonAn> dsma = new ArrayList<MonAn>();
        try {
            String sql = "SELECT * FROM admin1.MONAN";
            ConnectionDB conn = new ConnectionDB();
            conn.GetConnect();

            ResultSet rs = conn.executeQuery(sql);
            while (rs.next()) {
                String mamonn = rs.getString("MaMon");
                String tenmonn = rs.getString("TenMon");
                Integer giatienn = rs.getInt("GiaTien");

                Connection connection = conn.GetConnect(); // Lấy đối tượng Connection

                MonAn ma = new MonAn(mamonn, tenmonn, giatienn);
                dsma.add(ma);
                System.out.println("Lay du lieu mon an thanh cong!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsma;
    }

    public static int ThemXoaSuaMonAn(String sql) {
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

    public static ArrayList<String> getMaMonList() {
        ArrayList<String> maMonList = new ArrayList<>();
        try {
            String sql = "SELECT DISTINCT MaMon FROM MonAn";
            ConnectionDB conn = new ConnectionDB();
            conn.GetConnect();
            ResultSet rs = conn.executeQuery(sql);
            while (rs.next()) {
                String maMon = rs.getString("MaMon").trim();
                maMonList.add(maMon);
            }
        } catch (Exception e) {
            System.err.println("Không thể lấy dữ liệu mã món" + e.getMessage());
        }
        return maMonList;
    }

//    public ArrayList<MonAn> getDS_MonAn() {
//        ArrayList<MonAn> ds_ma = new ArrayList<MonAn>();
//        try {
//            String sql = "SELECT * FROM MonAn";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                MonAn ma = new MonAn(
//                    rs.getString("MaMon").trim(),
//                    rs.getString("TenMon").trim(),
//                    rs.getInt("GiaTien")
//                );
//
//                ds_ma.add(ma);
//            }
//        } catch (SQLException e) {
//            System.err.println("Không thể lấy dữ liệu món ăn: " + e.getMessage());
//        }
//        return ds_ma;
//    }
//
//    public ArrayList<MonAn> getDSMaMAn() {
//        ArrayList<MonAn> ds_ma = new ArrayList<MonAn>();
//        try {
//            String sql = "SELECT MaMon FROM MonAn";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                MonAn ma = new MonAn(
//                    rs.getString("MaMon").trim(),
//                    rs.getString("TenMon").trim(),
//                    rs.getInt("GiaTien")
//                );
//
//                ds_ma.add(ma);
//            }
//        } catch (SQLException e) {
//            System.err.println("Không thể lấy dữ liệu món ăn: " + e.getMessage());
//        }
//        return ds_ma;
//    }
//
//    public int ThemXoaSuaMonAn(String sql) {
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
//
//    public int ThemMonAnPROC(String sql, ArrayList<Object> a) {
//        int i = 0;
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            // Điền các tham số vào câu lệnh SQL
//            for (int j = 0; j < a.size(); j++) {
//                ps.setObject(j + 1, a.get(j));
//            }
//            i = ps.executeUpdate();
//            System.out.println("Thêm thành công");
//        } catch (SQLException e) {
//            System.out.println("Thêm không thành công: " + e.getMessage());
//        }
//        return i;
//    }
}
