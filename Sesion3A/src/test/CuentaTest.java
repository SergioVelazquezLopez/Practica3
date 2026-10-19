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
    void test0014() {
        Cuenta cuenta12345 = new Cuenta("12345", "Titular 1", 50.0);
        Cuenta cuenta67890 = new Cuenta("67890", "Titular 2", 0.0);

        cuenta12345.retirar(200.0);
        cuenta67890.retirar(350.0);  
        cuenta12345.ingresar(100.0); 
        cuenta67890.retirar(200.0); //Deberia fallar (saldo -350, limite -500)
        cuenta67890.retirar(150.0); 
        cuenta12345.retirar(200.0); 
        cuenta67890.ingresar(50.0);  
        cuenta67890.retirar(100.0); //Deberia fallar (saldo -450, limite -500)

        // Resultado para la Cuenta 12345
        assertEquals(-250.0, cuenta12345.getSaldo(), "El saldo final de 12345 debe ser -250€");
        
        // Resultado para la Cuenta 67890
        assertEquals(-450.0, cuenta67890.getSaldo(), "El saldo final de 67890 debe ser -450€");

        // Verificación de los errores registrados en la cuenta 67890
        assertEquals(2, cuenta67890.getErrores().size(), "Deberia haber 2 errores registrados en la cuenta 67890");
        
        String error1 = "Fondos insuficientes (saldo -350.0€) en la cuenta 67890 para el reintegro de 200.0€";
        assertTrue(cuenta67890.getErrores().contains(error1), "Falta el error 1");

        String error2 = "Fondos insuficientes (saldo -450.0€) en la cuenta 67890 para el reintegro de 100.0€";
        assertTrue(cuenta67890.getErrores().contains(error2), "Falta el error 2");
        
        System.out.println("--- ERRORES REGISTRADOS EN LA CUENTA 67890 ---");
        cuenta67890.getErrores().forEach(System.out::println);
    }

}
