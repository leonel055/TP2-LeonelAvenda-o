package ar.edu.unju.fi.ejercicio07;

public class Producto {
	
	private String codigo;
	private String descripcion;
	private double precioUnitario;
	private OrigenFabricacion OrigenFabricacion;
	private Categoria categoria;
	private boolean band;
	
	
	public boolean isBand() {
		return band;
	}


	public void setBand(boolean band) {
		this.band = band;
	}


	public Producto(String codigo, String descripcion, double precioUnitario,
			ar.edu.unju.fi.ejercicio07.Producto.OrigenFabricacion origenFabricacion, Categoria categoria,
			boolean band) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		OrigenFabricacion = origenFabricacion;
		this.categoria = categoria;
		this.band = band;
	}


	public Producto() {
		super();
	}

	
	public OrigenFabricacion getOrigenFabricacion() {
		return OrigenFabricacion;
	}
	public void setOrigenFabricacion(OrigenFabricacion origenFabricacion) {
		OrigenFabricacion = origenFabricacion;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
	
	public enum OrigenFabricacion{
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}
	public enum Categoria{
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}
	public String toString() {

        return "Producto {Codigo: " + codigo + ", Descripcion: " + descripcion  + ", Precio Unitario: $" + precioUnitario
        		+ ", Origen de Fabricacion: " + OrigenFabricacion + ", Categoria: " + categoria  + "}";
        		
    }
}