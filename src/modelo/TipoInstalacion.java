/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Carlos
 */
public class TipoInstalacion {

    private String idUbicacion;
    private String uso;
    private String cantidad;

    public TipoInstalacion(String nombre,String uso,String cantidad) {
        this.idUbicacion = nombre;
    }

    public String getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(String id) {
        this.idUbicacion = id;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    

    @Override
    public String toString() {
        return "Tipo{" + "id=" + this.idUbicacion + ", Uso="+this.uso +", cantidad="+this.cantidad +'}';
    }

}
