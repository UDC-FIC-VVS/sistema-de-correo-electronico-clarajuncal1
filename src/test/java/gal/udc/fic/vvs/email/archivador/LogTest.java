package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class LogTest {

	private String nombreArchivador = "Archivador";
	private int espacioArchivador = 100;
	private String nombreTexto = "Texto";
	private String contenido = "Texto de prueba";
	Texto texto = new Texto(nombreTexto, contenido);
	
	public void almacenarCorreo() {
		ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		Log log = new Log(archivador);
		
		Correo correo = new Mensaje(texto);
		
		assertEquals(true, log.almacenarCorreo(correo));
	}
}
