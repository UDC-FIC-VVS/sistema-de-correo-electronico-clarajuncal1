package gal.udc.fic.vvs.email.archUnit;

import org.junit.Test;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

public class TestArquitecturaCorreo {

	  /**
	  * Descripción : Realización de un test de arquitectura para el paquete Correo 
	  * Categoría : Prueba dinámica de caja blanca, positiva, estructural.
	  */
	@Test
	public void correoArquitecturaTest() {
		
		JavaClasses classesImported = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.correo");
		
		ArchRule methods = methods()
				.that().haveNameMatching(".*nombre").should()
				.haveRawReturnType(String.class);
		
		methods.check(classesImported);
	}
}
