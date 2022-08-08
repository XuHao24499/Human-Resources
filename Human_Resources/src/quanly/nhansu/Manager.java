package quanly.nhansu;

public class Manager extends Staff implements ICalculator{
    private String chucDanh;

    public Manager(String maNhanVien, String hoTen, int tuoi, double heSoLuong, String ngayVaoLam, int ngayNghiPhep, String boPhanLamVien, String chucDanh){
        super(maNhanVien, hoTen, tuoi, heSoLuong, ngayVaoLam, ngayNghiPhep, boPhanLamVien);
        this.chucDanh = chucDanh;
    }

    public Manager(){

    }
    public String getChucDanh(){
        return chucDanh;
    }

    public void setChucDanh(String chucDanh){
        this.chucDanh = chucDanh;
    }

    public double tinhLuong(){
        double luongTrachNhiem = 0;

        if(chucDanh == "Business Leader"){
            luongTrachNhiem = 8000000;
        }else if (chucDanh == "Project Leader"){
            luongTrachNhiem = 5000000;
        }else if (chucDanh == "Technical Leader"){
            luongTrachNhiem = 6000000;
        }
        
        double luong = getHeSoLuong()*5000000 + luongTrachNhiem;
        return luong;
    }

    public void displayInformation(){
        System.out.printf("%-15s | %-20s | %-4d | %-10.1f | %-13s | %-20s | %-20d | %-23s | %15.1f\n", getMaNhanVien(), getHoTen(),
        getTuoi(), getHeSoLuong(), getNgayVaoLam(), getBoPhanLamViec(), getNgayNghiPhep(), getChucDanh(), getLuong());
    }
        
}

