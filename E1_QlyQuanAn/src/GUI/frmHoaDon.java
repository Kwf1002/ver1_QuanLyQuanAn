/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

/**
 *
 * @author SONDAY
 */
//import DAO.ConnectionDB;
//import DAO.BanAn_DAO;
//import DAO.MonAn_DAO;
//import DAO.NuocUong_DAO;
//import DAO.NhanVien_DAO;
//import DAO.HoaDon_DAO;
import DAO.*;
import POJO.*;

import java.awt.Color;
import java.awt.Component;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import javax.swing.table.DefaultTableModel;

public class frmHoaDon extends javax.swing.JFrame {

    Vector tblData_HoaDon = new Vector();
    Vector tblTitle_HoaDon = new Vector();
    DefaultTableModel tblModel_HoaDon;

    Vector tblData_ChiTietHD = new Vector();
    Vector tblTitle_ChiTietHD = new Vector();
    DefaultTableModel tblModel_ChiTietHD;

    Vector tblData_MonAn = new Vector();
    Vector tblTitle_MonAn = new Vector();
    DefaultTableModel tblModel_MonAn;

    Vector tblData_NuocUong = new Vector();
    Vector tblTitle_NuocUong = new Vector();
    DefaultTableModel tblModel_NuocUong;

    Vector tblData_DatBanTrucTiep = new Vector();
    Vector tblTitle_DatBanTrucTiep = new Vector();
    DefaultTableModel tblModel_DatBanTrucTiep;

    static ArrayList<HoaDon> dshd = HoaDon_DAO.LayThongTinHoaDon();
    static ArrayList<ChiTietHD> dscthd = HoaDon_DAO.LayThongTinCTHD();
    static ArrayList<MonAn> dsma = MonAn_DAO.LayThongTinMonAn();
    static ArrayList<NuocUong> dsnu = NuocUong_DAO.LayThongTinNuocUong();
    static ArrayList<DatBanTrucTiep> dsdbtt = BanAn_DAO.LayThongTinDatBanTrucTiep();

    private frmDanhMucChucNang frmMenu;

    public frmHoaDon() {
        initComponents();
        this.setLocationRelativeTo(null);
        setTitle("Pay a bill Manager");
        hienthi_hoadon();
        laydulieu_hoadon(dshd);

        // Tạo mô hình cho cboMaMon
        DefaultComboBoxModel<String> modelMaMon = new DefaultComboBoxModel<>();
        addNullItemToComboBox(modelMaMon);

        // Tạo mô hình cho cboMaDoUong
        DefaultComboBoxModel<String> modelMaDoUong = new DefaultComboBoxModel<>();
        addNullItemToComboBox(modelMaDoUong);

        ArrayList<String> maDatBanList = BanAn_DAO.getMaDatBanList();
        DefaultComboBoxModel<String> model_MaDatBanList = new DefaultComboBoxModel<>(maDatBanList.toArray(new String[0]));
        cbmMaDatBan.setModel(model_MaDatBanList);

        ArrayList<String> maNVList = NhanVien_DAO.getMaNVList();
        DefaultComboBoxModel<String> model_MaNVList = new DefaultComboBoxModel<>(maNVList.toArray(new String[0]));
        cbmMaNV.setModel(model_MaNVList);

        hienthi_chitiethoadon();
        laydulieu_chitiethoadon(dscthd);

        ArrayList<String> maHDList = HoaDon_DAO.getMaHDList();
        DefaultComboBoxModel<String> model_MaHDList = new DefaultComboBoxModel<>(maHDList.toArray(new String[0]));
        cbmMaHD.setModel(model_MaHDList);

        ArrayList<String> maMonAnList = MonAn_DAO.getMaMonList();
        DefaultComboBoxModel<String> model_MaMonAnList = new DefaultComboBoxModel<>(maMonAnList.toArray(new String[0]));
        cbmMaMon.setModel(model_MaMonAnList);
        for (String maMonAn : maMonAnList) {
            modelMaMon.addElement(maMonAn);
        }
        setComboBoxModel(cbmMaMon, modelMaMon);

//        ArrayList<String> add_maMonAnList = MonAn_DAO.getMaMonList();
//        // Thêm một phần tử null vào danh sách
//        add_maMonAnList.add(0, "null");
//        DefaultComboBoxModel<String> model_add_MaMonAnList = new DefaultComboBoxModel<>(add_maMonAnList.toArray(new String[0]));
//        cbmMaMon.setModel(model_add_MaMonAnList);
        ArrayList<String> maNuocUongList = NuocUong_DAO.getMaDoUongList();
        DefaultComboBoxModel<String> model_MaNuocUongList = new DefaultComboBoxModel<>(maNuocUongList.toArray(new String[0]));
        cbmMaDoUong.setModel(model_MaNuocUongList);
        for (String maDoUong : maNuocUongList) {
            modelMaDoUong.addElement(maDoUong);
        }
        setComboBoxModel(cbmMaDoUong, modelMaDoUong);

//        ArrayList<String> add_maNuocUongAnList = MonAn_DAO.getMaMonList();
//        // Thêm một phần tử null vào danh sách
//        add_maNuocUongAnList.add(0, "null");
//        DefaultComboBoxModel<String> model_add_MaNuocUongList = new DefaultComboBoxModel<>(add_maNuocUongAnList.toArray(new String[0]));
//        cbmMaDoUong.setModel(model_add_MaNuocUongList);
        hienthi_monan();
        laydulieu_monan(dsma);

        hienthi_nuocuong();
        laydulieu_nuocuong(dsnu);

        hienthi_datbantructiep();
        laydulieu_datbantructiep(dsdbtt);

    }

