package model.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.Table;

import org.hibernate.metadata.ClassMetadata;

import model.filter.FilterSelector;

import static model.FactoryDAO.sessionInstance;
//import static model.FactoryDAO.closeInstance;
import static model.FactoryDAO.sessionFactory;;

public class GenericDAO<T, PK> {

	protected Class<?> manipulada;
	
	protected FilterSelector<T> filter;

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
	public List<T> findAll(FilterSelector<T> selector) {
		return null;
	}

	public StringBuilder buildSQLCommand(T entity) {

		// String className = entity.getClass().getSimpleName();

		Table table = entity.getClass().getAnnotation(Table.class);
		StringBuilder jpql = new StringBuilder("SELECT t FROM " + table.name() + " t ");

//		System.out.println(jpql.toString());
		
		// ClassMetadata hibernateMetadata = sessionFactory().;
		// AbstractEntityPersister persister = (AbstractEntityPersister)
		// hibernateMetadata;
		// String tableName = persister.getTableName();
		// String[] columnNames = persister.getKeyColumnNames();
		return jpql;
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