package com.app.tfg.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name ="servicio")
public class ServicioEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="codservicio")
	private Integer codServicio;
	
	@Column(name ="tiposervicio")
	private String tipoServicio;
	
	@ManyToOne//(fetch= FetchType.LAZY)
	@JoinColumn(name="codcliente")
	private ClienteEntity cliente;

	public Integer getCodServicio() {
		return codServicio;
	}

	public void setCodServicio(Integer codServicio) {
		this.codServicio = codServicio;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}
	



	
	

}
