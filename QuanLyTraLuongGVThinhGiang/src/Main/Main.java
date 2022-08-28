package Main;

import java.util.Scanner;

import entity.ChiTietGiangDay;
import entity.GVThinhGiang;
import entity.GiangVien;
import entity.MonHoc;
import entity.QuanLyGiangDay;
import service.QuanLyGiangVien;
import service.QuanLyMonHoc;

public class Main {
	private static GVThinhGiang[] GIANGVIEN = QuanLyGiangVien.showArr();
	private static MonHoc[] MONHOC = QuanLyMonHoc.showArr();
	private static QuanLyGiangDay[] QUANLYGIANGDAY = new QuanLyGiangDay[100];
	private static QuanLyMonHoc QLMH = new QuanLyMonHoc();
	private static QuanLyGiangVien QLGV = new QuanLyGiangVien();

	public static void main(String[] args) {
		showMenu();
	}

	private static void showMenu() {
		while (true) {
			int functionChoice = functionChoice();
			switch (functionChoice) {
			case 1:
				QLMH.addNew();
				;
				break;
			case 2:
				QLMH.display();
				;
				break;
			case 3:
				QLGV.addNew();
				break;
			case 4:
				QLGV.display();
				break;
			case 5:
				taoQuanLyGiangDay();
				showAllGiangDay();
				break;
			case 6:
				sxTheoTen();
				break;
			case 7:
				sxTheoSL();
				break;
			case 8:
				tinhTienCong();
				break;
                case 9:
                    System.out.println("Xin cảm ơn đã sử dụng phần mềm của chúng tôi!");
                    return;
			}
		}
	}

	private static int functionChoice() {
		System.out.println(
				"\n\n_________________Phần mềm quản lý trả lương cho giảng viên thỉnh giảng_______________\n\n");
		System.out.println("1. Nhập danh sách môn học mới mới.");
		System.out.println("2. In ra danh sách môn học trong hệ thống.");
		System.out.println("3. Nhập danh sách giảng viên mới.");
		System.out.println("4. In ra danh sách giảng viên trong hệ thống.");
		System.out.println("5. Lập bảng kê khai giảng dạy .");
		System.out.println("6. Sắp xếp danh sách kê khai theo họ tên khách hàng.");
		System.out.println("7. Sắp xếp danh sách kê khai theo số tiết giảng dạy");
		System.out.println("8. Lập bảng thống kê số tiền công cho giảng viên");
		System.out.println("9. Thoát chương trình");
		System.out.println("--------------------------------------");
		System.out.print("Xin mời nhập lựa chọn của bạn: ");
		int functionChoice = -1;
		do {
			functionChoice = new Scanner(System.in).nextInt();
			if (functionChoice >= 1 && functionChoice <= 9) {
				break;
			}
			System.out.print("Chức năng được chọn không hợp lệ, vui lòng chọn lại: ");
		} while (functionChoice > 9 || functionChoice < 1);
		return functionChoice;
	}

	/**/
	private static void taoQuanLyGiangDay() {
		if (!checkData()) {
			System.out.println("Chưa có dữ liệu về giảng viên hoặc môn học, hãy nhập thông tin trước");
			return;
		}

		System.out.println("Nhập số lượng giảng viên muốn quản lý:");
		int sl = new Scanner(System.in).nextInt();
		for (int i = 0; i < sl; i++) {
			QuanLyGiangDay qlgd = new QuanLyGiangDay();
			// xác định giảng viên
			GVThinhGiang giangVien = nhapGiangVien(i);
			qlgd.setGiaoVienThinhGiang(giangVien);

			// xác nhận gv dạy những môn nào
			ChiTietGiangDay[] ctgd = taoChiTietGiangDay();
			qlgd.setChiTietGiangDay(ctgd);

			luuQuanLyGiangDay(qlgd);
		}
	}

	/**/
	private static boolean checkData() {
		boolean duLieuGv = false;
		for (int i = 0; i < GIANGVIEN.length; i++) {
			if (GIANGVIEN[i] != null) {
				duLieuGv = true;
				break;
			}
		}
		boolean duLieuMh = false;
		for (int i = 0; i < MONHOC.length; i++) {
			if (MONHOC[i] != null) {
				duLieuMh = true;
				break;
			}
		}
		return duLieuGv && duLieuMh;
	}

