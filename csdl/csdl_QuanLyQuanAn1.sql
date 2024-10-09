
/*
-- Tao mott vai trò (role)
CREATE ROLE my_data_viewer;

-- Gán quyen SELECT vào b?ng cho vai trò
GRANT SELECT ON your_table TO my_data_viewer;

-- Gán vai trò cho nguoi dùng SYS hoac nguoi dùng tuong tu
GRANT my_data_viewer TO SYS;
*/


-----------------------------------------
create user user1 identified by user1;

grant connect, resource, dba to user1;

grant create session to user1;

grant unlimited tablespace to user1;
-------------------------------------------
create user user2 identified by user2;

grant connect, resource, dba to user2;

grant create session to user2;

grant unlimited tablespace to user2;
-------------------------------------------
create user user3 identified by user3;

grant connect, resource, dba to user3;

grant create session to user3;

grant unlimited tablespace to user3;
-------------------------------------------

alter user sys identified by sys;
grant all privileges to sys;

create user admin1 identified by admin1;
grant all privileges to admin1;

--- Gan quyen thuc thi dbms_rls cho user admin1
grant execute on dbms_rls to admin1

GRANT dba TO admin1 IDENTIFIED BY admin1;

--- Gan quyen EXEMPT ACCESS POLICY cho admin1 de user khong bi anh huong boi cac policy
GRANT EXEMPT ACCESS POLICY TO admin1;

--- Kiem tra ai duoc gan quyen EXEMPT ACCESS POLICY / use sys
SELECT grantee FROM dba_sys_privs
WHERE PRIVILEGE = 'EXEMPT ACCESS POLICY';

-------------------------------------------------------------
DROP TABLE NhanVien CASCADE CONSTRAINTS;

DROP TABLE BanAn CASCADE CONSTRAINTS;
DROP TABLE MonAn CASCADE CONSTRAINTS;
DROP TABLE NuocUong CASCADE CONSTRAINTS;
DROP TABLE DatBanTrucTiep CASCADE CONSTRAINTS;

DROP TABLE HoaDon CASCADE CONSTRAINTS;
DROP TABLE ChiTietHoaDon CASCADE CONSTRAINTS;

-----------------------------------------------------
--- [ Tao bang ] ---
CREATE TABLE NhanVien (
    MaNV VARCHAR2(30) PRIMARY KEY,
    TenNV VARCHAR2(30),
    GioiTinh VARCHAR2(30),
    DiaChi VARCHAR2(200),
    SoDT VARCHAR2(200),
    Email VARCHAR2(200),
    Luong NUMBER
);
GRANT SELECT, INSERT, UPDATE, DELETE ON NhanVien TO admin1;
GRANT SELECT ON NhanVien TO user1;
GRANT SELECT ON NhanVien TO user2;
GRANT SELECT ON NhanVien TO user3;

CREATE TABLE BanAn (
    MaBan VARCHAR2(30) PRIMARY KEY,
    TenBan VARCHAR2(30),
    TrangThai VARCHAR2(30),
    SucChua NUMBER
);
GRANT SELECT, INSERT, UPDATE, DELETE ON BanAn TO admin1;
GRANT SELECT, INSERT, UPDATE, DELETE ON BanAn TO user1;
GRANT SELECT, INSERT, UPDATE, DELETE ON BanAn TO user2;
GRANT SELECT, INSERT, UPDATE, DELETE ON BanAn TO user3;

CREATE TABLE MonAn (
    MaMon VARCHAR2(30) PRIMARY KEY,
    TenMon VARCHAR2(100),
    GiaTien NUMBER
);
GRANT SELECT, INSERT, UPDATE, DELETE ON MonAn TO admin1;
GRANT SELECT, INSERT, UPDATE, DELETE ON MonAn TO user1;
GRANT SELECT, INSERT, UPDATE, DELETE ON MonAn TO user2;
GRANT SELECT, INSERT, UPDATE, DELETE ON MonAn TO user3;



CREATE TABLE NuocUong (
    MaDoUong VARCHAR2(30) PRIMARY KEY,
    TenDoUong VARCHAR2(100),
    GiaTien NUMBER
);
GRANT SELECT, INSERT, UPDATE, DELETE ON NuocUong TO admin1;
GRANT SELECT, INSERT, UPDATE, DELETE ON NuocUong TO user1;
GRANT SELECT, INSERT, UPDATE, DELETE ON NuocUong TO user2;
GRANT SELECT, INSERT, UPDATE, DELETE ON NuocUong TO user3;



