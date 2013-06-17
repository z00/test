package com.sporting;

import java.io.Serializable;
import java.util.UUID;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

/**
 * Manages the current user in session.
 * 
 * @author "Hamzah Zineddin"
 * 
 */
public class CurrentUserManager implements Serializable {

	private static final long serialVersionUID = 1L;

	@Produces
	public LoggedInMemberInfo getCurrentAccount() {
		// for tests
		return new LoggedInMemberInfo(UUID.randomUUID(), "testEmail@sfs.com");
	}

	@Produces
	@RequestScoped
	public FacesContext context() {
		return FacesContext.getCurrentInstance();
	}

}