    public void hienthi_hoadon() {
        tblTitle_HoaDon.add("MAHD");
        tblTitle_HoaDon.add("MADATBAN");
        tblTitle_HoaDon.add("MANV");
        tblTitle_HoaDon.add("NGAYLAP");
        tblTitle_HoaDon.add("TONGTIEN");
    }

    public void laydulieu_hoadon(ArrayList<HoaDon> dshd) {
        tblData_HoaDon.removeAllElements();
        for (HoaDon b : dshd) {
            Vector v = new Vector();
            v.add(b.getMaHD());
            v.add(b.getMaDatBan());
            v.add(b.getMaNV());
            v.add(b.getNgayLap());
            v.add(b.getTongTien());
            tblData_HoaDon.add(v);
        }
        table_hoadon.setModel(new DefaultTableModel(tblData_HoaDon, tblTitle_HoaDon));
    }

    public void hienthi_chitiethoadon() {
        tblTitle_ChiTietHD.add("MACTHD");
        tblTitle_ChiTietHD.add("MAHD");
        tblTitle_ChiTietHD.add("MAMON");
        tblTitle_ChiTietHD.add("MADOUONG");
        tblTitle_ChiTietHD.add("SOLUONG");
        tblTitle_ChiTietHD.add("THANHTIEN");
    }

    public void laydulieu_chitiethoadon(ArrayList<ChiTietHD> dscthd) {
        tblData_ChiTietHD.removeAllElements();
        for (ChiTietHD b : dscthd) {
            Vector v = new Vector();
            v.add(b.getMaCTHD());
            v.add(b.getMaHD());
            v.add(b.getMaMon());
            v.add(b.getMaDoUong());
            v.add(b.getSoLuong());
            v.add(b.getThanhTien());
            tblData_ChiTietHD.add(v);
        }
        table_cthd.setModel(new DefaultTableModel(tblData_ChiTietHD, tblTitle_ChiTietHD));
    }

    public void hienthi_monan() {
        tblTitle_MonAn.add("MAMON");
        tblTitle_MonAn.add("TENMON");
        tblTitle_MonAn.add("GIATIEN");

    }

    public void laydulieu_monan(ArrayList<MonAn> dsma) {
        tblData_MonAn.removeAllElements();
        for (MonAn b : dsma) {
            Vector v = new Vector();
            v.add(b.getMaMon());
            v.add(b.getTenMon());
            v.add(b.getGiaTien());

            tblData_MonAn.add(v);
        }
        table_monan.setModel(new DefaultTableModel(tblData_MonAn, tblTitle_MonAn));
    }

