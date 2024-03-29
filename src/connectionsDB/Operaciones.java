package connectionsDB;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Gerardo
 */
public class Operaciones extends AccessDB {

    Scanner SC = new Scanner(System.in);
    int raw = 0;

    @Override
    protected void createConection() {
        super.createConection();
    }

    /**
     * Este metodo realiza la consulta a la tabla de libros, llama al metodo
     * createConenction para abrir la coneccion primero
     */
    public void consultarLibros() {
        this.createConection();

        try {

            String sql = "select * from libro";
            try (ResultSet result = instruccion.executeQuery(sql)) {
                System.out.println("Consultando.....");
                
                while (result.next()) {
                    System.out.println("------------------------------");
                    System.out.println("Id:" + result.getInt(1));
                    System.out.println("Nombre Libro:" + result.getString(2));
                    System.out.println("ISBN:" + result.getString(3));
                    System.out.println("Categoria:" + result.getString(4));
                    System.out.println("------------------------------");
                    System.out.println("------------------------------");
                    
                }
                
                System.out.println("Competado!!!");
            }
            instruccion.close();
            conexion.close();

        } catch (SQLException ex) {
            System.out.println("Consulta error");

            ex.printStackTrace();

        }

    }

    //---------------------------------------------------------------------------------------------------------------
    /**
     * Este metodo realiza las consultas a la tabla de clientes
     */
    public void consultarClientes() {
        try {
            this.createConection();
            Statement instruccion = conexion.createStatement();
            String sql = "select * from persona";
            ResultSet result = instruccion.executeQuery(sql);

            System.out.println("Consultando.....");

            while (result.next()) {
                System.out.println("------------------------------");
                System.out.println("Id :" + result.getInt(1));
                System.out.println("Nombre :" + result.getString(2));
                System.out.println("Direccion :" + result.getString(3));
                System.out.println("Telefono :" + result.getString(4));
                System.out.println("Estado  :" + result.getString(5));
                System.out.println("------------------------------");
                System.out.println("------------------------------");

            }

            System.out.println("Competado!!!");

            result.close();
            instruccion.close();
            conexion.close();

        } catch (SQLException ex) {
            System.out.println("Consulta error");

            ex.printStackTrace();

        }

    }

    //---------------------------------------------------------------------------------------------------------------
    /**
     * Este metodo inserta un nuevo libro a la tabla de libros
     */
    public void insertNewBook() {

        System.out.println(" Ingere el nombre del nuevo libro (obligatorio) ");

        String nombre = SC.nextLine();
        while (nombre.equals(null) | nombre.equals("")) {
            System.out.println("nombre es un campo obligatorio");
            System.out.println(" Ingere el nombre del nuevo libro (obligatorio) ");
            nombre = SC.nextLine();

        }

        System.out.println(" Ingrese el ISBN (obligatorio)");
        String ISBN = SC.nextLine();
        while (ISBN.equals(null)) {
            System.out.println("ISBN es un campo obligatorio");
            System.out.println(" Ingrese el ISBN (obligatorio)");
            ISBN = SC.nextLine();

        }

        System.out.println("Elija una categoria");
        System.out.println("Fantacia");
        System.out.println("Cientifico");
        System.out.println("Terror");
        System.out.println("Tecnologia");

        String categoria = SC.nextLine();
        if (categoria.equals("")) {
            categoria = "Sin Categoria";

        }

        String Query = "INSERT INTO libro(Nombre_Libro,,Categoria) VALUES('" + nombre + "','" + ISBN + "','" + categoria + "')";
        try {
            this.createConection();
            instruccion.executeUpdate(Query);

        //    raw = instruccion.getUpdateCount();
            //   System.out.println("Clomunas afectadas: "+raw);
            System.out.println("Datos insertados correctamente!!!");

            instruccion.close();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error de insercion!!!");
            ex.printStackTrace();
        }

    }

