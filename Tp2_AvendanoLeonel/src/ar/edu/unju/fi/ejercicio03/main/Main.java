package ar.edu.unju.fi.ejercicio03.main;
import ar.edu.unju.fi.ejercicio03.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
			
		Provincia[] p = Provincia.values();
		
        for (Provincia provincia : p) {
            System.out.println("Provincia: " + provincia);
            System.out.println("Cantidad de población: " + provincia.getCantPobl());
            System.out.println("Superficie: " + provincia.getSup());
            System.out.println("Densidad poblacional: " + provincia.CalcularDensidad());
            System.out.println();
        }
	}
}
