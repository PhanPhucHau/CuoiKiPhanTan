package entities;

import java.io.Serializable;
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
@Table(name = "MonHoc")

@NamedQueries({
	@NamedQuery(name = "MonHoc.findAll", query = "SELECT mh FROM MonHoc mh")
})

public class MonHoc implements Serializable{

	private static final long serialVersionUID = 2005202962079456190L;
	@Id
	@Column(name = "maMH")
	private int id;
	private String tenMH;
	private int soTiet;
	
	@OneToMany(mappedBy = "monHoc", fetch = FetchType.LAZY)
	private Set<KetQua> ketQua;
	
	
	public MonHoc() {
	}


	public MonHoc(int id, String tenMH, int soTiet) {
		this.id = id;
		this.tenMH = tenMH;
		this.soTiet = soTiet;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTenMH() {
		return tenMH;
	}


	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}


	public int getSoTiet() {
		return soTiet;
	}


	public void setSoTiet(int soTiet) {
		this.soTiet = soTiet;
	}


	@Override
	public String toString() {
		return "MonHoc [id=" + id + ", tenMH=" + tenMH + ", soTiet=" + soTiet + "]";
	}
	
	
	
	
	
	

}
