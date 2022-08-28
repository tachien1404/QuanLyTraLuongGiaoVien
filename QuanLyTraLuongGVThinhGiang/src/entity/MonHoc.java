package entity;

import java.util.Scanner;

public class MonHoc {
	private static int AUTO_ID = -1;
	private int maMonHoc;
	private String tenMon;
	private int tongSoTiet;
	private int soTietLyThuyet;
	private double mucKinhPhi;

	public static int getAUTO_ID() {
		return AUTO_ID;
	}

	public MonHoc() {
		if (AUTO_ID == -1) {
			AUTO_ID = 100;
			this.maMonHoc = ++AUTO_ID;
			return;
		}
		this.maMonHoc = ++AUTO_ID;
	}

	public int getMaMonHoc() {
		return maMonHoc;
	}

	public String getTenMon() {
		return tenMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}

	public int getTongSoTiet() {
		return tongSoTiet;
	}

	public void setTongSoTiet(int tongSoTiet) {
		this.tongSoTiet = tongSoTiet;
	}

	public int getSoTietLyThuyet() {
		return soTietLyThuyet;
	}

	public void setSoTietLyThuyet(int soTietLyThuyet) {
		this.soTietLyThuyet = soTietLyThuyet;
	}

	public double getMucKinhPhi() {
		return mucKinhPhi;
	}

	public void setMucKinhPhi(double mucKinhPhi) {
		this.mucKinhPhi = mucKinhPhi;
	}

	@Override
	public String toString() {
		return "entity.MonHoc{" + " mã môn học=" + maMonHoc + ", tên môn học='" + tenMon + '\'' + ", Tổng số tiết='"
				+ tongSoTiet + '\'' + ", Số tiết lý thuyết='" + soTietLyThuyet + '\'' + ", Mức kinh phí='" + mucKinhPhi
				+ '\'' + '}';
	}

	public void inputInfo() {
		System.out.print("Nhập tên môn học : ");
		this.tenMon = new Scanner(System.in).nextLine();
		System.out.print("Nhập tổng số tiết dạy: ");

		do {
			this.tongSoTiet = new Scanner(System.in).nextInt();
			if (tongSoTiet >= 1 && tongSoTiet <= 200) {
				break;
			}
			System.out.println("tổng số tiết không được lớn hơn 200, vui lòng nhập lại");
		} while (tongSoTiet > 200 || tongSoTiet < 1);

		System.out.print("Nhập số tiết lý thuyết: ");

		do {
			this.soTietLyThuyet = new Scanner(System.in).nextInt();
			if (soTietLyThuyet >= 1 && soTietLyThuyet <= tongSoTiet) {
				break;
			}
			System.out.println("số tiết lý thuyết không thể lớn hơn tổng số tiết, vui lòng nhập lại");
		} while (soTietLyThuyet > tongSoTiet || tongSoTiet < 1);
		System.out.print("Nhập mức kinh phí: ");
		this.mucKinhPhi = new Scanner(System.in).nextDouble();
	}

}
