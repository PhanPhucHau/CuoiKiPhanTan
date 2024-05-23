package until;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	public EntityManagerFactoryUtil() {
		entityManagerFactory = Persistence.createEntityManagerFactory("album_server");
		entityManager = entityManagerFactory.createEntityManager();
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	
	

}
