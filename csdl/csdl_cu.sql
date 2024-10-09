
DROP TABLE Login CASCADE CONSTRAINTS;
DROP TABLE NhanVien CASCADE CONSTRAINTS;

DROP TABLE BanAn CASCADE CONSTRAINTS;
DROP TABLE MonAn CASCADE CONSTRAINTS;
DROP TABLE NuocUong CASCADE CONSTRAINTS;
DROP TABLE DatBanTrucTiep CASCADE CONSTRAINTS;

DROP TABLE HoaDon CASCADE CONSTRAINTS;
DROP TABLE ChiTietHoaDon CASCADE CONSTRAINTS;

-------- ver.12

--- [ Tao bang ] ---
CREATE TABLE NhanVien (
    MaNV VARCHAR2(30) PRIMARY KEY,
    TenNV VARCHAR2(30),
    GioiTinh VARCHAR2(30),
    DiaChi VARCHAR2(200),
    SoDT VARCHAR2(200),
    Email VARCHAR2(200)
);
GRANT SELECT, INSERT, UPDATE, DELETE ON NhanVien TO sa;

CREATE TABLE Login (
    MaNV VARCHAR2(30),
    MatKhau VARCHAR2(30),
    VaiTro VARCHAR2(30),
    FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV)
    ON DELETE CASCADE
);
GRANT SELECT, INSERT, UPDATE, DELETE ON Login TO sa;

CREATE TABLE BanAn (
    MaBan VARCHAR2(30) PRIMARY KEY,
    TenBan VARCHAR2(30),
    TrangThai VARCHAR2(30),
    SucChua NUMBER
);
GRANT SELECT, INSERT, UPDATE, DELETE ON BanAn TO sa;

CREATE TABLE MonAn (
    MaMon VARCHAR2(30) PRIMARY KEY,
    TenMon VARCHAR2(100),
    GiaTien NUMBER
);
GRANT SELECT, INSERT, UPDATE, DELETE ON MonAn TO sa;


CREATE TABLE NuocUong (
    MaDoUong VARCHAR2(30) PRIMARY KEY,
    TenDoUong VARCHAR2(100),
    GiaTien NUMBER
);
GRANT SELECT, INSERT, UPDATE, DELETE ON NuocUong TO sa;


CREATE TABLE DatBanTrucTiep (
    MaDatBan VARCHAR2(30) PRIMARY KEY,
    MaBan VARCHAR2(30),
    NgayDatBan DATE,
    TenKH VARCHAR2(30),
    SoKhach NUMBER,
    FOREIGN KEY (MaBan) REFERENCES BanAn(MaBan)
);
GRANT SELECT, INSERT, UPDATE, DELETE ON DatBanTrucTiep TO sa;

select * from DatBanTrucTiep

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
GRANT SELECT, INSERT, UPDATE, DELETE ON HoaDon TO sa;



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
GRANT SELECT, INSERT, UPDATE, DELETE ON ChiTietHoaDon TO sa;
----------------


------------
INSERT INTO NhanVien (MaNV, TenNV, GioiTinh, DiaChi, SoDT, Email)
VALUES ('NV001', 'Nguyen Van A', 'Nam', '123 Tran Hung Dao', '0123456789', 'nva@gmail.com');

INSERT INTO NhanVien (MaNV, TenNV, GioiTinh, DiaChi, SoDT, Email)
VALUES ('NV002', 'Tran Thi B', 'Nu', '456 Le Loi', '0987654321', 'ttb@gmail.com');

INSERT INTO NhanVien (MaNV, TenNV, GioiTinh, DiaChi, SoDT, Email)
VALUES ('NV003', 'Le Cong C', 'Nam', '12 Ba Vi', '0988654321', 'lcc@gmail.com');

INSERT INTO NhanVien (MaNV, TenNV, GioiTinh, DiaChi, SoDT, Email)
VALUES ('NV004', 'Pham Thi D', 'Nu', '321 Tran Phu', '0987123456', 'ptd@gmail.com');

