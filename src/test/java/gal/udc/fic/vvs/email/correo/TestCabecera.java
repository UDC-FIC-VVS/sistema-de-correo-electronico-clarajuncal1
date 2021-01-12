package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.Test;

public class TestCabecera {

  private String nombreCabecera = "Cabecera";
  private String valorCabecera = "Valor de la cabecera";

  Texto texto = new Texto("Texto", "Texto de prueba");
  Mensaje mensaje = new Mensaje(texto);

  /**
  * Descripción : Obtener el tamaño de una cabecera, para ello se comprueba que el tamaño 
  *  del mensaje mas la longitud del nombre de la cabecera mas la longitud del valor de 
  *  la cabecera coincidan con el tamaño de la cabecera.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Cabecera : cabecera formada por un mensaje, un nombre y su valor.
  */
  @Test
  public void obtenerTamanho() {

    Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

    assertEquals(mensaje.obtenerTamaño() + nombreCabecera.length() + valorCabecera.length(), 
                  cabecera.obtenerTamaño());
  }

  /**
  * Descripción : Obtener la visualización de una cabecera, para ello se comprueba que 
  *  la visualización del mensaje mas el nombre de la cabecera mas el valor de la cabecera
  *  coincidan con la visualización de la cabecera.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Cabecera : cabecera formada por un mensaje, un nombre y su valor.
  */
  @Test
  public void obtenerVisualizacion() {

    Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

    assertEquals(nombreCabecera + ": " + valorCabecera + "\n" 
                  + mensaje.obtenerVisualizacion(), cabecera.obtenerVisualizacion());
  }

  /**
  * Descripción : Obtener la ruta de una cabecera, para ello se comprueba que 
  *  el contenido del mensaje coincide con la ruta de la cabecera.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Cabecera : cabecera formada por un mensaje, un nombre y su valor.
  */
  @Test
  public void obtenerRuta() {

    Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

    assertEquals("Texto de prueba...", cabecera.obtenerRuta());
  }


  /**
  * Descripción : Obtener la ruta con padre de una cabecera, para ello se comprueba que 
  *  el contenido del mensaje más los no leidos de la carpeta coinciden con la 
  *  ruta de la cabecera.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Cabecera : cabecera formada por un mensaje, un nombre y su valor.
  * @Param Carpeta : carpeta a la que se añade la cabecera.
  * @throws OperacionInvalida
  */
  @Test
  public void obtenerRutaConPadre() throws OperacionInvalida {

    Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);
    Carpeta carpeta = new Carpeta("carpeta");

    carpeta.añadir(cabecera);
    assertEquals("carpeta (1) > Texto de prueba...", cabecera.obtenerRuta());
  }

  /**
  * Descripción : Establecer y obtener los leidos de una Cabecera.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Cabecera : cabecera formada por un mensaje, un nombre y su valor.
  */
  @Test
  public void establecerYObtenerLeido() {

    Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

    assertEquals(1, cabecera.obtenerNoLeidos());

    cabecera.establecerLeido(true);

    assertEquals(0, cabecera.obtenerNoLeidos());
  }

  /**
  * Descripción : Obtener el icono de una Cabecera, para ello se comprueba que el icono 
  *  de dicha cabecera corresponde con el icono de un mensaje nuevo.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Cabecera : cabecera formada por un mensaje, un nombre y su valor.
  */
  @Test
  public void obtenerIcono() {

    Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

    assertEquals(Cabecera.ICONO_NUEVO_MENSAJE, cabecera.obtenerIcono());
  }

  /**
  * Descripción : Obtener la previsualización de una Cabecera para ello se comprueba que 
  *  el contenido del mensaje de dicha cabecera corresponde con la previsualizacion 
  *  de la cabecera.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Cabecera : cabecera formada por un mensaje, un nombre y su valor.
  */
  @Test
  public void obtenerPrevisualizacionCabeceraTest() {

    Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

    assertEquals("Texto de prueba...", cabecera.obtenerPreVisualizacion());
  }

  /**
  * Descripción : Explorar una cabecera.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, negativa, funcional.
  * @Param Cabecera : cabecera formada por un mensaje, un nombre y su valor.
  * @Throws OperacionInvalida : Devuelve una excepción, pues un
  *    adjunto no puede realizar dicha operación.
  *  
  */
  @Test(expected = OperacionInvalida.class)
  public void explorar() throws OperacionInvalida {

    Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

    cabecera.explorar();
  }

  /**
  * Descripción : Añadir una cabecera.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, negativa, funcional.
  * @Param Cabecera : cabecera formada por un mensaje, un nombre y su valor.
  * @Throws OperacionInvalida : Devuelve una excepción, pues un
  *    adjunto no puede realizar dicha operación.
  */
  @Test(expected = OperacionInvalida.class)
  public void anadir() throws OperacionInvalida {

    Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);
    Correo correo = new Mensaje(new Texto("prueba", "Intentar añadir un correo"));

    cabecera.añadir(correo);
  }

  /**
  * Descripción : Eliminar una cabecera.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, negativa, funcional.
  * @Param Cabecera : cabecera formada por un mensaje, un nombre y su valor.
  * @Throws OperacionInvalida : Devuelve una excepción, pues un
  *    adjunto no puede realizar dicha operación.
  */
  @Test(expected = OperacionInvalida.class)
  public void eliminar() throws OperacionInvalida {

    Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);
    Correo correo = new Mensaje(new Texto("prueba", "Intentar añadir un correo"));

    cabecera.eliminar(correo);
  }

  /**
  * Descripción : Obtener el hijo de una cabecera.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, negativa, funcional.
  * @Param Cabecera : cabecera formada por un mensaje, un nombre y su valor.
  * @Throws OperacionInvalida : Devuelve una excepción, pues un
  *    adjunto no puede realizar dicha operación.
  */
  @Test(expected = OperacionInvalida.class)
  public void obtenerHijo() throws OperacionInvalida {

    Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

    cabecera.obtenerHijo(0);
  }

  /**
  * Descripción : Obtener el padre de una cabecera despues de haber sido añadida a una carpeta.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Cabecera : cabecera formada por un mensaje, un nombre y su valor.
  * @Param Carpeta : carpeta a la que se añade la cabecera.
  * @Throws OperacionInvalida
  */
  @Test
  public void obtenerPadre() throws OperacionInvalida {

    Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);
    Carpeta carpeta = new Carpeta("Carpeta");

    carpeta.añadir(cabecera);

    assertEquals(carpeta, cabecera.obtenerPadre());
  }

  /**
  * Descripción : Buscar una cabecera despues de haber sido añadida a una carpeta.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Cabecera : cabecera formada por un mensaje, un nombre y su valor.
  * @Param Carpeta : carpeta a la que se añade la cabecera.
  * @Throws OperacionInvalida
  */
  @Test
  public void buscar() throws OperacionInvalida {

    Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);
    Carpeta carpeta = new Carpeta("Carpeta");

    carpeta.añadir(cabecera);

    assertEquals(true, cabecera.buscar("Texto").contains(cabecera));
  }
}
