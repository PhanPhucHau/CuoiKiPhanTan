package entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "LopHoc")

@NamedQueries({
	@NamedQuery(name = "LopHoc.findAll", query = "SELECT lh FROM LopHoc lh")
})



public class LopHoc implements Serializable{

	private static final long serialVersionUID = 2889971148040776733L;

	@Id
	@Column(name = "maLop")
	private int id;
	
	private String tenLop;
	
	private String giaoVienCN;
	
	@OneToMany(mappedBy = "lopHoc", fetch = FetchType.LAZY)
	private Set<SinhVien> sinhviens;
	
	

	public LopHoc() {
	}

	public LopHoc(int id, String tenLop) {
		this.id = id;
		this.tenLop = tenLop;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	@Override
	public String toString() {
		return "LopHoc [id=" + id + ", tenLop=" + tenLop + "]";
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
		LopHoc other = (LopHoc) obj;
		return id == other.id;
	}
	
	
	
	

}
