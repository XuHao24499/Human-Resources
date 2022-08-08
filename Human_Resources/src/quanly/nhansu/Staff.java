package quanly.nhansu;

import java.util.Scanner;

public abstract class Staff {
    private String maNhanVien, hoTen, boPhanLamVien, ngayVaoLam;
    private int tuoi, ngayNghiPhep;
    private double heSoLuong;
    private double luong;
    Scanner scanner = new Scanner(System.in);
    
    public Staff(String maNhanVien, String hoTen, int tuoi, double heSoLuong, String ngayVaoLam, int ngayNghiPhep, String boPhanLamVien){
        super();
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.heSoLuong = heSoLuong;
        this.ngayVaoLam = ngayVaoLam;
        this.ngayNghiPhep = ngayNghiPhep;
        this.boPhanLamVien = boPhanLamVien;
    }

    public Staff(){
    }

    public String getMaNhanVien(){
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien){
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen(){
        return hoTen;
    }

    public void setHoTen(String hoTen){
        this.hoTen = hoTen;
    }

    public String getBoPhanLamViec(){
        return boPhanLamVien;
    }

    public void setBoPhanLamViec(String boPhanLamVien){
        this.boPhanLamVien = boPhanLamVien;
    }

    public String getNgayVaoLam(){
        return ngayVaoLam;
    }

    public void setNgayVaoLam(String ngayVaoLam){
        this.ngayVaoLam = ngayVaoLam;
    }

    public int getTuoi(){
        return tuoi;
    }

    public void setTuoi(int tuoi){
        this.tuoi = tuoi;
    }

    public int getNgayNghiPhep(){
        return ngayNghiPhep;
    }

    public void setNgayNghiPhep(int ngayNghiPhep){
        this.ngayNghiPhep = ngayNghiPhep;
    }

    public double getHeSoLuong(){
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong){
        this.heSoLuong = heSoLuong;
    }

    public double getLuong(){
        return luong;
    }

    public void setLuong(double luong){
        this.luong = luong;
    }

    public abstract void displayInformation();
}

