package ejercicio2;

import static org.junit.Assert.assertFalse;

import org.junit.BeforeClass;
import org.junit.Test;


public class OrdinariaENDETest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testEsPalindromo() {
		String palabra = "reconocer";
		assertFalse(palabra, true);
	}

}
