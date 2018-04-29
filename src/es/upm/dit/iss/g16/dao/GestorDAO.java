package es.upm.dit.iss.g16.dao;

import java.util.List;

import es.upm.dit.isst.g16.dao.model.Gestor;

public interface GestorDAO {
	public Gestor loginGestor(String email, String pass);	
	public List<Gestor> readAllGestor();
	public void createGestor( Gestor gestor );	
	public Gestor readGestor( String email );	
	public void updateGestor( Gestor gestor );	
	public void deleteGestor( Gestor gestor );
}
