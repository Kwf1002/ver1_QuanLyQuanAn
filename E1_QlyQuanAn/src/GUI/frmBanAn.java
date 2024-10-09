/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

/**
 *
 * @author SONDAY
 */
import DAO.ConnectionDB;
import DAO.BanAn_DAO;
import POJO.BanAn;
import POJO.DatBanTrucTiep;

import java.awt.Color;
import java.awt.Component;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import javax.swing.table.DefaultTableModel;

public class frmBanAn extends javax.swing.JFrame {

    /**
     * Creates new form frmBanAn
     */
    Vector tblData_BanAn = new Vector();
    Vector tblTitle_BanAn = new Vector();
    DefaultTableModel tblModel_BanAn;

    Vector tblData_DatBanTrucTiep = new Vector();
    Vector tblTitle_DatBanTrucTiep = new Vector();
    DefaultTableModel tblModel_DatBanTrucTiep;

    static ArrayList<BanAn> dsba = BanAn_DAO.LayThongTinBanAn();
    static ArrayList<DatBanTrucTiep> dsdtbb = BanAn_DAO.LayThongTinDatBanTrucTiep();
    private frmDanhMucChucNang frmMenu;

    public frmBanAn() {
        initComponents();
        this.setLocationRelativeTo(null);
        setTitle("Reservation Manager");
        hienthi_banan();
        laydulieu_banan(dsba);

        ArrayList<String> trangThaiList = BanAn_DAO.getTrangThaiList();
        DefaultComboBoxModel<String> model_TrangThaiList = new DefaultComboBoxModel<>(trangThaiList.toArray(new String[0]));
        cbmTrangThai.setModel(model_TrangThaiList);

        hienthi_datbantructiep();
        laydulieu_datbantructiep(dsdtbb);

        ArrayList<String> maBanList = BanAn_DAO.getMaBanList();
        DefaultComboBoxModel<String> model_MaBanList = new DefaultComboBoxModel<>(maBanList.toArray(new String[0]));
        cbmMaBan.setModel(model_MaBanList);
    }

    public void hienthi_banan() {
        tblTitle_BanAn.add("MABAN");
        tblTitle_BanAn.add("TENBAN");
        tblTitle_BanAn.add("TRANGTHAI");
        tblTitle_BanAn.add("SUCCHUA");

    }

    public void laydulieu_banan(ArrayList<BanAn> dsba) {
        tblData_BanAn.removeAllElements();
        for (BanAn b : dsba) {
            Vector v = new Vector();
            v.add(b.getMaBan());
            v.add(b.getTenBan());
            v.add(b.getTrangThai());
            v.add(b.getSucChua());
            tblData_BanAn.add(v);
        }
        table_ban.setModel(new DefaultTableModel(tblData_BanAn, tblTitle_BanAn));

        // Thiết lập renderer cho cột trạng thái để tô màu nền
        TableColumn trangThaiColumn = table_ban.getColumnModel().getColumn(2);
        trangThaiColumn.setCellRenderer(new CustomCellRenderer(table_ban));

        table_ban.updateUI();
    }

    public class CustomCellRenderer extends DefaultTableCellRenderer {

        private final JTable table;

        public CustomCellRenderer(JTable table) {
            this.table = table;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            String trangThai = (String) value;
            if ("Trong".equals(trangThai)) {
                component.setBackground(Color.GREEN);
            } else {
                if (isSelected && table.isCellSelected(row, column)) {
                    component.setBackground(table.getSelectionBackground());
                } else {
                    component.setBackground(table.getBackground());
                }
            }

            return component;
        }
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
        btnThemBA = new javax.swing.JButton();
        btnXoaBA = new javax.swing.JButton();
        btnSuaBA = new javax.swing.JButton();
        btnRefreshBanAn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_ban = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtMaBan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenBan = new javax.swing.JTextField();
        txtSucChua = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbmTrangThai = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_datban = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtMaDatBan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNgayDatBan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        txtSoKhach = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbmMaBan = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        btnThemDB = new javax.swing.JButton();
        btnXoaDB = new javax.swing.JButton();
        btnSuaDB = new javax.swing.JButton();
        btnRefreshDatBan = new javax.swing.JButton();
        btnBackMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("QUẢN LÝ BÀN & ĐẶT BÀN");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(0, 0, 204));

