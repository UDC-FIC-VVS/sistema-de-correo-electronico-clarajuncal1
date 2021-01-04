package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class TestImagenProperty {
  /**
  * Descripción : Obtener el nombre de una Imagen  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *     nombre : un String cualquiera para el nombre de la Imagen,
  *     contenido : un String cualquiera para el contenido de la Imagen.
  */
  @Property 
  public void obtenerNombreProperty(String nombre, String contenido) {
    Imagen imagen = new Imagen(nombre, contenido);

    assertEquals(nombre, imagen.obtenerNombre());
  }

  /**
  * Descripción : Obtener el contenido de una Imagen  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *     nombre : un String cualquiera para el nombre de la Imagen,
  *     contenido : un String cualquiera para el contenido de la Imagen.
  */
  @Property 
  public void obtenerContenidoProperty(String nombre, String contenido) {
    Audio audio = new Audio(nombre, contenido);

    assertEquals(contenido, audio.obtenerContenido());
  }

  /**
  * Descripción : Obtener el tamaño de una Imagen  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *     nombre : un String cualquiera para el nombre de la Imagen,
  *     contenido : un String cualquiera para el contenido de la Imagen.
  */
  @Property
  public void obtenerTamanoProperty(String nombre, String contenido) {
    Imagen imagen = new Imagen(nombre, contenido);

    assertEquals(contenido.length(), imagen.obtenerTamaño());
 
  }

  /**
  * Descripción : Obtener la Visualización de una Imagen  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *     nombre : un String cualquiera para el nombre de la Imagen,
  *     contenido : un String cualquiera para el contenido de la Imagen.
  */
  @Property
  public void obtenerPrevisualizacionProperty(String nombre, String contenido) {
    Imagen imagen = new Imagen(nombre, contenido);

    assertEquals(imagen.obtenerPreVisualizacion(), 
                  nombre + "(" + contenido.length() + " bytes, " + "image/png)");
  }
}
