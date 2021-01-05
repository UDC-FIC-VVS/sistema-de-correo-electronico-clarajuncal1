package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.Test;

public class TestReenvio {

  Texto textoMensaje = new Texto("textoMensaje", "texto del mensaje abstracto");
  Mensaje mensajeAbstracto = new Mensaje(textoMensaje);

  Texto textoCorreo = new Texto("correo", "correo del reenvio");
  Correo correo = new Mensaje(textoCorreo);

  /**
  * Descripción : Obtener el tamaño de un Reenvio.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Reenvio : reenvio formada por un mensaje y un correo.
  */
  @Test 
  public void obtenerTamano() {

    Reenvio reenvio = new Reenvio(mensajeAbstracto, correo);

    assertEquals(mensajeAbstracto.obtenerTamaño()
                  + correo.obtenerTamaño(), reenvio.obtenerTamaño());
  }

  /**
  * Descripción : Obtener la visualización de un Reenvio.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Reenvio : reenvio formada por un mensaje y un correo.
  */
  @Test
  public void obtenerVisualizacion() {

    Reenvio reenvio = new Reenvio(mensajeAbstracto, correo);

    assertEquals(mensajeAbstracto.obtenerVisualizacion() 
                  + "\n\n---- Correo reenviado ----\n\n" + correo.obtenerVisualizacion() 
                  + "\n---- Fin correo reenviado ----", reenvio.obtenerVisualizacion());
  }

  /**
  * Descripción : Obtener la previsualización de un Reenvio.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Reenvio : reenvio formada por un mensaje y un correo.
  */
  @Test
  public void obtenerPrevisualizacion() {

    Reenvio reenvio = new Reenvio(mensajeAbstracto, correo);
    
    assertEquals("texto del mensaje abstracto...", reenvio.obtenerPreVisualizacion());
  }

  /**
  * Descripción : Obtener el icono de un Reenvio.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Reenvio : reenvio formada por un mensaje y un correo.
  */
  @Test
  public void obtenerIcono() {

    Reenvio reenvio = new Reenvio(mensajeAbstracto, correo);

    assertEquals(Reenvio.ICONO_NUEVO_MENSAJE, reenvio.obtenerIcono());
  }

  /**
  * Descripción : Establecer y Obtener los leídos de un Reenvio.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Reenvio : reenvio formada por un mensaje y un correo.
  */
  @Test 
  public void establecerYObtenerLeido() throws OperacionInvalida {
    Reenvio reenvio = new Reenvio(mensajeAbstracto, correo);

    assertEquals(1, reenvio.obtenerNoLeidos());

    reenvio.establecerLeido(true);
    
    assertEquals(0, reenvio.obtenerNoLeidos());
  }
  /**
  * Descripción : Obtener la ruta de un Reenvio.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Reenvio : reenvio formada por un mensaje y un correo.
  */
  @Test
  public void obtenerRuta() {

    Reenvio reenvio = new Reenvio(mensajeAbstracto, correo);

    assertEquals(mensajeAbstracto.obtenerRuta(), reenvio.obtenerRuta());
  }

  /**
  * Descripción : Explicar un reenvio.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, negativa, funcional.
  * @Param Reenvio : reenvio formada por un mensaje y un correo.
  * @Param Carpeta : carpeta a la que se añade el reenvio.
  * @Exception OperacionInvalida : Devuelve una excepción, pues un
  *    adjunto no puede realizar dicha operación.
  */
  @Test(expected = OperacionInvalida.class)
  public void explorar() throws OperacionInvalida {

    Reenvio reenvio = new Reenvio(mensajeAbstracto, correo);
    Carpeta carpeta = new Carpeta("Carpeta");

    carpeta.añadir(reenvio);

    reenvio.explorar();

  }

  /**
  * Descripción : Añadir un reenvio.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Reenvio : reenvio formada por un mensaje y un correo.
  * @Param Correo
  * @Exception OperacionInvalida : Devuelve una excepción, pues un
  *    adjunto no puede realizar dicha operación.
  */
  @Test(expected = OperacionInvalida.class)
  public void anadir() throws OperacionInvalida {

    Reenvio reenvio = new Reenvio(mensajeAbstracto, correo);
    Correo correo = new Mensaje(new Texto("CorreoPrueba", "Añadir correo al reenvio"));

    reenvio.añadir(correo);
  }

  /**
  * Descripción : Eliminar un reenvio.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, negativa, funcional.
  * @Param Reenvio : reenvio formada por un mensaje y un correo.
  * @Param Correo
  * @Exception OperacionInvalida : Devuelve una excepción, pues un
  *    adjunto no puede realizar dicha operación.
  */
  @Test(expected = OperacionInvalida.class)
  public void eliminar() throws OperacionInvalida {

    Reenvio reenvio = new Reenvio(mensajeAbstracto, correo);
    Correo correo = new Mensaje(new Texto("CorreoPrueba", "Añadir correo al reenvio"));
 
    reenvio.eliminar(correo);
  }

  /**
  * Descripción : obtener el hijo de un reenvio.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, negativa, funcional.
  * @Param Reenvio : reenvio formada por un mensaje y un correo.
  * @Exception OperacionInvalida : Devuelve una excepción, pues un
  *    adjunto no puede realizar dicha operación.
  */
  @Test(expected = OperacionInvalida.class)
  public void obtenerHijo() throws OperacionInvalida {

    Reenvio reenvio = new Reenvio(mensajeAbstracto, correo);

    reenvio.obtenerHijo(0);
  }

  /**
  * Descripción : Obtener el padre de un Reenvio.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Reenvio : reenvio formada por un mensaje y un correo.
  */
  @Test
  public void establecerYObtenerPadre() throws OperacionInvalida {

    Reenvio reenvio = new Reenvio(mensajeAbstracto, correo);
    Carpeta carpeta = new Carpeta("carpeta");

    reenvio.establecerPadre(carpeta);

    assertEquals(carpeta, reenvio.obtenerPadre());
  }
}
