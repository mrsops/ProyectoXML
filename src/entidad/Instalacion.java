/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.util.ArrayList;

/**
 * @author Carlos
 */
public class Instalacion {
    private String idInstalacion;
    private SubInstalaciones subInstalaciones;
    private String pedania;
    private String lugar;
    private String longitud;
    private String latitud;

    public Instalacion(String instID, String pedania, String lugar, String longitud, String latitud, SubInstalaciones subInstalaciones) {
        this.idInstalacion = instID;
        this.pedania = pedania;
        this.lugar = lugar;
        this.latitud = latitud;
        this.longitud = longitud;
        this.subInstalaciones = subInstalaciones;

    }

    public Instalacion() {
    }


    public ArrayList<SubInstalacion> getTiposInstalaciones() {
        return subInstalaciones;
    }

    public String getIdInstalacion() {
        return idInstalacion;
    }

    public void setIdInstalacion(String instalacionID) {
        this.idInstalacion = instalacionID;
    }


    public void setSubInstalaciones(SubInstalaciones subInstalaciones) {
        this.subInstalaciones = subInstalaciones;
    }

    public SubInstalaciones getSubInstalaciones() {
        return subInstalaciones;
    }

    public String getPedania() {
        return pedania;
    }

    public void setPedania(String pedania) {
        this.pedania = pedania;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }


    @Override
    public String toString() {
        return "Instalacion{" + ", titulo=" + idInstalacion + ", TiposInstalacion=" + subInstalaciones + ", a\u00f1o=" + pedania + ", precio=" + lugar + '}';
    }


}
