package dao;

import java.util.List;

import entities.LopHoc;
import entities.SinhVien;

public interface LopHocDAO {
	public List<LopHoc> findAll();
	public boolean addLopHoc(LopHoc lopHoc);
	public boolean updateLopHoc(LopHoc lopHoc);
	public boolean deleteLopHoc(int id);

}
