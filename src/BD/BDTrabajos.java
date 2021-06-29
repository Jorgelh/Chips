/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Clases.CTrabajos;
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
public class BDTrabajos {
    
    public static  void InsertarTrabajo(CTrabajos t) throws SQLException{
        Connection c = BD.BDConexion.getConnection();
        PreparedStatement ps = null;
        {
            ps = c.prepareStatement("insert into trabajos values(?,?,?,?,?,?,?,?,?,sysdate,1)");
            ps.setInt(1, t.getId_trabajo());
            ps.setString(2, t.getPN());
            ps.setString(3, t.getJob());
            ps.setString(4, t.getCliente());
            ps.setInt(5, t.getCantidadlotes());
            ps.setInt(6, t.getCantidadporlote());
            ps.setDate(7, new java.sql.Date(t.getFechain().getTime()));
            ps.setString(8, t.getObservaciones());
            ps.setString(9, t.getNotas());
            ps.executeUpdate();
        }
          c.close();
          ps.close();
    }

     public static ArrayList<CTrabajos> ListarTrabajosA(String a , String b) {
        return SQL2("select LOTES.id_LOTE,TRABAJOS.PN,TRABAJOS.JOB,TRABAJOS.CLIENTE,TRABAJOS.NOTAS,lotes.NO_LOTE,lotes.CANTIDAD,TRABAJOS.OBSERVACIONES from TRABAJOS inner join lotes on trabajos.id_trabajo = lotes.id_trabajo WHERE UPPER(TRABAJOS.PN) LIKE UPPER('"+a+"%') and UPPER(JOB) LIKE UPPER('"+b+"%') and lotes.estado = 2  order by lotes.id_trabajo,lotes.no_lote" );
    }
     public static ArrayList<CTrabajos> ListarTrabajosB(String a , String b) {
        return SQL2("select LOTES.id_LOTE,TRABAJOS.PN,TRABAJOS.JOB,TRABAJOS.CLIENTE,TRABAJOS.NOTAS,lotes.NO_LOTE,lotes.CANTIDAD,TRABAJOS.OBSERVACIONES from TRABAJOS inner join lotes on trabajos.id_trabajo = lotes.id_trabajo WHERE UPPER(PN) LIKE UPPER('"+a+"%') and UPPER(JOB) LIKE UPPER('"+b+"%') and lotes.estado = 3  order by lotes.id_trabajo,lotes.no_lote" );
    }
     
    public static ArrayList<CTrabajos> ListarTrabajos(String a , String b) {
        return SQL2("select LOTES.id_LOTE,TRABAJOS.PN,TRABAJOS.JOB,TRABAJOS.CLIENTE,TRABAJOS.NOTAS,lotes.NO_LOTE,lotes.CANTIDAD,TRABAJOS.OBSERVACIONES from TRABAJOS inner join lotes on trabajos.id_trabajo = lotes.id_trabajo WHERE UPPER(PN) LIKE UPPER('"+a+"%') and UPPER(JOB) LIKE UPPER('"+b+"%') and lotes.estado = 1 order by LOTES.id_LOTE" );
    } 
    
    public static ArrayList<CTrabajos> ListarTrabajosNotas(String a , String b) {
        return SQL2("select LOTES.id_LOTE,TRABAJOS.PN,TRABAJOS.JOB,TRABAJOS.CLIENTE,TRABAJOS.NOTAS,lotes.NO_LOTE,lotes.CANTIDAD,TRABAJOS.OBSERVACIONES from TRABAJOS inner join lotes on trabajos.id_trabajo = lotes.id_trabajo WHERE UPPER(TRABAJOS.PN) LIKE UPPER('"+a+"%') and UPPER(JOB) LIKE UPPER('"+b+"%') and lotes.estado IN(1,2)  order by LOTES.id_LOTE" );
    } 
    
    public static ArrayList<CTrabajos> ListarTrabajosEditar(String a , String b) {
        return SQL2("select LOTES.id_LOTE,TRABAJOS.PN,TRABAJOS.JOB,TRABAJOS.CLIENTE,TRABAJOS.NOTAS,lotes.NO_LOTE,lotes.CANTIDAD,TRABAJOS.OBSERVACIONES from TRABAJOS inner join lotes on trabajos.id_trabajo = lotes.id_trabajo WHERE UPPER(PN) LIKE UPPER('"+a+"%') and UPPER(JOB) LIKE UPPER('"+b+"%') and lotes.estado = 1 order by LOTES.id_LOTE" );
    } 
       
    
    private static ArrayList<CTrabajos> SQL2(String sql){
    ArrayList<CTrabajos> list = new ArrayList<CTrabajos>();
    Connection cn = BD.BDConexion.getConnection();
        try {
            CTrabajos t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 t = new CTrabajos();
                 t.setId_trabajo(rs.getInt("ID_LOTE"));
                 t.setPN(rs.getString("PN"));
                 t.setJob(rs.getString("JOB"));
                 t.setCliente(rs.getString("CLIENTE"));
                 t.setNotas(rs.getString("NOTAS"));
                 t.setNo_lote(rs.getInt("NO_LOTE"));
                 t.setCantidadporlote(rs.getInt("CANTIDAD"));
                 t.setObservaciones(rs.getString("OBSERVACIONES"));
                 list.add(t);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error consulta "+e);
            return null;
        } 
        return list;
}
    

     
    
