package gal.udc.fic.vvs.email.archUnit;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import org.junit.Test;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

import gal.udc.fic.vvs.email.archivo.Archivo;

public class TestArquitecturaArchivo {

	  /**
	  * Descripción : Realización de un test de arquitectura para el paquete Archivo 
	  * Categoría : Prueba dinámica de caja blanca, positiva, estructural.
	  */
	@Test
	public void archivoArquitecturaTest() {
		
		JavaClasses classesImported = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email");

		ArchRule rule = classes()
				.that().resideInAPackage("..archivo..")
				.should().notBeInterfaces().orShould().be(Archivo.class);
		
		rule.check(classesImported);
	}
	
}