    //---------------------------------------------------------------------------------------------------------------
    /**
     * Este metodo inserta un nuevo Cliente a la tabla persona
     */
    public void insertCliente() {

        System.out.println(" Ingere el nombre del nuevo cliente ");
        String nombre = SC.nextLine();
        while (nombre.equals(null) | nombre.equals("")) {
            System.out.println("nombre de cliente es un campo obligatorio");
            System.out.println(" Ingere el nombre del nuevo cliente ");
            nombre = SC.nextLine();
        }

        System.out.println(" Ingrese la direccion del cliente (obligatorio)");
        String dir = SC.nextLine();
        while (dir.equals(null) | dir.equals("")) {
            System.out.println("Direccion es un campo obligatorio");
            System.out.println(" Ingrese la direccion del cliente (obligatorio)");
            dir = SC.nextLine();

        }

        System.out.println("Ingrese el telefono del cliente");

        String telefono = SC.nextLine();

        if (telefono.equals(null)) {
            telefono = "Sin Telefono";

        }

        String Query = "INSERT INTO persona(Nombre_Persona,Direccion,Telefono) VALUES('" + nombre + "','" + dir + "','" + telefono + "')";
        try {
            this.createConection();
            instruccion.executeUpdate(Query);
            System.out.println("Datos insertados correctamente!!!");
            raw = instruccion.getUpdateCount();
            System.out.println("Clomunas afectadas: " + raw);
            instruccion.close();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error de insercion!!!");
            ex.printStackTrace();
        }

    }
//------------------------------------------------------------------------------------

    public void delete() throws SQLException {

        String SQL = null;
        int id;
        System.out.println("Que desea eliminar ");
        System.out.println("1- Usuarios");
        System.out.println("2- Libros");
        Integer respuesta = SC.nextInt();
        while (respuesta.equals("") | respuesta > 2) {
            System.out.println("Debe ingresar una opncion valida");

        }

        switch (respuesta) {
            case 1:
                System.out.println("Ingrese el ID del usuario");
                id = SC.nextInt();
                SQL = "DELETE FROM persona WHERE Id_Persona = " + id;
                try {
                    this.createConection();
                    instruccion.executeUpdate(SQL);

                } catch (Exception e) {
                    System.out.println("No se puedo eliminar ningun usuario con ese Id");
                    e.printStackTrace();
                } finally {
                    instruccion.close();
                    conexion.close();
                    break;
                }
            case 2:
                System.out.println("Ingrese el ID del libro");
                id = SC.nextInt();
                SQL = "DELETE FROM libro WHERE Id_Libro = " + id;
                try {
                    this.createConection();
                    instruccion.executeUpdate(SQL);

                } catch (Exception e) {
                    System.out.println("No se puedo eliminar ningun libro con ese ID");
                    e.printStackTrace();
                } finally {
                    instruccion.close();
                    conexion.close();

                }

                break;
            default:
                System.out.println("No se eligio una opcion valida");
        }

    }

    public void addPrestamo() {
        int id_Cliente, id_Emplead, id_Libro, id_Empleado;
        String SQL = null;
        System.out.println("Que tipo de prestamo desea realizar?");
        System.out.println("1- Prestamo para un cliente ya resgistrado");
        System.out.println("2- Prestamo para un nuevo cliente");
        String Respuesta = SC.nextLine();
        switch (Respuesta) {
            case "1":
                System.out.println("Ingrese el Id del cliente");
                id_Cliente = SC.nextByte();
                System.out.println("Ingrese el Id del empleado");
                id_Empleado = SC.nextInt();
                System.out.println("Ingrese el Id del libro");
                id_Libro = SC.nextInt();
                SQL = "INSERT INTO prestamo (id_empleado,id_cliente,id_libro) VALUES ('" + id_Empleado + "','" + id_Cliente + "','" + id_Libro + "')";
                try {
                    this.createConection();
                    this.instruccion.executeUpdate(SQL);

                    System.out.println("Datos Ingresados Correctamente");
                    raw = this.instruccion.getUpdateCount();
                    System.out.println("Columnas afectadas: " + raw);

                } catch (Exception e) {
                    System.out.println(" no se pudeo realizar la accion");
                    e.printStackTrace();
                }

                break;
            case "2":
                insertCliente();
                System.out.println("Ingrese el Id del cliente");
                id_Cliente = SC.nextByte();
                System.out.println("Ingrese el Id del empleado");
                id_Empleado = SC.nextInt();
                System.out.println("Ingrese el Id del libro");
                id_Libro = SC.nextInt();
                SQL = "INSERT INTO prestamo (id_empleado,id_cliente,id_libro) VALUES ('" + id_Empleado + "','" + id_Cliente + "','" + id_Libro + "')";

                try {
                    this.createConection();
                    this.instruccion.executeUpdate(SQL);

                    System.out.println("Datos Ingresados Correctamente");
                    raw = this.instruccion.getUpdateCount();
                    System.out.println("Columnas afectadas: " + raw);

                } catch (Exception e) {
                    System.out.println(" no se pudeo realizar la accion");
                    e.printStackTrace();
                }

                break;
            default:
                throw new AssertionError();
        }

    }

}
