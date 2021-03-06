package gal.udc.fic.vvs.email.correo;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeThat;

import java.util.Vector;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.runner.RunWith;


@RunWith(JUnitQuickcheck.class)
public class TestCarpetaLimitadaProperty {

  /**
  * Descripción : Establecer y obtener los leidos de una carpeta limitada.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante 
  *  generación automática de datos:
  *    nombreCarpeta : un String cualquiera para el nombre de la carpetaLimitada,
  *    tamañoCarpeta : un integer mayor que 0 cualquiera para el 
  *      tamaño de la carpetaLimitadas,
  *    nombreCorreo : un String cualquiera para el nombre del correo 
  *      que se almacena en la carpetaLimitada,
  *    contenidoCorreo : un String cualquiera para el contenido del correo 
  *      que se almacena en la carpetaLimitada.
  * @throws OperacionInvalida
  */
  @Property
  public void establecerYObtenerLeidoPropertyTest(String nombreCarpeta, 
               int tamanoCarpeta, String nombreCorreo, String contenidoCorreo) 
                  throws OperacionInvalida {

    assumeThat(tamanoCarpeta, greaterThan(0));
    Carpeta carpeta = new Carpeta(nombreCarpeta);
    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamanoCarpeta);

    Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));

    carpetaLimitada.añadir(correo);

    assertEquals(1, carpetaLimitada.obtenerNoLeidos());

    carpetaLimitada.establecerLeido(true);

    assertEquals(0, carpetaLimitada.obtenerNoLeidos());
  }

  /**
  * Descripción : Obtener el icono de una carpeta limitada.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante 
  *  generación automática de datos:
  *    nombreCarpeta : un String cualquiera para el nombre de la carpetaLimitada,
  *    tamañoCarpeta : un integer mayor que 0 cualquiera para el 
  *      tamaño de la carpetaLimitadas,
  *    nombreCorreo : un String cualquiera para el nombre del correo 
  *      que se almacena en la carpetaLimitada,
  *    contenidoCorreo : un String cualquiera para el contenido del correo 
  *      que se almacena en la carpetaLimitada.
  * @throws OperacionInvalida
  */
  @Property
  public void obtenerIconoPropertyTest(String nombreCarpeta, 
               int tamanoCarpeta, String nombreCorreo, String contenidoCorreo) 
                  throws OperacionInvalida {

    assumeThat(tamanoCarpeta, greaterThan(0));
    Carpeta carpeta = new Carpeta(nombreCarpeta);
    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamanoCarpeta);
    
    assertEquals(carpeta.obtenerIcono(), carpetaLimitada.obtenerIcono());
  }    
    
  /**
  * Descripción : obtener el tamaño de una carpeta limitada.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreCarpeta : un String cualquiera para el nombre de la carpetaLimitada,
  *    tamañoCarpeta : un integer mayor que 0 cualquiera para el tamaño de la carpetaLimitadas,
  *    nombreCorreo : un String cualquiera para el nombre del correo 
  *     que se almacena en la carpetaLimitada,
  *    contenidoCorreo : un String cualquiera para el contenido del correo 
  *     que se almacena en la carpetaLimitada.
  * @throws OperacionInvalida
  */
  @Property
  public void obtenerTamanoPropertyTest(String nombreCarpeta, 
             int tamanoCarpeta, String nombreCorreo, String contenidoCorreo) 
                  throws OperacionInvalida {

    assumeThat(tamanoCarpeta, greaterThan(0));

    Carpeta carpeta = new Carpeta(nombreCarpeta);
    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamanoCarpeta);

    Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));

    carpetaLimitada.añadir(correo);

    assertEquals(Correo.ICONO_CARPETA, carpetaLimitada.obtenerIcono());
  }

  /**
  * Descripción : Obtener la previsualización de una carpeta limitada.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreCarpeta : un String cualquiera para el nombre de la carpetaLimitada,
  *    tamañoCarpeta : un integer mayor que 0 cualquiera para el tamaño 
  *     de la carpetaLimitadas,
  *    nombreCorreo : un String cualquiera para el nombre del correo 
  *     que se almacena en la carpetaLimitada,
  *    contenidoCorreo : un String cualquiera para el contenido del correo 
  *     que se almacena en la carpetaLimitada.
  * @throws OperacionInvalida
  */
  @Property
  public void obtenerPrevisualizacionCarpetaLimitadaPropertyTest(String nombreCarpeta,
               int tamanoCarpeta, String nombreCorreo, String contenidoCorreo) 
                    throws OperacionInvalida {

    assumeThat(tamanoCarpeta, greaterThan(0));

    Carpeta carpeta = new Carpeta(nombreCarpeta);
    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamanoCarpeta);

    Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));

    carpetaLimitada.añadir(correo);

    assertEquals(nombreCarpeta + " (" + carpetaLimitada.obtenerNoLeidos() 
                  + ")", carpetaLimitada.obtenerPreVisualizacion());
  }

  /**
  * Descripción : Obtener la visualizacion de una carpeta limitada.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreCarpeta : un String cualquiera para el nombre de la carpetaLimitada,
  *    tamañoCarpeta : un integer mayor que 0 cualquiera para el tamaño de la carpetaLimitadas,
  *    nombreCorreo : un String cualquiera para el nombre del correo 
  *     que se almacena en la carpetaLimitada,
  *    contenidoCorreo : un String cualquiera para el contenido del correo 
  *     que se almacena en la carpetaLimitada.
  * @throws OperacionInvalida
  */
  @Property
  public void obtenerVisualizacion(String nombreCarpeta, int tamanoCarpeta, 
               String nombreCorreo, String contenidoCorreo) throws OperacionInvalida {

    assumeThat(tamanoCarpeta, greaterThan(0));

    Carpeta carpeta = new Carpeta(nombreCarpeta);
    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamanoCarpeta);

    Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));

    carpetaLimitada.añadir(correo);

    assertEquals(nombreCarpeta + " (" + carpetaLimitada.obtenerNoLeidos() 
                  + ")", carpetaLimitada.obtenerPreVisualizacion());
  }
  
  /**
  * Descripción : Obtener la ruta de una carpeta limitada.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreCarpeta : un String cualquiera para el nombre de la carpetaLimitada,
  *    tamañoCarpeta : un integer mayor que 0 cualquiera para el tamaño de la carpetaLimitadas,
  *    nombreCorreo : un String cualquiera para el nombre del correo 
  *     que se almacena en la carpetaLimitada,
  *    contenidoCorreo : un String cualquiera para el contenido del correo 
  *     que se almacena en la carpetaLimitada.
  * @throws OperacionInvalida
  */
  @Property
  public void obtenerRuta(String nombreCarpeta, int tamanoCarpeta, 
               String nombreCorreo, String contenidoCorreo) throws OperacionInvalida {

    assumeThat(tamanoCarpeta, greaterThan(0));

    Carpeta carpeta = new Carpeta(nombreCarpeta);
    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamanoCarpeta);
    
    assertEquals(carpetaLimitada.obtenerRuta(), carpeta.obtenerRuta());
  
  }
  
  /**
  * Descripción : Explorar que una carpeta limitada contenga correos.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreCarpeta : un String cualquiera para el nombre de la carpetaLimitada,
  *    tamañoCarpeta : un integer mayor que 0 cualquiera para el tamaño de la carpetaLimitadas,
  *    nombreCorreo : un String cualquiera para el nombre del correo 
  *     que se almacena en la carpetaLimitada,
  *    contenidoCorreo : un String cualquiera para el contenido del correo 
  *     que se almacena en la carpetaLimitada.
  * @throws OperacionInvalida
  */
  @Property
  public void explorarPropertyTest(String nombreCarpeta, int tamanoCarpeta, 
               String nombreCorreo, String contenidoCorreo) throws OperacionInvalida {

    assumeThat(tamanoCarpeta, greaterThan(0));

    Carpeta carpeta = new Carpeta(nombreCarpeta);
    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamanoCarpeta);

    Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));

    carpetaLimitada.añadir(correo);

    assertTrue(carpetaLimitada.explorar().contains(correo));
  }

  /**
  * Descripción : Añadir un correo a una carpeta limitada.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreCarpeta : un String cualquiera para el nombre de la carpetaLimitada,
  *    tamañoCarpeta : un integer mayor que 0 cualquiera para el tamaño de la carpetaLimitadas,
  *    nombreCorreo : un String cualquiera para el nombre del correo 
  *     que se almacena en la carpetaLimitada,
  *    contenidoCorreo : un String cualquiera para el contenido del correo 
  *     que se almacena en la carpetaLimitada.
  * @throws OperacionInvalida
  */
  @Property
  public void anadirPropertyTest(String nombreCarpeta, String nombreCorreo, 
               int tamanoCarpeta, String contenidoCorreo) throws OperacionInvalida {

    assumeThat(tamanoCarpeta, greaterThan(0));

    Carpeta carpeta = new Carpeta(nombreCarpeta);
    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamanoCarpeta);

    Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));

    carpetaLimitada.añadir(correo);

    assertEquals(correo.obtenerTamaño(), carpetaLimitada.obtenerTamaño());
  }

  /**
  * Descripción : Eliminar un correo de una carpeta limitada.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreCarpeta : un String cualquiera para el nombre de la carpetaLimitada,
  *    tamañoCarpeta : un integer mayor que 0 cualquiera para el tamaño de la carpetaLimitadas,
  *    nombreCorreo : un String cualquiera para el nombre del correo 
  *     que se almacena en la carpetaLimitada,
  *    contenidoCorreo : un String cualquiera para el contenido del correo 
  *      que se almacena en la carpetaLimitada.
  * @throws OperacionInvalida
  */
  @Property
  public void eliminarPropertyTest(String nombreCarpeta, String nombreCorreo, 
               int tamanoCarpeta, String contenidoCorreo) throws OperacionInvalida {

    assumeThat(tamanoCarpeta, greaterThan(0));

    Carpeta carpeta = new Carpeta(nombreCarpeta);
    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamanoCarpeta);

    Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));
    Correo correo2 = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));

    carpetaLimitada.añadir(correo);
    carpetaLimitada.añadir(correo2);

    carpetaLimitada.eliminar(correo);

    assertEquals(correo2.obtenerTamaño(), carpetaLimitada.obtenerTamaño());
  }

  /**
  * Descripción : Obtener el hijo de una carpeta limitada a partir 
  *  de un correo previamente añadido.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreCarpeta : un String cualquiera para el nombre de la carpetaLimitada,
  *    tamañoCarpeta : un integer mayor que 0 cualquiera para el tamaño de la carpetaLimitadas,
  *    nombreCorreo : un String cualquiera para el nombre del correo 
  *     que se almacena en la carpetaLimitada,
  *    contenidoCorreo : un String cualquiera para el contenido del correo 
  *      que se almacena en la carpetaLimitada.
  * @throws OperacionInvalida
  */
  @Property
  public void obtenerHijoPropertyTest(String nombreCarpeta, int tamanoCarpeta, 
               String nombreCorreo, String contenidoCorreo) throws OperacionInvalida {

    assumeThat(tamanoCarpeta, greaterThan(0));

    Carpeta carpeta = new Carpeta(nombreCarpeta);
    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamanoCarpeta);

    Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));

    carpetaLimitada.añadir(correo);

    assertEquals(correo, carpetaLimitada.obtenerHijo(0));
  }

  /**
  * Descripción : obtener la carpeta limitada padre de un correo previamente añadido.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreCarpeta : un String cualquiera para el nombre de la carpetaLimitada,
  *    tamañoCarpeta : un integer mayor que 0 cualquiera para el tamaño de la carpetaLimitadas,
  *    nombreCorreo : un String cualquiera para el nombre del correo 
  *     que se almacena en la carpetaLimitada,
  *    contenidoCorreo : un String cualquiera para el contenido del correo 
  *     que se almacena en la carpetaLimitada.
  * @throws OperacionInvalida
  */
  @Property
  public void obtenerPadrePropertyTest(String nombreCarpeta, int tamanoCarpeta, 
               String nombreCorreo, String contenidoCorreo) throws OperacionInvalida {

    assumeThat(tamanoCarpeta, greaterThan(0));

    Carpeta carpeta = new Carpeta(nombreCarpeta);
    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamanoCarpeta);
 
    Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));

    carpetaLimitada.añadir(correo);

    assertEquals(carpeta, correo.obtenerPadre());
  }
  
  /**
  * Descripción : Búsqueda en una carpera Limitada.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreCarpeta : un String cualquiera para el nombre de la carpetaLimitada,
  *    tamañoCarpeta : un integer mayor que 0 cualquiera para el tamaño de la carpetaLimitadas,
  *    busqueda : un String cualquiera para la busqueda en la carpetaLimitada.
  * @throws OperacionInvalida
  */
  @Property
  public void buscarPropertyTest(String nombreCarpeta, int tamanoCarpeta, 
               String busqueda) throws OperacionInvalida {

    assumeThat(tamanoCarpeta, greaterThan(0));

    Carpeta carpeta = new Carpeta(nombreCarpeta);
    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamanoCarpeta);
    
    Vector resultado = new Vector();
    
    assertEquals(carpetaLimitada.buscar(busqueda), resultado);
  }
}
