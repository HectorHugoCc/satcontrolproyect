package sac.millennium.model;

public class Menu {

	private String id;
	private int contenedor;
	private int ordenAparicion;
	private String nombreOpcion;
	private String formularioAsociado;
	private String estado;

	/*
	 * getters & setters
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getContenedor() {
		return contenedor;
	}

	public void setContenedor(int contenedor) {
		this.contenedor = contenedor;
	}

	public int getOrdenAparicion() {
		return ordenAparicion;
	}

	public void setOrdenAparicion(int ordenAparicion) {
		this.ordenAparicion = ordenAparicion;
	}

	public String getNombreOpcion() {
		return nombreOpcion;
	}

	public void setNombreOpcion(String nombreOpcion) {
		this.nombreOpcion = nombreOpcion;
	}

	public String getFormularioAsociado() {
		return formularioAsociado;
	}

	public void setFormularioAsociado(String formularioAsociado) {
		this.formularioAsociado = formularioAsociado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
