package model.dao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Query;
import javax.persistence.Table;

import org.hibernate.metadata.ClassMetadata;

import model.filter.FilterBuilder;

import static model.FactoryDAO.sessionInstance;
//import static model.FactoryDAO.closeInstance;
import static model.FactoryDAO.sessionFactory;;

public class GenericDAO<T, PK> {

	protected Class<?> manipulada;

	protected FilterBuilder<T> filter;

	public GenericDAO() {
		super();
		this.manipulada = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	protected Class<?> getManipulada() {
		return manipulada;
	}

	protected void setManipulada(Class<?> manipulada) {
		this.manipulada = manipulada;
	}

	// CRUD

	public T save(T entity) {
		try {
			sessionInstance().beginTransaction();
			sessionInstance().persist(entity);
			sessionInstance().getTransaction().commit();
			sessionInstance().refresh(entity);

		} catch (Exception e) {
			sessionInstance().getTransaction().rollback();
			throw e;
		} finally {
			// closeInstance();
		}
		return entity;
	}

	public T update(T entity) {
		try {
			sessionInstance().beginTransaction();
			sessionInstance().merge(entity);
			sessionInstance().getTransaction().commit();
			sessionInstance().refresh(entity);

		} catch (Exception e) {
			sessionInstance().getTransaction().rollback();
			throw e;
		} finally {
			// closeInstance();
		}
		return entity;
	}

	public void delete(PK pk) {
		try {
			sessionInstance().beginTransaction();

			T entity = findById(pk);

			sessionInstance().remove(entity);
			sessionInstance().getTransaction().commit();
			// return true;

		} catch (Exception e) {
			sessionInstance().getTransaction().rollback();
			throw e;

		} finally {
			// closeInstance();
		}

	}

	public Object executeQuery(String query, Object... params) {
		Query createQuery = sessionInstance().createQuery(query);

		for (int i = 0; i < params.length; i++) {
			createQuery.setParameter(i, params[i]);
		}

		return createQuery.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {

		List<T> retorno = sessionInstance().createQuery(("FROM " + this.manipulada.getName())).getResultList();
		// closeInstance();

		return retorno;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(FilterBuilder<T> selector) {
		return null;
	}

	public StringBuilder buildSQLCommand(T entity) {

		if(entity != null) {
			
			Class<? extends Object> c = entity.getClass();
			
			Map<String, String> mappedEntity = paramsCorverter(entity);
			
			Table table = c.getAnnotation(Table.class);
			StringBuilder jpql = new StringBuilder("SELECT t FROM " + table.name() + " t");
			
			if (mappedEntity != null && mappedEntity.size() > 0) {
				
				jpql.append(" WHERE ");
				
				boolean frst = true;
				for (Map.Entry<String, String> entry : mappedEntity.entrySet()) {
					
					if (!frst) {
						jpql.append(" AND ");
					} else {
						frst = false;
					}
					
					jpql.append("'" + entry.getKey() + "'" + " = " + "'" + entry.getValue() + "'");
				}
			}
			return jpql;			
		}
		return null;
	}

	private Map<String, String> paramsCorverter(T entity) {

		Class<? extends Object> c = entity.getClass();

		Map<String, String> mappedEntity = null;
		Field[] fields = c.getDeclaredFields();

		for (Field f : fields) {
			f.setAccessible(true);

			String column = null;
			String value = null;

			Column col = f.getAnnotation(Column.class);

			if (col != null && !col.name().equals("")) {
				column = col.name();
			} else {
				if (!f.getName().equals("serialVersionUID")) {
					column = f.getName();
				}
			}

			Object o = null;
			try {
				o = f.get(entity);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			if (o != null) {
				if (f.getType() == Calendar.class) {

					SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
					Calendar cc = (Calendar) o;
					String formatted = simple.format(cc.getTime());
					value = formatted;

				} else {
					if (f.getType() != List.class && f.getType() != ArrayList.class) {
						value = String.valueOf(o);
					}
				}
			}

			if (column != null && value != null) {

				if (mappedEntity != null) {
					mappedEntity.put(column, value);

				} else {
					mappedEntity = new HashMap<>();
					mappedEntity.put(column, value);
				}
			}
		}
		return mappedEntity;
	}

	@SuppressWarnings("unchecked")
	public T findById(PK pk) {
		T retorno;

		try {
			retorno = (T) sessionInstance().find(this.manipulada, pk);
		} catch (Exception e) {
			throw e;
		} finally {
			// closeInstance();
		}

		return retorno;
	}

}