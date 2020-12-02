package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class DelegadoTest {
	
	private String nombreArchivador = "Archivador";
	private int espacioArchivador = 100;
	private String nombreTexto = "Texto";
	private String contenido = "Texto de prueba";
	Texto texto = new Texto(nombreTexto, contenido);
		
	/*
	 * Comprobar que el correo se almacena correctamente
	 */
	@Test
	public void almacenarCorreo() {
		
		ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		Delegado delegado = new Delegado(archivador);
		
		Correo correo = new Mensaje(texto);
		
		
		assertEquals(true, delegado.almacenarCorreo(correo));
	}
	/*
	 * Comprobar que se establecen y se obtienen correctamente los delegados
	 */
	@Test
	public void EstablecerYObtenerDelegado() {
		
		ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		Delegado delegado = new Delegado(archivador);
		
		delegado.establecerDelegado(archivador);
		
		assertEquals(delegado.obtenerDelegado(), archivador);
	}
	
}