	/**/
	private static GVThinhGiang nhapGiangVien(int index) {
		System.out.print("Nhập mã giảng viên " + (index + 1) + " muốn quản lý: ");
		int maGv;
		GVThinhGiang giangVien;
		do {
			maGv = new Scanner(System.in).nextInt();
			// checkDl giảng viên trong hệ thống
			giangVien = timTheoMaGV(maGv);
			if (giangVien != null) {
				break;
			}
			System.out.print("Không tồn tại giảng viên có mãlà " + maGv + ", vui lòng nhập lại: ");
		} while (true);
		return giangVien;
	}

	/**/
	private static GVThinhGiang timTheoMaGV(int maGv) {
		for (int i = 0; i < GIANGVIEN.length; i++) {
			GVThinhGiang gv = GIANGVIEN[i];
			if (gv != null && gv.getMaGv() == maGv) {
				return gv;
			}
		}
		return null;
	}

	/**/
	private static ChiTietGiangDay[] taoChiTietGiangDay() {
		System.out.println("Nhập số lượng môn giảng viên quản lý:");
		int slMon = new Scanner(System.in).nextInt();

		ChiTietGiangDay[] CTGD = new ChiTietGiangDay[slMon];
		for (int i = 0; i < slMon; i++) {
			ChiTietGiangDay ctgd = new ChiTietGiangDay();
			MonHoc monHoc = nhapMonHoc(i);
			ctgd.setMonHoc(monHoc);

			System.out.println("nhập số lượng lớp giảng viên quản lý");
			int slLop;

			do {
				slLop = new Scanner(System.in).nextInt();
				if (slLop > 0 && slLop <= 3) {
					break;
				}
				System.out.println("Số lớp cho mỗi môn không được lớn hơn 3 và là số nguyên dương");
			} while (true);
			ctgd.setSoLop(slLop);

			// lưu chi tiết giảng dạy vào giảng dạy gv
			for (int j = 0; j < CTGD.length; j++) {
				if (CTGD[i] == null) {
					CTGD[i] = ctgd;
					break;
				}
			}
		}
		return CTGD;
	}

	/**/
	private static MonHoc nhapMonHoc(int index) {
		System.out.println("nhập mã môn học thứ " + (index + 1) + " mà giảng viên giảng  dạy:  ");
		int maMh;
		MonHoc monHoc;
		do {
			maMh = new Scanner(System.in).nextInt();
			monHoc = timTheoMaMonHoc(maMh);
			if (monHoc != null) {
				break;
			}
			System.out.println("Không tồn tạo môn học nào có mã là  " + maMh + "  vui lòng nhập lại");
		} while (true);
		return monHoc;
	}

	/**/
	private static MonHoc timTheoMaMonHoc(int maMh) {
		for (int i = 0; i < MONHOC.length; i++) {
			MonHoc mh = MONHOC[i];
			if (mh != null && mh.getMaMonHoc() == maMh) {
				return mh;
			}
		}
		return null;
	}

	/**/
	private static void luuQuanLyGiangDay(QuanLyGiangDay qlgd) {
		for (int i = 0; i < QUANLYGIANGDAY.length; i++) {
			if (QUANLYGIANGDAY[i] == null) {
				QUANLYGIANGDAY[i] = qlgd;
				return;
			}
		}
	}

	/**/
	private static void showAllGiangDay() {
		for (int i = 0; i < QUANLYGIANGDAY.length; i++) {
			QuanLyGiangDay qlgd = QUANLYGIANGDAY[i];
			if (qlgd != null) {
				System.out.println("Giảng viên" + qlgd.getGiaoVienThinhGiang().getTenGV() + "đã dạy những môn:");
				for (int j = 0; j < qlgd.getChiTietGiangDay().length; j++) {
					System.out.println(qlgd.getChiTietGiangDay()[j]);
				}
				System.out.println();
			}
		}
	}

