
package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

public class PagoEfectivo implements Pago{
	
    private LocalDate fecPago;
	private double montoPagado;

	public PagoEfectivo(double montoPagado, LocalDate fecPago) {
		super();
		this.fecPago = fecPago;
		this.montoPagado = montoPagado;
	}
	

	public void realizarPago(double monto) {
	        this.montoPagado = monto * 0.90; 
	    }
	
	 public void imprimirRecibo() {
	        System.out.println("Fecha de pago: " + fecPago);
	        System.out.println("Monto pagado: " + montoPagado);
	    }
	 
}
