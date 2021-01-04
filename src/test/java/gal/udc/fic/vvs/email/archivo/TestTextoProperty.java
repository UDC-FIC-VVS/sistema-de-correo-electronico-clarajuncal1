package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;


@RunWith(JUnitQuickcheck.class)
public class TestTextoProperty {
  /**
  * Descripción : Obtener el nombre de un Texto  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *     nombre : un String cualquiera para el nombre del Texto,
  *     contenido : un String cualquiera para el contenido del Texto.
  */
  @Property 
  public void obtenerNombreProperty(String nombre, String contenido) {
    Texto texto = new Texto(nombre, contenido);

    assertEquals(nombre, texto.obtenerNombre());
  }

  /**
  * Descripción : Obtener el contenido de un Texto  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *     nombre : un String cualquiera para el nombre del Texto,
  *     contenido : un String cualquiera para el contenido del Texto.
  */
  @Property 
  public void obtenerContenidoProperty(String nombre, String contenido) {
    Texto texto = new Texto(nombre, contenido);

    assertEquals(contenido, texto.obtenerContenido());
  }

  /**
  * Descripción : Obtener el tamaño de un Texto  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *     nombre : un String cualquiera para el nombre del Texto,
  *     contenido : un String cualquiera para el contenido del Texto.
  */
  @Property 
  public void obtenerTamanoProperty(String nombre, String contenido) {
    Texto texto = new Texto(nombre, contenido);

    assertEquals(contenido.length(), texto.obtenerTamaño());

  }

  /**
  * Descripción : Obtener la previsualización de un Texto  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *     nombre : un String cualquiera para el nombre del Texto,
  *     contenido : un String cualquiera para el contenido del Texto.
  */
  @Property 
  public void obtenerPrevisualizacionProperty(String nombre, String contenido) {
    Texto texto = new Texto(nombre, contenido);

    assertEquals(texto.obtenerPreVisualizacion(), 
                  nombre + "(" + contenido.length() + " bytes, " + "text/plain)");
  }
}
