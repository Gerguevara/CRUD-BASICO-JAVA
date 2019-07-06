package MainPK;

import connectionsDB.*;
import java.util.Scanner;

/**
 *
 * @author Gerardo
 */
public class Biblioteca {

    public static void main(String[] args) {

        Scanner SC = new Scanner(System.in);
        getMenu();
        String respuesta = SC.nextLine();
        Operaciones CM = new Operaciones();

        while (!(respuesta.equals("0"))) {

            switch (respuesta) {
                case "1":

                    CM.consultarLibros();

                    break;
                case "2":

                    CM.consultarClientes();

                    break;
                case "3":

                    CM.insertNewBook();

                    break;
                case "4":

                    CM.insertCliente();

                    break;
                default:
                    System.out.println("Opcion no valida");
            }

            System.out.println("Desea realizar otra otra accion?");
            getMenu();
            respuesta = SC.nextLine();

        }

        System.out.println("Adios!!");

    }

    public static void getMenu() {

        System.out.println("Que haccion desea realizar?");
        System.out.println("1- Consultar Menu de libros");
        System.out.println("2- Consultar Menu de usuarios");
        System.out.println("3- Agregar un Libro al inventario ");
        System.out.println("4- Agregar un nuevo cliente");
        System.out.println("---------------------------------");
        System.out.println("0-  Salir");
        System.out.println("");

    }

}
