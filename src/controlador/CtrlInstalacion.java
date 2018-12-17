/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidad.Instalacion;
import entidad.SubInstalacion;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

/**
 * @author Carlos
 */
public class CtrlInstalacion extends ControlDom {

    public CtrlInstalacion() {
    }

    public Instalacion leerInstalacion(Document doc, Element instalacion) {
        Instalacion ins = new Instalacion();
        Constantes cons = new Constantes();
        ins.setIdInstalacion(getValorEtiqueta(cons.ET_ID_INSTALACION, instalacion));
        String lugar = getValorEtiqueta(cons.ET_PEDANIA, instalacion);
        if (lugar == null){
            ins.setPedania(getValorEtiqueta("barrio", instalacion));
            ins.setBarrio(true);
        }else{
            ins.setPedania(lugar);
        }

        ins.setLugar(getValorEtiqueta(cons.ET_LUGAR, instalacion));
        ins.setLatitud(getValorEtiqueta(cons.ET_LATITUD, instalacion));
        ins.setLongitud(getValorEtiqueta(cons.ET_LONGITUD, instalacion));
        ArrayList<SubInstalacion> subs;
        subs = leerSubInstalaciones(doc, instalacion);
        ins.setSubInstalaciones(subs);

        return ins;
    }


    public void escribirInstalacion(Document doc, Element instalacion, Instalacion ins) {
        Constantes cons = new Constantes();

        Element eId = doc.createElement(cons.ET_ID_INSTALACION);
        eId.appendChild(doc.createTextNode(ins.getIdInstalacion()));
        instalacion.appendChild(eId);

        if (ins.isBarrio()){
            Element eBarrio = doc.createElement(cons.ET_BARRIO);
            eBarrio.appendChild(doc.createTextNode(ins.getPedania()));
            instalacion.appendChild(eBarrio);
        }else{
            Element ePedania = doc.createElement(cons.ET_PEDANIA);
            ePedania.appendChild(doc.createTextNode(ins.getPedania()));
            instalacion.appendChild(ePedania);
        }

        Element eLugar = doc.createElement(cons.ET_LUGAR);
        eLugar.appendChild(doc.createTextNode(ins.getLugar()));
        instalacion.appendChild(eLugar);

        Element eLongitud = doc.createElement(cons.ET_LONGITUD);
        eLongitud.appendChild(doc.createTextNode(ins.getLongitud()));
        instalacion.appendChild(eLongitud);

        Element eLatitud = doc.createElement(cons.ET_LATITUD);
        eLatitud.appendChild(doc.createTextNode(ins.getLatitud()));
        instalacion.appendChild(eLatitud);


        Element subInstalaciones = doc.createElement("subinstalaciones");
        escribirSubInstalaciones(doc, subInstalaciones, ins);
        instalacion.appendChild(subInstalaciones);

    }

    public void escribirSubInstalaciones(Document doc, Element subInstalaciones, Instalacion ins){
        Constantes cons = new Constantes();

        Element eId = doc.createElement("id");
        for (int i = 0; i < ins.getSubInstalaciones().size(); i++) {
            Element eSubInst = doc.createElement("subinstalacion");
            Element eUso = doc.createElement(cons.ET_USO);
            eUso.appendChild(doc.createTextNode(ins.getSubInstalaciones().get(i).getUso()));
            eSubInst.appendChild(eUso);
            Element eCantidad = doc.createElement(cons.ET_CANTIDAD);
            eCantidad.appendChild(doc.createTextNode(ins.getSubInstalaciones().get(i).getCantidad()));
            eSubInst.appendChild(eCantidad);
            subInstalaciones.appendChild(eSubInst);

        }

    }


    public ArrayList<SubInstalacion> leerSubInstalaciones(Document doc, Element instalacion) {
        Constantes cons = new Constantes();
        ArrayList<SubInstalacion> subInsLista = new ArrayList<>();


        Element subInstalaciones = (Element) instalacion.getElementsByTagName(cons.ET_SUBINSTALACIONES).item(0);
        NodeList listaSubInstalaciones = subInstalaciones.getElementsByTagName(cons.ET_SUBINSTALACION);


        for (int i = 0; i < listaSubInstalaciones.getLength(); i++) {
            if (listaSubInstalaciones.item(i).getNodeType() == Node.ELEMENT_NODE) {
                SubInstalacion si = leerSubInstalacion(doc, (Element) listaSubInstalaciones.item(i));
                System.out.println("Leida SubInstalacion:  " + si.toString());
                subInsLista.add(si);
            }
        }
        return subInsLista;
    }

    public SubInstalacion leerSubInstalacion(Document doc, Element subInstalacion) {
        Constantes cons = new Constantes();
        SubInstalacion sub = new SubInstalacion();
        sub.setIdTipo(getValorEtiqueta(cons.ET_UBICACION, subInstalacion));
        sub.setCantidad(getValorEtiqueta(cons.ET_CANTIDAD, subInstalacion));
        sub.setUso(getValorEtiqueta(cons.ET_USO, subInstalacion));
        return sub;
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
