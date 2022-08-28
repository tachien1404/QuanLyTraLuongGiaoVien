package entity;

public class QuanLyGiangDay {
	private GVThinhGiang giaoVienThinhGiang;
	private ChiTietGiangDay[] chiTietGiangDay;

	public GVThinhGiang getGiaoVienThinhGiang() {
		return giaoVienThinhGiang;
	}

	public void setGiaoVienThinhGiang(GVThinhGiang giaoVienThinhGiang) {
		this.giaoVienThinhGiang = giaoVienThinhGiang;
	}

	public ChiTietGiangDay[] getChiTietGiangDay() {
		return chiTietGiangDay;
	}

	public void setChiTietGiangDay(ChiTietGiangDay[] chiTietGiangDay) {
		this.chiTietGiangDay = chiTietGiangDay;
	}

}
