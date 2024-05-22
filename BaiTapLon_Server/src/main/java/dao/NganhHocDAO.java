package dao;

import java.util.List;

import entities.NganhHoc;

public interface NganhHocDAO {
	public List<NganhHoc> findAll();
	public boolean addNganhHoc(NganhHoc nganhHoc);
	public boolean updateNganhHoc(NganhHoc NganhHoc);
	public boolean deleteNganhHoc(int id);

}
