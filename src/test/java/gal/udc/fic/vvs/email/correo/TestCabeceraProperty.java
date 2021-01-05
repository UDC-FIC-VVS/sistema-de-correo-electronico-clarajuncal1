package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class TestCabeceraProperty {
  /**
  * Descripción : Obtener el tamaño de una cabecera.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreMensaje : un String cualquiera para el nombre del mensaje de la Cabecera,
  *    contenidoMensaje : un String cualquiera para el contenido del mensaje de la Cabecera,
  *    nombreCabecera : un String cualquiera para el nombre de la Cabecera,
  *    valor : un String cualquiera para el valor de la Cabecera.
  */
  @Property
  public void obtenerTamanoPropertyTest(String nombreMensaje, 
               String contenidoMensaje, String nombreCabecera, String valor) {

    Mensaje mensaje = new Mensaje(new Texto(nombreMensaje, contenidoMensaje));

    Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valor);

    assertEquals(mensaje.obtenerTamaño() + nombreCabecera.length() 
                  + valor.length(), cabecera.obtenerTamaño());

  }

  /**
  * Descripción : Obtener la visualización de una cabecera.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreMensaje : un String cualquiera para el nombre del mensaje de la Cabecera,
  *    contenidoMensaje : un String cualquiera para el contenido del mensaje de la Cabecera,
  *    nombreCabecera : un String cualquiera para el nombre de la Cabecera,
  *    valor : un String cualquiera para el valor de la Cabecera.
  */
  @Property
  public void obtenerVisualizacionPropertyTest(String nombreMensaje, 
               String contenidoMensaje, String nombreCabecera, String valor) {

    Mensaje mensaje = new Mensaje(new Texto(nombreMensaje, contenidoMensaje));

    Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valor);

    assertEquals(nombreCabecera + ": " + valor + "\n" 
                   + mensaje.obtenerVisualizacion(), cabecera.obtenerVisualizacion());
  }

  /**
  * Descripción : Obtener la ruta de una cabecera.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreMensaje : un String cualquiera para el nombre del mensaje de la Cabecera,
  *    contenidoMensaje : un String cualquiera para el contenido del mensaje de la Cabecera,
  *    nombreCabecera : un String cualquiera para el nombre de la Cabecera,
  *    valor : un String cualquiera para el valor de la Cabecera.
  */
  @Property
  public void obtenerRutaPropertyTest(String nombreMensaje, 
               String contenidoMensaje, String nombreCabecera, String valor) {

    Mensaje mensaje = new Mensaje(new Texto(nombreMensaje, contenidoMensaje));

    Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valor);

    assertEquals(mensaje.obtenerRuta(), cabecera.obtenerRuta());
  }

  /**
  * Descripción : Establecer y obtener los leidos de una Cabecera.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreMensaje : un String cualquiera para el nombre del mensaje de la Cabecera,
  *    contenidoMensaje : un String cualquiera para el contenido del mensaje de la Cabecera,
  *    nombreCabecera : un String cualquiera para el nombre de la Cabecera,
  *    valor : un String cualquiera para el valor de la Cabecera.
  */
  @Property
  public void establecerYObtenerLeidosPropertyTest(String nombreMensaje, 
               String contenidoMensaje, String nombreCabecera, String valor) {

    Mensaje mensaje = new Mensaje(new Texto(nombreMensaje, contenidoMensaje));

    Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valor);

    assertEquals(1, cabecera.obtenerNoLeidos());

    cabecera.establecerLeido(true);
    
    assertEquals(0, cabecera.obtenerNoLeidos());
  }

  /**
  * Descripción : Obtener el icono de una Cabecera.  
  * Nivel : Prueba dinámica de caja negra, positiva, funcional.
  * Categoría : Prueba dinámica de caja negra, positiva.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreMensaje : un String cualquiera para el nombre del mensaje de la Cabecera,
  *    contenidoMensaje : un String cualquiera para el contenido del mensaje de la Cabecera,
  *    nombreCabecera : un String cualquiera para el nombre de la Cabecera,
  *    valor : un String cualquiera para el valor de la Cabecera.
  */
  @Property
  public void obtenerIconoPropertyTest(String nombreMensaje,
               String contenidoMensaje, String nombreCabecera, String valor) {

    Mensaje mensaje = new Mensaje(new Texto(nombreMensaje, contenidoMensaje));

    Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valor);

    assertEquals(Mensaje.ICONO_NUEVO_MENSAJE, cabecera.obtenerIcono());
  }

  /**
  * Descripción : Obtener la previsualización de una Cabecera.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreMensaje : un String cualquiera para el nombre del mensaje de la Cabecera,
  *    contenidoMensaje : un String cualquiera para el contenido del mensaje de la Cabecera,
  *    nombreCabecera : un String cualquiera para el nombre de la Cabecera,
  *    valor : un String cualquiera para el valor de la Cabecera.
  */
  @Property
  public void obtenerPrevisualizacionPropertyTest(String nombreMensaje,
               String contenidoMensaje, String nombreCabecera, String valor) {

    Mensaje mensaje = new Mensaje(new Texto(nombreMensaje, contenidoMensaje));

    Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valor);

    assertEquals(mensaje.obtenerPreVisualizacion(), cabecera.obtenerPreVisualizacion());
  }

  /**
  * Descripción : Obtener el padre de una cabecera despues de haber sido añadida a una carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreMensaje : un String cualquiera para el nombre del mensaje de la Cabecera,
  *    contenidoMensaje : un String cualquiera para el contenido del mensaje de la Cabecera,
  *    nombreCabecera : un String cualquiera para el nombre de la Cabecera,
  *    valor : un String cualquiera para el valor de la Cabecera,
  *    nombreCarpeta : un String cualquiera para el nombre de la 
  *    carpeta donde se va a almacenar la Cabecera.
  * @throws OperacionInvalida
  */
  @Property
  public void obtenerPadre(String nombreMensaje, String contenidoMensaje, 
               String nombreCabecera, String valor, String nombreCarpeta) throws OperacionInvalida {

    Mensaje mensaje = new Mensaje(new Texto(nombreMensaje, contenidoMensaje));

    Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valor);

    Carpeta carpeta = new Carpeta(nombreCarpeta);

    carpeta.añadir(cabecera);

    assertEquals(carpeta, cabecera.obtenerPadre());
  }
}
