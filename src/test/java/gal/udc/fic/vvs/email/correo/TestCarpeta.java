package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import gal.udc.fic.vvs.email.TestJETM;
import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.Test;

import etm.core.monitor.EtmPoint;


public class TestCarpeta extends TestJETM{
  private String nombre = "nombreCarpeta";
  private String nombreTexto = "TextoPrueba";
  private String contenido = "Texto de prueba";
  Texto texto = new Texto(nombreTexto, contenido);

  /**
  * Descripción : Obtener el leido de una Carpeta.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *    @Param Carpeta : Formada por un nombre.
  *    @Param Correo : Formado por un mensaje(nombre y su contenido)
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
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *   @Param Carpeta : Formada por un nombre.
  *   @Param Correo : Formado por un mensaje(nombre y su contenido)
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
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *   @Param Carpeta : Formada por un nombre.
  *   @Param Correo : Formado por un mensaje(nombre y su contenido)
  * @throws OperacionInvalida
  * PiTest: Queda un mutante vivo debido a que no se puede probar el
  * point del etmMonitor creado para las pruebas con JETM.
  */
  @Test
  public void obtenerTamano() throws OperacionInvalida {
	EtmPoint point = monitor.createPoint("Carpeta:obtenerTamano");

    Carpeta carpeta = new Carpeta(nombre);
    Correo correo = new Mensaje(texto);

    carpeta.añadir(correo);

    point.collect();
    assertEquals(carpeta.obtenerTamaño(), correo.obtenerTamaño());
  }

  /**
  * Descripción : Obtener el icono de una Carpeta.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *   @Param Carpeta : Formada por un nombre.
  *   @Param Correo : Formado por un mensaje(nombre y su contenido)
  * @throws OperacionInvalida
  * PiTest: Queda un mutante vivo debido a que no se puede probar el
  * point del etmMonitor creado para las pruebas con JETM.
  */
  @Test
  public void obtenerIcono() throws OperacionInvalida {
	EtmPoint point = monitor.createPoint("Carpeta:obtenerIcono");

    Carpeta carpeta = new Carpeta(nombre);
    Correo correo = new Mensaje(texto);

    carpeta.añadir(correo);
    point.collect();
    assertEquals(Correo.ICONO_CARPETA, carpeta.obtenerIcono());
  }

  /**
  * Descripción : Obtener la previsualizacion de una Carpeta.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *   @Param Carpeta : Formada por un nombre.
  *   @Param Mensaje : Formado por un texto(nombre y su contenido)
  * @throws OperacionInvalida
  */
  @Test
  public void obtenerPreVisualizacionCarpetaTest() throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombre);
    Mensaje mensaje = new Mensaje(new Texto("TextoPrueba", "Texto de prueba"));

    carpeta.añadir(mensaje);

    assertEquals("nombreCarpeta (1)", carpeta.obtenerPreVisualizacion());
  }

  /**
  * Descripción : Obtener la visualizacion de una Carpeta.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *   @Param Carpeta : Formada por un nombre.
  *   @Param Correo : Formado por un mensaje(nombre y su contenido)
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
  * Descripción : Obtener la visualizacion de una Carpeta.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan valores frontera, puesto que se prueba un caso
  * en el que la carpeta no tenga visualizaciones.
  *   @Param Carpeta : Formada por un nombre.
  *   @Param Correo : Formado por un mensaje(nombre y su contenido)
  * @throws OperacionInvalida
  */
  @Test
  public void obtenerVisualizacionSinLeidos() throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombre);
    Correo correo = new Mensaje(texto);

    carpeta.añadir(correo);
    
    carpeta.establecerLeido(true);

    assertEquals(carpeta.obtenerVisualizacion(), nombre );
  }

  /**
  * Descripción : Explorar una Carpeta.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *   @Param Carpeta : Formada por un nombre.
  *   @Param Correo : Formado por un mensaje(nombre y su contenido)
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
  * Descripción : Explorar una Carpeta Inexistente.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, negativa, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan valores frontera, ya que se prueba un caso
  * en el que no existe el elemento que se quiere explorar.
  *   @Param Carpeta : Formada por un nombre.
  *   @Param Correo : Formado por un mensaje(nombre y su contenido)
  * @throws OperacionInvalida
  */
  @Test
  public void explorarInexistente() throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombre);
    Correo correo = new Mensaje(texto);

    assertEquals(false, carpeta.explorar().contains(correo));
    assertEquals(true, carpeta.explorar().isEmpty());
  }

  /**
  * Descripción : buscar un correo a una Carpeta.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *   @Param Carpeta : Formada por un nombre.
  *   @Param Correo : Formado por un mensaje(nombre y su contenido).
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
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *   @Param Carpeta : Formada por un nombre.
  *   @Param Correo : Formado por un mensaje(nombre y su contenido).
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
  * Descripción : Añadir un correo a una Carpeta.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *   @Param Carpeta : Formada por un nombre.
  *   @Param Correo : Formado por un mensaje(nombre y su contenido)
  * @throws OperacionInvalida
  */
  @Test
  public void anadirCarpetaConHijo() throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombre);
    Carpeta carpetaHijo = new Carpeta("carpetaHijo");
    Correo correo = new Mensaje(texto);

    carpetaHijo.añadir(correo);
    carpeta.añadir(carpetaHijo);

    assertEquals(carpeta.obtenerTamaño(), correo.obtenerTamaño());
  }

  /**
  * Descripción : Eliminar el correo de una Carpeta.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *   @Param Carpeta : Formada por un nombre.
  *   @Param Correo : Formado por un mensaje(nombre y su contenido)
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

    assertEquals(false, carpeta.explorar().contains(correo1));
    assertEquals(null, correo1.obtenerPadre());
  }

  /**
  * Descripción : Obtener el hijo de una Carpeta.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *   @Param Carpeta : Formada por un nombre.
  *   @Param Correo : Formado por un mensaje(nombre y su contenido).
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
  * Descripción : Obtener el hijo de una Carpeta sin hijos.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, negativa, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan valores frontera, se escoge un elemento 
  * vacío para realizar la prueba
  *   @Param Carpeta : Formada por un nombre.
  *   @Param Correo : Formado por un mensaje(nombre y su contenido)
  * @throws OperacionInvalida
  */
  @Test(expected = ArrayIndexOutOfBoundsException.class)
  public void obtenerHijoInexistente() throws OperacionInvalida {

    Carpeta carpeta = new Carpeta(nombre);
    Correo correo = new Mensaje(texto);

    Assert.assertNull(correo.toString(), carpeta.obtenerHijo(1));

  }

  /**
  * Descripción : Obtener la ruta de una Carpeta.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *   @Param Carpeta : Formada por un nombre.
  *   @Param Correo : Formado por un mensaje(nombre y su contenido).
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
