package entity;

import java.util.Scanner;

public class GVThinhGiang extends GiangVien {
    public static final String GS_TS = "Giáo sư - Tiến sỹ";
    public static final String PGS_TS = "Phó giáo sư - Tiến sỹ";
    public static final String GVC = "Giảng Viên Chính";
    public static final String TS = "Thạc Sỹ";

	private static int AUTO_ID = -1;

	protected int maGv;
	private String trinhDo;
    
    
	public GVThinhGiang() {
		if (AUTO_ID == -1) {
			AUTO_ID = 100;
			this.maGv = AUTO_ID;
			return;
		}
		this.maGv = ++AUTO_ID;
	}
	

	public GVThinhGiang(int maGv, String trinhDo) {
		super();
		this.maGv = maGv;
		this.trinhDo = trinhDo;
	}




	public int getMaGv() {
		return maGv;
	}


	public String getTrinhDo() {
		return trinhDo;
	}


	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}


	@Override
	public void inputInfo() {
		super.inputInfo();
		 System.out.println("Nhập trình độ giảng viên là 1 trong các lựa chọn dưới đây: ");
	        System.out.println("1. Giáo sư - Tiến sỹ ");
	        System.out.println("2. Phó giáo sư - Tiến sỹ");
	        System.out.println("3. Giảng viên chính");
	        System.out.println("4. Thạc sỹ");
	        System.out.print("Xin mời nhập lựa chọn của bạn: ");
	        int choice = -1;
	        do {
	            choice = new Scanner(System.in).nextInt();
	            if (choice >= 1 && choice <= 4) {
	                break;
	            }
	            System.out.print("Lựa chọn loại khách hàng không hợp lệ, vui lòng chọn lại: ");
	        } while (choice > 4 || choice < 1);
	        switch (choice) {
	            case 1:
	                this.trinhDo = GVThinhGiang.GS_TS;
	                break;
	            case 2:
	                this.trinhDo = GVThinhGiang.PGS_TS;
	                break;
	            case 3:
	                this.trinhDo = GVThinhGiang.GVC;
	                break;
	            case 4:
	                this.trinhDo = GVThinhGiang.TS;
	                break;
	        }
	}
	       
	
	@Override
    public String toString() {
        return "entity.GTThinhGiang{" +
                "maGv=" + maGv +
                ", họ tên='" + tenGV + '\'' +
                ", địa chỉ='" + diaChi + '\'' +
                ", số điện thoại='" + sdt + '\'' +
                ", trình độ='" + trinhDo  + '\'' +
                '}';
    }
}
