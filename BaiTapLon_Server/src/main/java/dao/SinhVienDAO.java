package dao;

import java.util.List;

import entities.SinhVien;

public interface SinhVienDAO {
	public List<SinhVien> findAll();
	public boolean addSinhVien(SinhVien sinhVien);
	public boolean updateSinhVien(SinhVien sinhVien);
	public boolean deleteSinhVien(int id);
	public SinhVien findSinhVienByID(int id);
	public SinhVien findSinhVienByName(String title);

}
