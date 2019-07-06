package connectionsDB;

import java.sql.*;
import java.util.Scanner;

public class AccessDB {
    
    protected final String url = "jdbc:mysql://localhost:3306/biblioteca?useSSL=false";
    protected Connection conexion;
    protected Statement instruccion;

    /**
     * este metodo crea solamente la coneccion para ser utilizada por otros
     * metodos
     *
     */
    protected void createConection()  {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");//No obligatorio de declarar pero recomendado
            this.conexion = (Connection) DriverManager.getConnection(url, "root", "admin");
            this.instruccion = conexion.createStatement();
            System.out.println("Conexion exitosa!!!");
            
        } catch (SQLException|ClassNotFoundException e) {
            System.out.println("Error de coneccion");
        }
        
    }

    
}
