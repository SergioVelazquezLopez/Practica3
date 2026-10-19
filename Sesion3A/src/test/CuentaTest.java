package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sesion3A.Cuenta;

class CuentaTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
    void testIngresar() {
        Cuenta cuenta = new Cuenta("12345", "Titular de Prueba");
        cuenta.ingresar(1000.0);
        
        // Al estar ingresar() vacío, devuelve 0 y el test falla 
        assertEquals(1000.0, cuenta.getSaldo());
    }

    @Test
    void testRetirar() {
        Cuenta cuenta = new Cuenta("12345", "Titular de Prueba");
        cuenta.retirar(500.0);
        
        // Al estar retirar() vacío, devuelve 0 y el test falla 
        assertEquals(-500.0, cuenta.getSaldo());
    }

}
