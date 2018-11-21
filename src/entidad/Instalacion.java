/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Instalacion {
    private int idInstalacion;
    private ArrayList<TipoInstalacion> tiposInstalacion=new ArrayList<>();
    private String pedania;
    private String lugar;
    private String longitud;
    private String latitud;

    public Instalacion(int instID, String pedania, String lugar, String longitud, String latitud) {
        this.idInstalacion = instID;
        this.pedania = pedania;
        this.lugar = lugar;
        this.latitud=latitud;
        this.longitud = longitud;
        
    }
    public Instalacion(){}


    public ArrayList<TipoInstalacion> getTiposInstalaciones() {
        return tiposInstalacion;
    }

    public int getIdInstalacion() {
        return idInstalacion;
    }

    public void setIdInstalacion(int instalacionID) {
        this.idInstalacion = instalacionID;
    }


    public void setTiposInstalacion(ArrayList<TipoInstalacion> tiposInstalacion) {
        this.tiposInstalacion = tiposInstalacion;
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
        return "Instalacion{" + ", titulo=" + idInstalacion + ", TiposInstalacion=" + tiposInstalacion + ", a\u00f1o=" + pedania + ", precio=" + lugar + '}';
    }
    
    
    
    
}
