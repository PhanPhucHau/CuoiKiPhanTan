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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "NganhHoc")

@NamedQueries({
	@NamedQuery(name = "NganhHoc.findAll", query = "SELECT nh FROM NganhHoc nh")
})


public class NganhHoc implements Serializable{

	private static final long serialVersionUID = 983815571937518031L;

	@Id
	@Column(name = "maNganh")
	private int id;
	
	private String tenNganh;
	
	@OneToMany(mappedBy = "nganhHoc", fetch = FetchType.LAZY)
	private Set<SinhVien> sinhviens;

	public NganhHoc() {
	}

	public NganhHoc(int id, String tenNganh) {
		this.id = id;
		this.tenNganh = tenNganh;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenNganh() {
		return tenNganh;
	}

	public void setTenNganh(String tenNganh) {
		this.tenNganh = tenNganh;
	}

	@Override
	public String toString() {
		return "NganhHoc [id=" + id + ", tenNganh=" + tenNganh + "]";
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
		NganhHoc other = (NganhHoc) obj;
		return id == other.id;
	}


	
	
	
	
	

}
