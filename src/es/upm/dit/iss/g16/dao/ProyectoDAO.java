package es.upm.dit.iss.g16.dao;

import java.util.List;

import es.upm.dit.isst.g16.dao.model.Proyecto;

public interface ProyectoDAO {
	public List<Proyecto> readAllProyecto();
	public void createProyecto( Proyecto proyecto );	
	public Proyecto readProyecto( int id );	
	public Proyecto updateProyecto( Proyecto proyecto );	
	public Proyecto deleteProyecto( Proyecto proyecto );
}
