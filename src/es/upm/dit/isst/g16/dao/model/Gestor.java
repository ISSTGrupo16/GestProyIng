package es.upm.dit.isst.g16.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
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
	private List<Proyecto> managedProjects;
	
	//Constructor
	public Gestor() {
		this.managedProjects = new ArrayList<>();
	}
	
	//Getters
	public String getEmail() {
		return this.email;
	}
	
	public String getPass() {
		return this.pass;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public String getFoto() {
		return this.foto;
	}
	
	public List<Proyecto> getManagedProjects() {
		return this.managedProjects;
	}
	
	//setters
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public void setManagedProjects(List<Proyecto> managedProjects) {
		this.managedProjects = managedProjects;
	}
}