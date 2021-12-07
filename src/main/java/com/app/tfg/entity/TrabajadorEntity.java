package com.app.tfg.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "trabajador")
public class TrabajadorEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="cod")
	private Integer codigo;

	@Column(name = "dni")
	private String dni;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name ="apellido")
	private String apellido;
	
	@OneToMany(mappedBy = "trabajador")
	private Collection<ClienteEntity> clienteCollection;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Collection<ClienteEntity> getClienteCollection() {
		return clienteCollection;
	}

	public void setClienteCollection(Collection<ClienteEntity> clienteCollection) {
		this.clienteCollection = clienteCollection;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "TrabajadorEntity [codigo=" + codigo + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", clienteCollection=" + clienteCollection + "]";
	}

}
