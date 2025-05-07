/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import Modelo.Credencial;
import Modelo.GestorCredenciales;
import java.util.Scanner;

/**
 *
 * @author vicen
 */
public class MenuConsola {

    private static final Scanner scanner = new Scanner(System.in);
    private static Credencial plantillaBase = new Credencial("Nombre Base", "Cargo Base", "RUT Base");

    public static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Generador de Credenciales ---");
            System.out.println("1. Ver plantilla base");
            System.out.println("2. Crear nueva credencial (desde plantilla)");
            System.out.println("3. Ver todas las credenciales");
            System.out.println("4. Eliminar credencial");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    verPlantilla();
                case 2:
                    crearDesdePlantilla();
                case 3:
                    GestorCredenciales.getInstancia().listarCredenciales();
                case 4:
                    eliminarCredencial();
                case 5:
                    System.out.println("Saliendo...");
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private static void verPlantilla() {
        System.out.println("Plantilla base: " + plantillaBase);
    }

    private static void crearDesdePlantilla() {
        Credencial nueva = plantillaBase.clone();
        System.out.print("Ingrese nombre: ");
        nueva.setNombre(scanner.nextLine());
        System.out.print("Ingrese cargo: ");
        nueva.setCargo(scanner.nextLine());
        System.out.print("Ingrese RUT: ");
        nueva.setRut(scanner.nextLine());
        GestorCredenciales.getInstancia().agregarCredencial(nueva);
        System.out.println("Credencial creada exitosamente.");
    }

    private static void eliminarCredencial() {
        GestorCredenciales gestor = GestorCredenciales.getInstancia();
        gestor.listarCredenciales();
        System.out.print("Ingrese número de credencial a eliminar: ");
        int idx = scanner.nextInt();
        scanner.nextLine();
        gestor.eliminarCredencial(idx - 1);
        System.out.println("Credencial eliminada.");
    }

}
