/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Instalacion {
    private String instalacionID;
    private ArrayList<TipoInstalacion> tiposInstalacion=new ArrayList<>();
    private String pedania;
    private String lugar;
    private String longitud;
    private String latitud;

    public Instalacion(String instID, String pedania, String lugar, String longitud, String latitud) {
        this.instalacionID = instID;
        this.pedania = pedania;
        this.lugar = lugar;
        this.latitud=latitud;
        this.longitud = longitud;
        
    }
    public Instalacion(){}

    public String getTitulo() {
        return instalacionID;
    }

    public void setTitulo(String titulo) {
        this.instalacionID = titulo;
    }

    public ArrayList<TipoInstalacion> getAutores() {
        return tiposInstalacion;
    }

    public void setAutores(ArrayList<TipoInstalacion> tiposInst) {
        this.tiposInstalacion = tiposInst;
    }

    public String getAño() {
        return pedania;
    }

    public void setAño(String año) {
        this.pedania = año;
    }

    public String getPrecio() {
        return lugar;
    }

    public void setPrecio(String precio) {
        this.lugar = precio;
    }

    @Override
    public String toString() {
        return "Instalacion{" + ", titulo=" + instalacionID + ", TiposInstalacion=" + tiposInstalacion + ", a\u00f1o=" + pedania + ", precio=" + lugar + '}';
    }
    
    
    
    
}
