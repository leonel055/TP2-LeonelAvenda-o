package ar.edu.unju.fi.ejercicio07.main;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio07.Producto;

public class Main {
	
    private static List<Producto> productos;
	public static void main(String[] args) {
		
		productos = cargarProductos();
        new ArrayList<>();
        
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        
        while (continuar) {
            mostrarMenu();
            int opc = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opc) {
                case 1:
                    mostrarProductosDisponibles();
                    break;
                case 2:
                    mostrarProductosFaltantes();
                    break;
                case 3:
                    incrementarPrecios();
                    break;
                case 4:
                    mostrarElectrohogarDisponibles();
                    break;
                case 5:
                    ordenarProductosPorPrecio();
                    break;
                case 6:
                    mostrarNombresEnMayusculas();
                    break;
                case 7:
                    continuar = false;
                    break;
                default:
                    System.out.println("OPCION INVALIDA");
                    break;
            }
        }
        
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n***** MENU DE OPCIONES ******\n");
        System.out.println("1. Mostrar productos disponibles");
        System.out.println("2. Mostrar los productos faltantes");
        System.out.println("3. Incrementar los precios de los productos en un 20%");
        System.out.println("4. Mostrar los productos de categoría Electrohogar disponibles");
        System.out.println("5. Ordenar los productos por precio de forma descendente");
        System.out.println("6. Mostrar los productos con los nombres en mayúsculas");
        System.out.println("7. Salir");
        System.out.println("Ingrese su opción:");
    }

    private static void mostrarProductosDisponibles() {
        System.out.println("\nPRODUCTOS DISPONIBLES\n");
        productos.stream()
                .filter(Producto::isBand)
                .forEach(System.out::println);
    }

    private static void mostrarProductosFaltantes() {
        System.out.println("\nPRODUCTOS FALTANTES\n");
        productos.stream()
                .filter(p -> !p.isBand())
                .forEach(System.out::println);
    }

    private static void incrementarPrecios() {
        productos.stream()
                .peek(p -> p.setPrecioUnitario(p.getPrecioUnitario() * 1.20))
                .collect(Collectors.toList());
        System.out.println("Precios incrementados en un 20%.");
    }

    private static void mostrarElectrohogarDisponibles() {
        System.out.println("Productos de categoría Electrohogar disponibles:");
        productos.stream()
                .filter(p -> p.getCategoria() == Producto.Categoria.ELECTROHOGAR && p.isBand())
                .forEach(System.out::println);
    }

    private static void ordenarProductosPorPrecio() {
        System.out.println("Productos ordenados por precio (descendente):");
        productos.stream()
                .sorted(Comparator.comparing(Producto::getPrecioUnitario).reversed())
                .forEach(System.out::println);
    }

    private static void mostrarNombresEnMayusculas() {
        System.out.println("Nombres de productos en mayúsculas:");
        productos.stream()
                .map(p -> p.getDescripcion().toUpperCase())
                .forEach(System.out::println);
    }
	

	private static List<Producto> cargarProductos() {

        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("001", "Teléfono móvil", 250.0, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.TELEFONIA, true));
        productos.add(new Producto("002", "Laptop", 800.0, Producto.OrigenFabricacion.CHINA, Producto.Categoria.INFORMATICA, false));
        productos.add(new Producto("003", "Aspiradora", 120.0, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.ELECTROHOGAR, false));
        productos.add(new Producto("004", "Destornillador", 10.0, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.HERRAMIENTAS, true));
        productos.add(new Producto("005", "Tablet", 300.0, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.INFORMATICA, true));
        productos.add(new Producto("006", "Smart TV", 700.0, Producto.OrigenFabricacion.CHINA, Producto.Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("007", "Taladro", 50.0, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.HERRAMIENTAS, true));
        productos.add(new Producto("008", "Secador de pelo", 25.0, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("009", "Router WiFi", 40.0, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.INFORMATICA, false));
        productos.add(new Producto("010", "Martillo", 15.0, Producto.OrigenFabricacion.CHINA, Producto.Categoria.HERRAMIENTAS, true));
        productos.add(new Producto("011", "Plancha", 30.0, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("012", "Teléfono fijo", 50.0, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.TELEFONIA, false));
        productos.add(new Producto("013", "Teclado", 20.0, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.INFORMATICA, true));
        productos.add(new Producto("014", "Cámara de seguridad", 60.0, Producto.OrigenFabricacion.CHINA, Producto.Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("015", "Sierra eléctrica", 90.0, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.HERRAMIENTAS, false));
       
		return productos;
	}
	
}
