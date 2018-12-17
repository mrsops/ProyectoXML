package controlador;

import entidad.SubInstalacion;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CtrlSubInstalacion extends ControlDom {

    public SubInstalacion leerSubInstalacion(Document doc, Element subInstalacion) {
        Constantes cons = new Constantes();
        SubInstalacion sub = new SubInstalacion();
        sub.setIdTipo(getValorEtiqueta(cons.ET_INSTALACION, subInstalacion));
        sub.setCantidad(getValorEtiqueta(cons.ET_CANTIDAD, subInstalacion));
        sub.setUso(getValorEtiqueta(cons.ET_USO, subInstalacion));
        return sub;
    }

    public void escribirSubInstalacion() {

    }
}