INSERT INTO NhanVien (MaNV, TenNV, GioiTinh, DiaChi, SoDT, Email)
VALUES ('NV005', 'Hoang Van E', 'Nam', '654 Le Duan', '0123789456', 'hve@gmail.com');

select * from NhanVien



INSERT INTO Login (MaNV, MatKhau, VaiTro)
VALUES ('NV001', '123456', 'quanly');

INSERT INTO Login (MaNV, MatKhau, VaiTro)
VALUES ('NV002', 'abc002', 'nhanvien');

INSERT INTO Login (MaNV, MatKhau, VaiTro)
VALUES ('NV003', 'abc003', 'nhanvien');

INSERT INTO Login (MaNV, MatKhau, VaiTro)
VALUES ('NV004', 'abc004', 'nhanvien');

INSERT INTO Login (MaNV, MatKhau, VaiTro)
VALUES ('NV005', 'abc005', 'nhanvien');

select * from Login


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


-- Thêm d? li?u vào b?ng HoaDon
INSERT INTO HoaDon (MaHD, MaDatBan, MaNV, TongTien, NgayLap)
VALUES ('HD001', 'DB001', 'NV001', 125, TO_DATE('2022-08-26', 'YYYY-MM-DD'));

INSERT INTO HoaDon (MaHD, MaDatBan, MaNV, TongTien, NgayLap)
VALUES ('HD002', 'DB002', 'NV002', 20, TO_DATE('2022-08-26', 'YYYY-MM-DD'));

INSERT INTO HoaDon (MaHD, MaDatBan, MaNV, TongTien, NgayLap)
VALUES ('HD003', 'DB003', 'NV004', 40, TO_DATE('2022-08-27', 'YYYY-MM-DD'));

INSERT INTO HoaDon (MaHD, MaDatBan, MaNV, TongTien, NgayLap)
VALUES ('HD004', 'DB004', 'NV005', 60, TO_DATE('2022-08-27', 'YYYY-MM-DD'));

INSERT INTO HoaDon (MaHD, MaDatBan, MaNV, TongTien, NgayLap)
VALUES ('HD005', 'DB005', 'NV001', 60, TO_DATE('2022-08-28', 'YYYY-MM-DD'));

select * from HoaDon


-- Thêm d? li?u vào b?ng ChiTietHoaDon
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






--- Ki?m tra xem gói DBMS_CRYPTO ð? ðý?c cài ð?t chýa:
SELECT object_name, object_type
FROM all_objects
WHERE object_name = 'DBMS_CRYPTO';









-- Tao hàm ma hóa AES
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

-- Tao hàm giai ma AES
CREATE OR REPLACE FUNCTION GiaiMa_AES(P_Khoa VARCHAR2, P_DaMaHoa RAW)
RETURN VARCHAR2 IS
    V_GiaiMa RAW(2000);
BEGIN
    V_GiaiMa := DBMS_CRYPTO.DECRYPT(
        P_DaMaHoa,
        DBMS_CRYPTO.ENCRYPT_AES256 + DBMS_CRYPTO.CHAIN_CBC + DBMS_CRYPTO.PAD_PKCS5,
        UTL_RAW.CAST_TO_RAW(P_Khoa)
    );
    RETURN UTL_I18N.RAW_TO_NCHAR(V_GiaiMa);
END GiaiMa_AES;
/

-- T?o th? t?c thêm nhân viên v?i m? hóa
CREATE OR REPLACE PROCEDURE ThemNhanVien(
    P_MaNV VARCHAR2,
    P_TenNV VARCHAR2,
    P_GioiTinh VARCHAR2,
    P_DiaChi VARCHAR2,
    P_SoDT VARCHAR2,
    P_Email VARCHAR2
) AS
    V_Khoa VARCHAR2(32) := 'XINCHAOTATCAMOINGUOIMINHLASONDAY'; -- Khóa m? hóa, b?n có th? thay ð?i khóa này.
