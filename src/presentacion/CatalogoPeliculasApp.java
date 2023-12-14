/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import dominio.Pelicula;
import java.util.Scanner;
import servicio.IServicioPeliculas;
import servicio.ServicioPeliculasArchivo;
import servicio.ServicioPeliculasLista;

/**
 *
 * @author klogew
 */
public class CatalogoPeliculasApp {

    public static void main(String[] args) {
        boolean salir = false;
        Scanner sc = new Scanner(System.in);
        // Agregamos la implementacion del servicio
//        IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasArchivo();

        while (!salir) { // Mientras sea diferente a salir
            try {
                mostrarMenu();
                salir = ejecutarOpciones(sc, servicioPeliculas);
            } catch (Exception e) {

            }
        } // end while loop
    }

    private static void mostrarMenu() {
        System.out.println("""
                           *** Catalago de Peliculas ***
                           1. Agregar Pelicula
                           2. Listar Pelicula
                           3. Buscar Pelicula
                           4. Salir
                           """);
    }

    private static boolean ejecutarOpciones(Scanner sc, IServicioPeliculas servicioPeliculas) {
        System.out.print("Que desea realizar? ");
        int opcion = Integer.parseInt(sc.nextLine());
        System.out.println(""); // Salto de linea
        boolean salir = false;
        switch (opcion) {
            case 1 -> {
                System.out.print("Introduce el nombre de la pelicula: ");
                String nombrePelicula = sc.nextLine();
                servicioPeliculas.agregarPelicula(new Pelicula(nombrePelicula));
            }
            case 2 ->
                servicioPeliculas.listar();
            case 3 -> {
                System.out.print("Introduce la pelicula buscar: ");
                String pelicula = sc.nextLine();
                servicioPeliculas.buscarPelicula(new Pelicula(pelicula));
            }
            case 4 -> {
                System.out.println("Hasta pronto...");
                salir = true;
            }
            default ->
                System.out.println("Opcion no reconocida: " + opcion);
        } // end switch

        System.out.println(""); // Salto de linea
        return salir;
    }
}
