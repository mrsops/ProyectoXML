/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidad.SubInstalacion;
import entidad.Instalacion;
import entidad.InstalacionesDeportivas;

/**
 * @author Carlos
 */
public class Constantes {

    public static final String ET_INSTALACION = "instalacion";
    public static final String ET_ID_INSTALACION = "id";
    public static final String ET_PEDANIA = "pedania";
    public static final String ET_LUGAR = "lugar";
    public static final String ET_LONGITUD = "longitud";
    public static final String ET_LATITUD = "latitud";
    public static final String ET_SUBINSTALACIONES = "subinstalaciones";
    public static final String ET_SUBINSTALACION = "subinstalacion";
    public static final String ET_UBICACION = "idubicacion";
    public static final String ET_USO = "uso";
    public static final String ET_CANTIDAD = "cantidad";
    public static final String ET_BARRIO = "barrio";
    public static final String ET_INSTALACIONES_DEPORTIVAS = "instalaciones-deportivas";

    public Constantes() {
    }
/*
    public void altaLibrosDefault(InstalacionesDeportivas bs) {
        Instalacion book = new Instalacion("78", "BOCAIRENT", "Polideportivo Municipal", "2011", "28.69");
        book.getAutores().add(new SubInstalacion("ID", "USO", "CANTIDAD"));
        book.getAutores().add(new SubInstalacion("ID", "USO", "CANTIDAD"));
        
        Instalacion book2 = new Instalacion("Childrens", "paperback", "Hunger Games: Catching Fire", "2013", "17.10");
        book2.getAutores().add(new SubInstalacion("ID", "USO", "CANTIDAD"));
        
        Instalacion book3 = new Instalacion("Fiction YA", "hardcover", "Eldest", "2005", "16.15");
        book3.getAutores().add(new SubInstalacion("ID", "USO", "CANTIDAD"));

        
        bs.add(book);
        bs.add(book2);
        bs.add(book3);
    }
*/
}
