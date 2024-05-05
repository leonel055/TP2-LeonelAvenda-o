

package ar.edu.unju.fi.ejercicio05.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio05.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio05.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio05.model.Producto;


public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);


        ArrayList<Producto> productos = precargarProductos();

        int opc;

        do {	
        	
        	menu();
           

            try {
                opc = scanner.nextInt();
                scanner.nextLine(); 

                switch (opc) {
                    case 1:
                        mostrarProductos(productos);
                        break;
                    case 2:
                    	realizarCompra(productos, scanner);
                    case 3:
                        System.out.println("Saliendo del programa");
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR");
                scanner.nextLine(); 
                opc = 0; 
            }

        } while (opc != 3);

        scanner.close();
    }

	
	
	private static void menu() {
	
		 System.out.println("***** MENU DE OPCIONES *****");
         System.out.println("1. Mostrar productos");
         System.out.println("2. Realizar compra");
         System.out.println("3. Salir");
         System.out.println("Seleccione una opción:");
		
	}
  

    private static void mostrarProductos(ArrayList<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            System.out.println("Productos disponibles:");
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }
    private static void realizarCompra(ArrayList<Producto> productos, Scanner scanner) {
        ArrayList<Producto> productosSeleccionados = new ArrayList<>();
        double total = 0;

        System.out.println("Seleccione los productos que desea comprar:");
        mostrarProductos(productos);
        int opcion;
        do {
            System.out.print("Ingrese el numero del producto: ");
           System.out.println("\nINGRESE ´0´ PARA FINALIZAR");
            opcion = scanner.nextInt();
            if (opcion >= 1 && opcion <= productos.size()) {
                Producto productoSeleccionado = productos.get(opcion - 1);
                if (productoSeleccionado.isBand()) {
                    productosSeleccionados.add(productoSeleccionado);
                    total += productoSeleccionado.getPrecioUnitario();
                    productoSeleccionado.setBand(false);
                } else {
                    System.out.println("PRODUCTO NO DISPONIBLE EN STOCK");
                }
            } else if (opcion != 0) {
                System.out.println("OPCION INVALIDA");
            }
        } while (opcion != 0);

        System.out.println("Seleccione el metodo de pago:");
        System.out.println("1. Pago efectivo");
        System.out.println("2. Pago con tarjeta");
        int metodoPago = scanner.nextInt();
        switch (metodoPago) {
            case 1:
                PagoEfectivo pagoEfectivo = new PagoEfectivo(0, LocalDate.now());
                pagoEfectivo.realizarPago(total);
                pagoEfectivo.imprimirRecibo();
                break;
            case 2:
                scanner.nextLine();
                System.out.print("Ingrese el numero de tarjeta: ");
                String numeroTarjeta = scanner.nextLine();
                PagoTarjeta pagoTarjeta = new PagoTarjeta(numeroTarjeta, LocalDate.now(), 0);
                pagoTarjeta.realizarPago(total);
                pagoTarjeta.imprimirRecibo();
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
   }
  private static ArrayList<Producto> precargarProductos() {
    	
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("001", "Camiseta", 20.0, true));
        productos.add(new Producto("002", "Pantalón", 35.5, false));
        productos.add(new Producto("003", "Zapatos", 50.0, true));
        productos.add(new Producto("004", "Bufanda", 10.0, true));
        productos.add(new Producto("005", "Gorra", 15.0, false));
        productos.add(new Producto("006", "Calcetines", 5.0, true));
        productos.add(new Producto("007", "Abrigo", 80.0, true));
        productos.add(new Producto("008", "Vestido", 45.0, false));
        productos.add(new Producto("009", "Cinturón", 12.0, true));
        productos.add(new Producto("010", "Bufanda", 10.0, true));
        productos.add(new Producto("011", "Jersey", 30.0, false));
        productos.add(new Producto("012", "Pantalón corto", 25.0, true));
        productos.add(new Producto("013", "Botas", 60.0, true));
        productos.add(new Producto("014", "Gafas de sol", 18.0, false));
        productos.add(new Producto("015", "Chaqueta", 70.0, true));
        
        return productos;
    }
   	}
   