    public static CTrabajos buscarTrabajo(int a) throws SQLException{
        return buscarTrabajo(a ,null);
    }
    
    public static CTrabajos buscarTrabajo(int a, CTrabajos c) throws SQLException {
             
            Connection cn = BD.BDConexion.getConnection();
            PreparedStatement ps = null;
            ps = cn.prepareStatement("select lotes.id_lote,pn,job,cliente,lotes.cantidad,lotes.no_lote,fechain,lotes.nota from lotes inner join trabajos on lotes.id_trabajo = trabajos.id_trabajo where lotes.id_lote ="+a);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
               if (c==null)
               {c = new CTrabajos(){
               };
               }
               c.setId_trabajo(rs.getInt("id_lote"));
               c.setPN(rs.getString("pn"));
               c.setJob(rs.getString("job"));
               c.setCliente(rs.getString("cliente"));
               c.setCantidadporlote(rs.getInt("cantidad"));
               c.setNo_lote(rs.getInt("no_lote"));
               c.setInf_fecha(rs.getString("fechain"));
               c.setNotas(rs.getString("nota"));
            }
            cn.close();
            ps.close();
            return c;
}
    
    
    
public static CTrabajos buscarTrabajoEditar(int a) throws SQLException{
        return buscarTrabajoEdit(a ,null);
    }
    
    public static CTrabajos buscarTrabajoEdit(int a, CTrabajos c) throws SQLException {
             
            Connection cn = BD.BDConexion.getConnection();
            PreparedStatement ps = null;
            ps = cn.prepareStatement("select lotes.id_lote,pn,job,cliente,lotes.cantidad,lotes.no_lote,fechain,lotes.nota from lotes inner join trabajos on lotes.id_trabajo = trabajos.id_trabajo where lotes.id_lote ="+a);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
               if (c==null)
               {c = new CTrabajos(){
               };
               }
               c.setId_trabajo(rs.getInt("id_lote"));
               c.setPN(rs.getString("pn"));
               c.setJob(rs.getString("job"));
               c.setCliente(rs.getString("cliente"));
               c.setCantidadporlote(rs.getInt("cantidad"));
               c.setNo_lote(rs.getInt("no_lote"));
               c.setInf_fecha(rs.getString("fechain"));
               c.setNotas(rs.getString("nota"));
            }
            cn.close();
            ps.close();
            return c;
}    
    
    
public static CTrabajos buscarTrabajoHistorial(int a) throws SQLException{
        return buscarTrabajoHistorial1(a ,null);
    }
    
    public static CTrabajos buscarTrabajoHistorial1(int a, CTrabajos c) throws SQLException {
             
            Connection cn = BD.BDConexion.getConnection();
            PreparedStatement ps = null;
            ps = cn.prepareStatement("select lotes.fechafin,lotes.id_lote,trabajos.pn,trabajos.job,trabajos.cliente,lotes.cantidad,lotes.no_lote,lotes.fechainicio,trabajos.notas,TRUNC(TO_DATE(lotes.fechafin,'dd/mm/yyyy')-TO_DATE(lotes.fechainicio,'dd/mm/yyyy')) as \"DiasP\" from lotes inner join trabajos on lotes.id_trabajo = trabajos.id_trabajo where lotes.id_lote ="+a);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
               if (c==null)
               {c = new CTrabajos(){
               };
               }
               c.setId_trabajo(rs.getInt("id_lote"));
               c.setPN(rs.getString("pn"));
               c.setJob(rs.getString("job"));
               c.setCliente(rs.getString("cliente"));
               c.setCantidadporlote(rs.getInt("cantidad"));
               c.setNo_lote(rs.getInt("no_lote"));
               c.setInf_fecha(rs.getString("fechainicio"));
               c.setNotas(rs.getString("notas"));
               c.setDiaspro(rs.getInt("DiasP"));
               c.setFechafin(rs.getString("fechafin"));
            }
            cn.close();
            ps.close();
            return c;
}    
    
    
public static boolean IniciarTra(CTrabajos t) throws SQLException{
        Connection cn = BD.BDConexion.getConnection();
        PreparedStatement ps = null;
        ps = cn.prepareStatement("UPDATE LOTES SET ESTADO = 2, FECHAINICIO = ? WHERE ID_LOTE ="+t.getId_lote());
        ps.setDate(1,new java.sql.Date(t.getFechainicio().getTime()));    
        int rowsUpdated = ps.executeUpdate();
        cn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

public static boolean EditarNota(CTrabajos t) throws SQLException{
        Connection cn = BD.BDConexion.getConnection();
        PreparedStatement ps = null;
        ps = cn.prepareStatement("UPDATE LOTES SET NOTA = ? ,  CANTIDAD = ? WHERE ID_LOTE ="+t.getId_lote());
        ps.setString(1, t.getNotas());
        ps.setInt(2, t.getCantidadporlote());
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
