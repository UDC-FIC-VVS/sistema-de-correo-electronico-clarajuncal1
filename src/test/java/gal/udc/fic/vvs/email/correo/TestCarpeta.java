package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.Test;


public class TestCarpeta {
  private String nombre = "nombreCarpeta";
  private String nombreTexto = "TextoPrueba";
  private String contenido = "Texto de prueba";
  Texto texto = new Texto(nombreTexto, contenido);

  /**
  * Descripción : Obtener el leido de una Carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @throws OperacionInvalida
  */
  @Test
  public void obtenerNoLeido() throws OperacionInvalida {
    Carpeta carpeta = new Carpeta(nombre);
    Correo correo = new Mensaje(texto);

    carpeta.añadir(correo);

    assertEquals(1, carpeta.obtenerNoLeidos());
  }

  /**
  * Descripción : Establecer el leido de una Carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @throws OperacionInvalida
  */
  @Test
  public void establecerYObtenerLeido() throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombre);
    Correo correo = new Mensaje(texto);

    carpeta.añadir(correo);

    carpeta.establecerLeido(true);

    assertEquals(0, carpeta.obtenerNoLeidos());
  }

  /**
  * Descripción : Obtener el tamaño de una Carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funciona.
  * @throws OperacionInvalida
  */
  @Test
  public void obtenerTamano() throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombre);
    Correo correo = new Mensaje(texto);

    carpeta.añadir(correo);

    assertEquals(carpeta.obtenerTamaño(), correo.obtenerTamaño());
  }

  /**
  * Descripción : Obtener el icono de una Carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @throws OperacionInvalida
  */
  @Test
  public void obtenerIcono() throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombre);
    Correo correo = new Mensaje(texto);

    carpeta.añadir(correo);

    assertEquals(Correo.ICONO_CARPETA, carpeta.obtenerIcono());
  }

  /**
  * Descripción : Obtener la previsualizacion de una Carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @throws OperacionInvalida
  */
  @Test
  public void obtenerPreVisualizacion() throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombre);
    Mensaje mensaje = new Mensaje(new Texto("TextoPrueba", "Texto de prueba"));

    carpeta.añadir(mensaje);

    assertEquals("nombreCarpeta (1)", carpeta.obtenerPreVisualizacion());
  }

  /**
  * Descripción : Obtener la visualizacion de una Carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @throws OperacionInvalida
  */
  @Test
  public void obtenerVisualizacion() throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombre);
    Correo correo = new Mensaje(texto);

    carpeta.añadir(correo);

    assertEquals(carpeta.obtenerVisualizacion(), nombre + " (" + carpeta.obtenerNoLeidos() + ")");
  }

  /**
  * Descripción : Explorar una Carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @throws OperacionInvalida
  */
  @Test
  public void explorar() throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombre);
    Correo correo = new Mensaje(texto);

    carpeta.añadir(correo);

    assertEquals(true, carpeta.explorar().contains(correo));
  }

  /**
  * Descripción : buscar un correo a una Carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @throws OperacionInvalida
  */
  @Test
  public void buscar() throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombre);
    Correo correo = new Mensaje(texto);

    carpeta.añadir(correo);

    assertEquals(true, carpeta.buscar("Texto").contains(correo));
    assertEquals(1, carpeta.buscar("Texto").size());
  }

  /**
  * Descripción : Añadir un correo a una Carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @throws OperacionInvalida
  */
  @Test
  public void anadir() throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombre);
    Correo correo = new Mensaje(texto);

    carpeta.añadir(correo);

    assertEquals(carpeta.obtenerTamaño(), correo.obtenerTamaño());
  }

  /**
  * Descripción : Eliminar el correo de una Carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @throws OperacionInvalida
  */
  @Test
  public void eliminar() throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombre);
    Correo correo1 = new Mensaje(texto);
    Correo correo2 = new Mensaje(new Texto("correoPrueba", "correo de prueba"));

    carpeta.añadir(correo1);
    carpeta.añadir(correo2);

    carpeta.eliminar(correo1);

    assertEquals(1, carpeta.buscar("Prueba").size());
  }

  /**
  * Descripción : Obtener el hijo de una Carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @throws OperacionInvalida
  */
  @Test
  public void obtenerHijo() throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombre);
    Correo correo = new Mensaje(texto);

    carpeta.añadir(correo);

    assertEquals(correo, carpeta.obtenerHijo(0));
  }

  /**
  * Descripción : Obtener la ruta de una Carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @throws OperacionInvalida
  */
  @Test
  public void obtenerRuta() throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombre);
    Correo correo = new Mensaje(texto);

    carpeta.añadir(correo);

    assertEquals(nombre + " (" +  carpeta.obtenerNoLeidos() + ")", carpeta.obtenerRuta());
  }
}
