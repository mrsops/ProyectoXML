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
            stmt = con.prepareStatement("INSERT INTO SubInstalacion ( Uso ) VALUES(?)");
            stmt.setString(1, subInstalacion.getUso());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("problemas al insertar la instalacion " + ex.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
    
    /*
    public SubInstalacion findByIdTipoInstalacion(Connection con, SubInstalacion tipo) throws Exception{
        
        PreparedStatement stmt=null;
        ResultSet rs=null;
        
        try{
         stmt = con.prepareStatement("SELECT * FROM SubInstalacion WHERE IdTipo=?");
         stmt.setInt(1, tipo.getIdTipo());
         rs = stmt.executeQuery();
            
            while(rs.next()){
                tipo=new SubInstalacion();
                obtenTipoFila(rs, tipo);
            }
         
        }catch (SQLException ex){
           ex.printStackTrace();
           throw new Exception("problema al buscar por Id "+ex.getMessage());
        }finally
        {
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();
        }
        return tipo;
        
        
        
    }
    */

    /*
    private void obtenTipoFila(ResultSet rs, SubInstalacion tipo) throws Exception{
        
        tipo.setIdTipo(rs.getInt("IdInstalacion"));
        tipo.setUso(rs.getString("Pedania"));
    }

    */


}
