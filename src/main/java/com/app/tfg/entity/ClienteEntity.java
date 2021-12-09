package com.app.tfg.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "cliente")
public class ClienteEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CLIENTE")
	private Integer id;
	
	@Column(name ="DNIC")
	private String dni;
	
	@Column(name ="nombrec")
	private String nombre;
	
	@Column(name ="apellidoc")
	private String apellidos;
	
	
	@OneToMany(mappedBy = "cliente",cascade=CascadeType.ALL)
	private Collection<ServicioEntity> servicioCollection;
	
	@ManyToOne//(fetch= FetchType.LAZY)
	@JoinColumn(name="cod")
	private TrabajadorEntity trabajador;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Collection<ServicioEntity> getServicioCollection() {
		return servicioCollection;
	}

	public void setServicioCollection(Collection<ServicioEntity> servicioCollection) {
		this.servicioCollection = servicioCollection;
	}

	public TrabajadorEntity getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(TrabajadorEntity trabajador) {
		this.trabajador = trabajador;
	}

	@Override
	public String toString() {
		return "ClienteEntity [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", servicioCollection=" + servicioCollection + ", trabajador=" + trabajador + "]";
	}

}
