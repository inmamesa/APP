package com.app.tfg.dominio;

import java.io.Serializable;

public class Servicio implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer codServicio;
	private String tipoServicio;
	
	public Servicio(Integer codServicio, String tipoServicio) {
		super();
		this.codServicio = codServicio;
		this.tipoServicio = tipoServicio;
	}

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
	


}
