package com.sporting;

import java.io.Serializable;
import java.util.UUID;

/**
 * Info about logged in member. Cluster safe.
 * 
 * @author "Hamzah Zineddin"
 * 
 */
public final class LoggedInMemberInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private final UUID id;
	private final String accountEmail;

	public LoggedInMemberInfo(final UUID memberId, final String email) {
		id = memberId;
		this.accountEmail = email;
	}

	public UUID getIdAsUUID() {
		return id;
	}

	public String getId() {
		return id.toString();
	}

	public String getAccountEmail() {
		return accountEmail;
	}
}
