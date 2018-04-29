package es.upm.dit.iss.g16.dao;

import java.util.List;

import es.upm.dit.isst.g16.dao.model.Trabajador;


public interface TrabajadorDAO {
	public Trabajador loginTrabajador(String email, String pass);	
	public List<Trabajador> readAllTrabajador();
	public void createTrabajador( Trabajador trabajador );	
	public Trabajador readTrabajador( String email );	
	public Trabajador updateTrabajador( Trabajador trabajador );	
	public Trabajador deleteTrabajador( Trabajador trabajador );
}
