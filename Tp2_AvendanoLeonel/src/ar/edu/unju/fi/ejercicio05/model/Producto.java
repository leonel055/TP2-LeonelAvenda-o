
package ar.edu.unju.fi.ejercicio05.model;

public class Producto {

	private String codigo;
	private String descripcion;
	private double precioUnitario;
	private boolean band;
	
	
	
	
	public Producto(String codigo, String descripcion, double precioUnitario, boolean band) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.band = band;
	}

	public Producto() {
		super();
	}

	public boolean isBand() {
		return band;
	}

	public void setBand(boolean band) {
		this.band = band;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	public String toString() {

        return "Producto {Codigo: " + codigo + ", Descripcion: " + descripcion  + ", Precio: " + precioUnitario + "}";
        		
    }
}
