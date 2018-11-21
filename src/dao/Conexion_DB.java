/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidad.Instalacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
    
        
public class Conexion_DB {
    
    public Connection abrirConexion()throws Exception{
        
            Connection con=null;
            
        try {    
            
            Class.forName("com.mysql.jdbc.Connection");
            String urlOdbc="jdbc:mysql://localhost:3306/InstalacionesDeportivas";
            con=(java.sql.DriverManager.getConnection(urlOdbc, "root",""));
            
            return con; 
            
        } catch (Exception e) {
            e.printStackTrace();
            
            throw new Exception("Ha sido imposible establecer la conexion: " +e.getMessage());
        } 
    }
    public void cerrarConexion(Connection con)throws Exception{
        
        try{
        if(con!=null){
            con.close();            
        }
        
        } catch (SQLException e) {
            e.printStackTrace();
            
            throw new Exception("ha sido imposible cerrar la conexion: " +e.getMessage());
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
    
}
