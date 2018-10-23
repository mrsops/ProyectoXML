/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import modelo.Instalacion;
import modelo.InstalacionesDeportivas;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import controlador.Constantes.*;

/**
 *
 * @author Carlos
 */
public class CtrlInstalacionesDeportivas extends ControlDom {

    ArrayList<Instalacion> listaLibros;
    InstalacionesDeportivas bStore;

    public Document recuperar(File xmlFile) throws ParserConfigurationException, SAXException, IOException {
        Document doc = null;
        doc = deXMLaDOM(xmlFile);
        return doc;
    }

    public void almacenar(Document doc, File archivoDestino) throws TransformerException {
        deDOMaXML(doc, archivoDestino);
    }

    public InstalacionesDeportivas leerInstalacionesDeportivas(Document doc) {
        Element raiz = doc.getDocumentElement();
        NodeList listaInstalaciones = raiz.getChildNodes();
        InstalacionesDeportivas insDeportivas = new InstalacionesDeportivas();
        CtrlInstalacion ctrlInstalacion = new CtrlInstalacion();
        for (int i = 0; i < listaInstalaciones.getLength(); i++) {
            if (listaInstalaciones.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Instalacion b = ctrlInstalacion.leerInstalacion(doc, (Element) listaInstalaciones.item(i));
                System.out.println("Leida instalación:  " + b.toString());
                insDeportivas.add(b);
            }
        }
        System.out.println("Se devuelve las instalaciones deportivas con " + insDeportivas.size() + " instalaciones");
        return insDeportivas;
    }

    public void escribirInstalacionesDeportivas(Document doc, InstalacionesDeportivas insDep, Element raiz) {
        CtrlInstalacion cInstalacion = new CtrlInstalacion();
        for (int i = 0; i < insDep.size(); i++) {
            Element instalacion = doc.createElement(Constantes.ET_INSTALACION);
            raiz.appendChild(instalacion);
            //instalacion.setAttribute("category", bs.get(i).getCategoria());
            //if (bs.get(i).getCover() != "") {
            //    instalacion.setAttribute("cover", bs.get(i).getCover());
            //}
            cInstalacion.escribirInstalacion(doc, instalacion, insDep.get(i));
        }
    }

}
