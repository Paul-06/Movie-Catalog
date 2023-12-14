/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import dominio.Pelicula;

/**
 *
 * @author klogew
 */
public interface IServicioPeliculas {

    // Agregamos las firmas de los metodos
    public void listar();

    public void agregarPelicula(Pelicula pelicula);

    public void buscarPelicula(Pelicula pelicula);
}
