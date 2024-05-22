package dao;

import java.util.List;

import entities.MonHoc;
import entities.SinhVien;

public interface MonHocDAO {
	public List<MonHoc> findAll();
	public boolean addMonHoc(MonHoc monHoc);
	public boolean updateMonHoc(MonHoc monHoc);
	public boolean deleteMonHoc(int id);

}
