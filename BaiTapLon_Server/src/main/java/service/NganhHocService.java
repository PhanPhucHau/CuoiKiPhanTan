package service;

import java.util.List;

import dao.NganhHocDAO;
import entities.NganhHoc;
import jakarta.persistence.EntityManager;

public class NganhHocService implements NganhHocDAO{
	
	private EntityManager entityManager;
	
	public NganhHocService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<NganhHoc> findAll() {
		return entityManager.createQuery("NganhHoc.findAll", NganhHoc.class).getResultList();
	}

	@Override
	public boolean addNganhHoc(NganhHoc nganhHoc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateNganhHoc(NganhHoc NganhHoc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteNganhHoc(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
