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
public class InstalacionesDeportivas extends ArrayList<Instalacion> {

    public InstalacionesDeportivas() {
    }

    public int getModCount() {
        return modCount;
    }

    public void setModCount(int modCount) {
        this.modCount = modCount;
    }

    public void mostrarInstalacionesDeportivas() {
        System.out.println("Información Instalaciones Deportivas");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i).toString());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");


    }

    @Override
    public String toString() {
        return "Existen " + this.size() + " intalaciones deportivas";
    }

}
