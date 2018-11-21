/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidad.Instalacion;
import entidad.TipoInstalacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author mrsops
 */
public class InstalacionTieneTiposDAO {
    public void insertar(Connection con, Instalacion instalacion) throws Exception{
        PreparedStatement stmt=null;
        
        try{
            stmt=con.prepareStatement("INSERT INTO Instalacion (Id, Pedania, Lugar, Longitud, Latitud ) VALUES(?,?,?,?,?)");
            stmt.setInt(1, instalacion.getIdInstalacion());
            stmt.setString(2, instalacion.getPedania());
            stmt.setString(3, instalacion.getLugar());
            stmt.setString(4, instalacion.getLongitud());
            stmt.setString(5, instalacion.getLatitud());
            stmt.executeUpdate();
            
            for(TipoInstalacion tI : instalacion.getTiposInstalaciones()){
                stmt=con.prepareStatement("INSERT INTO TipoInstalacion ( Uso ) VALUES(?)");
                stmt.setString(1, tI.getUso());
                stmt.executeUpdate();
                
                stmt=con.prepareStatement("INSERT INTO TieneTiposInstalaciones ( IdInstalacion, IdTipo, Cantidad ) VALUES(?,?,?)");
                stmt.setInt(1, instalacion.getIdInstalacion());
                stmt.setInt(2, tI.getIdTipo());
                stmt.setString(3, tI.getCantidad());
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
}
