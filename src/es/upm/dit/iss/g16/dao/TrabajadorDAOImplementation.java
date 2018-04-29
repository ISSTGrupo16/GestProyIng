package es.upm.dit.iss.g16.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import es.upm.dit.isst.g16.dao.model.Trabajador;

public class TrabajadorDAOImplementation implements TrabajadorDAO {

	@Override
	public Trabajador loginTrabajador(String email, String pass) {
		Session session = SessionFactoryService.get().openSession();
		Trabajador trabajador = null;
		try {
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Trabajador> criteriaQuery = builder.createQuery(Trabajador.class);
			Root<Trabajador> root = criteriaQuery.from(Trabajador.class);
			criteriaQuery.select(root)
				.where(builder.and(
						builder.equal(root.get("pass"), pass),
						builder.equal(root.get("email"), email)));
			Query<Trabajador> query = session.createQuery(criteriaQuery);
	        trabajador = query.getSingleResult();	
	        session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return trabajador;
	}

	@Override
	public List<Trabajador> readAllTrabajador() {
		Session session = SessionFactoryService.get().openSession();
		List<Trabajador> trabajadores = new ArrayList<>();
		try {
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Trabajador> criteriaQuery = builder.createQuery(Trabajador.class);
			Root<Trabajador> root = criteriaQuery.from(Trabajador.class);
			criteriaQuery.select(root);
			
			Query<Trabajador> query = session.createQuery(criteriaQuery);
			trabajadores.addAll( query.list() );	
	        session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return trabajadores;
	}

	@Override
	public void createTrabajador(Trabajador trabajador) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.persist(trabajador);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
	}

	@Override
	public Trabajador readTrabajador(String email) {
		Session session = SessionFactoryService.get().openSession();
		Trabajador trabajador = null;
		try {
			trabajador = session.get(Trabajador.class, email);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return trabajador;
	}

	@Override
	public void updateTrabajador(Trabajador trabajador) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(trabajador);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
	}

	@Override
	public void deleteTrabajador(Trabajador trabajador) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(trabajador);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}	
	}
}
