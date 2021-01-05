package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.TestJETM;

public class TestTexto extends TestJETM{
  private String nombrePrueba = "TextoPrueba";
  private String contenido = "Texto de Prueba";
  
  /**
  * Descripción : Obtener el nombre de un Texto  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  */
  @Test
  public void obtenerNombre() {

    //Se crea un nuevo texto introduciendo un nombre y un contenido
    Texto texto = new Texto(nombrePrueba, contenido);

    //Se comprueba que el nombre introducido es el nombre definido previamente
    assertEquals(texto.obtenerNombre(), nombrePrueba);

  }

  /**
  * Descripción : Obtener el contenido de un Texto  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  */
  @Test
  public void obtenerContenido() {

    //Se crea un nuevo texto introduciendo un nombre y un contenido
    Texto texto = new Texto(nombrePrueba, contenido);

    //Se comprueba que el contenido introducido es el mismo definido previamente
    assertEquals(texto.obtenerContenido(), contenido);
  }

  /**
  * Descripción : Obtener el tamaño de un Texto  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  */
  @Test
  public void obtenerTamano() {

    //Se crea un nuevo texto introduciendo un nombre y un contenido
    Texto texto = new Texto(nombrePrueba, contenido);

    //Se comprueba que el tamaño del texto coincida con la longitud de su contenido
    assertEquals(texto.obtenerTamaño(), contenido.length());
  }

  /**
  * Descripción : Obtener la previsualizacion de un Texto  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  */
  @Test
  public void obtenerPrevisualizacionTextosTest() {

    //Se crea un nuevo texto introduciendo un nombre y un contenido
    Texto texto = new Texto(nombrePrueba, contenido);

    assertEquals(texto.obtenerPreVisualizacion(), 
                  nombrePrueba + "(" + contenido.length() + " bytes, " + "text/plain)");

  }
}
