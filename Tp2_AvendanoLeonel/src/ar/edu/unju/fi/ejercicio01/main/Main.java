package ar.edu.unju.fi.ejercicio01.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		int opcion;
        do {
            System.out.println("\n------MENU DE OPCIONES------:");
            System.out.println("1. Crear Producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Modificar producto");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    crearProducto(productos, scanner);
                    break;
                case 2:
                    mostrarProductos(productos);
                    break;
                case 3:
                    modificarProducto(productos, scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
	
	private static void crearProducto(List<Producto> productos, Scanner scanner) {
		
        System.out.println("Ingrese el código del producto: ");
        String codigo = scanner.nextLine();

        System.out.println("Ingrese la descripción del producto: ");
        String descripcion = scanner.nextLine();

        System.out.println("Ingrese el precio unitario del producto: ");
        double precioUnitario = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.println("------ Origen de fabricación ------\n");
        mostrarOpcionesEnum(OrigenFabricacion.values());
        System.out.println("Elija una opcion:");
        int opcionOrigen = scanner.nextInt();
        scanner.nextLine(); 
        OrigenFabricacion origen = OrigenFabricacion.values()[opcionOrigen - 1];

        System.out.println("------ Categoria ------\n");
        mostrarOpcionesEnum(Categoria.values());
        System.out.println("Elija una opcion:");
        int opcionCategoria = scanner.nextInt();
        scanner.nextLine(); 
        Categoria categoria = Categoria.values()[opcionCategoria - 1];

        Producto producto = new Producto(codigo, descripcion, precioUnitario, origen, categoria);
        
        productos.add(producto);
        
        System.out.println("\nProducto creado con éxito\n");
    }

	
	
	
    private static void mostrarProductos(ArrayList<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("\nNO HAY PRODUCTOS\n");
            return;
        }

        System.out.println("\nLISTA DE PRODUCTOS");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    
    
    private static void modificarProducto(ArrayList<Producto> productos, Scanner scanner) {
        if (productos.isEmpty()) {
            System.out.println("\nNO HAY PRODUCTOS PARA MODIFICAR\n");
            return;
        }

        System.out.println("Ingrese el código del producto a modificar:");
        String codigo = scanner.nextLine();

        Producto productoAModificar = null;
        
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                productoAModificar = producto;
                break;
            }
        }

        if (productoAModificar == null) {
            System.out.println("\nNo se encontró ningún producto con el código ingresado\n");
            return;
        }

        System.out.println("\n****SELECCIONE EL CAMPO A MODIFICAR****");
        System.out.println("1. Descripción");
        System.out.println("2. Precio Unitario");
        System.out.println("3. Origen de Fabricación");
        System.out.println("4. Categoría");
        int opc = scanner.nextInt();
        scanner.nextLine(); 

        switch (opc) {
            case 1:
                System.out.println("Ingrese la nueva descripción:");
                String nuevaDescripcion = scanner.nextLine();
                productoAModificar.setDescripcion(nuevaDescripcion);
                break;
            case 2:
                System.out.println("Ingrese el nuevo precio unitario:");
                double nuevoPrecio = scanner.nextDouble();
                scanner.nextLine(); 
                productoAModificar.setPrecioUnitario(nuevoPrecio);
                break;
            case 3:
                System.out.println("------ Origen de fabricación ------\n");
                mostrarOpcionesEnum(OrigenFabricacion.values());
                System.out.println("Elija una opcion:");
                int opcNuevoOrigen = scanner.nextInt();
                scanner.nextLine(); 
                OrigenFabricacion nuevoOrigen = OrigenFabricacion.values()[opcNuevoOrigen - 1];
                productoAModificar.setOrigenFabricacion(nuevoOrigen);
                break;
            case 4:
                System.out.println("------- Categoría ------\n");
                mostrarOpcionesEnum(Categoria.values());
                System.out.println("Elija una opcion:");
                int opcNuevaCategoria = scanner.nextInt();
                scanner.nextLine(); 
                Categoria nuevaCategoria = Categoria.values()[opcNuevaCategoria - 1];
                productoAModificar.setCategoria(nuevaCategoria);
                break;
            default:
                System.out.println("\nOpción no válida\n");
        }

        System.out.println("\nProducto modificado con éxito\n");
    }

    private static void mostrarOpcionesEnum(Enum<?>[] valores) {
        for (int i = 0; i < valores.length; i++) {
            System.out.println((i + 1) + " - " + valores[i]);
        }
	
    }
 }
