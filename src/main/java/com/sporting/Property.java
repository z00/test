package com.sporting;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "properties")
@NamedQueries({ @NamedQuery(name = Property.PROPERTY_QUERY, query = "Select p FROM Property as p where p.key = :"
		+ Property.KEY) })
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Property implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String PROPERTY_QUERY = "propertyQuery";
	public static final String KEY = "key";
	private DBEnum key;
	private String value;

	public Property(final DBEnum key, final String value) {
		this.key = key;
		this.value = value;
	}

	Property() {
	}

	@Id
	@Enumerated(EnumType.STRING)
	@Column(name = "k", length = 128)
	public DBEnum getKey() {
		return key;
	}

	public void setKey(final DBEnum key) {
		this.key = key;
	}

	@Column(name = "v", length = 1024)
	public String getValue() {
		return value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

	@Transient
	public void setTrue() {
		value = "true";
	}

	@Transient
	public void setfalse() {
		value = "false";
	}

	public static boolean getBooleanKeyValue(final DBEnum key, final EntityManager em) {
		final String result = getKeyValue(key, em);
		if (result == null) {
			throw new IllegalArgumentException("No key found for: " + key.toString());
		}
		return Boolean.parseBoolean(result);
	}

	public static String getKeyValue(final DBEnum key, final EntityManager em) {
		try {
			return em.find(Property.class, key).getValue();
		} catch (final Exception e) {
			return null;
		}
	}

	public static Property getProperty(final DBEnum key, final EntityManager em) {
		try {
			return em.find(Property.class, key);
		} catch (final Exception e) {
			return null;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (key == null ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Property)) {
			return false;
		}
		final Property other = (Property) obj;
		if (key != other.key) {
			return false;
		}
		return true;
	}
}
