package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestAudio {
  private String nombrePrueba = "AudioPrueba";
  private String contenido = "Audio de Prueba";


  /**
  * Descripción : Obtener el nombre de un Audio  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *   @Param Audio : Formado por un nombre y su contenido.
  */
  @Test
  public void obtenerNombre() {

    //Se crea un nuevo audio introduciendo un nombre y un contenido
    Audio audio = new Audio(nombrePrueba, contenido);

    //Se comprueba que el nombre introducido es el nombre definido previamente
    assertEquals(audio.obtenerNombre(), nombrePrueba);

  }

  /**
  * Descripción : Obtener el contenido de un Audio  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo..
  *   @Param Audio : Formado por un nombre y su contenido.
  */
  @Test
  public void obtenerContenido() {

    //Se crea un nuevo audio introduciendo un nombre y un contenido
    Audio audio = new Audio(nombrePrueba, contenido);

    //Se comprueba que el contenido introducido es el mismo contenido definido previamente
    assertEquals(audio.obtenerContenido(), contenido);
  }

  /**
  * Descripción : Obtener el tamaño de un Audio  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo..
  *   @Param Audio : Formado por un nombre y su contenido.
  */
  @Test
  public void obtenerTamano() {

    //Se crea un nuevo audio introduciendo un nombre y un contenido
    Audio audio = new Audio(nombrePrueba, contenido);

    //Se comprueba que el tamaño del audio coincida con la longitud de su contenido
    assertEquals(audio.obtenerTamaño(), contenido.length());
  }

  /**
  * Descripción : Obtener la Visualización de un Audio  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo..
  *   @Param Audio : Formado por un nombre y su contenido.
  */
  @Test
  public void obtenerPrevisualizacionAudioTest() {

    //Se crea un nuevo audio introduciendo un nombre y un contenido
    Audio audio = new Audio(nombrePrueba, contenido);

    assertEquals(audio.obtenerPreVisualizacion(), 
                  nombrePrueba + "(" + contenido.length() + " bytes, " + "audio/ogg)");
    
  }
}
