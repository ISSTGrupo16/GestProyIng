package es.upm.dit.iss.g16.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import es.upm.dit.isst.g16.dao.model.Proyecto;
import es.upm.dit.isst.g16.dao.model.Proyecto;

public class ProyectoDAOImplementation implements ProyectoDAO {

	@Override
	public List<Proyecto> readAllProyecto() {
		Session session = SessionFactoryService.get().openSession();
		List<Proyecto> proyecto = new ArrayList<>();
		try {
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Proyecto> criteriaQuery = builder.createQuery(Proyecto.class);
			Root<Proyecto> root = criteriaQuery.from(Proyecto.class);
			criteriaQuery.select(root);
			
			Query<Proyecto> query = session.createQuery(criteriaQuery);
			proyecto.addAll( query.list() );	
	        session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return proyecto;
	}

	@Override
	public void createProyecto(Proyecto proyecto) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.persist(proyecto);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
	}

	@Override
	public Proyecto readProyecto(int id) {
		Session session = SessionFactoryService.get().openSession();
		Proyecto proyecto = null;
		try {
			proyecto = session.get(Proyecto.class, id);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return proyecto;
	}

	@Override
	public void updateProyecto(Proyecto proyecto) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(proyecto);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
	}

	@Override
	public void deleteProyecto(Proyecto proyecto) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(proyecto);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
	}

}