CREATE TABLE DatBanTrucTiep (
    MaDatBan VARCHAR2(30) PRIMARY KEY,
    MaBan VARCHAR2(30),
    NgayDatBan DATE,
    TenKH VARCHAR2(30),
    SoKhach NUMBER,
    FOREIGN KEY (MaBan) REFERENCES BanAn(MaBan)
);
GRANT SELECT, INSERT, UPDATE, DELETE ON DatBanTrucTiep TO admin1;
GRANT SELECT, INSERT, UPDATE, DELETE ON DatBanTrucTiep TO user1;
GRANT SELECT, INSERT, UPDATE, DELETE ON DatBanTrucTiep TO user2;
GRANT SELECT, INSERT, UPDATE, DELETE ON DatBanTrucTiep TO user3;


CREATE TABLE HoaDon (
    MaHD VARCHAR2(30) PRIMARY KEY,
    MaDatBan VARCHAR2(30),
    MaNV VARCHAR2(30),
    TongTien NUMBER,
    NgayLap DATE,
    FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV),
    FOREIGN KEY (MaDatBan) REFERENCES DatBanTrucTiep(MaDatBan)
    ON DELETE CASCADE
);
GRANT SELECT, INSERT, UPDATE, DELETE ON HoaDon TO admin1;
GRANT SELECT, INSERT, UPDATE, DELETE ON HoaDon TO user1;
GRANT SELECT, INSERT, UPDATE, DELETE ON HoaDon TO user2;
GRANT SELECT, INSERT, UPDATE, DELETE ON HoaDon TO user3;



CREATE TABLE ChiTietHoaDon (
    MaCTHD VARCHAR2(30),
    MaHD VARCHAR2(30),
    MaMon VARCHAR2(30),
    MaDoUong VARCHAR2(30),
    SoLuong NUMBER,
    ThanhTien NUMBER,
	FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
	FOREIGN KEY (MaMon) REFERENCES MonAn(MaMon),
	FOREIGN KEY (MaDoUong) REFERENCES NuocUong(MaDoUong)
	ON DELETE CASCADE 
);
GRANT SELECT, INSERT, UPDATE, DELETE ON ChiTietHoaDon TO admin1;
GRANT SELECT, INSERT, UPDATE, DELETE ON ChiTietHoaDon TO user1;
GRANT SELECT, INSERT, UPDATE, DELETE ON ChiTietHoaDon TO user2;
GRANT SELECT, INSERT, UPDATE, DELETE ON ChiTietHoaDon TO user3;

--------------------------------------------------------------------------
-- Thêm du lieu vao bang NhanVien
INSERT INTO NhanVien (MaNV, TenNV, GioiTinh, DiaChi, SoDT, Email, Luong)
VALUES ('NV001', 'Nguyen Van Ut', 'Nam', '123 Tran Hung Dao', '0123456789', 'nva@gmail.com', 1000);

INSERT INTO NhanVien (MaNV, TenNV, GioiTinh, DiaChi, SoDT, Email, Luong)
VALUES ('NV002', 'Tran Van Hao', 'Nu', '456 Le Loi', '0987654321', 'ttb@gmail.com', 1500);

INSERT INTO NhanVien (MaNV, TenNV, GioiTinh, DiaChi, SoDT, Email, Luong)
VALUES ('NV003', 'Le Cong Tan', 'Nam', '12 Ba Vi', '0988654321', 'lcc@gmail.com', 2000);

select * from NhanVien



-- Thêm du lieu vao bang BanAn
INSERT INTO BanAn (MaBan, TenBan, TrangThai, SucChua)
VALUES ('B001', 'Ban 1', 'Da dat', 5);

INSERT INTO BanAn (MaBan, TenBan, TrangThai, SucChua)
VALUES ('B002', 'Ban 2', 'Da dat', 5);

INSERT INTO BanAn (MaBan, TenBan, TrangThai, SucChua)
VALUES ('B003', 'Ban 3', 'Da dat', 5);

INSERT INTO BanAn (MaBan, TenBan, TrangThai, SucChua)
VALUES ('B004', 'Ban 4', 'Da dat', 5);

INSERT INTO BanAn (MaBan, TenBan, TrangThai, SucChua)
VALUES ('B005', 'Ban 5', 'Da dat', 10);

