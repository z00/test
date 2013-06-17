package com.sporting;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public class PersistenceConfiguration {

	public static final String UNIT_NAME = "testDS-PU";

	@PersistenceUnit(unitName = UNIT_NAME)
	private EntityManagerFactory entityManagerFactory;

	@Produces
	// @TransactionScoped
	@RequestScoped
	public EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	public void closeEntityManager(@Disposes final EntityManager em) {
		if (em.isOpen()) // this check is optional -not needed if #close doesn't get called by the transactional bean
		{
			em.close();
		}
	}
}
