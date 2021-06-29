/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Clases.CProcesos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jluis
 */
public class BDProcesos {
    
    
    
    public static void InsertarProceso(CProcesos t) throws SQLException{
        Connection con = BDConexion.getConnection();
        PreparedStatement ps = null;
        ps = con.prepareStatement("insert into proceso values(?,?,?,?,?,?,?,?)");
        ps.setInt(1,t.getId_proceso());
        ps.setInt(2, t.getId_lote());
        ps.setString(3, t.getDescripcion());
        ps.setDate(4, new java.sql.Date(t.getFecha().getTime()));
        ps.setInt(5, t.getCantidad());
        ps.setString(6, t.getComentario());
        ps.setString(7, t.getHora());
        ps.setInt(8, t.getCodigo());
        ps.executeUpdate();
        con.close();
        ps.close(); 
    }
    
    
     public static ArrayList<CProcesos> ListarProceso(int a) {
                   
        return SQL1("select descripcion,fecha,cantidad,codigo,comentario from proceso where id_lote ="+a+"order by id_proceso");
    }
    private static ArrayList<CProcesos> SQL1(String sql){
    ArrayList<CProcesos> list = new ArrayList<CProcesos>();
    Connection cn = BDConexion.getConnection();
        try {
            CProcesos b;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 b = new CProcesos();
                 b.setDescripcion(rs.getString("descripcion"));
                 b.setFecharet(rs.getString("fecha"));
                 b.setCantidad(rs.getInt("cantidad"));
                 b.setCodigo(rs.getInt("codigo"));
                 b.setComentario(rs.getString("comentario"));
                 list.add(b);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } 
        return list;
}
    
    
    public static boolean CerrarTra(CProcesos t) throws SQLException{
        
        Connection cn = BDConexion.getConnection();
        PreparedStatement ps = null;
        ps = cn.prepareStatement("UPDATE LOTES SET ESTADO = 3, FECHAFIN = ? WHERE ID_LOTE ="+t.getId_lote());
        ps.setDate(1,new java.sql.Date(t.getFecha().getTime()));    
        int rowsUpdated = ps.executeUpdate();
        cn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }    
    
}
