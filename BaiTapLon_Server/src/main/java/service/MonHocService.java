package service;

import java.util.List;

import dao.MonHocDAO;
import entities.MonHoc;
import jakarta.persistence.EntityManager;

public class MonHocService implements MonHocDAO {
	private EntityManager entityManager;
	
	public MonHocService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<MonHoc> findAll() {
		return entityManager.createNamedQuery("MonHoc.findAll", MonHoc.class).getResultList();
	}

	@Override
	public boolean addMonHoc(MonHoc monHoc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMonHoc(MonHoc monHoc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMonHoc(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
