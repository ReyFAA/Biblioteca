package Bibliotecario_example;

import persona_example.persona;
import libro_example.libro;
import usuario_example.usuario;
import java.util.ArrayList;
import java.util.List;

public class Bibliotecario extends persona {
    protected List<libro> libros;

    public Bibliotecario(String nombre, String apellido) {
        super(nombre, apellido);
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado: " + libro.getTitulo());
    }

    public void mostrarLibros() {
        System.out.println("Lista de libros en la biblioteca:");
        for (libro libro : libros) {
            System.out.println(libro);
        }
    }

    public void prestarLibro(usuario usuario, libro libro) {
        if (libros.contains(libro) && !libro.isPrestado()) {
            usuario.prestarLibro(libro);
        } else {
            System.out.println("El libro " + libro.getTitulo() + " no está disponible para préstamo.");
        }
    }

    public void recibirDevolucion(usuario usuario, libro libro) {
        usuario.devolverLibro(libro);
    }

    public List<libro> getLibros() {
        return libros;
    }
}
