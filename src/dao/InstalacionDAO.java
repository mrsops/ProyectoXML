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
import entidad.InstalacionesDeportivas;
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
     */
    public void insertar(Connection con, Instalacion instalacion) throws Exception {

        PreparedStatement stmt = null;
        System.out.println("Tiene " + instalacion.getSubInstalaciones().size() + " subinstalaciones");

        try {
            Instalacion inst = findByIdInstalacion(con, instalacion);
            if (inst == null) { // comparamos que no exista en la BD
                // Si no existe en la BD, la añadimos
                stmt = con.prepareStatement("INSERT INTO Instalaciones (Localizacion, Lugar, Longitud, Latitud, Es_Barrio) VALUES(?,?,?,?,?,?)");
                //stmt.setInt(1, id);
                stmt.setString(1, instalacion.getLocalizacion());
                stmt.setString(2, instalacion.getLugar());
                stmt.setString(3, instalacion.getLongitud());
                stmt.setString(4, instalacion.getLatitud());
                stmt.setBoolean(5, instalacion.isBarrio());
                stmt.executeUpdate();

            } else {
                System.out.println("Instalacion con id " + inst.getIdInstalacion() + " y Localizacion " + inst.getLocalizacion() + ", Ya existe");

            }

            for (SubInstalacion sub : instalacion.getSubInstalaciones()) {
                InstalacionTieneSubsDAO tieneSubsDao = new InstalacionTieneSubsDAO();
                SubInstalacionDAO subsDao = new SubInstalacionDAO();
                SubInstalacion subI = subsDao.findByUso(con, sub);
                if (subI == null) {
                    System.out.println("Entra en la parte de subI = null");
                    subsDao.insertar(con, sub);
                    sub.setIdSubInstalacion(subsDao.findByUso(con, sub).getIdSubInstalacion());

                } else {
                    sub.setIdSubInstalacion(subI.getIdSubInstalacion());
                }
                System.out.println("Id de subinstalacion " + sub.getIdSubInstalacion());
                tieneSubsDao.insertar(con, instalacion, sub);
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

    public void insertar(Connection con, Instalacion instalacion, int id) throws Exception {
        PreparedStatement stmt = null;
        System.out.println("Tiene " + instalacion.getSubInstalaciones().size() + " subinstalaciones");

        try {
            Instalacion inst = findByIdInstalacion(con, instalacion);
            if (inst == null) { // comparamos que no exista en la BD
                // Si no existe en la BD, la añadimos
                stmt = con.prepareStatement("INSERT INTO Instalaciones (IdInstalacion, Localizacion, Lugar, Longitud, Latitud, Es_Barrio) VALUES(?,?,?,?,?,?)");
                stmt.setInt(1, id);
                stmt.setString(2, instalacion.getLocalizacion());
                stmt.setString(3, instalacion.getLugar());
                stmt.setString(4, instalacion.getLongitud());
                stmt.setString(5, instalacion.getLatitud());
                stmt.setBoolean(6, instalacion.isBarrio());
                stmt.executeUpdate();

            } else {
                System.out.println("Instalacion con id " + inst.getIdInstalacion() + " y Localizacion " + inst.getLocalizacion() + ", Ya existe");

            }

            for (SubInstalacion sub : instalacion.getSubInstalaciones()) {
                InstalacionTieneSubsDAO tieneSubsDao = new InstalacionTieneSubsDAO();
                SubInstalacionDAO subsDao = new SubInstalacionDAO();
                SubInstalacion subI = subsDao.findByUso(con, sub);
                if (subI == null) {

                    subsDao.insertar(con, sub);
                    sub.setIdSubInstalacion(subsDao.findByUso(con, sub).getIdSubInstalacion());

                } else {
                    sub.setIdSubInstalacion(subI.getIdSubInstalacion());
                }
                
                tieneSubsDao.insertar(con, instalacion, sub);
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

    /*
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
    
     */
    public Instalacion findByIdInstalacion(Connection con, Instalacion instalacion) throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM Instalaciones WHERE IdInstalacion=?");
            stmt.setInt(1, instalacion.getIdInstalacion());
            rs = stmt.executeQuery();
            boolean existe = false;
            while (rs.next()) {
                existe = true;
                instalacion = new Instalacion();
                obtenInstalacionFila(rs, instalacion);
            }
            if (!existe) {
                return null;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("problema al buscar por DNI " + ex.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return instalacion;
    }

    public ArrayList<Instalacion> findByLocalizacion(Connection con, Instalacion instalacion) throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Instalacion> instalaciones = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Instalaciones WHERE Localizacion=?");
            stmt.setString(1, instalacion.getLocalizacion());
            rs = stmt.executeQuery();

            while (rs.next()) {
                Instalacion ins = new Instalacion();
                obtenInstalacionFila(rs, ins);
                instalaciones.add(ins);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("problema al buscar por DNI " + ex.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return instalaciones;
    }

    private void obtenInstalacionFila(ResultSet rs, Instalacion instalacion) throws Exception {

        instalacion.setIdInstalacion(rs.getInt("IdInstalacion"));
        instalacion.setLocalizacion(rs.getString("Localizacion"));
        instalacion.setLugar(rs.getString("Lugar"));
        instalacion.setLongitud(rs.getString("Longitud"));
        instalacion.setLatitud(rs.getString("Latitud"));
    }
    
    public InstalacionesDeportivas findAll(Connection con) throws Exception{
        PreparedStatement stmt = null;
        ResultSet rs = null;
        InstalacionesDeportivas instalaciones = new InstalacionesDeportivas();
        InstalacionTieneSubsDAO itsd = new InstalacionTieneSubsDAO();

        try {
            stmt = con.prepareStatement("SELECT * FROM Instalaciones");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Instalacion instalacion = new Instalacion();
                obtenInstalacionFila(rs, instalacion);
                itsd.buscarSubInstalaciones(con, instalacion);
                instalaciones.add(instalacion);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("problema al buscar por DNI " + ex.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return instalaciones;
    }

}
