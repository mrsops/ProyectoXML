/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Constantes;
import controlador.ControlDom;
import controlador.CtrlInstalacionesDeportivas;
import entidad.Instalacion;
import entidad.InstalacionesDeportivas;
import entidad.SubInstalacion;
import entidad.SubInstalaciones;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author mrsops
 */
public class ProyectoXml {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, TransformerException {
        // TODO code application logic here

        String ruta = "DocumentoXml/instalaciones_deportivas.xml";
        Scanner tc = new Scanner(System.in);
        ControlDom ctrlDoc = new ControlDom();
        Constantes cons = new Constantes();
        CtrlInstalacionesDeportivas cb = new CtrlInstalacionesDeportivas();
        Document doc = null;
        Document docNuevo = null;
        InstalacionesDeportivas insDeportivas = null;
        InstalacionesDeportivas bStore2 = null;
        String opcion = "";
        String rutaAlmacenarXml = "";
        boolean docCreado = false;


        do {
            mostrarMenu();
            opcion = tc.nextLine();
            switch (opcion) {
                case "1": //Seleccionar fichero XML
                    System.out.print("Introduce la ruta del bookstore a leer (En blanco para bookstore por defecto): ");
                    ruta = tc.nextLine();
                    if (ruta.equals("")) {
                        doc = ctrlDoc.deXMLaDOM(new File("Bookstores/bookstore.xml"));
                    } else {
                        doc = ctrlDoc.deXMLaDOM(new File(ruta));
                    }
                    docCreado = true;
                    break;
                case "2": // Crear bookstore y leer del document
                    if (docCreado) {
                        insDeportivas = new InstalacionesDeportivas();
                        insDeportivas = cb.leerInstalacionesDeportivas(doc);
                    } else {
                        System.out.println("El documento aun no se ha seleccionado");
                    }
                    break;
                case "3": // Mostrar el bookstore
                    if (docCreado) {
                        insDeportivas.mostrarBookstore();
                    } else {
                        System.out.println("El documento aun no se ha seleccionado");
                    }

                    break;
                case "4": // Crear un nuevo bookstore y añadir libros
                    bStore2 = new InstalacionesDeportivas();
                    String masBooks = "";

                    System.out.print("¿Desea crear libros por su cuenta? (s/n para usar los libros por defecto dejar en blanco o 'n'): ");
                    String lectura = tc.nextLine();

                    if (lectura.equals("s") || lectura.equals("S")) {
                        do {
                            Instalacion instalacion = new Instalacion();
                            System.out.println("NUEVO LIBRO");
                            System.out.println("--------------------------------------------------------------------------");
                            System.out.print("Introduce la categoria: ");
                            String cat = tc.nextLine();
                            System.out.print("Introduce tipo de portada (En blanco si no tiene o se desconoce): ");
                            String cover = tc.nextLine();
                            if (cover.equals("")) {
                                cover = "cover";
                            }
                            System.out.print("Introduce el titulo del libro: ");
                            String title = tc.nextLine();
                            System.out.print("Introduce el año de publicacion: ");
                            String year = tc.nextLine();
                            System.out.print("Introduce el precio del libro: ");
                            String precio = tc.nextLine();
                            String masAutores = "";
                            SubInstalaciones subs = new SubInstalaciones();
                            instalacion = new Instalacion("pene", "mas pene", "mas mas penes", "super penes", "more penises", subs);
                            do {
                                System.out.print("Introduce el nombre del autor: ");
                                String nombreAutor = tc.nextLine();
                                SubInstalacion subIns = new SubInstalacion("inventao", "sin uso", "1");
                                bStore2.add(instalacion);
                                System.out.print("El libro posee mas autores (s/n): ");
                                masAutores = tc.nextLine();
                            } while (masAutores.equals("s") || masAutores.equals("S"));

                            System.out.print("¿Desea crear mas libros para este bookstore?(s/n) : ");
                            masBooks = tc.nextLine();
                        } while (masBooks.equals("s") || masBooks.equals("S"));
                    } else {
                        /*
                        cons.altaLibrosDefault(bStore2); //Añadimos algunos libros por defecto
                        bStore2.mostrarBookstore();
                        */
                    }

                    break;
                case "5": // Escribir el objeto bookstore en un nuevo documento
                    /*

                    docNuevo = ctrlDoc.instanciarDocumento();
                    Element raiz = docNuevo.createElement("bookstore");
                    docNuevo.appendChild(raiz);
                    System.out.println("Se ha añadido de elemento raiz al documento: " + docNuevo.getDocumentElement().getTagName());
                    cb.escribirBookstore(docNuevo, bStore2, raiz);
                    System.out.println("Se ha generado el dom satisfactoriamente");
                    break;
                    */
                case "6": //Seleccionar el nombre del fichero donde almacenarlo
                    System.out.print("Nombre del fichero (En blanco para defaultBookstore.xml): ");
                    rutaAlmacenarXml = tc.nextLine();
                    break;
                case "7": //Guardar el documento a xml
                    if (!rutaAlmacenarXml.equals("")) {
                        ctrlDoc.deDOMaXML(docNuevo, new File("Bookstores/" + rutaAlmacenarXml + ".xml"));
                    } else {
                        ctrlDoc.deDOMaXML(docNuevo, new File("Bookstores/defaultBookstore.xml"));
                    }

                    break;
                case "0":
                    System.out.println("Finalizando programa");
                    break;

                default:
                    System.out.println("Respuesta Incorrecta");
                    break;
            }
        } while (!opcion.equals("0"));


    }


    private static void menu() {
        System.out.println("1. Mostrar las pedanias donde existen instalaciones deportivas");
        System.out.println("2. Mostrar todas instalaciones deportivas de una localidad");
        System.out.println("3. Seleccionar una instalacion deportiva: ");
        System.out.println("4. ");
    }

    public static void mostrarMenu() { //Menu
        System.out.println("1. Seleccionar fichero xml para nuevo documento");
        System.out.println("2. Leer documento y crear objeto Bookstore a partir de el");
        System.out.println("3.-Mostrar el BookStore");
        System.out.println("4.-Crear nuevo Bookstore, y añadir libros en el");
        System.out.println("5.-Escribir el bookstore a documento");
        System.out.println("6.-Introducir ruta destino del archivo xml (Solo nombre sin extension)");
        System.out.println("7.-Guardar el documento a XML");
        System.out.println("0. Salir");
    }

}
