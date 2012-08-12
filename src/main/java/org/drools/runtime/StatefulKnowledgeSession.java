package org.drools.runtime;

import java.util.Collection;

import org.drools.runtime.rule.FactHandle;

public class StatefulKnowledgeSession {

	public void retract(final Object obj) {

	}

	public void fireAllRules() {

	}

	public Collection<Object> getObjects(final ObjectFilter filter) {
		return null;
	}

	public String getEntryPointId() {
		return null;
	}

	public FactHandle insert(final Object object) {
		return null;
	}

	public void retract(final FactHandle handle) {
	}

	public void update(final FactHandle handle, final Object object) {

	}

	public FactHandle getFactHandle(final Object object) {
		return null;
	}

	public Object getObject(final FactHandle factHandle) {
		return null;
	}

	public <T extends FactHandle> Collection<T> getFactHandles() {
		return null;
	}

	public <T extends FactHandle> Collection<T> getFactHandles(final ObjectFilter filter) {
		return null;
	}

	public long getFactCount() {
		return 0;
	}

	public void dispose() {

	}

	public int getId() {
		return 0;
	}
}
