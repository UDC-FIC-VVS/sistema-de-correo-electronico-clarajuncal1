package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.Test;

public class TestCarpetaLimitada {

  private String nombre = "carpetaPrueba";
  Carpeta carpeta = new Carpeta(nombre);
  private int tamano = 50;

  private String nombreTexto = "Texto";
  private String contenidoTexto = "Texto de Prueba";
  Texto texto = new Texto(nombreTexto, contenidoTexto);

  /**
  * Descripción : obtener el tamaño de una carpeta limitada.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *    @Param CarpetaLimitada : Formada por un carpeta y un tamaño.
  */
  @Test
  public void obtenerTamano() {

    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);

    assertEquals(carpetaLimitada.obtenerTamaño(), carpeta.obtenerTamaño());
  }

  /**
  * Descripción : Establecer los leidos de una carpeta limitada.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *    @Param CarpetaLimitada : Formada por un carpeta y un tamaño.
  */
  @Test
  public void establecerLeido() {

    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);

    carpetaLimitada.establecerLeido(true);

    assertEquals(0, carpetaLimitada.obtenerNoLeidos());
  }

  /**
  * Descripción : Obtener los leidos de una carpeta limitada.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *   @Param CarpetaLimitada : Formada por un carpeta y un tamaño.
  *   @Param Correo : Formado por un mensaje(nombre y su contenido).
  * @throws OperacionInvalida
  */
  @Test
  public void obtenerNoLeido() throws OperacionInvalida {

    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);

    Correo correo = new Mensaje(texto);

    carpetaLimitada.añadir(correo);

    assertEquals(1, carpetaLimitada.obtenerNoLeidos());
  }

  /**
  * Descripción : Obtener el icono de una carpeta limitada.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *    @Param CarpetaLimitada : Formada por un carpeta y un tamaño.
  */
  @Test
  public void obtenerIcono() {

    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);

    assertEquals(carpetaLimitada.obtenerIcono(), carpeta.obtenerIcono());
  }

  /**
  * Descripción : Obtener la previsualización de una carpeta limitada.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *    @Param CarpetaLimitada : Formada por un carpeta y un tamaño.
  */
  @Test
  public void obtenerPrevisualizacionCarpetaLimitadaTest() {

    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);

    assertEquals(carpetaLimitada.obtenerPreVisualizacion(), carpeta.obtenerPreVisualizacion());
  }

  /**
  * Descripción : Obtener la visualizacion de una carpeta limitada.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *    @Param CarpetaLimitada : Formada por un carpeta y un tamaño.
  */
  @Test
  public void obtenerVisualizacion() {

    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);

    assertEquals(carpetaLimitada.obtenerVisualizacion(), carpeta.obtenerVisualizacion());
  }

  /**
  * Descripción : Obtener la ruta de una carpeta limitada.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *    @Param CarpetaLimitada : Formada por un carpeta y un tamaño.
  */
  @Test
  public void obtenerRuta() {

    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);

    assertEquals(carpetaLimitada.obtenerRuta(), carpeta.obtenerRuta());
  }

  /**
  * Descripción : Explorar que una carpeta limitada contenga correos.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *    @Param CarpetaLimitada : Formada por un carpeta y un tamaño.
  * @throws OperacionInvalida
  */
  @Test
  public void explorar() throws OperacionInvalida {

    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);

    assertEquals(carpetaLimitada.explorar(), carpeta.explorar());
  }
  
  /**
  * Descripción : Explorar una CarpetaLimitada Inexistente.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan valores frontera, esto es, se escoge 
  * un elemento vacío para realizar la prueba.
  *   @Param CarpetaLimitada : Formada por un carpeta y un tamaño.
  * @throws OperacionInvalida
  */
  @Test
  public void explorarInexistente() throws OperacionInvalida {

	CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);

    assertEquals(true, carpetaLimitada.explorar().isEmpty());
  }

  /**
  * Descripción : Añadir un correo a una carpeta limitada.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *   @Param CarpetaLimitada : Formada por un carpeta y un tamaño.
  *   @Param Correo : Formado por un mensaje(nombre y su contenido).
  * @throws OperacionInvalida
  */
  @Test
  public void anadir() throws OperacionInvalida {

    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);
    Correo correo = new Mensaje(texto);

    carpetaLimitada.añadir(correo);
    
    assertEquals(correo.obtenerTamaño(), carpetaLimitada.obtenerTamaño());
  }

  /**
  * Descripción : Eliminar un correo de una carpeta limitada.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *   @Param CarpetaLimitada : Formada por un carpeta y un tamaño.
  *   @Param Correo : Formado por un mensaje(nombre y su contenido).
  * @throws OperacionInvalida
  */
  @Test
  public void eliminar() throws OperacionInvalida {

    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);
    Correo correo = new Mensaje(texto);

    carpetaLimitada.eliminar(correo);
    
    assertEquals(0, carpetaLimitada.obtenerTamaño());
  }

  /**
  * Descripción : Obtener el hijo de una carpeta limitada a partir 
  *  de un correo previamente añadido.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *   @Param CarpetaLimitada : Formada por un carpeta y un tamaño.
  *   @Param Correo : Formado por un mensaje(nombre y su contenido).
  * @throws OperacionInvalida
  */
  @Test
  public void obtenerHijo() throws OperacionInvalida {

    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);
    Correo correo = new Mensaje(texto);

    carpetaLimitada.añadir(correo);

    assertEquals(correo, carpetaLimitada.obtenerHijo(0));

  }
  
  /**
  * Descripción : Obtener el hijo de una CarpetaLimitada sin hijos.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, negativa, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan valores frontera, esto es, se escoge 
  * un elemento vacío para realizar la prueba.
  *   @Param CarpetaLimitada : Formada por un carpeta y un tamaño.
  *   @Param Correo : Formado por un mensaje(nombre y su contenido).
  * @throws OperacionInvalida
  */
  @Test(expected = ArrayIndexOutOfBoundsException.class)
  public void obtenerHijoInexistente() throws OperacionInvalida {

    Carpeta carpetaLimitada = new Carpeta(nombre);
    Correo correo = new Mensaje(texto);

    Assert.assertNull(correo.toString(), carpetaLimitada.obtenerHijo(1));

  }

  /**
  * Descripción : obtener la carpeta limitada padre de un correo previamente añadido.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
  *   @Param CarpetaLimitada : Formada por un carpeta y un tamaño.
  *   @Param Correo : Formado por un mensaje(nombre y su contenido).
  */
  @Test
  public void establecerYObtenerPadre() {

    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);
    Correo correo = new Mensaje(texto);

    carpetaLimitada.establecerPadre(correo);

    assertEquals(correo, carpetaLimitada.obtenerPadre());

  }

  /**
  * Descripción : obtener la carpeta limitada padre sin correo.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan valores frontera, esto es, se escoge 
  * un elemento vacío para realizar la prueba.
  *    @Param CarpetaLimitada : Formada por un carpeta y un tamaño.
  */
  @Test
  public void obtenerPadreNull() {
    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);

    assertEquals(null, carpetaLimitada.obtenerPadre());
  }
  
  /**
   * Descripción : buscar un correo a una Carpeta Limitada.  
   * Nivel : Prueba de Integración.
   * Categoría : Prueba dinámica de caja negra, positiva, funcional.
   * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge 
  * un elemento que representa al grupo.
   *   @Param CarpetaLimitada : Formada por un carpeta y un tamaño.
   *   @Param Correo : Formado por un mensaje(nombre y su contenido).
   * @throws OperacionInvalida
   * PiTest: No se puede matar un mutante pues no es posible acceder
   * al array y en consecuencia eliminar un elemento.
   */
   @Test
   public void buscar() throws OperacionInvalida {

	 CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 1);
     Correo correo = new Mensaje(texto);
     Correo correo2 = new Mensaje(texto);
     
     carpetaLimitada.añadir(correo);
     carpetaLimitada.añadir(correo2);
     
     assertEquals(true, carpetaLimitada.buscar("Texto").contains(correo));
     assertEquals(2, carpetaLimitada.buscar("Texto").size());
   }
}
