/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.TipoInstalacion;
import modelo.Instalacion;
import modelo.InstalacionesDeportivas;

/**
 *
 * @author Carlos
 */
public class Constantes {

    public static final String ET_TITULO = "title";
    public static final String ET_AUTOR = "author";
    public static final String ET_AÑO = "year";
    public static final String ET_PRECIO = "price";
    public static final String ET_AUTORES="autores";
    public static final String ET_INSTALACION="instalacion";

    public Constantes() {
    }

    public void altaLibrosDefault(InstalacionesDeportivas bs) {
        Instalacion book = new Instalacion("78", "BOCAIRENT", "Polideportivo Municipal", "2011", "28.69");
        book.getAutores().add(new TipoInstalacion("ID", "USO", "CANTIDAD"));
        book.getAutores().add(new TipoInstalacion("ID", "USO", "CANTIDAD"));
        
        Instalacion book2 = new Instalacion("Childrens", "paperback", "Hunger Games: Catching Fire", "2013", "17.10");
        book2.getAutores().add(new TipoInstalacion("ID", "USO", "CANTIDAD"));
        
        Instalacion book3 = new Instalacion("Fiction YA", "hardcover", "Eldest", "2005", "16.15");
        book3.getAutores().add(new TipoInstalacion("ID", "USO", "CANTIDAD"));

        
        bs.add(book);
        bs.add(book2);
        bs.add(book3);
    }

}
