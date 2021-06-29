/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import BD.Conn;
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
public class guardarPotting {
    
    String fe;
    public static void GuadarTrabajoPottingTrans (inspe i) throws SQLException{
    Connection cn = Conn.getConnection();
    PreparedStatement ps = null;
    ps=cn.prepareStatement("insert into ORDENESPOTTING (no,trabajo,pn,fechain,fechaout,cantidadin,cantidadout,proceso,lote,notas,realizado) Values(?,?,?,?,?,?,?,?,?,?,?)");
    ps.setInt(1, i.getNo());
    ps.setString(2, i.getTrabajo());
    ps.setString(3, i.getPN());
    ps.setDate(4, new java.sql.Date(i.getFecha1().getTime()));
    ps.setString(5, i.getFecha2());
    ps.setInt(6, i.getCantidadIn());
    ps.setInt(7, i.getCantidadOut());
    ps.setString(8, i.getProceso());
    ps.setString(9,i.getLote());
    ps.setString(10, i.getNotas());
    ps.setString(11, i.getRealizadopor());
    ps.executeUpdate();
    cn.close();
    ps.close();
    }  
    
    
    public static ArrayList<inspe> ListarPNPottingTrans(String a){
    
           return SQL("select no,trabajo,pn,fechain,fechaout,cantidadin,cantidadout,proceso,lote,notas,realizado from ORDENESPOTTING where upper(pn) like upper('"+a+"%') order by no");
    }
    
    private static ArrayList<inspe> SQL(String sql) {
          ArrayList<inspe> list = new ArrayList<inspe>();
          Connection cn = Conn.getConnection();
          
          try {
            inspe p;
              Statement stmt = cn.createStatement();
              ResultSet rs = stmt.executeQuery(sql);
              while (rs.next()){
                  
                  p = new inspe();
                  p.setNo(rs.getInt("no"));
                  p.setPN(rs.getString("PN"));
                  p.setTrabajo(rs.getString("trabajo"));
                  p.setLote(rs.getString("lote"));
                  p.setProceso(rs.getString("proceso"));
                  p.setFechain(rs.getString("fechain"));
                  p.setFechaout(rs.getString("fechaout"));
                  p.setCantidadIn(rs.getInt("cantidadin"));
                  p.setCantidadOut(rs.getInt("cantidadout"));
                  p.setNotas(rs.getString("notas"));
                  p.setRealizadopor(rs.getString("realizado"));
                  list.add(p);
              }
              cn.close();
        } catch (SQLException e) {
              System.err.println("BD = "+e);
              return null;
        }
         return list;
    }

    
    public static void GuadarTrabajoPottingchips (inspe i) throws SQLException{
    Connection cn = Conn.getConnection();
    PreparedStatement ps = null;
    ps=cn.prepareStatement("insert into ORDENESPOTTINGCHIPS (no,trabajo,pn,fechain,fechaout,cantidadin,cantidadout,proceso,lote,notas,realizado) Values(?,?,?,?,?,?,?,?,?,?,?)");
    ps.setInt(1, i.getNo());
    ps.setString(2, i.getTrabajo());
    ps.setString(3, i.getPN());
    ps.setDate(4, new java.sql.Date(i.getFecha1().getTime()));
    ps.setString(5, i.getFecha2());    
    ps.setInt(6, i.getCantidadIn());
    ps.setInt(7, i.getCantidadOut());
    ps.setString(8, i.getProceso());
    ps.setString(9,i.getLote());
    ps.setString(10, i.getNotas());
    ps.setString(11, i.getRealizadopor());
    ps.executeUpdate();
    cn.close();
    ps.close();
    }  
    
    public static ArrayList<inspe> ListarPNPottingChips(String a){
    
           return SQL1("select no,trabajo,pn,fechain,fechaout,cantidadin,cantidadout,proceso,lote,notas,realizado from ORDENESPOTTINGCHIPS where upper(pn) like upper('"+a+"%') order by fechaout");
    }
    
    private static ArrayList<inspe> SQL1(String sql) {
          ArrayList<inspe> list = new ArrayList<inspe>();
          Connection cn = Conn.getConnection();
          
          try {
            inspe p;
              Statement stmt = cn.createStatement();
              ResultSet rs = stmt.executeQuery(sql);
              while (rs.next()){
                  
                  p = new inspe();
                  
                  p.setNo(rs.getInt("no"));
                  p.setPN(rs.getString("PN"));
                  p.setTrabajo(rs.getString("trabajo"));
                  p.setLote(rs.getString("lote"));
                  p.setProceso(rs.getString("proceso"));
                  p.setFechain(rs.getString("fechain"));
                  p.setFechaout(rs.getString("fechaout"));
                  p.setCantidadIn(rs.getInt("cantidadin"));
                  p.setCantidadOut(rs.getInt("cantidadout"));
                  p.setNotas(rs.getString("notas"));
                  p.setRealizadopor(rs.getString("realizado"));
                  list.add(p);
              }
              cn.close();
        } catch (SQLException e) {
              System.err.println("BD = "+e);
              return null;
        }
         return list;
    
    }
    
}
