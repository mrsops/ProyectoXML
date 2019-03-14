/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Constantes;
import controlador.ControlDom;
import controlador.CtrlInstalacionesDeportivas;
import dao.Conexion_DB;
import dao.InstalacionDAO;
import entidad.Instalacion;
import entidad.InstalacionesDeportivas;
import entidad.SubInstalacion;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
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
        Conexion_DB conexionDb=new Conexion_DB();
        String ruta;
        Connection con=null;
        Scanner tc = new Scanner(System.in);
        ControlDom ctrlDoc = new ControlDom();
        Constantes cons = new Constantes();
        CtrlInstalacionesDeportivas cid = new CtrlInstalacionesDeportivas();
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
                        doc = ctrlDoc.deXMLaDOM(new File("DocumentoXml/instalaciones_deportivas.xml"));
                    } else {
                        doc = ctrlDoc.deXMLaDOM(new File(ruta));
                    }
                    docCreado = true;
                    break;
                case "2": // Crear bookstore y leer del document
                    if (docCreado) {
                        insDeportivas = new InstalacionesDeportivas();
                        insDeportivas = cid.leerInstalacionesDeportivas(doc);
                    } else {
                        System.out.println("El documento aun no se ha seleccionado");
                    }
                    break;
                case "3": // Mostrar el bookstore
                    if(insDeportivas !=null){
                        insDeportivas.mostrarInstalacionesDeportivas();
                    }else{
                        System.out.println("Las instalaciones Deportivas aun no se han creado");
                    }


                    break;
                case "4": // Crear un nuevo bookstore y añadir libros
                    /*
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
                            ArrayList<SubInstalacion> subs = new ArrayList<>();
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
                        
                        cons.altaLibrosDefault(bStore2); //Añadimos algunos libros por defecto
                        bStore2.mostrarBookstore();                      
                    }
            */
                    break;
                case "5": // Escribir el objeto en un nuevo documento
                    docNuevo = ctrlDoc.instanciarDocumento();
                    Element raiz = docNuevo.createElement(cons.ET_INSTALACIONES_DEPORTIVAS);
                    docNuevo.appendChild(raiz);
                    System.out.println("Se ha añadido de elemento raiz al documento: " + docNuevo.getDocumentElement().getTagName());
                    cid.escribirInstalacionesDeportivas(docNuevo, insDeportivas, raiz);
                    System.out.println("Se ha generado el dom satisfactoriamente");
                    break;

                case "6": //Seleccionar el nombre del fichero donde almacenarlo
                    System.out.print("Nombre del fichero (En blanco para instalaciones_deportivas.xml): ");
                    rutaAlmacenarXml = tc.nextLine();
                    break;
                case "7": //Guardar el documento a xml
                    if (!rutaAlmacenarXml.equals("")) {
                        ctrlDoc.deDOMaXML(docNuevo, new File("DocumentoXml/" + rutaAlmacenarXml + ".xml"));
                    } else {
                        ctrlDoc.deDOMaXML(docNuevo, new File("DocumentoXml/instalaciones_deportivas.xml"));
                    }

                    break;
                    
                case "8": // Pasar datos a base de datos
                    
                    try {
                        con = conexionDb.abrirConexion();
                        InstalacionDAO insDao = new InstalacionDAO();
                        for(Instalacion i:insDeportivas){
                            insDao.insertar(con, i, i.getIdInstalacion());
                        }
                        con.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                    
                case "9": //Leer de la base de datos
                    
                    try {
                        con = conexionDb.abrirConexion();
                        InstalacionDAO insDao = new InstalacionDAO();
                        insDeportivas = insDao.findAll(con);
                        con.close();
                    } catch (Exception e) {
                        e.printStackTrace();
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
        System.out.println("3.-Mostrar las instalaciones deportivas");
        System.out.println("4.-Inactivo");
        System.out.println("5.-Escribir las instalaciones a documento");
        System.out.println("6.-Introducir ruta destino del archivo xml (Solo nombre sin extension)");
        System.out.println("7.-Guardar el documento a XML");
        System.out.println("8.-Pasar Instalaciones deportivas a Base de datos");
        System.out.println("9.-Pasar Instalaciones deportivas a Base de datos");
        System.out.println("0. Salir");
    }

}
