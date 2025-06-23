import java.util.ArrayList;
import java.util.Scanner;

public class VideoclubApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        ArrayList<Videojuego> videojuegos = new ArrayList<>();

        // Leer películas
        System.out.print("Cantidad de películas: ");
        int cantidadPeliculas = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        for (int i = 0; i < cantidadPeliculas; i++) {
            System.out.println("Película " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Costo Renta: ");
            double costoRenta = scanner.nextDouble();
            System.out.print("Días: ");
            int dias = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            System.out.print("Género: ");
            String genero = scanner.nextLine();
            System.out.print("Año: ");
            int anio = scanner.nextInt();
            System.out.print("Rentado (1 para Sí, 0 para No): ");
            boolean rentado = scanner.nextInt() == 1;
            scanner.nextLine(); // Limpiar buffer
            peliculas.add(new Pelicula(nombre, costoRenta, dias, rentado, genero, anio));
        }

        // Leer videojuegos
        System.out.print("Cantidad de videojuegos: ");
        int cantidadVideojuegos = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        for (int i = 0; i < cantidadVideojuegos; i++) {
            System.out.println("Videojuego " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Costo Renta: ");
            double costoRenta = scanner.nextDouble();
            System.out.print("Días: ");
            int dias = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            System.out.print("Estilo: ");
            String estilo = scanner.nextLine();
            System.out.print("Plataforma: ");
            String plataforma = scanner.nextLine();
            System.out.print("Rentado (1 para Sí, 0 para No): ");
            boolean rentado = scanner.nextInt() == 1;
            scanner.nextLine(); // Limpiar buffer
            videojuegos.add(new Videojuego(nombre, costoRenta, dias, rentado, estilo, plataforma));
        }

        // Menú de opciones
        char opcion;
        do {
            System.out.println("\nOpciones:");
            System.out.println("T/t: Despliega todos los productos.");
            System.out.println("P/p: Despliega todas las películas.");
            System.out.println("V/v: Despliega todos los videojuegos.");
            System.out.println("S/s: Checar si una película está rentada.");
            System.out.println("J/j: Verifica si un videojuego está o no rentado.");
            System.out.println("C/c: Devuelve la cantidad de películas que están rentadas.");
            System.out.println("X/x: Indica la cantidad de videojuegos cuya plataforma es Xbox One.");
            System.out.println("U/u: Termina el programa.");
            System.out.print("Elige una opción: ");
            opcion = scanner.next().charAt(0);
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 'T':
                case 't':
                    System.out.println("Todos los productos:");
                    peliculas.forEach(System.out::println);
                    videojuegos.forEach(System.out::println);
                    break;
                case 'P':
                case 'p':
                    System.out.println("Películas:");
                    peliculas.forEach(System.out::println);
                    break;
                case 'V':
                case 'v':
                    System.out.println("Videojuegos:");
                    videojuegos.forEach(System.out::println);
                    break;
                case 'S':
                case 's':
                    System.out.print("Nombre de la película: ");
                    String peliculaBuscada = scanner.nextLine();
                    peliculas.stream()
                            .filter(p -> p.getNombre().equalsIgnoreCase(peliculaBuscada))
                            .forEach(p -> System.out.println("Rentado: " + (p.isRentado() ? "Sí" : "No")));
                    break;
                case 'J':
                case 'j':
                    System.out.print("Nombre del videojuego: ");
                    String videojuegoBuscado = scanner.nextLine();
                    videojuegos.stream()
                            .filter(v -> v.getNombre().equalsIgnoreCase(videojuegoBuscado))
                            .forEach(v -> System.out.println("Rentado: " + (v.isRentado() ? "Sí" : "No")));
                    break;
                case 'C':
                case 'c':
                    long peliculasRentadas = peliculas.stream().filter(Pelicula::isRentado).count();
                    System.out.println("Cantidad de películas rentadas: " + peliculasRentadas);
                    break;
                case 'X':
                case 'x':
                    long videojuegosXbox = videojuegos.stream()
                            .filter(v -> v.getPlataforma().equalsIgnoreCase("Xbox One"))
                            .count();
                    System.out.println("Cantidad de videojuegos en Xbox One: " + videojuegosXbox);
                    break;
                case 'U':
                case 'u':
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 'U' && opcion != 'u');

        scanner.close();
    }
}