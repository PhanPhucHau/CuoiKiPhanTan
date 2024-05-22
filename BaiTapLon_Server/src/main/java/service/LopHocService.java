package service;

import java.util.List;

import dao.LopHocDAO;
import entities.LopHoc;
import jakarta.persistence.EntityManager;

public class LopHocService implements LopHocDAO{

	private EntityManager entityManager;
	
	public LopHocService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	public List<LopHoc> findAll() {
		return entityManager.createNamedQuery("LopHoc.findAll", LopHoc.class).getResultList();
	}
	@Override
	public boolean addLopHoc(LopHoc lopHoc) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean updateLopHoc(LopHoc lopHoc) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteLopHoc(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
