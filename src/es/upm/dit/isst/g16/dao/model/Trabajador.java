package es.upm.dit.isst.g16.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Trabajador implements Serializable{
	
	@Id
	private String email;
	private String pass;
	private String nombre;
	private String apellido;
	private String foto;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="trabajadores", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private List<Proyecto> proyectos;
	
	//Constructor
	public Trabajador() {
		this.proyectos = new ArrayList<>();
	}
	//getters
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
	public List<Proyecto> getProyectos(){
		return this.proyectos;
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
	public void setproyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
}
