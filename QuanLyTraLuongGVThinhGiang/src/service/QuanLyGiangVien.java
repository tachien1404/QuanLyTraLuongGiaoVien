package service;

import java.util.Scanner;

import entity.GVThinhGiang;
import entity.GiangVien;
import entity.MonHoc;

public class QuanLyGiangVien implements IQuanLy {
 static GVThinhGiang[] GIANGVIEN = new GVThinhGiang[100];

	@Override
	public void addNew() {
	System.out.println("Nhập số lượng giảng viên muốn thêm");
	int slGV = new Scanner(System.in).nextInt();
	for(int i= 0;i<slGV;i++) {
		System.out.println("Nhập thông tin cho giảng viên thứ "+(i+1));
		GVThinhGiang gvtg  = new GVThinhGiang();
		gvtg.inputInfo();
		save(gvtg);
	}
	}

	@Override
	public void display() {
		for (int i = 0; i < GIANGVIEN.length; i++) {
			if (GIANGVIEN[i] == null) {
				continue;
			}
			System.out.println(GIANGVIEN[i]);
		}
		
	}

	public void save(GVThinhGiang gvtg) {
		for (int j = 0; j < GIANGVIEN.length; j++) {
			if (GIANGVIEN[j] == null) {
				GIANGVIEN[j] = gvtg;
				break;
			}
		}		
	}
	
	public static GVThinhGiang[] showArr() {
		return GIANGVIEN;
	}
}