BEGIN
    -- M? hóa d? li?u trý?c khi thêm vào b?ng NhanVien
    INSERT INTO NhanVien (MaNV, TenNV, GioiTinh, DiaChi, SoDT, Email)
    VALUES (
        P_MaNV,
        P_TenNV,
        P_GioiTinh,
        MaHoa_AES(V_Khoa, P_DiaChi),
        P_SoDT,
        MaHoa_AES(V_Khoa, P_Email)
    );
    
    COMMIT;
END ThemNhanVien;

DROP PROCEDURE ThemNhanVien;


-- T?o vai tr? "quanly"
CREATE ROLE quanly;

-- T?o vai tr? "nhanvien"
CREATE ROLE nhanvien;

-- Kiem tra cac role hien tai dang co
SELECT * FROM DBA_ROLES;





















CREATE OR REPLACE TRIGGER trg_ChiTietHoaDon
BEFORE INSERT OR UPDATE ON ChiTietHoaDon
FOR EACH ROW
DECLARE
    v_Gia NUMBER;
BEGIN
    IF :NEW.MaDoAn IS NOT NULL THEN
        SELECT Gia INTO v_Gia FROM MonAn WHERE MaDoAn = :NEW.MaDoAn;
    ELSE
        SELECT Gia INTO v_Gia FROM NuocUong WHERE MaDoUong = :NEW.MaDoUong;
    END IF;
    
    :NEW.ThanhTien := v_Gia * :NEW.SoLuong;
END;




CREATE OR REPLACE TRIGGER trg_ChiTietHoaDon_TongTien
AFTER INSERT OR UPDATE OR DELETE ON ChiTietHoaDon
FOR EACH ROW
DECLARE
    v_TongTien NUMBER;
BEGIN
    SELECT SUM(ThanhTien) INTO v_TongTien FROM ChiTietHoaDon WHERE MaHD = :NEW.MaHD;
    UPDATE HoaDon SET TongTien = v_TongTien WHERE MaHD = :NEW.MaHD;
END;




--------------------------------------------------------------------------------------------------------------
-- T?o vai tr? "quanly"
CREATE ROLE quanly;

-- T?o vai tr? "nhanvien"
CREATE ROLE nhanvien;

-- Kiem tra cac role hien tai dang co
SELECT * FROM DBA_ROLES;

-----------------------------------------------------------------------------------------------------------------
-- Cho phep vai tro "quanly" truy cap tat ca cac bang va thuc hien cac thao tac SELECT, INSERT, UPDATE, DELETE
GRANT SELECT, INSERT, UPDATE, DELETE ON NhanVien TO quanly;

GRANT SELECT, INSERT, UPDATE, DELETE ON Login TO quanly;

GRANT SELECT, INSERT, UPDATE, DELETE ON BanAn TO quanly;

GRANT SELECT, INSERT, UPDATE, DELETE ON MonAn TO quanly;

GRANT SELECT, INSERT, UPDATE, DELETE ON NuocUong TO quanly;

GRANT SELECT, INSERT, UPDATE, DELETE ON DatBanTrucTiep TO quanly;

GRANT SELECT, INSERT, UPDATE, DELETE ON HoaDon TO quanly;

GRANT SELECT, INSERT, UPDATE, DELETE ON ChiTietHoaDon TO quanly;

-- Cho phep chi quan ly thuc hien thu tuc ThemNhanVien
GRANT EXECUTE ON ThemNhanVien TO quanly;

--- Kiem tra role quanly co nhung quyen gi tren bang NhanVien
SELECT *
FROM dba_tab_privs
WHERE table_name = 'NHANVIEN'
  AND grantee = 'QUANLY';
  

