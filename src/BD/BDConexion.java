/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jluis
 */
public class BDConexion {
    
    public static Connection getConnection() {
        Connection cn = null;
        try {
           Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@192.168.0.2:1521:orcl";
            String user = "chips";
            String password = "campana";
            
            /*String url = "jdbc:oracle:thin:@192.168.0.30:1521:orcl";
            String user = "testing";
            String password = "campana";*/
            cn= DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            cn=null;
            JOptionPane.showMessageDialog(null,"ERROR DE CONEXION DE BASE DE DATOS CONTACTE AL ADMINISTRADOR DEL SISTEMA" +e);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR DE CONEXION DE BASE DE DATOS CONTACTE AL ADMINISTRADOR DEL SISTEMA" +e);
            cn=null;
        }
        return cn;
    }
    
    
}
