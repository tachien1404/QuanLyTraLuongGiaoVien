package entity;

import java.util.Scanner;

public class GiangVien {

	protected String tenGV;
	protected String diaChi;
	protected String sdt;

	
	public String getTenGV() {
		return tenGV;
	}

	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public void inputInfo() {
		System.out.println("Nhập tên giảng viên:");
		this.tenGV = new Scanner(System.in).nextLine();
		System.out.println("Nhập địa chỉ của giảng viên:");
		this.diaChi = new Scanner(System.in).nextLine();
		System.out.println("Nhập số điện thoại của giảng viên");
		this.sdt = new Scanner(System.in).nextLine();
	}

}
