package quanly.nhansu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import javafx.print.Collation;

public class HumanResources {
    public static ArrayList<Staff> StaffList = new ArrayList<>();
    public static ArrayList<Department> DepartmentList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        danhSach();
        boPhan();
        while(true){
            menu();
        }
    }

    public static void menu(){
        System.out.println("CHUONG TRINH QUAN LY NHAN VIEN");
        System.out.println("1. Hien thi danh sach nhan vien hien co trong cong ty.");
        System.out.println("2. Hien thi cac bo phan trong cong ty.");
        System.out.println("3. Hien thi cac nhan vien theo tung bo phan.");
        System.out.println("4. Them nhan vien moi vao cong ty.");
        System.out.println("5. Tim kiem thong tin nhan vien theo ten hoac ma nhan vien.");
        System.out.println("6. Hien thi bang luong cua nhan vien toan cong ty.");
        System.out.println("7. Hien thi bang luong cua nhan vien theo thu tu tang dan.");
        System.out.println("0. Thoat chuong trinh.");
        System.out.print("Lua chon cua ban (0-7): ");

        String luaChon = scanner.nextLine();

        switch (Integer.parseInt(luaChon)){
            case 1:
                System.out.println("Danh sach nhan vien cong ty:");
                System.out.printf("%-15s | %-20s | %-4s | %-10s | %-13s | %-20s | %-20s | %-23s | %15s\n", "Ma nhan vien","Ho va ten","Tuoi","HS Luong","Ngay vao lam","Bo phan lam viec", "Ngay nghi phep ","So gio lam them/Chuc vu","Luong");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                inDanhSach();
                break;
            case 2:
                System.out.println("Cac bo phan cua cong ty:");
                System.out.printf("%-10s | %-20s | %-25s\n","Ma bo phan", "Ten bo phan", "So luong nhan vien hien tai");
                System.out.println("----------------------------------------------------");
                inBoPhan();
                break;
            case 3:
                System.out.printf("%-20s | %-15s | %-4s | %-10s | %-13s | %-20s | %-20s | %-23s | %15s\n", "Ho va ten","Ma nhan vien","Tuoi","HS Luong","Ngay vao lam","Bo phan lam viec", "So ngay nghi phep","So gio lam them/Chuc vu","Luong");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                inNhanVienTheoBoPhan();
                break;
            case 4:
                System.out.println("Moi ban nhap thong tin:");
                addNhanVien();
                break;
            case 5: 
                timKiemNhanVien();
                break;
            case 6:
                System.out.println("Danh sach luong cua nhan vien trong cong ty:");
                System.out.printf("%-15s | %-20s | %-4s | %-10s | %-13s | %-20s | %-20s | %-23s | %15s\n", "Ma nhan vien","Ho va ten","Tuoi","HS Luong","Ngay vao lam","Bo phan lam viec", "Ngay nghi phep ","So gio lam them/Chuc vu","Luong");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                inDanhSach();
                break;
            case 7:
                System.out.println("Danh sach luong theo thu tu tang dan:");
                System.out.printf("%-15s | %-20s | %-4s | %-10s | %-13s | %-20s | %-20s | %-23s | %15s\n", "Ma nhan vien","Ho va ten","Tuoi","HS Luong","Ngay vao lam","Bo phan lam viec", "Ngay nghi phep ","So gio lam them/Chuc vu","Luong");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                sapXepLuongTangDan();
                for (int i = 0; i < StaffList.size(); i ++ ){
                    StaffList.get(i).displayInformation();
                }
                break;
            case 0: 
                System.out.println("Tam biet!");
                System.exit(0);
            default:
                System.out.println("Chuc nang ban chon khong ton tai~");
        }
    }

    public static void danhSach(){
        Employee nv1 = new Employee("001", "Tran Van Quyet", 27, 5.0, "1/1/2019", 10, "Hanh chinh nhan su", 5.0);
        nv1.setLuong(nv1.tinhLuong());
        Employee nv2 = new Employee("002", "Nguyen Thi Hong", 24, 4.0, "5/6/2020", 5, "Hanh chinh nhan su", 4.0);
        nv2.setLuong(nv2.tinhLuong());
        Employee nv3 = new Employee("003", "Tran Thi Tuyet", 20, 4.0, "2/9/2021", 6, "Marketing", 4.0);
        nv3.setLuong(nv3.tinhLuong());
        Employee nv4 = new Employee("004", "Tran Van Nam", 22, 4.5, "15/10/2018", 4, "Cong Nghe Thong Tin", 3.0);
        nv4.setLuong(nv4.tinhLuong());

        Manager ql1 = new Manager("005", "Trinh Hong Quang", 30, 6.0, "6/12/2017", 8, "Cong nghe thong tin", "Technical Leader");
        ql1.setLuong(ql1.tinhLuong());
        Manager ql2 = new Manager("006", "Mai Thi Van", 31, 6.5, "22/10/2017", 8, "Hanh chinh nhan su", "Project Leader");
        ql2.setLuong(ql2.tinhLuong());
        Manager ql3 = new Manager("007", "Vu Hoang Quy", 29, 5.5, "30/5/2017", 8, "Marketing", "Business Leader");
        ql3.setLuong(ql3.tinhLuong());

        StaffList.add(nv1);
        StaffList.add(nv2);
        StaffList.add(nv3);
        StaffList.add(nv4);
        StaffList.add(ql1);
        StaffList.add(ql2);
        StaffList.add(ql3);
    }

    public static void inDanhSach(){
        for(Staff x: StaffList){
            x.displayInformation();
        }
    }

    public static void boPhan(){
        Department dp1 = new Department("IT", "Cong nghe thong tin", 1);
        Department dp2 = new Department("MKT", "Marketing", 1);
        Department dp3 = new Department("HC", "Hanh chinh nhan su", 2);

        DepartmentList.add(dp1);
        DepartmentList.add(dp2);
        DepartmentList.add(dp3);
    }

    public static void inBoPhan(){
        for (Department x: DepartmentList){
            System.out.println(x);
        }
    }

    public static void addNhanVien(){
        while(true){
            System.out.println("Chon 1 de them nhan vien thong thuong");
            System.out.println("Chon 2 de them nhan vien la cap quan ly(Co them chuc vu)");
            int chon = scanner.nextInt();
            if(chon == 1){
                Employee addList = new Employee();
                System.out.print("Nhap ma nhan vien: ");
                addList.setMaNhanVien(scanner.nextLine());
                System.out.print("Nhap ho va ten: ");
                addList.setHoTen(scanner.nextLine());
                System.out.print("Nhap tuoi nhan vien: ");
                addList.setTuoi(scanner.nextInt());
                System.out.print("Nhap he so luong cua nhan vien ");
                addList.setHeSoLuong(scanner.nextDouble());
                System.out.print("Nhap ngay vao lam cua nhan vien: ");
                addList.setNgayVaoLam(scanner.nextLine());
                System.out.print("Nhap so ngay nghi phep: ");
                addList.setNgayNghiPhep(scanner.nextInt());

                System.out.println("1. Hanh chinh nhan su:");
                System.out.println("2. Cong nghe thong tin:");
                System.out.println("3. Maketing:");
                System.out.println("Nhap bo phan lam viec: ");
                int chonBoPhan = scanner.nextInt();
                if(chonBoPhan == 1){
                    addList.setBoPhanLamViec("Hanh chinh nhan su");
                }else if (chonBoPhan == 2){
                    addList.setBoPhanLamViec("Cong nghe thong tin");
                }else if(chonBoPhan == 3){
                    addList.setBoPhanLamViec("Marketing");
                }

                System.out.print("Nhap so gio lam them: ");
                addList.setSoGioLamThem(scanner.nextDouble());
                addList.setLuong(addList.tinhLuong());
                StaffList.add(addList);

            }else if(chon == 2){
                Manager newManager = new Manager();
                System.out.print("Nhap ma nhan vien: ");
                newManager.setMaNhanVien(scanner.nextLine());
                System.out.print("Nhap ho va ten: ");
                newManager.setHoTen(scanner.nextLine());
                System.out.print("Nhap tuoi nhan vien: ");
                newManager.setTuoi(scanner.nextInt());
                System.out.print("Nhap he so luong cua nhan vien ");
                newManager.setHeSoLuong(scanner.nextDouble());
                System.out.print("Nhap ngay vao lam cua nhan vien: ");
                newManager.setNgayVaoLam(scanner.nextLine());
                System.out.print("Nhap so ngay nghi phep: ");
                newManager.setNgayNghiPhep(scanner.nextInt());

                System.out.println("1. Hanh chinh nhan su:");
                System.out.println("2. Cong nghe thong tin:");
                System.out.println("3. Maketing:");
                System.out.println("Nhap bo phan lam viec: ");
                int chonBoPhan = scanner.nextInt();
                if(chonBoPhan == 1){
                    newManager.setBoPhanLamViec("Hanh chinh nhan su");
                }else if (chonBoPhan == 2){
                    newManager.setBoPhanLamViec("Cong nghe thong tin");
                }else if(chonBoPhan == 3){
                    newManager.setBoPhanLamViec("Marketing");
                }

                System.out.println("Chuc danh: ");
                System.out.println("1. Business Leader");
                System.out.println("2. Project Leader");
                System.out.println("3. Technical Leader");
                int chonChucDanh = scanner.nextInt();
                if(chonChucDanh == 1){
                    newManager.setChucDanh("Business Leader");
                }else if(chonChucDanh == 2){
                    newManager.setChucDanh("Project Leader");
                }else if(chonChucDanh == 3){
                    newManager.setChucDanh("Technical Leader");
                }
                StaffList.add(newManager);
            }
            System.out.println("Ban co muon tiep tuc them nhan vien: chon Y/N");
            if(scanner.next().equalsIgnoreCase("n")){
                break;
            }
        }
    }

    public static void inNhanVienTheoBoPhan(){
        for (Department x: DepartmentList){
            System.out.println(x.getTenBoPhan());
            for(Staff y: StaffList){
                if(y.getBoPhanLamViec().equals(x.getTenBoPhan())){
                    y.displayInformation();
                }
            }
        }
    }

    public static  void timKiemNhanVien(){
        System.out.println("Moi ban chon:");
        System.out.println("Chon 1: Tim kiem bang ten nhan vien:");
        System.out.println("Chon 2: Tim kiem bang ma nhan vien:");
        int chon = scanner.nextInt();
        scanner.nextLine();
        if(chon == 1 ) {
            System.out.print("Moi ban nhap ten: ");
            String timKiem = scanner.nextLine();
            for (Staff x : StaffList) {
                if (timKiem.equalsIgnoreCase(x.getHoTen())) {
                    System.out.println("Da tim thay nhan vien: " + timKiem);
                    System.out.printf("%-20s | %-15s | %-4s | %-10s | %-13s | %-20s | %-20s | %-23s | %15s\n", "Ho va ten","Ma nhan vien","Tuoi","HS Luong","Ngay vao lam","Bo phan lam viec", "So ngay nghi phep","So gio lam them/Chuc vu","Luong");
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    x.displayInformation();
                    return;
                }
            }
        }else {
            System.out.print("Moi ban nhap ma nhan vien: ");
            String timKiem = scanner.nextLine();
            for (Staff x: StaffList) {
                if(timKiem.equalsIgnoreCase(x.getMaNhanVien())){
                    System.out.println("Da tim thay nhan vien: " + timKiem);
                    System.out.printf("%-20s | %-15s | %-4s | %-10s | %-13s | %-20s | %-20s | %-23s | %15s\n", "Ho va ten","Ma nhan vien","Tuoi","HS Luong","Ngay vao lam","Bo phan lam viec", "So ngay nghi phep","So gio lam them/Chuc vu","Luong");
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    x.displayInformation();
                    return;
                }
            }
        }
        System.out.println("Khong tim thay nhan vien: ");
    }

    public static void sapXepLuongTangDan(){
        for (int i = 0; i < StaffList.size(); i++){
            for (int j = i + 1; j < StaffList.size(); j++ ){
                Staff nvi = StaffList.get(i);
                Staff nvj = StaffList.get(j);
                if(nvi.getLuong() > nvj.getLuong()){
                    Staff a = nvi;
                    StaffList.set(i, StaffList.get(j));
                    StaffList.set(j, a);
                }
            }
        }
    }
}

