package com.sporting.misc;

import java.io.File;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

public class BaseIntegrationTest {

	private BaseIntegrationTest() {
	}

	public static Archive<WebArchive> createTestArchive() {
		File[] libs = Maven.resolver().loadPomFromFile("pom.xml").importRuntimeAndTestDependencies().as(File.class);
		final WebArchive war = ShrinkWrap.create(WebArchive.class, "test.war")
				.setWebXML(new File("src/main/webapp/WEB-INF/web.xml")).addPackages(true, "com.sporting")
				.addPackages(true, "org.drools").addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
				.addAsResource("test-validation.xml", "META-INF/validation.xml")
				.addAsResource("import-test.sql", "import.sql")
				.addAsWebInfResource(new File("src/main/webapp/WEB-INF/pretty-config.xml"))
				.addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"), "beans.xml")
				.addAsWebInfResource(new File("src/main/webapp/WEB-INF/faces-config.xml"), "faces-config.xml")
				.addAsLibraries(libs);

		// .exclusions("com.google.guava:guava:jar:r07",
		// "com.google.collections:google-collections:jar:1.0", "dom4j:dom4j:jar:1.6.1",
		// "org.jboss.arquillian.junit:arquillian-junit-container:jar:1.0.0.CR4")
		// .resolveAs(GenericArchive.class)

		// add everything in /src/main/webapp but filter out .svn directory
		/*
		 * JavaArchive webappFolder = ShrinkWrap.create(JavaArchive.class, "webappFolder.jar");
		 * webappFolder.as(ExplodedImporter.class).importDirectory("src/main/webapp"); war.merge(webappFolder, "", new
		 * Filter<ArchivePath>() {
		 * 
		 * @Override public boolean include(ArchivePath ap) { String path = ap.get(); return (!path.contains(".svn") &&
		 * !path.contains("context.xml")); }
		 * 
		 * });
		 */

		// .addAsLibraries(MavenArtifactResolver.resolve("org.jboss.jsfunit", "jsfunit-arquillian",
		// "2.0.0.Beta1"))
		// .addAsLibraries(MavenArtifactResolver.resolve("org.jboss.jsfunit", "jboss-jsfunit-core",
		// "2.0.0.Beta1"))
		// .addAsWebResource("home.xhtml").addAsWebResource("layout/template.xhtml")
		// .addAsWebResource("layout/sportivityMenu.xhtml").addAsWebResource("components/ajaxBusyDialog.xhtml");
		System.out.println(war.toString(true));
		return war;
	}
}
