package gal.udc.fic.vvs.email.archUnit;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;
import org.junit.Test;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

public class TestArquitecturaArchivador {

	  /**
	  * Descripción : Realización de un test de arquitectura para el paquete Archivador 
	  * Categoría : Prueba dinámica de caja blanca, positiva, estructural.
	  */
	@Test
	public void archivadorArquitecturaTest() {
		
		JavaClasses classesImported = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email");

		ArchRule rule = classes()
				.that().resideInAPackage("..archivador..")
				.should().notBePrivate();
		
		ArchRule method = methods()
				.that().areDeclaredIn("..archivador..")
				.should().bePublic();
		
		rule.check(classesImported);
		method.check(classesImported);
	}
}
