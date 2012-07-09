package come.test;

import java.io.Serializable;
import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Alternative;

import org.jboss.seam.security.permission.PermissionResolver;

@Alternative
@SessionScoped
public class SecurityDroolsAlternative implements PermissionResolver, Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public boolean hasPermission(final Object resource, final String permission) {
		return false;
	}

	@Override
	public void filterSetByAction(final Set<Object> resources, final String permission) {

	}

}
