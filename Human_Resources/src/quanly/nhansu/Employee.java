package quanly.nhansu;

public class Employee extends Staff implements ICalculator  {
    private double soGioLamThem;


    public Employee(String maNhanVien, String hoTen, int tuoi, double heSoLuong, String ngayVaoLam, int ngayNghiPhep, String boPhanLamVien, Double soGioLamThem){
        super(maNhanVien, hoTen, tuoi, heSoLuong, ngayVaoLam, ngayNghiPhep, boPhanLamVien);
        this.soGioLamThem = soGioLamThem;
    }

    public Employee(){

    }

    public double getSoGioLamThem(){
        return soGioLamThem;
    }

    public void setSoGioLamThem(Double soGioLamThem){
        this.soGioLamThem = soGioLamThem;
    }

    public void displayInformation(){
        System.out.printf("%-15s | %-20s | %-4d | %-10.1f | %-13s | %-20s | %-20d | %-23.1f | %15.1f\n", getMaNhanVien(), getHoTen(),
        getTuoi(), getHeSoLuong(), getNgayVaoLam(), getBoPhanLamViec(), getNgayNghiPhep(), getSoGioLamThem(), getLuong());
    }
    public double tinhLuong(){
        double luong = getHeSoLuong()*3000000 + getSoGioLamThem()*200000;
        return luong;
    }


}