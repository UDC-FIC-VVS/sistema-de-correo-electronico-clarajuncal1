package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;

@RunWith(JUnitQuickcheck.class)
public class TestCarpetaProperty {
	
	@Property
	public void establecerYObtenerNoLeidoPropertyTest(String nombreCarpeta, String nombreTexto, String contenidoTexto) throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Correo correo = new Mensaje (new Texto(nombreTexto, contenidoTexto));
		
		carpeta.añadir(correo);
		
		assertEquals(1, carpeta.obtenerNoLeidos());
		
		carpeta.establecerLeido(true);
		
		assertEquals(0, carpeta.obtenerNoLeidos());
	}
	
	@Property
	public void obtenerTamaño(String nombreCarpeta, String nombreTexto, String contenidoTexto) throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Correo correo = new Mensaje (new Texto(nombreTexto, contenidoTexto));
		Correo correo2 = new Mensaje (new Texto(nombreTexto, contenidoTexto));

		carpeta.añadir(correo);
		carpeta.añadir(correo2);
		
		assertEquals(carpeta.obtenerTamaño(), correo.obtenerTamaño()+correo2.obtenerTamaño());
	}

	@Property
	public void obtenerPrevisualización(String nombreCarpeta, String nombreTexto, String contenidoTexto) throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Correo correo = new Mensaje (new Texto(nombreTexto, contenidoTexto));
		
		carpeta.añadir(correo);
		
		assertEquals(nombreCarpeta + " (" + carpeta.obtenerNoLeidos() + ")", carpeta.obtenerPreVisualizacion());
	}
	
	@Property
	public void obtenerIconoPropertyTest(String nombreCarpeta, String nombreTexto, String contenidoTexto) throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Correo correo = new Mensaje (new Texto(nombreTexto, contenidoTexto));
		
		carpeta.añadir(correo);
		
		assertEquals(Correo.ICONO_CARPETA, carpeta.obtenerIcono());
	}
	
	@Property
	public void obtenerVisualizaciónPropertyTest(String nombreCarpeta, String nombreTexto, String contenidoTexto) throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Correo correo = new Mensaje (new Texto(nombreTexto, contenidoTexto));
		
		carpeta.añadir(correo);
		
		assertEquals(nombreCarpeta + " (" + carpeta.obtenerNoLeidos() + ")", carpeta.obtenerPreVisualizacion());

	}
	
	@Property
	public void añadirPropertyTest(String nombreCarpeta, String nombreTexto, String contenidoTexto) throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Correo correo = new Mensaje (new Texto(nombreTexto, contenidoTexto));
		
		carpeta.añadir(correo);
		
		assertEquals(carpeta.obtenerTamaño(), correo.obtenerTamaño());
	}
	
	@Property
	public void eliminarPropertyTest(String nombreCarpeta, String nombreTexto, String contenidoTexto) throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Correo correo = new Mensaje (new Texto(nombreTexto, contenidoTexto));
		Correo correo2 = new Mensaje (new Texto(nombreTexto, contenidoTexto));

		carpeta.añadir(correo);
		carpeta.añadir(correo2);
		
		assertEquals(carpeta.obtenerTamaño(), correo.obtenerTamaño()+correo2.obtenerTamaño());
		
		carpeta.eliminar(correo);
		
		assertEquals(carpeta.obtenerTamaño(), correo2.obtenerTamaño());
	}
	
	@Property
	public void obtenerHijoPropertyTest(String nombreCarpeta, String nombreTexto, String contenidoTexto) throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Correo correo = new Mensaje (new Texto(nombreTexto, contenidoTexto));
		
		carpeta.añadir(correo);
		
		assertEquals(correo, carpeta.obtenerHijo(0));
	}
	
	@Property
	public void explorarPropertyTest(String nombreCarpeta, String nombreTexto, String contenidoTexto) throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Correo correo = new Mensaje (new Texto(nombreTexto, contenidoTexto));
		
		carpeta.añadir(correo);
		
		assertEquals(true, carpeta.explorar().contains(correo));
	}
	
	@Property
	public void obtenerRutaPropertyTest(String nombreCarpeta, String nombreTexto, String contenidoTexto) throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Correo correo = new Mensaje (new Texto(nombreTexto, contenidoTexto));
		
		carpeta.añadir(correo);
		
		assertEquals(nombreCarpeta + " (" + carpeta.obtenerNoLeidos() + ")", carpeta.obtenerPreVisualizacion());
	}
}
