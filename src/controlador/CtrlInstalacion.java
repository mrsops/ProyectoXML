/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidad.Instalacion;
import entidad.SubInstalacion;
import entidad.SubInstalaciones;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Carlos
 */
public class CtrlInstalacion extends ControlDom {

    public CtrlInstalacion() {
    }

    public Instalacion leerInstalacion(Document doc, Element instalacion) {
        Instalacion ins = new Instalacion();
        Constantes cons = new Constantes();
        String titulo, autor, año, precio;
        ins.setIdInstalacion(getValorEtiqueta(cons.ET_ID_INSTALACION, instalacion));
        ins.setPedania(getValorEtiqueta(cons.ET_PEDANIA, instalacion));
        ins.setLugar(getValorEtiqueta(cons.ET_LUGAR, instalacion));
        ins.setLatitud(getValorEtiqueta(cons.ET_LATITUD, instalacion));
        ins.setLongitud(getValorEtiqueta(cons.ET_LONGITUD, instalacion));
        SubInstalaciones subs = new SubInstalaciones();
        subs = leerSubInstalaciones(doc, instalacion);
        ins.setSubInstalaciones(subs);

        return ins;
    }

    /*
    public void escribirInstalacion(Document doc, Element book, Instalacion libro) {
        Constantes cons = new Constantes();

        Element title = doc.createElement(cons.ET_TITULO);
        title.appendChild(doc.createTextNode(libro.getTitulo()));
        book.appendChild(title);

        Element eAutores = doc.createElement(cons.ET_AUTORES);
        escribirTiposInstalacion(doc, eAutores, libro);
        book.appendChild(eAutores);

        Element year = doc.createElement(cons.ET_AÑO);
        year.appendChild(doc.createTextNode(libro.getAño()));
        book.appendChild(year);

        Element price = doc.createElement(cons.ET_PRECIO);
        price.appendChild(doc.createTextNode(libro.getPrecio()));
        book.appendChild(price);
    }
*/

    public SubInstalaciones leerSubInstalaciones(Document doc, Element instalacion) {
        Constantes cons = new Constantes();
        SubInstalaciones subInsLista = new SubInstalaciones();

        NodeList listaSubInstalaciones = instalacion.getElementsByTagName(cons.ET_SUBINSTALACION);
        CtrlSubInstalacion ctrlSubInstalacion = new CtrlSubInstalacion();

        for (int i = 0; i < listaSubInstalaciones.getLength(); i++) {
            if (listaSubInstalaciones.item(i).getNodeType() == Node.ELEMENT_NODE) {
                SubInstalacion si = ctrlSubInstalacion.leerSubInstalacion(doc, (Element) listaSubInstalaciones.item(i));
                System.out.println("Leida instalación:  " + si.toString());
                subInsLista.add(si);
            }
        }
        return subInsLista;
    }

    /*
    public void escribirTiposInstalacion(Document doc, Element eAutores, Instalacion b) {
        Constantes cons = new Constantes();

        for (int i = 0; i < b.getAutores().size(); i++) {
            Element autor = doc.createElement(cons.ET_AUTOR);
            autor.appendChild(doc.createTextNode(b.getAutores().get(i).getIdUbicacion()));
            eAutores.appendChild(autor);
        }
    }

    */

}
