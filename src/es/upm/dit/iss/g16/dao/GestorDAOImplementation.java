package es.upm.dit.iss.g16.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import es.upm.dit.isst.g16.dao.model.Gestor;

public class GestorDAOImplementation implements GestorDAO {

	public static GestorDAOImplementation instance;
	private GestorDAOImplementation() { }
	public static GestorDAOImplementation getInstance() {
		if ( null == instance )
			instance = new GestorDAOImplementation();
		return instance;
	}
	
	@Override
	public Gestor loginGestor(String email, String pass) {
		Session session = SessionFactoryService.get().openSession();
		Gestor gestor = null;
		try {
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Gestor> criteriaQuery = builder.createQuery(Gestor.class);
			Root<Gestor> root = criteriaQuery.from(Gestor.class);
			criteriaQuery.select(root)
				.where(builder.and(
						builder.equal(root.get("pass"), pass),
						builder.equal(root.get("email"), email)));
			Query<Gestor> query = session.createQuery(criteriaQuery);
	        gestor = query.getSingleResult();	
	        session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return gestor;
	}

	@Override
	public void createGestor(Gestor gestor) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.persist(gestor);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
	}
	
	@Override
	public List<Gestor> readAllGestor(){
		Session session = SessionFactoryService.get().openSession();
		List<Gestor> gestores = new ArrayList<>();
		try {
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Gestor> criteriaQuery = builder.createQuery(Gestor.class);
			Root<Gestor> root = criteriaQuery.from(Gestor.class);
			criteriaQuery.select(root);
			
			Query<Gestor> query = session.createQuery(criteriaQuery);
			gestores.addAll( query.list() );	
	        session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return gestores;
	}
	
	@Override
	public Gestor readGestor( String email ) {
		Session session = SessionFactoryService.get().openSession();
		Gestor gestor = null;
		try {
			gestor = session.get(Gestor.class, email);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return gestor;
	}
	
	@Override
	public void updateGestor( Gestor gestor ) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(gestor);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
	}
	
	@Override
	public void deleteGestor( Gestor gestor ) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(gestor);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
	}
	
	
	
	
	
	
}
