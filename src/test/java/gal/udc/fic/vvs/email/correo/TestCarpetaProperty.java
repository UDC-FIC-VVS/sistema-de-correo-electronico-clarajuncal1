package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.Vector;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class TestCarpetaProperty {
  /**
  * Descripción : Establecer y obtener el leido de una Carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreTexto : un String cualquiera para el nombre del mensaje del Correo,
  *    contenidoTexto : un String cualquiera para el contenido del mensaje del Correo,
  *    nombreCarpeta : un String cualquiera para el nombre de la Carpeta.
  * @throws OperacionInvalida
  */
  @Property
  public void establecerYObtenerNoLeidoPropertyTest(String nombreCarpeta, 
               String nombreTexto, String contenidoTexto)
                 throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombreCarpeta);
    Correo correo = new Mensaje(new Texto(nombreTexto, contenidoTexto));

    carpeta.añadir(correo);
 
    assertEquals(1, carpeta.obtenerNoLeidos());

    carpeta.establecerLeido(true);

    assertEquals(0, carpeta.obtenerNoLeidos());
  }

  /**
  * Descripción : Obtener el tamaño de una Carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreTexto : un String cualquiera para el nombre del mensaje del Correo,
  *    contenidoTexto : un String cualquiera para el contenido del mensaje del Correo,
  *    nombreCarpeta : un String cualquiera para el nombre de la Carpeta.
  * @throws OperacionInvalida
  */
  @Property
  public void obtenerTamano(String nombreCarpeta, String nombreTexto,
               String contenidoTexto) throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombreCarpeta);
    Correo correo = new Mensaje(new Texto(nombreTexto, contenidoTexto));
    Correo correo2 = new Mensaje(new Texto(nombreTexto, contenidoTexto));

    carpeta.añadir(correo);
    carpeta.añadir(correo2);

    assertEquals(carpeta.obtenerTamaño(),
                  correo.obtenerTamaño() + correo2.obtenerTamaño());
  }

  /**
  * Descripción : Obtener la previsualizacion de una Carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreTexto : un String cualquiera para el nombre del mensaje del Correo,
  *    contenidoTexto : un String cualquiera para el contenido del mensaje del Correo,
  *    nombreCarpeta : un String cualquiera para el nombre de la Carpeta.
  * @throws OperacionInvalida
  */
  @Property
  public void obtenerPrevisualizacionCarpetaTest(String nombreCarpeta, String nombreTexto, 
               String contenidoTexto) throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombreCarpeta);
    Correo correo = new Mensaje(new Texto(nombreTexto, contenidoTexto));

    carpeta.añadir(correo);

    assertEquals(nombreCarpeta + " (" + carpeta.obtenerNoLeidos() + ")", 
                  carpeta.obtenerPreVisualizacion());
  }

  /**
  * Descripción : Obtener el icono de una Carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreTexto : un String cualquiera para el nombre del mensaje del Correo,
  *    contenidoTexto : un String cualquiera para el contenido del mensaje del Correo,
  *    nombreCarpeta : un String cualquiera para el nombre de la Carpeta.
  * @throws OperacionInvalida
  */
  @Property
  public void obtenerIconoPropertyTest(String nombreCarpeta, String nombreTexto,
               String contenidoTexto) throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombreCarpeta);
    Correo correo = new Mensaje(new Texto(nombreTexto, contenidoTexto));

    carpeta.añadir(correo);
    
    assertEquals(Correo.ICONO_CARPETA, carpeta.obtenerIcono());
  }  

  /**
  * Descripción : Obtener la visualizacion de una Carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreTexto : un String cualquiera para el nombre del mensaje del Correo,
  *    contenidoTexto : un String cualquiera para el contenido del mensaje del Correo,
  *    nombreCarpeta : un String cualquiera para el nombre de la Carpeta.
  * @throws OperacionInvalida
  */
  @Property
  public void obtenerVisualizacionPropertyTest(String nombreCarpeta, 
               String nombreTexto, String contenidoTexto) throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombreCarpeta);
    Correo correo = new Mensaje(new Texto(nombreTexto, contenidoTexto));

    carpeta.añadir(correo);

    assertEquals(nombreCarpeta + " (" + carpeta.obtenerNoLeidos() + ")", 
                  carpeta.obtenerPreVisualizacion());

  }

  /**
  * Descripción : Añadir un correo a una Carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreTexto : un String cualquiera para el nombre del mensaje del Correo,
  *    contenidoTexto : un String cualquiera para el contenido del mensaje del Correo,
  *    nombreCarpeta : un String cualquiera para el nombre de la Carpeta.
  * @throws OperacionInvalida
  */
  @Property
  public void anadirPropertyTest(String nombreCarpeta, String nombreTexto, 
               String contenidoTexto) throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombreCarpeta);
    Correo correo = new Mensaje(new Texto(nombreTexto, contenidoTexto));

    carpeta.añadir(correo);

    assertEquals(carpeta.obtenerTamaño(), correo.obtenerTamaño());
  }

  /**
  * Descripción : Eliminar el correo de una Carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreTexto : un String cualquiera para el nombre del mensaje del Correo,
  *    contenidoTexto : un String cualquiera para el contenido del mensaje del Correo,
  *    nombreCarpeta : un String cualquiera para el nombre de la Carpeta.
  * @throws OperacionInvalida
  */
  @Property
  public void eliminarPropertyTest(String nombreCarpeta, String nombreTexto, 
               String contenidoTexto) throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombreCarpeta);
    Correo correo = new Mensaje(new Texto(nombreTexto, contenidoTexto));
    Correo correo2 = new Mensaje(new Texto(nombreTexto, contenidoTexto));

    carpeta.añadir(correo);
    carpeta.añadir(correo2);

    assertEquals(carpeta.obtenerTamaño(),
                  correo.obtenerTamaño() + correo2.obtenerTamaño());

    carpeta.eliminar(correo);

    assertEquals(carpeta.obtenerTamaño(), correo2.obtenerTamaño());
  }

  /**
  * Descripción : Obtener el hijo de una Carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreTexto : un String cualquiera para el nombre del mensaje del Correo,
  *    contenidoTexto : un String cualquiera para el contenido del mensaje del Correo,
  *    nombreCarpeta : un String cualquiera para el nombre de la Carpeta.
   * @throws OperacionInvalida
  */
  @Property
  public void obtenerHijoPropertyTest(String nombreCarpeta, String nombreTexto, 
             String contenidoTexto) throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombreCarpeta);
    Correo correo = new Mensaje(new Texto(nombreTexto, contenidoTexto));
    
    carpeta.añadir(correo);

    assertEquals(correo, carpeta.obtenerHijo(0));
  }

  /**
  * Descripción : Explorar una Carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreTexto : un String cualquiera para el nombre del mensaje del Correo,
  *    contenidoTexto : un String cualquiera para el contenido del mensaje del Correo,
  *    nombreCarpeta : un String cualquiera para el nombre de la Carpeta.
  * @throws OperacionInvalida
  */
  @Property
  public void explorarPropertyTest(String nombreCarpeta, String nombreTexto, 
               String contenidoTexto) throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombreCarpeta);
    Correo correo = new Mensaje(new Texto(nombreTexto, contenidoTexto));

    carpeta.añadir(correo);

    assertEquals(true, carpeta.explorar().contains(correo));
  }

  /**
  * Descripción : Obtener la ruta de una Carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreTexto : un String cualquiera para el nombre del mensaje del Correo,
  *    contenidoTexto : un String cualquiera para el contenido del mensaje del Correo,
  *    nombreCarpeta : un String cualquiera para el nombre de la Carpeta.
  * @throws OperacionInvalida
  */
  @Property
  public void obtenerRutaPropertyTest(String nombreCarpeta, 
               String nombreTexto, String contenidoTexto) throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombreCarpeta);
    Correo correo = new Mensaje(new Texto(nombreTexto, contenidoTexto));

    carpeta.añadir(correo);

    assertEquals(nombreCarpeta + " (" + carpeta.obtenerNoLeidos() + ")", 
                  carpeta.obtenerPreVisualizacion());
  }
  
  /**
  * Descripción : buscar un correo a una Carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreCarpeta : un String cualquiera para el nombre de la Carpeta,
  *    busqueda : un String cualquiera para la busqueda en una carpeta.
  * @throws OperacionInvalida
  */
  @Property
  public void buscarPropertyTest(String nombreCarpeta, 
          String busqueda) throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombreCarpeta);
    Vector resultado = new Vector();
    
    assertEquals(carpeta.buscar(busqueda), resultado);
  }
}
