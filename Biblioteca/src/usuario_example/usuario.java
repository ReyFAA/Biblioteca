package usuario_example;

import persona_example.persona;
import libro_example.libro;
import java.util.ArrayList;
import java.util.List;

public class usuario extends persona {
    private List<libro> librosPrestados;

    public usuario(String nombre, String apellido) {
        super(nombre, apellido);
        this.librosPrestados = new ArrayList<>();
    }

    public void prestarLibro(libro libro) {
        librosPrestados.add(libro);
        libro.setPrestado(true);
        System.out.println(getNombreCompleto() + " ha prestado el libro: " + libro.getTitulo());
    }

    public void devolverLibro(libro libro) {
        if (librosPrestados.remove(libro)) {
            libro.setPrestado(false);
            System.out.println(getNombreCompleto() + " ha devuelto el libro: " + libro.getTitulo());
        } else {
            System.out.println(getNombreCompleto() + " no ha prestado el libro: " + libro.getTitulo());
        }
    }

    public void mostrarLibrosPrestados() {
        System.out.println("Libros prestados por " + getNombreCompleto() + ":");
        for (libro libro : librosPrestados) {
            System.out.println(libro);
        }
    }
}
