package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class TestReenvioProperty {

  /**
  * Descripción : Obtener el tamaño de un Reenvio.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreMensaje : un String cualquiera para el nombre del mensaje del Reenvio,
  *    contenidoMensaje : un String cualquiera para el contenido del mensaje del Reenvio,
  *    nombreArchivo : un String cualquiera para el nombre del correo del Reenvio,
  *    contenidoArchivo : un String cualquiera para el contenido del correo del Reenvio.
  */
  @Property
  public void obtenerTamanoPropertyTest(String nombreMensaje, String contenidoMensaje, 
               String nombreCorreo, String contenidoCorreo) {

    Mensaje mensaje = new Mensaje(new Texto(nombreMensaje, contenidoMensaje));
    Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));

    Reenvio reenvio = new Reenvio(mensaje, correo);

    assertEquals(correo.obtenerTamaño() + mensaje.obtenerTamaño(), reenvio.obtenerTamaño());
  }

  /**
  * Descripción : Obtener la visualización de un Reenvio.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreMensaje : un String cualquiera para el nombre del mensaje del Reenvio,
  *    contenidoMensaje : un String cualquiera para el contenido del mensaje del Reenvio,
  *    nombreCorreo : un String cualquiera para el nombre del correo del Reenvio,
  *    contenidoCorreo : un String cualquiera para el contenido del correo del Reenvio.
  */
  @Property
  public void obtenerVisualizacionPropertyTest(String nombreMensaje, String contenidoMensaje, 
               String nombreCorreo, String contenidoCorreo) {

    Mensaje mensaje = new Mensaje(new Texto(nombreMensaje, contenidoMensaje));
    Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));

    Reenvio reenvio = new Reenvio(mensaje, correo);

 
    assertEquals(mensaje.obtenerVisualizacion() 
                  + "\n\n---- Correo reenviado ----\n\n" + correo.obtenerVisualizacion() 
                  + "\n---- Fin correo reenviado ----", reenvio.obtenerVisualizacion());
  }

  /**
  * Descripción : Obtener el icono de un Reenvio.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreMensaje : un String cualquiera para el nombre del mensaje del Reenvio,
  *    contenidoMensaje : un String cualquiera para el contenido del mensaje del Reenvio,
  *    nombreCorreo : un String cualquiera para el nombre del correo del Reenvio,
  *    contenidoCorreo : un String cualquiera para el contenido del correo del Reenvio.
  */
  @Property
  public void obtenerIconoPropertyTest(String nombreMensaje, String contenidoMensaje, 
               String nombreCorreo, String contenidoCorreo) {

    Mensaje mensaje = new Mensaje(new Texto(nombreMensaje, contenidoMensaje));
    Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));

    Reenvio reenvio = new Reenvio(mensaje, correo);

    assertEquals(Reenvio.ICONO_NUEVO_MENSAJE, reenvio.obtenerIcono());
  }

  /**
  * Descripción : Establecer y Obtener los leídos de un Reenvio.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreMensaje : un String cualquiera para el nombre del mensaje del Reenvio,
  *    contenidoMensaje : un String cualquiera para el contenido del mensaje del Reenvio,
  *    nombreCorreo : un String cualquiera para el nombre del correo del Reenvio,
  *    contenidoCorreo : un String cualquiera para el contenido del correo del Reenvio.
  */
  @Property
  public void establecerYObtenerPropertyTest(String nombreMensaje, String contenidoMensaje, 
               String nombreCorreo, String contenidoCorreo) {

    Mensaje mensaje = new Mensaje(new Texto(nombreMensaje, contenidoMensaje));
    Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));

    Reenvio reenvio = new Reenvio(mensaje, correo);

    assertEquals(1, reenvio.obtenerNoLeidos());

    reenvio.establecerLeido(true);

    assertEquals(0, reenvio.obtenerNoLeidos());

  }

  /**
  * Descripción : Obtener la ruta de un Reenvio.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreMensaje : un String cualquiera para el nombre del mensaje del Reenvio,
  *    contenidoMensaje : un String cualquiera para el contenido del mensaje del Reenvio,
  *    nombreCorreo : un String cualquiera para el nombre del correo del Reenvio,
  *    contenidoCorreo : un String cualquiera para el contenido del correo del Reenvio.
  */
  @Property
  public void obtenerRuta(String nombreMensaje, String contenidoMensaje, 
               String nombreCorreo, String contenidoCorreo) {

    Mensaje mensaje = new Mensaje(new Texto(nombreMensaje, contenidoMensaje));
    Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));
 
    Reenvio reenvio = new Reenvio(mensaje, correo);

    assertEquals(reenvio.obtenerRuta(), mensaje.obtenerRuta());
  }

  /**
  * Descripción : Obtener el padre de un Reenvio.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreMensaje : un String cualquiera para el nombre del mensaje del Reenvio,
  *    contenidoMensaje : un String cualquiera para el contenido del mensaje del Reenvio,
  *    nombreCorreo : un String cualquiera para el nombre del correo del Reenvio,
  *    contenidoCorreo : un String cualquiera para el contenido del correo del Reenvio.
  *      nombreCarpeta : un String cualquiera para el nombre de la carpeta padre del Reenvio.
  */
  @Property
  public void obtenerPadre(String nombreMensaje, String contenidoMensaje, String nombreCorreo, 
                String contenidoCorreo, String nombreCarpeta) throws OperacionInvalida {

    Mensaje mensaje = new Mensaje(new Texto(nombreMensaje, contenidoMensaje));
    Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));
 
    Reenvio reenvio = new Reenvio(mensaje, correo);

    Carpeta carpeta = new Carpeta(nombreCarpeta);

    carpeta.añadir(reenvio);

    assertEquals(carpeta, reenvio.obtenerPadre());
  }
}