INSERT INTO BanAn (MaBan, TenBan, TrangThai, SucChua)
VALUES ('B006', 'Ban 6', 'Trong', 10);

INSERT INTO BanAn (MaBan, TenBan, TrangThai, SucChua)
VALUES ('B007', 'Ban 7', 'Trong', 10);

INSERT INTO BanAn (MaBan, TenBan, TrangThai, SucChua)
VALUES ('B008', 'Ban 8', 'Trong', 6);

INSERT INTO BanAn (MaBan, TenBan, TrangThai, SucChua)
VALUES ('B009', 'Ban 9', 'Trong', 10);

INSERT INTO BanAn (MaBan, TenBan, TrangThai, SucChua)
VALUES ('B0010', 'Ban 10', 'Trong', 8);

select * from BanAn


-- Thêm du lieu vao bang MonAn
INSERT INTO MonAn (MaMon, TenMon, GiaTien)
VALUES ('MA001', 'Pho Bo', 40);

INSERT INTO MonAn (MaMon, TenMon, GiaTien)
VALUES ('MA002', 'Bun Bo Hue', 30);

INSERT INTO MonAn (MaMon, TenMon, GiaTien)
VALUES ('MA003', 'Banh Mi Thit', 20);

INSERT INTO MonAn (MaMon, TenMon, GiaTien)
VALUES ('MA004', 'Hu Tieu Nam Vang', 35);

INSERT INTO MonAn (MaMon, TenMon, GiaTien)
VALUES ('MA005', 'Banh xeo', 10);

select * from MonAn


-- Thêm du lieu vao bang NuocUong
INSERT INTO NuocUong (MaDoUong, TenDoUong, GiaTien)
VALUES ('NU001', 'Coca Cola', 15);

INSERT INTO NuocUong (MaDoUong, TenDoUong, GiaTien)
VALUES ('NU002', 'Pepsi', 15);

INSERT INTO NuocUong (MaDoUong, TenDoUong, GiaTien)
VALUES ('NU003', 'Mirinda Cam', 15);

INSERT INTO NuocUong (MaDoUong, TenDoUong, GiaTien)
VALUES ('NU004', '7 Up', 15);

INSERT INTO NuocUong (MaDoUong, TenDoUong, GiaTien)
VALUES ('NU005', 'Nuoc suoi', 10);

select * from NuocUong



-- Thêm du lieu vao bang DatBanTrucTiep
INSERT INTO DatBanTrucTiep (MaDatBan, MaBan, NgayDatBan, TenKH, SoKhach)
VALUES ('DB001', 'B001', TO_DATE('2022-08-26', 'YYYY-MM-DD'), 'Huy', 4);

INSERT INTO DatBanTrucTiep (MaDatBan, MaBan, NgayDatBan, TenKH, SoKhach)
VALUES ('DB002', 'B002', TO_DATE('2022-08-26', 'YYYY-MM-DD'), 'Son', 4);

INSERT INTO DatBanTrucTiep (MaDatBan, MaBan, NgayDatBan, TenKH, SoKhach)
VALUES ('DB003', 'B003', TO_DATE('2022-08-27', 'YYYY-MM-DD'), 'Thanh', 4);

INSERT INTO DatBanTrucTiep (MaDatBan, MaBan, NgayDatBan, TenKH, SoKhach)
VALUES ('DB004', 'B004', TO_DATE('2022-08-27', 'YYYY-MM-DD'), 'Hau', 4);

INSERT INTO DatBanTrucTiep (MaDatBan, MaBan, NgayDatBan, TenKH, SoKhach)
VALUES ('DB005', 'B005', TO_DATE('2022-08-28', 'YYYY-MM-DD'), 'Duc', 7);

select * from DatBanTrucTiep


-- Thêm du lieu vao bang HoaDon
INSERT INTO HoaDon (MaHD, MaDatBan, MaNV, TongTien, NgayLap)
VALUES ('HD001', 'DB001', 'NV001', 125, TO_DATE('2022-08-26', 'YYYY-MM-DD'));

INSERT INTO HoaDon (MaHD, MaDatBan, MaNV, TongTien, NgayLap)
VALUES ('HD002', 'DB002', 'NV002', 20, TO_DATE('2022-08-26', 'YYYY-MM-DD'));

INSERT INTO HoaDon (MaHD, MaDatBan, MaNV, TongTien, NgayLap)
VALUES ('HD003', 'DB003', 'NV003', 40, TO_DATE('2022-08-27', 'YYYY-MM-DD'));