-- Tao 1 bang tam de luu ket qua
CREATE TABLE role_privileges AS
SELECT table_name, privilege, grantee
FROM dba_tab_privs
WHERE grantee = 'QUANLY'; -- Thay 'TEN_ROLE' b?ng tên c?a vai tr? b?n mu?n ki?m tra

-- Xem quyen cua vai tro tren cac bang
SELECT * FROM role_privileges;

----------------------------------------------------------------------------------------------------------------------------
-- Cho phep vai tro "nhanvien" truy cap tat ca cac bang can thiet va thuc hien cac thao tac SELECT, INSERT, UPDATE, DELETE
GRANT SELECT, INSERT, UPDATE, DELETE ON BanAn TO nhanvien;

GRANT SELECT, INSERT, UPDATE, DELETE ON DatBanTrucTiep TO nhanvien;

GRANT SELECT, INSERT, UPDATE, DELETE ON HoaDon TO nhanvien;

GRANT SELECT, INSERT, UPDATE, DELETE ON ChiTietHoaDon TO nhanvien;

GRANT SELECT ON NhanVien TO nhanvien;


--- Kiem tra role nhanvien co nhung quyen gi tren bang NhanVien
SELECT *
FROM dba_tab_privs
WHERE table_name = 'NHANVIEN'
  AND grantee = 'NHANVIEN';
  
------------------------------------------------------------------------------------------------------------------------
-- C?p quy?n CREATE ANY DIRECTORY
GRANT CREATE ANY DIRECTORY TO sa;






CREATE OR REPLACE PROCEDURE DangNhap(
    P_MaNV VARCHAR2,
    P_MatKhau VARCHAR2,
    P_VaiTro OUT VARCHAR2
) AS
    V_SQL VARCHAR2(100);
BEGIN
    -- Ki?m tra thông tin ðãng nh?p
    SELECT VaiTro INTO P_VaiTro
    FROM Login
    WHERE MaNV = P_MaNV AND MatKhau = P_MatKhau;

    -- Gán vai tr? cho ngý?i dùng sau khi ðãng nh?p thành công
    IF P_VaiTro = 'quanly' THEN
        -- Gán vai tr? 'quanly' cho ngý?i dùng
        V_SQL := 'ALTER SESSION SET ROLE quanly';
        EXECUTE IMMEDIATE V_SQL;
    ELSIF P_VaiTro = 'nhanvien' THEN
        -- Gán vai tr? 'nhanvien' cho ngý?i dùng
        V_SQL := 'ALTER SESSION SET ROLE nhanvien';
        EXECUTE IMMEDIATE V_SQL;
    ELSE
        -- Không t?m th?y thông tin ðãng nh?p h?p l?
        RAISE_APPLICATION_ERROR(-20001, 'Thông tin ðãng nh?p không h?p l?');
    END IF;
END DangNhap;
/



GRANT EXECUTE ON DangNhap TO quanly;
GRANT EXECUTE ON DangNhap TO nhanvien;

SET SERVEROUTPUT ON
EXECUTE DangNhap('NV001', '123456', :vaitro);













-- T?o m?t thý m?c ð? lýu tr? c?p khóa RSA
CREATE OR REPLACE DIRECTORY my_rsa_keys AS 'D:/HUFI/k7/BaoMat/DOAN_Nhom_QlyQuanAn/save_RSA';

-- C?p quy?n cho ngý?i dùng truy c?p vào thý m?c
GRANT READ, WRITE ON DIRECTORY my_rsa_keys TO sa;

-- T?o c?p khóa RSA (khóa riêng tý và khóa công khai)
BEGIN
  DBMS_CRYPTO.CREATE_RSA_KEY_PAIR(
    key_length       => 2048,
    use_hard_token   => FALSE,
    use_mkm          => FALSE,
    key_id           => 'RSA_KEY_PAIR',
    keystore_location=> 'file:my_rsa_keys', -- S? d?ng tên thý m?c ð? t?n t?i
    keystore_password=> 'XINCHAOSONDAY'
  );
END;
/






















