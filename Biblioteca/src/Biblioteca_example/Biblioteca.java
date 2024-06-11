package Biblioteca_example;

import Bibliotecario_example.Bibliotecario;
import libro_example.libro;
import usuario_example.usuario;
import java.util.Scanner;

public class Biblioteca {
    private static Bibliotecario Bibliotecario = new Bibliotecario("Juan", "Perez");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1 -> agregarLibro();
                case 2 -> Bibliotecario.mostrarLibros();
                case 3 -> prestarLibro();
                case 4 -> devolverLibro();
                case 5 -> mostrarLibrosPrestadosPorUsuario();
                case 6 -> {
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\nSistema de Gestión de Biblioteca");
        System.out.println("1. Agregar libro");
        System.out.println("2. Mostrar libros agregados");
        System.out.println("3. Prestar libro");
        System.out.println("4. Devolver libro");
        System.out.println("5. Mostrar libros prestados por usuario");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarLibro() {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el año de publicación: ");
        int ano = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        libro libro = new libro(titulo, autor, ano);
        Bibliotecario.agregarLibro(libro);
    }

    private static void prestarLibro() {
        usuario usuario = obtenerUsuario();
        System.out.print("Ingrese el título del libro a prestar: ");
        String tituloPrestar = scanner.nextLine();
        libro libro = buscarLibro(tituloPrestar);
        if (libro != null) {
            Bibliotecario.prestarLibro(usuario, libro);
        } else {
            System.out.println("El libro no se encuentra en la biblioteca.");
        }
    }

    private static void devolverLibro() {
        usuario usuario = obtenerUsuario();
        System.out.print("Ingrese el título del libro a devolver: ");
        String tituloDevolver = scanner.nextLine();
        libro libro = buscarLibro(tituloDevolver);
        if (libro != null) {
            Bibliotecario.recibirDevolucion(usuario, libro);
        } else {
            System.out.println("El libro no se encuentra en la biblioteca.");
        }
    }

    private static void mostrarLibrosPrestadosPorUsuario() {
        usuario usuario = obtenerUsuario();
        usuario.mostrarLibrosPrestados();
    }

    private static usuario obtenerUsuario() {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del usuario: ");
        String apellido = scanner.nextLine();
        return new usuario(nombre, apellido);
    }

    private static libro buscarLibro(String titulo) {
        for (libro libro : Bibliotecario.getLibros()) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }
}
