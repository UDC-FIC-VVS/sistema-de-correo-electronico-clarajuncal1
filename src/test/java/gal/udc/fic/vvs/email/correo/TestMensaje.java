package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import gal.udc.fic.vvs.email.archivo.Texto;
import java.util.Collection;
import org.junit.Test;

public class TestMensaje {
  /**
  * Descripción : Establecer si un Mensaje ha sido leido.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Mensaje : mensaje formado por un texto
  */
  @Test
  public void establecerLeido() {

    Texto texto = new Texto("textoPrueba", "Texto de prueba");
    Mensaje mensaje = new Mensaje(texto);

    mensaje.establecerLeido(true);

    assertEquals(0, mensaje.obtenerNoLeidos());

  }

  /**
  * Descripción : Obtener si un Mensaje ha sido leido.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Mensaje : mensaje formado por un texto
  */
  @Test
  public void obtenerNoLeidos() {

    Texto texto = new Texto("textoPrueba", "Texto de prueba");
    Mensaje mensaje = new Mensaje(texto);

    assertEquals(1, mensaje.obtenerNoLeidos());
  }

  /**
  * Descripción : Obtener el tamaño de un Mensaje.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Mensaje : mensaje formado por un texto
  */
  @Test
  public void obtenerTamano() {

    Texto texto = new Texto("textoPrueba", "Texto de prueba");
    Mensaje mensaje = new Mensaje(texto);

    assertEquals(mensaje.obtenerTamaño(), texto.obtenerTamaño());
  }

  /**
  * Descripción : Obtener el icono de un Mensaje.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Mensaje : mensaje formado por un texto
  */
  @Test
  public void obtenerIcono() {

    Texto texto = new Texto("textoPrueba", "Texto de prueba");
    Mensaje mensaje = new Mensaje(texto);

    assertEquals(Correo.ICONO_NUEVO_MENSAJE, mensaje.obtenerIcono());

    mensaje.establecerLeido(true);

    assertEquals(Correo.ICONO_MENSAJE, mensaje.obtenerIcono());
  }

  /**
  * Descripción : Obtener la visualización de un Mensaje.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Mensaje : mensaje formado por un texto
  */
  @Test
  public void obtenerVisualizacion() {

    Texto texto = new Texto("textoPrueba", "Texto de prueba");
    Mensaje mensaje = new Mensaje(texto);

    assertEquals("Texto de prueba", mensaje.obtenerVisualizacion());
  }
  
  /**
  * Descripción : Obtener la previsualización de un Mensaje.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Mensaje : mensaje formado por un texto
  */
  @Test
  public void obtenerPrevisualizacionMensajeTest() {

    Texto texto = new Texto("textoPrueba", "Texto de prueba");
    Mensaje mensaje = new Mensaje(texto);

    assertEquals("Texto de prueba...", mensaje.obtenerPreVisualizacion());
  }

  /**
  * Descripción : Buscar un Mensaje.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Mensaje : mensaje formado por un texto
  */
  @Test
  public void buscar() {

    Texto texto = new Texto("textoPrueba", "Texto de prueba");

    Mensaje mensaje = new Mensaje(texto);

    Collection resultado = mensaje.buscar("texto");

    assertEquals(1, resultado.size());
    assertEquals(true, resultado.contains(mensaje));
  }

  /**
  * Descripción : Buscar un Mensaje no existente.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Mensaje : mensaje formado por un texto
  */
  @Test
  public void buscarNoExistente() {

    Texto texto = new Texto("textoPrueba", "Texto de prueba");
    Mensaje mensaje = new Mensaje(texto);

    Collection resultado = mensaje.buscar("audio");

    assertEquals(true, resultado.isEmpty());
  }
  
  /**
  * Descripción : Obtener el padre de un Reenvio.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Reenvio : reenvio formada por un mensaje y un correo.
  */
  @Test
  public void establecerYObtenerPadre() throws OperacionInvalida {

    Texto texto = new Texto("textoPrueba", "Texto de prueba");
    Mensaje mensaje = new Mensaje(texto);
    Carpeta carpeta = new Carpeta("carpeta");

    mensaje.establecerPadre(carpeta);

    assertEquals(carpeta, mensaje.obtenerPadre());
  }
  
  /**
  * Descripción : obtener el hijo de un mensaje.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, negativa, funcional.
  * @Param Mensaje : mensaje formada por un texto.
  * @Exception OperacionInvalida : Devuelve una excepción, pues un
  *    adjunto no puede realizar dicha operación.
  */
  @Test(expected = OperacionInvalida.class)
  public void obtenerHijo() throws OperacionInvalida {

    Texto texto = new Texto("textoPrueba", "Texto de prueba");
    Mensaje mensaje = new Mensaje(texto);
    mensaje.obtenerHijo(0);
  }
  
  /**
  * Descripción : Explicar un mensaje.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, negativa, funcional.
  * @Param Mensaje : mensaje formado por un texto.
  * @Param Carpeta : carpeta a la que se añade el mensaje.
  * @Exception OperacionInvalida : Devuelve una excepción, pues un
  *    adjunto no puede realizar dicha operación.
  */
  @Test(expected = OperacionInvalida.class)
  public void explorar() throws OperacionInvalida {

    Texto texto = new Texto("textoPrueba", "Texto de prueba");
    Mensaje mensaje = new Mensaje(texto);
    Carpeta carpeta = new Carpeta("Carpeta");

    carpeta.añadir(mensaje);

    mensaje.explorar();

  }
}
