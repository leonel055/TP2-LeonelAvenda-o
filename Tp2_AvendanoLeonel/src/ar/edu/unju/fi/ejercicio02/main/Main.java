package ar.edu.unju.fi.ejercicio02.main;
import java.util.ArrayList;

import ar.edu.unju.fi.ejercicio02.constantes.Mes;
import ar.edu.unju.fi.ejercicio02.model.Efemeride;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int opc;
		ArrayList<Efemeride> efemerides = new ArrayList<>();
		Scanner scanner = new Scanner (System.in);
		
		 do {
			 	Menu();
	            opc = scanner.nextInt();

	            switch (opc) {
	                case 1:
	                    crearEfemeride(scanner, efemerides);
	                    break;
	                case 2:
	                    mostrarEfemerides(efemerides);
	                    break;
	                case 3:
	                    eliminarEfemeride(scanner, efemerides);
	                    break;
	                case 4:
	                    modificarEfemeride(scanner, efemerides);
	                    break;
	                case 5:
	                    System.out.println("Saliendo del programa...");
	                    break;
	                default:
	                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
	                    break;
	            }
	        } while (opc != 5);

	        scanner.close();
	    }
		
	public static void Menu() {
		
        System.out.println("\n****** MENU DE OPCIONES ******");
        System.out.println("1. Crear efeméride");
        System.out.println("2. Mostrar efemérides");
        System.out.println("3. Eliminar efeméride");
        System.out.println("4. Modificar efeméride");
        System.out.println("5. Salir");
        System.out.print("Ingrese su opción: ");
		
		
	}
	private static void crearEfemeride(Scanner scanner, ArrayList<Efemeride> efemerides) {
		
		  	System.out.println("Ingrese el código de la efemerides:");
	        int codigo = scanner.nextInt();
	        scanner.nextLine(); 

	        System.out.println("Ingrese el mes (1-12):");
	        int numMes = scanner.nextInt();
	        scanner.nextLine(); 

	        if (numMes < 1 || numMes > 12) {
	            System.out.println("MES INVALIDO");
	            return;
	        }

	        System.out.println("Ingrese el día:");
	        int dia = scanner.nextInt();
	        scanner.nextLine(); 

	        System.out.println("Ingrese el detalle:");
	        String detalle = scanner.nextLine();

	        Efemeride efemeride = new Efemeride(codigo, Mes.values()[numMes - 1], dia, detalle);
	        efemerides.add(efemeride);
	        System.out.println("\nEfeméride creada correctamente\n");
	}
	
	
	public static void mostrarEfemerides(ArrayList<Efemeride> efemerides) {
		
        if (efemerides.isEmpty()) {
            System.out.println("\nNo hay efemérides para mostrar\n");
        } else {
            System.out.println("\nEFEMÉRIDES:");
            for (Efemeride efemeride : efemerides) {
                System.out.println(efemeride);
            }
        }
	}
	
	public static void eliminarEfemeride(Scanner scanner, ArrayList<Efemeride> efemerides) {
        if (efemerides.isEmpty()) {
            System.out.println("\nNo hay efemérides para eliminar\n");
            return;
        }

        System.out.println("Ingrese el código de la efeméride a eliminar:");
        int codigo = scanner.nextInt();
        scanner.nextLine(); 

        boolean eliminar = false;
        for (Efemeride e : efemerides) {
            if (e.getCodigo() == codigo) {
                efemerides.remove(e);
                System.out.println("\nEfeméride eliminada correctamente\n");
                eliminar = true;
                break;
            }
        }

        if (!eliminar) {
            System.out.println("NO EXISTE");
        }
    }

	 public static void modificarEfemeride(Scanner scanner, ArrayList<Efemeride> efemerides) {
		 
	        if (efemerides.isEmpty()) {
	            System.out.println("\nNo hay efemérides para modificar\n");
	            return;
	        }

	        System.out.println("Ingrese el código de la efeméride a modificar:");
	        int codigo = scanner.nextInt();
	        scanner.nextLine(); 

	        Efemeride efemerideSeleccionada = null;
	        for (Efemeride e : efemerides) {
	            if (e.getCodigo() == codigo) {
	                efemerideSeleccionada = e;
	                break;
	            }
	        }

	        if (efemerideSeleccionada == null) {
	            System.out.println("No se encontró ninguna efeméride con el código ingresado.");
	            return;
	        }

	        System.out.println("Ingrese el nuevo detalle:");
	        String detalle = scanner.nextLine();
	        efemerideSeleccionada.setDetalle(detalle);

	        System.out.println("Efeméride modificada correctamente.");
	    }
	
	}

