package com.sporting.misc;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class EverythingTest {

	@Deployment
	public static Archive<WebArchive> setup() {
		return BaseIntegrationTest.createTestArchive();
	}

	@PersistenceContext(unitName = "testDS-PU")
	private EntityManager em;

	@Test
	public void loginTest() {
		// credentials.setCredential(new PasswordCredential("member0"));
		// credentials.setUsername("member0@sportivity.com");
		// ident.login();

	}

}
