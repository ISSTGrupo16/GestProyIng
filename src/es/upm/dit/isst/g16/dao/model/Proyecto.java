package es.upm.dit.isst.g16.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
	private Gestor gestorProyecto;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Trabajador> trabajadores;
	
	//Constructor
	public Proyecto() {
		this.trabajadores = new ArrayList<>();
	}
	
	//Getters
	public int getId() {
		return this.id;
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
	public Date getFechaInicio() {
		return this.fechaInicio;
	}
	public Date getFechaFin() {
		return this.fechaFin;
	}
	public String getEstadoProyecto() {
		return this.estadoProyecto;
	}
	public Gestor getGestorProyecto() {
		return this.gestorProyecto;
	}
	public List<Trabajador> getTreabajadores(){
		return this.trabajadores;
	}
	
	//Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public void setEstadoProyecto (String estadoProyecto) {
		this.estadoProyecto = estadoProyecto;
	}
	public void setGestorProyecto(Gestor gestorProyecto) {
		this.gestorProyecto = gestorProyecto;
	}
	public void setTrabajadores(List<Trabajador> trabajadores) {
		this.trabajadores = trabajadores;
	}
}