	/**/
	private static void sxTheoTen() {
		// kiểm tra đã có dữ liệu hay chưa
		boolean coDuLieu = false;
		for (int i = 0; i < QUANLYGIANGDAY.length; i++) {
			if (QUANLYGIANGDAY[i] != null) {
				coDuLieu = true;
			}
		}
		if (!coDuLieu) {
			System.out.println(
					"chưa có danh sách kê khai giảng dạy nào trong hệ thống trước khi thực hiện tính năng này.");
			return;
		}
		sxtt();
		showAllGiangDay();
	}

	/**/
	private static void sxtt() {
		for (int i = 0; i < QUANLYGIANGDAY.length - 1; i++) {
			QuanLyGiangDay qlgd1 = QUANLYGIANGDAY[i];
			for (int j = i + 1; j < QUANLYGIANGDAY.length; j++) {
				QuanLyGiangDay qlgd2 = QUANLYGIANGDAY[j];
				if (qlgd1.getGiaoVienThinhGiang().getTenGV().compareTo(qlgd2.getGiaoVienThinhGiang().getTenGV()) > 0) {
					QuanLyGiangDay temp = qlgd1;
					qlgd1 = qlgd2;
					qlgd2 = temp;
				}
			}
		}
	}

	/**/
	private static void sxTheoSL() {
		// kiểm tra đã có dữ liệu hay chưa
		boolean coDuLieu = false;
		for (int i = 0; i < QUANLYGIANGDAY.length; i++) {
			if (QUANLYGIANGDAY[i] != null) {
				coDuLieu = true;
			}
		}
		if (!coDuLieu) {
			System.out.println(
					"chưa có danh sách kê khai giảng dạy nào trong hệ thống trước khi thực hiện tính năng này.");
			return;
		}
		sxsl();
		showAllGiangDay();
	}

	/**/
	private static void sxsl() {
		for (int i = 0; i < QUANLYGIANGDAY.length - 1; i++) {
			QuanLyGiangDay qlgd1 = QUANLYGIANGDAY[i];
			for (int j = i + 1; j < QUANLYGIANGDAY.length; j++) {
				QuanLyGiangDay qlgd2 = QUANLYGIANGDAY[j];
				if (qlgd1.getChiTietGiangDay()[i].getMonHoc().getTongSoTiet() > qlgd2.getChiTietGiangDay()[j].getMonHoc().getTongSoTiet()) {
					QuanLyGiangDay temp = qlgd1;
					qlgd1 = qlgd2;
					qlgd2 = temp;
				}
			}
		}
	}
	
	private static void tinhTienCong() {
        // kiểm tra xem trong ORDER đã có dữ liệu hay chưa
        boolean coDuLieu = false;
        for (int i = 0; i < QUANLYGIANGDAY.length; i++) {
            if (QUANLYGIANGDAY[i] != null) {
            	coDuLieu = true;
            }
        }
        if (!coDuLieu) {
            System.out.println("Chưa có dl trong hệ thống, vui lòng tạo thông tin danh sách kê khai giảng dạy trước khi thực hiện tính năng này.");
            return;
        }

        for (int i = 0; i < QUANLYGIANGDAY.length; i++) {
            QuanLyGiangDay qlgd = QUANLYGIANGDAY[i];
            if (qlgd == null) {
                continue;
            }
            int tienLuong = 0;
            ChiTietGiangDay[] ctdg = qlgd.getChiTietGiangDay();
            for (int j = 0; j < ctdg.length; j++) {
                ChiTietGiangDay ctgd = ctdg[j];
                tienLuong += (ctgd.getMonHoc().getMucKinhPhi() * ctgd.getMonHoc().getSoTietLyThuyet() +
               +(ctgd.getMonHoc().getMucKinhPhi()*0.7*(ctgd.getMonHoc().getTongSoTiet()-ctgd.getMonHoc().getSoTietLyThuyet())))*(ctgd.getSoLop());;
            }
            System.out.println("Giảng viên " + qlgd.getGiaoVienThinhGiang().getTenGV() + " được nhận " + tienLuong + "VND");
        }
    }

}
