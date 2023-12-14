/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dominio.Pelicula;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author klogew
 */
public class ServicioPeliculasLista implements IServicioPeliculas {

    // Creamos un lista de peliculas
    private final List<Pelicula> peliculas;

    public ServicioPeliculasLista() {
        this.peliculas = new ArrayList<>();
    }

    // Implementacion de los metodos de la interfaz
    @Override
    public void listar() {
        System.out.println("Lista de Peliculas...");
        peliculas.forEach(System.out::println); // Usamos el metodo de referencia
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agrego la pelicula: " + pelicula);
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        // Regresa el indice de la pelicula encontrada en la lista
        int indice = peliculas.indexOf(pelicula);
        if (indice == -1) {
            System.out.println("No se encontro la pelicula " + pelicula);
            return;
        }

        System.out.println("Pelicula encontrada en el indice " + indice);
    }

}
