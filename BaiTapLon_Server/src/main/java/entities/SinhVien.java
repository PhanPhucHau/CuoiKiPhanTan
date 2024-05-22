package entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SinhVien")

@NamedQueries({
	@NamedQuery(name = "SinhVien.findAll", query = "SELECT sv FROM SinhVien sv")
})



public  class SinhVien implements Serializable{

	private static final long serialVersionUID = 1000940541324930283L;

	@Id
	@Column(name = "maSV")
	private int id;
	
	private String tenSV;
	private String gioiTinh;
	private String diaChi;
	
	@OneToOne
	@JoinColumn(name = "maSV")
	private DangNhap dangnhap;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maLop")
	private LopHoc lopHoc;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maNganh")
	private NganhHoc nganhHoc;
	
	
	

	public LopHoc getLopHoc() {
		return lopHoc;
	}




	public void setLopHoc(LopHoc lopHoc) {
		this.lopHoc = lopHoc;
	}




	public NganhHoc getNganhHoc() {
		return nganhHoc;
	}




	public void setNganhHoc(NganhHoc nganhHoc) {
		this.nganhHoc = nganhHoc;
	}


	@OneToMany(mappedBy = "sinhVien", fetch = FetchType.LAZY)
	private Set<KetQua> ketQua;
	
	public SinhVien() {
	}
	
	


	public SinhVien(int id, String tenSV, String gioiTinh, String diaChi, DangNhap dangnhap, LopHoc lopHoc,
			NganhHoc nganhHoc, Set<KetQua> ketQua) {
		super();
		this.id = id;
		this.tenSV = tenSV;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.dangnhap = dangnhap;
		this.lopHoc = lopHoc;
		this.nganhHoc = nganhHoc;
		this.ketQua = ketQua;
	}




	public SinhVien(int id, String tenSV, String gioiTinh, String diaChi) {
		this.id = id;
		this.tenSV = tenSV;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTenSV() {
		return tenSV;
	}


	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}


	public String getGioiTinh() {
		return gioiTinh;
	}


	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}


	@Override
	public String toString() {
		return "SinhVien [id=" + id + ", tenSV=" + tenSV + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVien other = (SinhVien) obj;
		return id == other.id;
	}
	
	
	
	
	

}
