/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dominio.Pelicula;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author klogew
 */
public class ServicioPeliculasArchivo implements IServicioPeliculas {

    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    // Constructor
    public ServicioPeliculasArchivo() {
        File archivo = new File(NOMBRE_ARCHIVO);
        try {
            // Si ya exite el archivo, no se vuelve a crear
            if (archivo.exists()) {
                System.out.println("El archivo ya existe.");
            } else {
                // Si no exite, se crea vacio
                PrintWriter salida = new PrintWriter(new FileWriter(archivo));
                salida.close(); // Cerramos el archivo para guardarlo
                System.out.println("Se ha creado el archivo.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /*
    Nota:
    Los archivos trabajados nunca deben quedar abiertos. Al terminar
    las operaciones correspondientes, deben ser cerrados.F
     */
    @Override
    public void listar() {
        // Volvemos abrir el archivo
        File archivo = new File(NOMBRE_ARCHIVO);

        try {
            System.out.println("*** Lista de Peliculas ***");
            // Abrimos el archivo para lectura
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            // Leemos linea a linea el archivo
            String linea;
            linea = entrada.readLine();
            // Leemos todas las lineas del archivo
            while (linea != null) {
                Pelicula pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                // Antes de terminar el ciclo volvemos a leer la siguiente linea
                linea = entrada.readLine();
            }

            // Cerramos el archivo
            entrada.close();

        } catch (Exception e) {
            System.out.println("Ocurrio un error al leer el archivo: " + e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        // Si ya existe el archivo, vamos a anexar informacion (agregar, no sobreescribir)
        boolean anexar = false;
        File archivo = new File(NOMBRE_ARCHIVO);
        try {
            // Revisamos si existe el archivo
            anexar = archivo.exists();
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));

            // Agregamos la pelicula (toString)
            salida.println(pelicula);
            System.out.println("Se agrego al archivo: " + pelicula.getNombre());
            salida.close();

        } catch (Exception e) {
            System.out.println("Ocurrio un error al agregar la pelicula: " + e.getMessage());
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        // Como sabemos, volvemos a abrir el archivo
        File archivo = new File(NOMBRE_ARCHIVO);
        try {
            // Abrimos el archivo para lectura linea a linea
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto;
            lineaTexto = entrada.readLine();
            int indice = 1;
            boolean encontrada = false;
            String peliculaBuscar = pelicula.getNombre();

            // Recorremos el archivo en busca de la pelicula
            while (lineaTexto != null) {
                // Buscamos sin importar las mayusculas y minusculas
                if (peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)) {
                    encontrada = true;
                    break;
                }

                // Leemos la siguiente linea antes de la iteracion (tambien incrementamos el indice)
                lineaTexto = entrada.readLine(); // el metodo readLine avanza automaticamente
                indice++;
            } // end while

            // Imprimimos los resultados de la busqueda
            if (encontrada) {
                System.out.println("Pelicula " + lineaTexto + " encontrada: linea " + indice);
            } else {
                System.out.println("No se encontro la pelicula " + pelicula.getNombre());
            }

            // Cerramos el archivo
            entrada.close();

        } catch (Exception e) {
            System.out.println("Ocurrio un error al buscar la pelicula: " + e.getMessage());
        }

    }

}
