/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidad.Instalacion;
import entidad.SubInstalacion;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author mrsops
 */
public class InstalacionDAO {
    /*
    
    public void actualiza(Connection con, Instalacion  instalacion) throws Exception{
        PreparedStatement stmt=null;
        
        try {
            stmt = con.prepareStatement("UPDATE Instalacion SET Pedania=?, Lugar=?, Longitud=?, Latitud=? WHERE IdInstalacio=? ");
            stmt.setString(1, instalacion.getPedania());
            stmt.setString(2, instalacion.getLugar());
            stmt.setString(3, instalacion.getLongitud());
            stmt.setString(4, instalacion.getLatitud());
            stmt.setInt(5, instalacion.getIdInstalacion());
            
                    
            stmt.executeUpdate();
        
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw  new Exception("Problemas al actualizar la instalacion "+ex.getMessage());
        } finally
        {
            if(stmt!=null){
                stmt.close();
            }
        }
    } 
    
    public void insertar(Connection con, Instalacion instalacion) throws Exception{
        PreparedStatement stmt=null;
        
        try{
            Instalacion inst = findByIdInstalacion(con, instalacion);
            if (inst != null && inst.getIdInstalacion() == instalacion.getIdInstalacion()){ // comparamos que no exista en la BD
                // Si no existe en la BD, la añadimos
            stmt=con.prepareStatement("INSERT INTO Instalacion (Id, Pedania, Lugar, Longitud, Latitud ) VALUES(?,?,?,?,?)");
            stmt.setInt(1, instalacion.getIdInstalacion());
            stmt.setString(2, instalacion.getPedania());
            stmt.setString(3, instalacion.getLugar());
            stmt.setString(4, instalacion.getLongitud());
            stmt.setString(5, instalacion.getLatitud());
            stmt.executeUpdate();
            
            for(SubInstalacion tI : instalacion.getTiposInstalaciones()){
                stmt=con.prepareStatement("INSERT INTO SubInstalacion ( Uso ) VALUES(?)");
                stmt.setString(1, tI.getUso());
                stmt.executeUpdate();
                
                stmt=con.prepareStatement("INSERT INTO TieneTiposInstalaciones ( IdInstalacion, IdTipo, Cantidad ) VALUES(?,?,?)");
                stmt.setInt(1, instalacion.getIdInstalacion());
                stmt.setInt(2, tI.getIdTipo());
                stmt.setString(3, tI.getCantidad());
            }
            }
            
        
        } catch (SQLException ex){
            ex.printStackTrace();
            throw new Exception("problemas al insertar la instalacion "+ex.getMessage());
        } finally
        {
           if(stmt!=null){
                stmt.close();
            }
        }
    }
    
    
    public void elimina(Connection con, Instalacion instalacion) throws Exception{
        PreparedStatement stmt=null;
        
        try{
           stmt=con.prepareStatement("DELETE FROM Instalacion WHERE IdInstalacion=?");
           stmt.setInt(1, instalacion.getIdInstalacion());
           stmt.executeUpdate();
           
        } catch (SQLException ex){
            ex.printStackTrace();
            throw new Exception("problemas al insertar el cliente "+ex.getMessage());
        } finally
        {
           if(stmt!=null){
                stmt.close();
            }
        } 
    }
    
    
    
    public Instalacion findByIdInstalacion(Connection con, Instalacion instalacion) throws Exception{
        PreparedStatement stmt=null;
        ResultSet rs=null;
        
        try{
         stmt = con.prepareStatement("SELECT * FROM Instalacion WHERE IdInstalacion=?");
         stmt.setInt(1, instalacion.getIdInstalacion());
         rs = stmt.executeQuery();
            
            while(rs.next()){
                instalacion=new Instalacion();
                obtenInstalacionFila(rs, instalacion);
            }
         
        }catch (SQLException ex){
           ex.printStackTrace();
           throw new Exception("problema al buscar por DNI "+ex.getMessage());
        }finally
        {
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();
        }
        return instalacion;
    }
    
        public ArrayList<Instalacion> findByPedania(Connection con, Instalacion instalacion) throws Exception{
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Instalacion> instalaciones = new ArrayList<>();
        
        try{
         stmt = con.prepareStatement("SELECT * FROM Instalacion WHERE Pedania=?");
         stmt.setString(1, instalacion.getPedania());
         rs = stmt.executeQuery();
            
            while(rs.next()){
                Instalacion ins = new Instalacion();
                obtenInstalacionFila(rs, ins);
                instalaciones.add(ins);
            }
         
        }catch (SQLException ex){
           ex.printStackTrace();
           throw new Exception("problema al buscar por DNI "+ex.getMessage());
        }finally
        {
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();
        }
        return instalaciones;
    }
    
    
    
    
    private void obtenInstalacionFila(ResultSet rs, Instalacion instalacion) throws Exception{
        
        instalacion.setIdInstalacion(rs.getInt("IdInstalacion"));
        instalacion.setPedania(rs.getString("Pedania"));
        instalacion.setLugar(rs.getString("Lugar"));
        instalacion.setLongitud(rs.getString("Longitud"));
        instalacion.setLatitud(rs.getString("Latitud"));
    }
    */
}
