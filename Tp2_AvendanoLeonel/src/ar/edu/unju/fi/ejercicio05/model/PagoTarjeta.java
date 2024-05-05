
package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

 public class PagoTarjeta implements Pago{
	 
	private String numTarjeta;
    private LocalDate fecPago;
    private double montoPagado;
    
    
	public PagoTarjeta(String numTarjeta, LocalDate fecPago, double montoPagado) {
		
		this.numTarjeta = numTarjeta;
		this.fecPago = fecPago;
		this.montoPagado = montoPagado;
	}
    
	public void realizarPago(double monto) {
        this.montoPagado = monto * 1.15; 
    }
	
	public void imprimirRecibo() {
        System.out.println("Número de tarjeta: " + numTarjeta);
        System.out.println("Fecha de pago: " + fecPago);
        System.out.println("Monto pagado: " + montoPagado);
    }
	
	
}

