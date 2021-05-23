/**
 * 
 */
package cs145.Lab03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * Tests the various methods of the Complex Number class
 * 
 * @author Noah Kamenick
 * @version 2021.2.16
 *
 */
class ComplexNumberTest {

	ComplexNumber realNumber;
	ComplexNumber realAndImagine;
	ComplexNumber realAndImagineTwo;
	ComplexNumber zero;
	ComplexNumber copy;
	ComplexNumber positiveImagineBefore;
	ComplexNumber negativeImagineBefore;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {

		realNumber = new ComplexNumber(5);
		realAndImagine = new ComplexNumber(4, 3);
		realAndImagineTwo = new ComplexNumber(2, -5);
		zero = new ComplexNumber();
		copy = new ComplexNumber(realAndImagine);
		positiveImagineBefore = new ComplexNumber(0, 2);
		negativeImagineBefore = new ComplexNumber(0, -4);

	}

	/**
	 * 
	 * This method tests if the real and imaginary numbers are zero
	 * 
	 * Test method for {@link cs145.Lab03.ComplexNumber#ComplexNumber()}.
	 */
	@Test
	void testComplexNumber() {

		assertEquals(0, zero.getReal(), 0.00001); // Tests the default constructor, should have both real/imagine as 0
		assertEquals(0, zero.getImaginary(), 0.00001);

	}

	/**
	 * 
	 * This method asserts that the ComplexNumber method gets correct values
	 * 
	 * Test method for
	 * {@link cs145.Lab03.ComplexNumber#ComplexNumber(double, double)}.
	 */
	@Test
	void testComplexNumberDoubleDouble() {
		assertEquals(4, realAndImagine.getReal(), 0.00001);
		assertEquals(3, realAndImagine.getImaginary(), 0.00001);
	}

	/**
	 * This method asserts that the getReal getter method pulls the correct values
	 * out of the realNumber object.
	 * 
	 * Test method for {@link cs145.Lab03.ComplexNumber#ComplexNumber(double)}.
	 */
	@Test
	void testComplexNumberDouble() {

		assertEquals(5, realNumber.getReal(), 0.00001);
		assertEquals(0, realNumber.getImaginary(), 0.00001);

	}

	/**
	 * This method asserts that the copy constructor copied the correct values
	 * pulled from the realAndImagine object and its params
	 * 
	 * Test method for
	 * {@link cs145.Lab03.ComplexNumber#ComplexNumber(cs145.Lab03.ComplexNumber)}.
	 */
	@Test
	void testComplexNumberComplexNumber() {

		assertEquals(4, copy.getReal(), 0.00001);
		assertEquals(3, copy.getImaginary(), 0.00001);

	}

	/**
	 * This method asserts that getReal getter seeing 5 as the zero objects real
	 * number parameter.
	 * 
	 * Test method for {@link cs145.Lab03.ComplexNumber#setReal(double)}.
	 */
	@Test
	void testSetReal() {

		zero.setReal(5);
		assertEquals(5, zero.getReal()); //
	}

	/**
	 * 
	 * This method asserts that setImaginary setter method sets 4.5 to the zero
	 * objects imaginary parameter
	 * 
	 * Test method for {@link cs145.Lab03.ComplexNumber#setImaginary(double)}.
	 */
	@Test
	void testSetImaginary() {

		zero.setImaginary(4.5);
		assertEquals(4.5, zero.getImaginary(), 0.00001);
	}

	/**
	 * 
	 * This method tests that the realNumber object gets 5 as its real number using
	 * getReal getter method
	 * 
	 * Test method for {@link cs145.Lab03.ComplexNumber#getReal()}
	 * 
	 */

	@Test
	void testGetReal() {

		assertEquals(5, realNumber.getReal(), 0.00001);
	}

	/**
	 * 
	 * This method asserts that the realAndImagine object gets 3 as its imaginary
	 * number using the getImaginary getter method
	 * 
	 * Test method for {@link cs145.Lab03.ComplexNumber#getImaginary()}
	 * 
	 */
	@Test
	void testGetImaginary() {

		assertEquals(3, realAndImagine.getImaginary(), 0.00001);

	}

	/**
	 * 
	 * This method asserts that the conjugate method returns the appropriately
	 * conjugated value
	 * 
	 */

	@Test
	void testConjugate() {

		assertEquals(-3, realAndImagine.conjugate().getImaginary(), 0.00001);
		assertEquals(5, realAndImagineTwo.conjugate().getImaginary(), 0.00001);

	}

	/**
	 * 
	 * This method tests that the string and signs are formatted and concatenated
	 * correctly
	 * 
	 */

	@Test
	void testToString() {
		assertEquals("4.000 + 3.000i", realAndImagine.toString());
		assertEquals("0.000-4.000i", negativeImagineBefore.toString());

	}

	/**
	 * 
	 * This tests the add method
	 * 
	 */

	@Test
	void testAdd() {

		ComplexNumber c1 = new ComplexNumber(0.5, 1.5);
		ComplexNumber c2 = new ComplexNumber(2, -4.5);
		ComplexNumber result = c1.add(c2);
		assertEquals(2.5, result.getReal(), 0.00001);
		assertEquals(-3, result.getImaginary(), 0.00001);
	}

	/**
	 * 
	 * This tests the subtract method
	 * 
	 */

	@Test
	void testSubtract() {

		ComplexNumber c1 = new ComplexNumber(0.5, 1.5);
		ComplexNumber c2 = new ComplexNumber(2.0, -4.5);
		ComplexNumber result = c1.subtract(c2);
		assertEquals(-1.5, result.getReal(), 0.00001);
		assertEquals(6, result.getImaginary(), 0.00001);

	}

	/**
	 * 
	 * This tests the multiply method
	 * 
	 */

	@Test
	void testMultiply() {

		ComplexNumber c1 = new ComplexNumber(0.5, 1.5);
		ComplexNumber c2 = new ComplexNumber(2.0, -4.5);
		ComplexNumber result = c1.multiply(c2);
		assertEquals(7.75, result.getReal(), 0.00001);
		assertEquals(0.75, result.getImaginary(), 0.00001);

	}

	/**
	 * 
	 * This tests the divide method
	 * 
	 */

	@Test
	void testDivide() {

		ComplexNumber c1 = new ComplexNumber(0.5, 1.5);
		ComplexNumber c2 = new ComplexNumber(2.0, -4.5);
		ComplexNumber result = c1.divide(c2);
		assertEquals(-0.237, result.getReal(), 0.001);
		assertEquals(0.216, result.getImaginary(), 0.001);

	}

}
