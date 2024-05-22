package entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DangNhap")
public class DangNhap implements Serializable{

	private static final long serialVersionUID = 335193305703342923L;
	
	@Id
	@Column(name = "taiKhoan")
	private int id;
	private int matkhau;
	

	public DangNhap() {
	}
	
	
	public DangNhap(int id, int matkhau) {
		this.id = id;
		this.matkhau = matkhau;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(int matkhau) {
		this.matkhau = matkhau;
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
		DangNhap other = (DangNhap) obj;
		return id == other.id;
	}


	@Override
	public String toString() {
		return "DangNhap [id=" + id + ", matkhau=" + matkhau + "]";
	}
	
	
	
	
	
	
	
	

}
