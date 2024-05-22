package entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "KetQua")

@NamedQueries({
	@NamedQuery(name = "KetQua.findAll", query = "SELECT kq FROM KetQua kq")
})


public class KetQua  implements Serializable{

	private static final long serialVersionUID = 8668373595768967581L;

	@Id
	private int hocKi;
	private double diemTK;
	private double diemGK;
	private double diemCK;
	private double diemTB;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maSV")
	private SinhVien sinhVien;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maMH")
	private MonHoc monHoc;
	
	
	
	public KetQua() {
	}

	public KetQua(int hocKi, double diemTK, double diemGK, double diemCK, double diemTB) {
		this.hocKi = hocKi;
		this.diemTK = diemTK;
		this.diemGK = diemGK;
		this.diemCK = diemCK;
		this.diemTB = diemTB;
	}
	
	

	public int getHocKi() {
		return hocKi;
	}

	public void setHocKi(int hocKi) {
		this.hocKi = hocKi;
	}

	public double getDiemTK() {
		return diemTK;
	}

	public void setDiemTK(double diemTK) {
		this.diemTK = diemTK;
	}

	public double getDiemGK() {
		return diemGK;
	}

	public void setDiemGK(double diemGK) {
		this.diemGK = diemGK;
	}

	public double getDiemCK() {
		return diemCK;
	}

	public void setDiemCK(double diemCK) {
		this.diemCK = diemCK;
	}

	public double getDiemTB() {
		return diemTB;
	}

	public void setDiemTB(double diemTB) {
		this.diemTB = diemTB;
	}

	@Override
	public String toString() {
		return "KetQua [hocKi=" + hocKi + ", diemTK=" + diemTK + ", diemGK=" + diemGK + ", diemCK=" + diemCK
				+ ", diemTB=" + diemTB + "]";
	}
	
	
	
	
	
	
	
	

	
	
	

	
	
	
	

}
