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
    private int idInstalacion;
    private String localizacion;
    private String lugar;
    private String longitud;
    private String latitud;
    private ArrayList<SubInstalacion> subInstalaciones;
    private boolean barrio;

    public Instalacion(int instID, String pedania, String lugar, String longitud, String latitud, ArrayList<SubInstalacion> subInstalaciones) {
        this.idInstalacion = instID;
        this.localizacion = pedania;
        this.lugar = lugar;
        this.latitud = latitud;
        this.longitud = longitud;
        this.subInstalaciones = subInstalaciones;
        this. barrio = false;

    }

    public Instalacion() {
    }


    public int getIdInstalacion() {
        return idInstalacion;
    }

    public void setIdInstalacion(int instalacionID) {
        this.idInstalacion = instalacionID;
    }


    public void setSubInstalaciones(ArrayList<SubInstalacion> subInstalaciones) {
        this.subInstalaciones = subInstalaciones;
    }

    public ArrayList<SubInstalacion> getSubInstalaciones() {
        return subInstalaciones;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
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

    public boolean isBarrio() {
        return barrio;
    }

    public void setBarrio(boolean barrio) {
        this.barrio = barrio;
    }

    @Override
    public String toString() {
        if(barrio){
            return "Instalacion{" + " Id=" + idInstalacion + ", SubInstalaciones=" + subInstalaciones + ", barrio=" + localizacion + ", lugar=" + lugar + '}';
        }else {
            return "Instalacion{" + " Id=" + idInstalacion + ", SubInstalaciones=" + subInstalaciones + ", pedania=" + localizacion + ", lugar=" + lugar + '}';
        }


    }


}
