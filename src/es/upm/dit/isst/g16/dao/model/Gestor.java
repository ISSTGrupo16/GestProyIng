package es.upm.dit.isst.g16.dao.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Id;

import es.upm.dit.isst.g16.dao.model.Proyecto;

@Entity
public class Gestor implements Serializable{
	
	@Id
	private String email;
	private String pass;
	private String nombre;
	private String apellido;
	private String foto;
	
	@OneToMany(mappedBy = "gestorProyecto", fetch = FetchType.EAGER)
	private List<Proyecto> managedProyects;
	
}