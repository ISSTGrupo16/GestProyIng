package es.upm.dit.isst.g16.dao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.Id;

@Entity
public class Proyecto implements Serializable {
	
	@Id
	private int id;
	private String nombre;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private String estadoProyecto;
	
	@ManyToOne
	private String gestorProyecto;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Trabajador> trabajadores;
	
	

}
