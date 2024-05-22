package dao;

import java.util.List;

import entities.KetQua;
import entities.SinhVien;

public interface KetQuaDAO {
	public List<KetQua> findAll();
	public boolean addKetQua(KetQua ketQua);
	public boolean updateKetQua(KetQua ketQua);
	public boolean deleteKetQua(int id);

}
