/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import javax.xml.soap.Node;
import modelo.TipoInstalacion;
import modelo.Instalacion;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author Carlos
 */
public class CtrlInstalacion extends ControlDom {

    public CtrlInstalacion() {
    }

    public Instalacion leerInstalacion(Document doc, Element book) {
        Instalacion libro = new Instalacion();
        Constantes cons = new Constantes();
        String titulo, autor, año, precio;
        libro.setAño(getValorEtiqueta(cons.ET_AUTOR, book));
        libro.setPrecio(getValorEtiqueta(cons.ET_PRECIO, book));
        libro.setTitulo(getValorEtiqueta(cons.ET_TITULO, book));

        Element eAutores = getElementEtiqueta(cons.ET_AUTORES, book);
       // libro.setAutores(leerTiposInstalacion(eAutores)); MODIFICAR
        return libro;
    }

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

    /* MODIFICAR
    public ArrayList<TipoInstalacion> leerTiposInstalacion(Element eAutores) { 
        Constantes cons = new Constantes();
        ArrayList<TipoInstalacion> autores = new ArrayList<>();
        Element pruba;
        NodeList nodeListAutores = eAutores.getElementsByTagName(cons.ET_AUTOR);
        for (int i = 0; i < nodeListAutores.getLength(); i++) {
            TipoInstalacion autor = new TipoInstalacion(nodeListAutores.item(i).getTextContent());
            autores.add(autor);
        }
        return autores;
    }
*/

    public void escribirTiposInstalacion(Document doc, Element eAutores, Instalacion b) {
        Constantes cons = new Constantes();

        for (int i = 0; i < b.getAutores().size(); i++) {
            Element autor = doc.createElement(cons.ET_AUTOR);
            autor.appendChild(doc.createTextNode(b.getAutores().get(i).getIdUbicacion()));
            eAutores.appendChild(autor);
        }
    }

}