    public void hienthi_nuocuong() {
        tblTitle_NuocUong.add("MADOUONG");
        tblTitle_NuocUong.add("TENDOUONG");
        tblTitle_NuocUong.add("GIATIEN");

    }

    public void laydulieu_nuocuong(ArrayList<NuocUong> dsnu) {
        tblData_NuocUong.removeAllElements();
        for (NuocUong b : dsnu) {
            Vector v = new Vector();
            v.add(b.getMaDoUong());
            v.add(b.getTenDoUong());
            v.add(b.getGiaTien());

            tblData_NuocUong.add(v);
        }
        table_douong.setModel(new DefaultTableModel(tblData_NuocUong, tblTitle_NuocUong));
    }

    public void hienthi_datbantructiep() {
        tblTitle_DatBanTrucTiep.add("MADATBAN");
        tblTitle_DatBanTrucTiep.add("MABAN");
        tblTitle_DatBanTrucTiep.add("NGAYDATBAN");
        tblTitle_DatBanTrucTiep.add("TENKH");
        tblTitle_DatBanTrucTiep.add("SOKHACH");

    }

    public void laydulieu_datbantructiep(ArrayList<DatBanTrucTiep> dsdbtt) {
        tblData_DatBanTrucTiep.removeAllElements();
        for (DatBanTrucTiep b : dsdbtt) {
            Vector v = new Vector();
            v.add(b.getMaDatBan());
            v.add(b.getMaBan());
            v.add(b.getNgayDatBan());
            v.add(b.getTenKH());
            v.add(b.getSoKhach());
            tblData_DatBanTrucTiep.add(v);
        }
        table_datban.setModel(new DefaultTableModel(tblData_DatBanTrucTiep, tblTitle_DatBanTrucTiep));
    }

    private void addNullItemToComboBox(DefaultComboBoxModel<String> model) {
        model.addElement(null); // hoặc model.addElement("Giá trị Mặc định");
    }

// Hàm để thiết lập mô hình cho JComboBox
    private void setComboBoxModel(JComboBox<String> comboBox, DefaultComboBoxModel<String> model) {
        comboBox.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnThemHD = new javax.swing.JButton();
        btnXoaHD = new javax.swing.JButton();
        btnSuaHD = new javax.swing.JButton();
        btnRefreshHD = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_hoadon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNgayLap = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        cbmMaNV = new javax.swing.JComboBox<>();
        cbmMaDatBan = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_datban = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_monan = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_douong = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_cthd = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtMaCTHD = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        cbmMaMon = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        cbmMaHD = new javax.swing.JComboBox<>();
        cbmMaDoUong = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        btnThemCTHD = new javax.swing.JButton();
        btnXoaCTHD = new javax.swing.JButton();
        btnSuaCTHD = new javax.swing.JButton();
        btnBackMenu = new javax.swing.JButton();
        btnRefreshCTHD = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("QUẢN LÝ HOÁ ĐƠN");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(0, 0, 204));

