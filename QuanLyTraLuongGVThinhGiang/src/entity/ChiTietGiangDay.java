package entity;

public class ChiTietGiangDay {
 private MonHoc monHoc;
 private int soLop;
public MonHoc getMonHoc() {
	return monHoc;
}
public void setMonHoc(MonHoc monHoc) {
	this.monHoc = monHoc;
}
public int getSoLop() {
	return soLop;
}
public void setSoLop(int soLop) {
	this.soLop = soLop;
}
 
@Override
public String toString() {
    return "ChiTietGiangDay{" +
            "môn học=" + monHoc +
            ", số lớp=" + soLop +
            '}';
}
}
