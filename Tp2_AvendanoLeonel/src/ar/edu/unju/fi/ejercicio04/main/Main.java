
package ar.edu.unju.fi.ejercicio04.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;
import ar.edu.unju.fi.ejercicio04.model.Jugador;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        ArrayList<Jugador> jugadores = new ArrayList<>();

        int opc;

        do {
            menu();
            try {
                opc = scanner.nextInt();
                scanner.nextLine(); 

                switch (opc) {
                    case 1:
                        altaJugador(jugadores, scanner);
                        break;
                    case 2:
                        mostrarJugadores(jugadores);
                        break;
                    case 3:
                        modificarPosicion(jugadores, scanner);
                        break;
                    case 4:
                        eliminarJugador(jugadores, scanner);
                        break;
                    case 5:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nError. INTRODUZCA UN NUMERO VALIDO\n");
                scanner.nextLine(); 
                opc = 0; 
            }

        } while (opc != 5);

        scanner.close();
    }

    private static void altaJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
    	
        System.out.println("Ingrese el nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido:");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese la fecha de nacimiento (YYYY-MM-DD):");
        LocalDate fechaNac = LocalDate.parse(scanner.nextLine());

        System.out.println("Ingrese la nacionalidad:");
        String nacionalidad = scanner.nextLine();

        System.out.println("Ingrese la estatura(CM):");
        double estatura = scanner.nextDouble();

        System.out.println("Ingrese el peso(KG):");
        double peso = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.println("Ingrese la posición (DELANTERO, MEDIO, DEFENSA, ARQUERO):");
        Posicion posicion = Posicion.valueOf(scanner.nextLine().toUpperCase());

        Jugador jugador = new Jugador(nombre, apellido, fechaNac, nacionalidad, estatura, peso, posicion);
        jugadores.add(jugador);
        System.out.println("\nJUGADOR AGREGADO CORRECTAMENTE\n");
    }

    private static void mostrarJugadores(ArrayList<Jugador> jugadores) {
        if (jugadores.isEmpty()) {
            System.out.println("\nNo hay jugadores registrado\n");
        } else {
            for (Jugador jugador : jugadores) {	
                System.out.println(jugador);
            }
        }
    }

    private static void modificarPosicion(ArrayList<Jugador> jugadores, Scanner scanner) {
        System.out.println("Ingrese el nombre del jugador:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido del jugador:");
        String apellido = scanner.nextLine();

        Iterator<Jugador> iterador = jugadores.iterator();
        boolean band = false;

        while (iterador.hasNext()) {
            Jugador jugador = iterador.next();
            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                band = true;
                System.out.println("Ingrese la nueva posición (DELANTERO, MEDIO, DEFENSA, ARQUERO):");
                Posicion nuevaPosicion = Posicion.valueOf(scanner.nextLine().toUpperCase());
                jugador.setPosicion(nuevaPosicion);
                System.out.println("\nPOSICION MODIFICADA CORRECTAMENTE\n");
                break;
            }
        }

        if (!band) {
            System.out.println("\nNo se encontró al jugador\n");
        }
    }

    private static void eliminarJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
        System.out.println("Ingrese el nombre del jugador:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido del jugador:");
        String apellido = scanner.nextLine();

        Iterator<Jugador> iterador = jugadores.iterator();
        boolean encontrado = false;

        while (iterador.hasNext()) {
            Jugador jugador = iterador.next();
            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                encontrado = true;
                iterador.remove();
                System.out.println("\nJugador eliminado correctamente\n");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\nNo se encontró al jugador\n");
        }
        
    }
    public static void menu(){
    	System.out.println("\n****** MENU DE OPCIONES ******");
        System.out.println("1. Alta de jugador");
        System.out.println("2. Mostrar todos los jugadores.");
        System.out.println("3. Modificar la posición de un jugador.");
        System.out.println("4. Eliminar un jugador.");
        System.out.println("5. Salir.");
        System.out.println("Seleccione una opción:");
    }
}
