package com.sporting;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Startup
public class DBLoader implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(DBLoader.class);

	@PersistenceContext(unitName = "testDS-PU")
	private EntityManager entityManager;

	@Resource
	private TimerService timerService;

	@TransactionAttribute
	@PostConstruct
	public void setup() {
		LOGGER.warn("DBLoader setup ThreadID: " + Thread.currentThread().getName());
		timerService.createSingleActionTimer(0, new TimerConfig(null, false));
	}

	@Timeout
	public void start() {
		LOGGER.warn("DBLoader start ThreadID: " + Thread.currentThread().getName());
		Property p = new Property(DBEnum.TOMEE, "long weekend testing");
		entityManager.persist(p);
		Property property = Property.getProperty(DBEnum.TOMEE, entityManager);
		if (property != null) {
			LOGGER.info("found prop: " + property.getValue());
		}
	}
}
