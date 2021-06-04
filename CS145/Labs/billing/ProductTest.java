package cs145.billing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void testProduct() {
		Product test = new Product("This is a test product", 343);
		assertEquals("This is a test product", test.getDescription());
		assertEquals(343, test.getPrice());
		
	}

}