INSERT INTO HoaDon (MaHD, MaDatBan, MaNV, TongTien, NgayLap)
VALUES ('HD004', 'DB004', 'NV001', 60, TO_DATE('2022-08-27', 'YYYY-MM-DD'));

INSERT INTO HoaDon (MaHD, MaDatBan, MaNV, TongTien, NgayLap)
VALUES ('HD005', 'DB005', 'NV002', 60, TO_DATE('2022-08-28', 'YYYY-MM-DD'));

select * from HoaDon


-- Thêm du lieu vao bang ChiTietHoaDon
INSERT INTO ChiTietHoaDon (MaCTHD, MaHD, MaMon, MaDoUong, SoLuong, ThanhTien)
VALUES ('CT001', 'HD001', 'MA001', NULL, 2, 80);

INSERT INTO ChiTietHoaDon (MaCTHD, MaHD, MaMon, MaDoUong, SoLuong, ThanhTien)
VALUES ('CT002', 'HD001', NULL, 'NU002', 3, 45);

INSERT INTO ChiTietHoaDon (MaCTHD, MaHD, MaMon, MaDoUong, SoLuong, ThanhTien)
VALUES ('CT003', 'HD002', 'MA003', NULL, 1, 20);

INSERT INTO ChiTietHoaDon (MaCTHD, MaHD, MaMon, MaDoUong, SoLuong, ThanhTien)
VALUES ('CT004', 'HD003', NULL, 'NU005', 4, 40);

INSERT INTO ChiTietHoaDon (MaCTHD, MaHD, MaMon, MaDoUong, SoLuong, ThanhTien)
VALUES ('CT005', 'HD004', 'MA002', NULL, 2, 60);

INSERT INTO ChiTietHoaDon (MaCTHD, MaHD, MaMon, MaDoUong, SoLuong, ThanhTien)
VALUES ('CT006', 'HD005', 'MA002', NULL, 2, 60);

select * from ChiTietHoaDon


--------------------------------------------------------------- 
--- Kiem tra xem goi DBMS_CRYPTO da duoc cai dat chua:
SELECT object_name, object_type
FROM all_objects
WHERE object_name = 'DBMS_CRYPTO';


--------------------------------------------------------------- 
--- Tao hàm ma hoa AES
CREATE OR REPLACE FUNCTION MaHoa_AES(P_Khoa VARCHAR2, P_DuLieu VARCHAR2)
RETURN RAW IS
    V_DaMaHoa RAW(2000);
BEGIN
    V_DaMaHoa := DBMS_CRYPTO.ENCRYPT(
        UTL_I18N.STRING_TO_RAW(P_DuLieu, 'AL32UTF8'),
        DBMS_CRYPTO.ENCRYPT_AES256 + DBMS_CRYPTO.CHAIN_CBC + DBMS_CRYPTO.PAD_PKCS5,
        UTL_RAW.CAST_TO_RAW(P_Khoa)
    );
    RETURN V_DaMaHoa;
END MaHoa_AES;
/


--------------------------------------------------------------- 
-- Tao ham giai ma AES
CREATE OR REPLACE FUNCTION GiaiMa_AES(P_Khoa VARCHAR2, P_DaMaHoa RAW)
RETURN VARCHAR2 IS
    V_KetQua VARCHAR2(2000);
BEGIN
    V_KetQua := UTL_I18N.RAW_TO_CHAR(DBMS_CRYPTO.DECRYPT(
        P_DaMaHoa,
        DBMS_CRYPTO.ENCRYPT_AES256 + DBMS_CRYPTO.CHAIN_CBC + DBMS_CRYPTO.PAD_PKCS5,
        UTL_RAW.CAST_TO_RAW(P_Khoa)
    ), 'AL32UTF8');
    RETURN V_KetQua;
END GiaiMa_AES;
/


--------------------------------------------------------------- 
-- Test AES
-- vd : Ma hoa Email
UPDATE NhanVien
SET Email = MaHoa_AES('XINCHAOTATCAMOINGUOIMINHLASONDAY', Email);


-- Su dung ham GiaiMa_AES de giai ma Email
SELECT MaNV, TenNV, GioiTinh, DiaChi, SoDT, GiaiMa_AES('XINCHAOTATCAMOINGUOIMINHLASONDAY', Email) AS Email, Luong
FROM NhanVien;

select * from NhanVien