        btnThemHD.setBackground(new java.awt.Color(0, 204, 0));
        btnThemHD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThemHD.setText("Thêm");
        btnThemHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHDActionPerformed(evt);
            }
        });

        btnXoaHD.setBackground(new java.awt.Color(0, 204, 0));
        btnXoaHD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXoaHD.setText("Xóa");

        btnSuaHD.setBackground(new java.awt.Color(0, 204, 0));
        btnSuaHD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSuaHD.setText("Sửa");

        btnRefreshHD.setBackground(new java.awt.Color(51, 102, 255));
        btnRefreshHD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRefreshHD.setForeground(new java.awt.Color(255, 255, 51));
        btnRefreshHD.setText("Refresh");
        btnRefreshHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnRefreshHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(btnThemHD)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnXoaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnSuaHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSuaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRefreshHD, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bảng Hoá đơn:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16), new java.awt.Color(0, 0, 204))); // NOI18N

        table_hoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_hoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_hoadonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_hoadon);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Mã HD");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Mã Đặt Bàn");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Mã NV");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Ngày Lập");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Tổng Tiền");

        cbmMaNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbmMaDatBan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbmMaNV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNgayLap)
                    .addComponent(txtMaHD)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbmMaDatBan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbmMaDatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbmMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đặt bàn trực tiếp:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16), new java.awt.Color(0, 0, 204))); // NOI18N

        table_datban.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(table_datban);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đồ ăn:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16), new java.awt.Color(0, 0, 204))); // NOI18N

        table_monan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(table_monan);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đồ uống:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16), new java.awt.Color(0, 0, 204))); // NOI18N

        table_douong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(table_douong);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bảng CTHD:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16), new java.awt.Color(0, 0, 204))); // NOI18N

        table_cthd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_cthd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_cthdMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(table_cthd);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Mã CTHD");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Mã HD");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Mã Món");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Mã Đồ Uống");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Số Lượng");

        cbmMaMon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Thành Tiền");

        cbmMaHD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbmMaDoUong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbmMaMon, javax.swing.GroupLayout.Alignment.TRAILING, 0, 124, Short.MAX_VALUE)
                        .addComponent(txtMaCTHD, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cbmMaHD, javax.swing.GroupLayout.Alignment.TRAILING, 0, 124, Short.MAX_VALUE)
                        .addComponent(cbmMaDoUong, javax.swing.GroupLayout.Alignment.TRAILING, 0, 124, Short.MAX_VALUE)))
                .addGap(11, 11, 11))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMaCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbmMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbmMaMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(cbmMaDoUong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanel6.setForeground(new java.awt.Color(0, 0, 204));

        btnThemCTHD.setBackground(new java.awt.Color(0, 204, 0));
        btnThemCTHD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThemCTHD.setText("Thêm");
        btnThemCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCTHDActionPerformed(evt);
            }
        });

        btnXoaCTHD.setBackground(new java.awt.Color(0, 204, 0));
        btnXoaCTHD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXoaCTHD.setText("Xóa");

        btnSuaCTHD.setBackground(new java.awt.Color(0, 204, 0));
        btnSuaCTHD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSuaCTHD.setText("Sửa");

        btnBackMenu.setBackground(new java.awt.Color(51, 102, 255));
        btnBackMenu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBackMenu.setForeground(new java.awt.Color(255, 255, 51));
        btnBackMenu.setText("Back");
        btnBackMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackMenuActionPerformed(evt);
            }
        });

        btnRefreshCTHD.setBackground(new java.awt.Color(51, 102, 255));
        btnRefreshCTHD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRefreshCTHD.setForeground(new java.awt.Color(255, 255, 51));
        btnRefreshCTHD.setText("Refresh");
        btnRefreshCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshCTHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThemCTHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSuaCTHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBackMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaCTHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnRefreshCTHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBackMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btnRefreshCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(558, 558, 558)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHDActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnThemHDActionPerformed

    private void table_hoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_hoadonMouseClicked
        // TODO add your handling code here:
        // Lấy dòng (row) được chọn bằng cách sử dụng phương thức getSelectedRow
        int selectedRow = table_hoadon.getSelectedRow();

        if (selectedRow != -1) {
            // Lấy dữ liệu từ hàng được chọn trong bảng hoadon
            String maHD = (String) table_hoadon.getValueAt(selectedRow, 0);
            String maDatBan = (String) table_hoadon.getValueAt(selectedRow, 1);
            String maNV = (String) table_hoadon.getValueAt(selectedRow, 2);
            String ngayLap = (String) table_hoadon.getValueAt(selectedRow, 3);
            String tongTien = table_hoadon.getValueAt(selectedRow, 4).toString();

            // Hiển thị thông tin hoặc thực hiện các hành động khác ở đây
            // Ví dụ: hiển thị thông tin trong các JTextField
            txtMaHD.setText(maHD);
            cbmMaDatBan.setSelectedItem(maDatBan);
            cbmMaNV.setSelectedItem(maNV);
            txtNgayLap.setText(ngayLap);
            txtTongTien.setText(tongTien);
        }
    }//GEN-LAST:event_table_hoadonMouseClicked

    private void table_cthdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_cthdMouseClicked
        // TODO add your handling code here:
        // Lấy dòng (row) được chọn bằng cách sử dụng phương thức getSelectedRow
        int selectedRow = table_cthd.getSelectedRow();

        if (selectedRow != -1) {
            // Lấy dữ liệu từ hàng được chọn trong bảng cthd
            String maCTHD = (String) table_cthd.getValueAt(selectedRow, 0);
            String maHD = (String) table_cthd.getValueAt(selectedRow, 1);
            String maMon = (String) table_cthd.getValueAt(selectedRow, 2);
            String maDoUong = (String) table_cthd.getValueAt(selectedRow, 3);
            String soLuong = table_cthd.getValueAt(selectedRow, 4).toString();
            String thanhTien = table_cthd.getValueAt(selectedRow, 5).toString();

            // Hiển thị thông tin hoặc thực hiện các hành động khác ở đây
            // Ví dụ: hiển thị thông tin trong các JTextField hoặc JComboBox
            txtMaCTHD.setText(maCTHD);
            cbmMaHD.setSelectedItem(maHD);
            cbmMaMon.setSelectedItem(maMon);
            cbmMaDoUong.setSelectedItem(maDoUong);
            txtSoLuong.setText(soLuong);
            txtThanhTien.setText(thanhTien);
        }
    }//GEN-LAST:event_table_cthdMouseClicked

    private void btnThemCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCTHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemCTHDActionPerformed

    private void btnBackMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackMenuActionPerformed
        // TODO add your handling code here:
        frmMenu = new frmDanhMucChucNang();
        frmMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackMenuActionPerformed

    private void btnRefreshHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshHDActionPerformed
        // TODO add your handling code here:
        ArrayList<HoaDon> newDshd = HoaDon_DAO.LayThongTinHoaDon();

        // Xoá nội dung của các JTextField
        txtMaHD.setText("");
        cbmMaDatBan.setSelectedIndex(0);
        cbmMaNV.setSelectedIndex(0);
        txtNgayLap.setText("");
        txtTongTien.setText("");

        // Cập nhật danh sách hóa đơn
        dshd.clear();
        dshd.addAll(newDshd);

        // Làm mới bảng hiển thị
        laydulieu_hoadon(dshd);

        // Hiển thị thông báo cho người dùng
        JOptionPane.showMessageDialog(this, "Danh sách hóa đơn và các trường đã được làm mới !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btnRefreshHDActionPerformed

    private void btnRefreshCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshCTHDActionPerformed
        // TODO add your handling code here:
        ArrayList<ChiTietHD> newDscthd = HoaDon_DAO.LayThongTinCTHD();

        // Xoá nội dung của các JTextField
        txtMaCTHD.setText("");
        cbmMaHD.setSelectedIndex(0);
        cbmMaMon.setSelectedIndex(0);
        cbmMaDoUong.setSelectedIndex(0);
        txtSoLuong.setText("");
        txtThanhTien.setText("");

        // Cập nhật danh sách chi tiết hóa đơn
        dscthd.clear();
        dscthd.addAll(newDscthd);

        // Làm mới bảng hiển thị
        laydulieu_chitiethoadon(dscthd);

        // Hiển thị thông báo cho người dùng
        JOptionPane.showMessageDialog(this, "Danh sách chi tiết hóa đơn và các trường đã được làm mới !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btnRefreshCTHDActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackMenu;
    private javax.swing.JButton btnRefreshCTHD;
    private javax.swing.JButton btnRefreshHD;
    private javax.swing.JButton btnSuaCTHD;
    private javax.swing.JButton btnSuaHD;
    private javax.swing.JButton btnThemCTHD;
    private javax.swing.JButton btnThemHD;
    private javax.swing.JButton btnXoaCTHD;
    private javax.swing.JButton btnXoaHD;
    private javax.swing.JComboBox<String> cbmMaDatBan;
    private javax.swing.JComboBox<String> cbmMaDoUong;
    private javax.swing.JComboBox<String> cbmMaHD;
    private javax.swing.JComboBox<String> cbmMaMon;
    private javax.swing.JComboBox<String> cbmMaNV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable table_cthd;
    private javax.swing.JTable table_datban;
    private javax.swing.JTable table_douong;
    private javax.swing.JTable table_hoadon;
    private javax.swing.JTable table_monan;
    private javax.swing.JTextField txtMaCTHD;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayLap;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
