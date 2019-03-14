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

    private int idSubInstalacion;
    private String uso;
    private int cantidad;

    public SubInstalacion() {
    }

    public SubInstalacion(int id, String uso, String cantidad) {
        this.idSubInstalacion = id;
    }

    public int getIdSubInstalacion() {
        return idSubInstalacion;
    }

    public void setIdSubInstalacion(int idSubInstalacion) {
        this.idSubInstalacion = idSubInstalacion;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    


    @Override
    public String toString() {
        return "Tipo{" + "id=" + this.idSubInstalacion + ", Uso=" + this.uso + ", cantidad=" + this.cantidad + '}';
    }

}
