package gal.udc.fic.vvs.email.archivo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class TestAudioProperty {
  /*
  * Descripción : Obtener el nombre de un Audio  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *     nombre : un String cualquiera para el nombre del Audio,
  *     contenido : un String cualquiera para el contenido del Audio.
  */
  @Property 
  public void obtenerNombreProperty(String nombre, String contenido) {
    Audio audio = new Audio(nombre, contenido);

    assertEquals(nombre, audio.obtenerNombre());
  }

  /*
  * Descripción : Obtener el contenido de un Audio  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *     nombre : un String cualquiera para el nombre del Audio,
  *     contenido : un String cualquiera para el contenido del Audio.
  */
  @Property 
  public void obtenerContenidoProperty(String nombre, String contenido) {
    Audio audio = new Audio(nombre, contenido);

    assertEquals(contenido, audio.obtenerContenido());
  }

  /*
  * Descripción : Obtener el tamaño de un Audio  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *     nombre : un String cualquiera para el nombre del Audio,
  *     contenido : un String cualquiera para el contenido del Audio.
  */
  @Property 
  public void obtenerTamanoProperty(String nombre, String contenido) {
    Audio audio = new Audio(nombre, contenido);

    assertEquals(contenido.length(), audio.obtenerTamaño());

  }

  /*
  * Descripción : Obtener la Visualización de un Audio  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *     nombre : un String cualquiera para el nombre del Audio,
  *     contenido : un String cualquiera para el contenido del Audio.
  */
  @Property 
  public void obtenerVisualizacionProperty(String nombre, String contenido) {
    Audio audio = new Audio(nombre, contenido);

    assertEquals(audio.obtenerPreVisualizacion(), 
                  nombre + "(" + contenido.length() + " bytes, " + "audio/ogg)");
  }
}