        btnThemBA.setBackground(new java.awt.Color(0, 204, 0));
        btnThemBA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThemBA.setText("Thêm");

        btnXoaBA.setBackground(new java.awt.Color(0, 204, 0));
        btnXoaBA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXoaBA.setText("Xóa");

        btnSuaBA.setBackground(new java.awt.Color(0, 204, 0));
        btnSuaBA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSuaBA.setText("Sửa");

        btnRefreshBanAn.setBackground(new java.awt.Color(51, 102, 255));
        btnRefreshBanAn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRefreshBanAn.setForeground(new java.awt.Color(255, 255, 51));
        btnRefreshBanAn.setText("Refresh");
        btnRefreshBanAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshBanAnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnThemBA, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaBA, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnSuaBA, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRefreshBanAn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemBA, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaBA, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaBA, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btnRefreshBanAn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bảng Bàn:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16), new java.awt.Color(0, 0, 204))); // NOI18N

        table_ban.setModel(new javax.swing.table.DefaultTableModel(
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
        table_ban.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_banMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_ban);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Mã Bàn");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Tên Bàn");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Sức Chứa");

        cbmTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Trạng Thái");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSucChua)
                    .addComponent(txtTenBan, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMaBan, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbmTrangThai, 0, 139, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTenBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSucChua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbmTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(0, 46, Short.MAX_VALUE)))
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
        table_datban.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_datbanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_datban);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Mã Đặt Bàn");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Mã Bàn");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Ngày Đặt Bàn");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Tên KH");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Số Khách");

        cbmMaBan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(49, 49, 49)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSoKhach, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(txtNgayDatBan)
                    .addComponent(txtMaDatBan, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTenKH)
                    .addComponent(cbmMaBan, 0, 139, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMaDatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(cbmMaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtNgayDatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtSoKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanel6.setForeground(new java.awt.Color(0, 0, 204));

        btnThemDB.setBackground(new java.awt.Color(0, 204, 0));
        btnThemDB.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThemDB.setText("Thêm");
        btnThemDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDBActionPerformed(evt);
            }
        });

        btnXoaDB.setBackground(new java.awt.Color(0, 204, 0));
        btnXoaDB.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXoaDB.setText("Xóa");

        btnSuaDB.setBackground(new java.awt.Color(0, 204, 0));
        btnSuaDB.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSuaDB.setText("Sửa");

        btnRefreshDatBan.setBackground(new java.awt.Color(51, 102, 255));
        btnRefreshDatBan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRefreshDatBan.setForeground(new java.awt.Color(255, 255, 51));
        btnRefreshDatBan.setText("Refresh");
        btnRefreshDatBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshDatBanActionPerformed(evt);
            }
        });

        btnBackMenu.setBackground(new java.awt.Color(51, 102, 255));
        btnBackMenu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBackMenu.setForeground(new java.awt.Color(255, 255, 51));
        btnBackMenu.setText("Back");
        btnBackMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRefreshDatBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(btnThemDB, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoaDB, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSuaDB, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBackMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemDB, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaDB, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaDB, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btnRefreshDatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBackMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(34, 34, 34)))
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGap(535, 535, 535)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDBActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnThemDBActionPerformed

    private void btnRefreshBanAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshBanAnActionPerformed
        // TODO add your handling code here:
        ArrayList<BanAn> newDsba = BanAn_DAO.LayThongTinBanAn();

        // Xoá nội dung của các JTextField
        txtMaBan.setText("");
        txtTenBan.setText("");
        txtSucChua.setText("");

        // Xóa dữ liệu trong JComboBox
        cbmTrangThai.setSelectedIndex(0);

        // Cập nhật danh sách bàn ăn
        dsba.clear();
        dsba.addAll(newDsba);

        // Làm mới bảng hiển thị
        laydulieu_banan(dsba);

        // Hiển thị thông báo cho người dùng
        JOptionPane.showMessageDialog(this, "Danh sách bàn ăn và các trường đã được làm mới !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnRefreshBanAnActionPerformed

    private void btnRefreshDatBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshDatBanActionPerformed
        // TODO add your handling code here:
        ArrayList<DatBanTrucTiep> newDsdbtt = BanAn_DAO.LayThongTinDatBanTrucTiep();

        // Xoá nội dung của các JTextField
        txtMaDatBan.setText("");
        txtNgayDatBan.setText("");
        txtTenKH.setText("");
        txtSoKhach.setText("");

        // Xóa dữ liệu trong JComboBox
        cbmMaBan.setSelectedIndex(0);

        // Cập nhật danh sách đặt bàn trực tiếp
        dsdtbb.clear();
        dsdtbb.addAll(newDsdbtt);

        // Làm mới bảng hiển thị
        laydulieu_datbantructiep(dsdtbb);

        // Hiển thị thông báo cho người dùng
        JOptionPane.showMessageDialog(this, "Danh sách đặt bàn trực tiếp và các trường đã được làm mới !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnRefreshDatBanActionPerformed

    private void table_banMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_banMouseClicked
        // TODO add your handling code here:
        // Lấy dòng (row) được chọn bằng cách sử dụng phương thức getSelectedRow
        int selectedRow = table_ban.getSelectedRow();

        if (selectedRow != -1) {
            // Lấy dữ liệu từ hàng được chọn
            String maBan = (String) table_ban.getValueAt(selectedRow, 0);
            String tenBan = (String) table_ban.getValueAt(selectedRow, 1);
            String trangThai = (String) table_ban.getValueAt(selectedRow, 2);
            String sucChua = table_ban.getValueAt(selectedRow, 3).toString();

            // Hiển thị thông tin trong các trường hoặc thực hiện các hành động khác ở đây
            // Ví dụ: hiển thị thông tin trong các JTextField
            txtMaBan.setText(maBan);
            txtTenBan.setText(tenBan);
            cbmTrangThai.setSelectedItem(trangThai);
            txtSucChua.setText(sucChua);
        }
    }//GEN-LAST:event_table_banMouseClicked

    private void table_datbanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_datbanMouseClicked
        // TODO add your handling code here:
        // Lấy dòng (row) được chọn bằng cách sử dụng phương thức getSelectedRow
        int selectedRow = table_datban.getSelectedRow();

        if (selectedRow != -1) {
            // Lấy dữ liệu từ hàng được chọn
            String maDatBan = (String) table_datban.getValueAt(selectedRow, 0);
            String maBan = (String) table_datban.getValueAt(selectedRow, 1);
            String ngayDatBan = (String) table_datban.getValueAt(selectedRow, 2);
            String tenKH = (String) table_datban.getValueAt(selectedRow, 3);
            String soKhach = table_datban.getValueAt(selectedRow, 4).toString();

            // Hiển thị thông tin trong các trường hoặc thực hiện các hành động khác ở đây
            // Ví dụ: hiển thị thông tin trong các JTextField hoặc JComboBox
            txtMaDatBan.setText(maDatBan);
            cbmMaBan.setSelectedItem(maBan);
            txtNgayDatBan.setText(ngayDatBan);
            txtTenKH.setText(tenKH);
            txtSoKhach.setText(soKhach);
        }
    }//GEN-LAST:event_table_datbanMouseClicked

    private void btnBackMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackMenuActionPerformed
        // TODO add your handling code here:
        frmMenu = new frmDanhMucChucNang();
        frmMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackMenuActionPerformed

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
            java.util.logging.Logger.getLogger(frmBanAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBanAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBanAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBanAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBanAn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackMenu;
    private javax.swing.JButton btnRefreshBanAn;
    private javax.swing.JButton btnRefreshDatBan;
    private javax.swing.JButton btnSuaBA;
    private javax.swing.JButton btnSuaDB;
    private javax.swing.JButton btnThemBA;
    private javax.swing.JButton btnThemDB;
    private javax.swing.JButton btnXoaBA;
    private javax.swing.JButton btnXoaDB;
    private javax.swing.JComboBox<String> cbmMaBan;
    private javax.swing.JComboBox<String> cbmTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_ban;
    private javax.swing.JTable table_datban;
    private javax.swing.JTextField txtMaBan;
    private javax.swing.JTextField txtMaDatBan;
    private javax.swing.JTextField txtNgayDatBan;
    private javax.swing.JTextField txtSoKhach;
    private javax.swing.JTextField txtSucChua;
    private javax.swing.JTextField txtTenBan;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
