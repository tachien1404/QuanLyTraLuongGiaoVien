package service;

import java.util.Scanner;

import entity.GVThinhGiang;
import entity.MonHoc;

public class QuanLyMonHoc implements IQuanLy {
	private static MonHoc[] MONHOC = new MonHoc[100];
	@Override
	public void addNew() {
		System.out.print("Nhập số lượng môn học muốn thêm: ");
		int slMonHoc =new Scanner(System.in).nextInt();
		for (int i = 0; i < slMonHoc; i++) {
			System.out.println("Nhập thông tin cho môn học thứ " + (i + 1));
			MonHoc monHoc = new MonHoc();
			monHoc.inputInfo();

			save(monHoc);
		}
		
	}

	@Override
	public void display() {
		for (int i = 0; i < MONHOC.length; i++) {
			if (MONHOC[i] == null) {
				continue;
			}
			System.out.println(MONHOC[i]);
		}
	}
	
	public void save(MonHoc monHoc) {
		for (int j = 0; j < MONHOC.length; j++) {
			if (MONHOC[j] == null) {
				MONHOC[j] = monHoc;
				break;
			}
		}		
	}
	
	public static MonHoc[] showArr() {
		return MONHOC;
	}

}
