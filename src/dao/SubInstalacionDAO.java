/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidad.SubInstalacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author mrsops
 */
public class SubInstalacionDAO {


    public void insertar(Connection con, SubInstalacion subInstalacion) throws Exception {
        PreparedStatement stmt = null;
        
        try {
            SubInstalacion subI = findByUso(con, subInstalacion);
            if(subI==null){
            if (subInstalacion.getIdSubInstalacion()!= -1){
                stmt = con.prepareStatement("INSERT INTO subInstalaciones ( IdSubinstalacion, Uso ) VALUES(?,?)");
                stmt.setInt(1, subInstalacion.getIdSubInstalacion());
                stmt.setString(2, subInstalacion.getUso());
            }else{
                stmt = con.prepareStatement("INSERT INTO subInstalaciones ( Uso ) VALUES(?)");
                stmt.setString(1, subInstalacion.getUso());
            }
            System.out.println("Se ha intentado insertar sub inst");
            
            stmt.executeUpdate();
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("problemas al insertar la instalacion " + ex.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
    
    
    public SubInstalacion findByIdSubInstalacion(Connection con, SubInstalacion subInstalacion) throws Exception{
        
        PreparedStatement stmt=null;
        ResultSet rs=null;
        
        try{
         stmt = con.prepareStatement("SELECT * FROM subInstalaciones WHERE IdSubInstalacion=?");
         stmt.setInt(1, subInstalacion.getIdSubInstalacion());
         rs = stmt.executeQuery();
            
            while(rs.next()){
                subInstalacion=new SubInstalacion();
                obtenSubInstalacionFila(rs, subInstalacion);
            }
         
        }catch (SQLException ex){
           ex.printStackTrace();
           throw new Exception("problema al buscar por Id "+ex.getMessage());
        }finally
        {
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();
        }
        return subInstalacion;
    }
    
    public SubInstalacion findByUso(Connection con, SubInstalacion subInstalacion) throws Exception{
        
        PreparedStatement stmt=null;
        ResultSet rs=null;
        
        try{
         stmt = con.prepareStatement("SELECT * FROM subInstalaciones WHERE uso=?");
         stmt.setString(1, subInstalacion.getUso());
         rs = stmt.executeQuery();
            
         boolean existe = false;
            while(rs.next()){
                existe = true;
                subInstalacion=new SubInstalacion();
                obtenSubInstalacionFila(rs, subInstalacion);
            }
            if(!existe){
                return null;
            }
         
        }catch (SQLException ex){
           ex.printStackTrace();
           throw new Exception("problema al buscar por Id "+ex.getMessage());
        }finally
        {
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();
        }
        return subInstalacion;
    }
    

    
    private void obtenSubInstalacionFila(ResultSet rs, SubInstalacion subInstalacion) throws Exception{
     
        subInstalacion.setIdSubInstalacion(rs.getInt("IdSubInstalacion"));
        subInstalacion.setUso(rs.getString("Uso"));
    }

    


}