rollback



-- Tao thu tuc them nhan vien voi ma hoa AES
CREATE OR REPLACE PROCEDURE ThemNhanVien(
    P_MaNV VARCHAR2,
    P_TenNV VARCHAR2,
    P_GioiTinh VARCHAR2,
    P_DiaChi VARCHAR2,
    P_SoDT VARCHAR2,
    P_Email VARCHAR2,
    P_Luong VARCHAR2
) AS
    V_Khoa VARCHAR2(32) := 'XINCHAOTATCAMOINGUOIMINHLASONDAY';
BEGIN
    -- Ma hoa du lieu truoc khi them vào bang NhanVien
    INSERT INTO NhanVien (MaNV, TenNV, GioiTinh, DiaChi, SoDT, Email, Luong)
    VALUES (
        P_MaNV,
        P_TenNV,
        P_GioiTinh,
        MaHoa_AES(V_Khoa, P_DiaChi),
        P_SoDT,
        MaHoa_AES(V_Khoa, P_Email),
        P_Luong
    );
    
    COMMIT;
END ThemNhanVien;
/

--- Test Proc ThemNhanVien
DECLARE
    V_MaNV VARCHAR2(30) := 'NV004';
    V_TenNV VARCHAR2(30) := 'Tran Thi Mai';
    V_GioiTinh VARCHAR2(30) := 'Nu';
    V_DiaChi VARCHAR2(200) := '789 Le Van Sy';
    V_SoDT VARCHAR2(200) := '0123456780';
    V_Email VARCHAR2(200) := 'ttm@gmail.com';
    V_Luong NUMBER := 1200;
BEGIN
    ThemNhanVien(V_MaNV, V_TenNV, V_GioiTinh, V_DiaChi, V_SoDT, V_Email, TO_CHAR(V_Luong));
END;
/

DROP PROCEDURE ThemNhanVien;

select * from NhanVien

DELETE FROM NhanVien WHERE MaNV = 'NV005';
commit


----
CREATE OR REPLACE PROCEDURE CapNhatNhanVien(
    P_MaNV VARCHAR2,
    P_TenNV VARCHAR2,
    P_GioiTinh VARCHAR2,
    P_DiaChi VARCHAR2,
    P_SoDT VARCHAR2,
    P_Email VARCHAR2,
    P_Luong VARCHAR2
) AS
    V_Khoa VARCHAR2(32) := 'XINCHAOTATCAMOINGUOIMINHLASONDAY';
    V_MaHoaEmail RAW(2000);
    V_MaHoaDiaChi RAW(2000); -- Khai báo bi?n cho mã hoá ??a ch?
BEGIN
    -- Mã hoá Email và dia chi
    V_MaHoaEmail := MaHoa_AES(V_Khoa, P_Email);
    V_MaHoaDiaChi := MaHoa_AES(V_Khoa, P_DiaChi);

    -- C?p nh?t thông tin nhân viên trong b?ng NhanVien
    UPDATE NhanVien
    SET TenNV = P_TenNV,
        GioiTinh = P_GioiTinh,
        DiaChi = V_MaHoaDiaChi,
        SoDT = P_SoDT,
        Email = V_MaHoaEmail,
        Luong = P_Luong
    WHERE MaNV = P_MaNV;

    COMMIT;
END CapNhatNhanVien;
/



--- Test Proc CapNhatNhanVien
BEGIN
    CapNhatNhanVien('NV005', 'Nguyen Van Ut', 'Nam', '123 Tran Hung Dao', '0123456789', 'sasa', '1000');
END;
/

select * from NhanVien


--------------------------------------------------------------- 
--- Thu tuc them mon an
CREATE OR REPLACE PROCEDURE ThemMonAn(
    p_MaMon VARCHAR2,
    p_TenMon VARCHAR2,
    p_GiaTien NUMBER
) AS
BEGIN
    INSERT INTO MonAn(MaMon, TenMon, GiaTien)
    VALUES (p_MaMon, p_TenMon, p_GiaTien);
    COMMIT;
END ThemMonAn;
/

--- Kiem tra
BEGIN
    ThemMonAn('MA006', 'Mì Qu?ng', 25.0);
END;
/

BEGIN
    ThemMonAn('MA007', 'Mì Qu?ng', 25.0);
END;
/

select * from MonAn

DELETE FROM MonAn WHERE MaMon = 'MA006';
commit





--------------------------------------------------------------- 








