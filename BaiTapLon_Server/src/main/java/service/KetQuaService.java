package service;

import java.util.List;

import dao.KetQuaDAO;
import entities.KetQua;
import jakarta.persistence.EntityManager;

public class KetQuaService implements KetQuaDAO {
	private EntityManager entityManager;
	
	public KetQuaService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<KetQua> findAll() {
		return entityManager.createNamedQuery("KetQua.findAll", KetQua.class).getResultList();
	}

	@Override
	public boolean addKetQua(KetQua ketQua) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateKetQua(KetQua ketQua) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteKetQua(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
