package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class LogTest {

	private String nombreArchivador = "Archivador";
	private int espacioArchivador = 100;
	private String nombreTexto = "Texto";
	private String contenido = "Texto de prueba";
	Texto texto = new Texto(nombreTexto, contenido);
	
	@Test
	public void almacenarCorreo() {
		//Se crea un Log a partir de un Archivador
		ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		Log log = new Log(archivador);
		
		//Se crea un mensaje de correo nuevo
		Correo correo = new Mensaje(texto);
		
		//Se comprueba que el log es capaz de almacenar dicho mensaje de correo
		assertEquals(true, log.almacenarCorreo(correo));
	}
}
