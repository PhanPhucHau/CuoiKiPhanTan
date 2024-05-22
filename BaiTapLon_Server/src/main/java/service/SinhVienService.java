package service;

import java.util.List;

import dao.SinhVienDAO;
import entities.SinhVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class SinhVienService implements SinhVienDAO{
	
	private EntityManager entityManager;
	
	public SinhVienService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<SinhVien> findAll() {	
		return entityManager.createNamedQuery("SinhVien.findAll", SinhVien.class).getResultList();
	}

	@Override
	public boolean addSinhVien(SinhVien sinhVien) {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.persist(sinhVien);
			trans.commit();
			return true;
		} catch (Exception e) {
			if (trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateSinhVien(SinhVien sinhVien) {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.merge(sinhVien);
			trans.commit();
			return true;
		} catch (Exception e) {
			if(trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
		}	
		return false;
	}

	@Override
	public boolean deleteSinhVien(int id) {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			SinhVien sinhVien = entityManager.find(SinhVien.class, id);
			entityManager.remove(sinhVien);
			trans.commit();
			return true;
		} catch (Exception e) {

			if (trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
		}
	
		return false;
	}

	@Override
	public SinhVien findSinhVienByID(int id) {
		return entityManager.find(SinhVien.class, id);
	}

	@Override
	public SinhVien findSinhVienByName(String title) {
		return entityManager.createQuery("SELECT sv  FROM SinhVien sv WHERE sv.tenSV =: tenSV", SinhVien.class).setParameter("tenSV", title).getSingleResult();
	}

}
