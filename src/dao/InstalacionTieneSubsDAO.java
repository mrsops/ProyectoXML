/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidad.Instalacion;
import entidad.SubInstalacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author mrsops
 */
public class InstalacionTieneSubsDAO {

    public void insertar(Connection con, Instalacion instalacion, SubInstalacion subInstalacion) throws Exception {
        PreparedStatement stmt = null;

        try {
            if (!relacionExiste(con, instalacion, subInstalacion)) {
                stmt = con.prepareStatement("INSERT INTO tienesubinstalaciones (IdInstalacion, IdSubInstalacion, Cantidad ) VALUES(?,?,?)");
                //stmt.setInt(1, instalacion.getIdInstalacion());
                stmt.setInt(1, instalacion.getIdInstalacion());
                stmt.setInt(2, subInstalacion.getIdSubInstalacion());
                stmt.setInt(3, subInstalacion.getCantidad());
                stmt.executeUpdate();
            } else {
                System.out.println("La relacion entre " + instalacion.getLocalizacion() + " y " + subInstalacion.getUso() + " Ya existe");
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

    public boolean relacionExiste(Connection con, Instalacion instalacion, SubInstalacion subInstalacion) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean existe = false;
        try {
            stmt = con.prepareStatement("SELECT * FROM tienesubinstalaciones WHERE IdInstalacion=? AND IdSubInstalacion=?");
            stmt.setInt(1, instalacion.getIdInstalacion());
            stmt.setInt(2, subInstalacion.getIdSubInstalacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                existe = true;
            }

        } catch (Exception e) {
        }
        return existe;

    }

    public void buscarSubInstalaciones(Connection con, Instalacion instalacion) {
        PreparedStatement stmt = null;
        ArrayList<SubInstalacion> subInstalaciones = new ArrayList<>();
        ArrayList<SubInstalacion> subCompletos = new ArrayList<>();
        ResultSet rs = null;
        SubInstalacionDAO subDao = new SubInstalacionDAO();

        try {
            stmt = con.prepareStatement("SELECT * FROM tienesubinstalaciones WHERE IdInstalacion=?");
            stmt.setInt(1, instalacion.getIdInstalacion());
            rs = stmt.executeQuery();
            while (rs.next()) {

                SubInstalacion subinstalacion = new SubInstalacion();
                obtenFila(rs, subinstalacion);
                subInstalaciones.add(subinstalacion);
            }
            for (SubInstalacion s : subInstalaciones) {
                stmt = con.prepareStatement("SELECT * FROM subinstalaciones WHERE IdSubInstalacion=?");
                stmt.setInt(1, s.getIdSubInstalacion());
                rs = stmt.executeQuery();
                while (rs.next()) {
                    int cantidad = s.getCantidad();
                    s = subDao.findByIdSubInstalacion(con, s);
                    s.setCantidad(cantidad);
                    subCompletos.add(s);
                }
            }
            instalacion.setSubInstalaciones(subCompletos);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void obtenFila(ResultSet rs, SubInstalacion subInstalacion) throws Exception {
        subInstalacion.setIdSubInstalacion(rs.getInt("IdSubInstalacion"));
        subInstalacion.setCantidad(rs.getInt("Cantidad"));
    }

}
