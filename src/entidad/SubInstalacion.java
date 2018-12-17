/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

/**
 * @author Carlos
 */
public class SubInstalacion {

    private String idTipo;
    private String uso;
    private String cantidad;

    public SubInstalacion() {
    }

    public SubInstalacion(String id, String uso, String cantidad) {
        this.idTipo = id;
    }

    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String id) {
        this.idTipo = id;
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
        return "Tipo{" + "id=" + this.idTipo + ", Uso=" + this.uso + ", cantidad=" + this.cantidad + '}';
    }

}
