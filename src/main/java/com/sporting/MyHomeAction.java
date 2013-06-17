package com.sporting;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("myHomeAction")
@ViewScoped
public class MyHomeAction implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(MyHomeAction.class);

	@Inject
	private EntityManager entityManager;

	@Inject
	private Instance<LoggedInMemberInfo> loggedInMemberInfo;

	@SuppressWarnings("unused")
	@PostConstruct
	private void initialize() {
		if (loggedInMemberInfo.get() != null) {
			LOGGER.warn("hit PostConstruct");
		}
	}

	@Transactional
	public List<Property> getMemberFriends() {

		return entityManager.createQuery("FROM Property", Property.class).getResultList();
	}

	public UUID getMemberId() {
		return loggedInMemberInfo.get().getIdAsUUID();
	}

}
