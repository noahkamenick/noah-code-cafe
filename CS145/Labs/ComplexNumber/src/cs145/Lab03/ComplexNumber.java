package cs145.Lab03;

import java.lang.Math;
import java.text.DecimalFormat;

/**
 * 
 * A class of various methods that calculate complex numbers using basic
 * arithmetic.
 * 
 * @author Noah Kamenick
 * @version 2021.2.16
 *
 */

public class ComplexNumber {

	ComplexNumber conj;

	DecimalFormat fmt;

	private double real;

	private double imaginary;

	/**
	 * 
	 * A default constructor that sets both "real" and "imaginary" instance
	 * variables to zero.
	 * 
	 */

	public ComplexNumber() {

		real = 0;

		imaginary = 0;

	}

	/**
	 * 
	 * Method that takes double parameters and uses those to set and initialize
	 * respective instance variables
	 * 
	 * @param real      sets and initializes local variable (method parameter)
	 *                  "real" to instance variable "real".
	 * @param imaginary sets and initializes local variable (method parameter)
	 *                  "real" to instance variable "real"
	 */

	public ComplexNumber(double real, double imaginary) {

		this.real = real;

		this.imaginary = imaginary;

	}

	/**
	 * 
	 * Method that takes one double parameter and assigns that input to the instance
	 * variable named "real". Sets instance variable "imaginary" to zero.
	 * 
	 * @param real passes in a real number, which is then set to instance double
	 *             "real"
	 */

	public ComplexNumber(double real) {

		this.real = real;

		this.imaginary = 0;

	}

	/**
	 * 
	 * Copy Constructor that constructs a new "ComplexNumber" object by setting
	 * instance double (global) "real" to the parameter (local variable) "real".
	 * 
	 * 
	 * @param other is the inputted complex number object
	 */

	public ComplexNumber(ComplexNumber other) {

		this.real = other.real;

		this.imaginary = other.imaginary;

	}

	/**
	 * 
	 * Return a real number
	 * 
	 * @return a real number
	 */
	public double getReal() {
		return real;
	}

	/**
	 * 
	 * Set a real number
	 * 
	 * @param real sets global real to passed-in real
	 */
	public void setReal(double real) {
		this.real = real;
	}

	/**
	 * Return an imaginary number
	 * 
	 * @return an imaginary number
	 */
	public double getImaginary() {
		return imaginary;
	}

	/**
	 * 
	 * Set local imaginary to global imaginary
	 * 
	 * @param imaginary the imaginary to set
	 */
	public void setImaginary(double imaginary) {
		this.imaginary = imaginary;
	}

	/**
	 * 
	 * This method takes the conjugate of an inputted complex number
	 * 
	 * @return a conjugated imaginary number
	 */

	public ComplexNumber conjugate() {
		conj = new ComplexNumber(real, imaginary);

		if (imaginary < 0) {
			conj.imaginary = Math.abs(imaginary); // Calculates the conjugate of a negative imaginary
		}

		if (imaginary > 0) {

			conj.imaginary = 0 - imaginary; // Calculates the conjugate of a positive imaginary

		}

		return conj; // is this returning an object or returning the value of an object's field?
	}

	/**
	 * 
	 * 
	 * Converts and formats real and imaginary numbers into complex numbers
	 * 
	 * @return formatted complex number expression
	 */

	public String toString() {
		fmt = new DecimalFormat("#0.000");

		String sign = new String();

		if (imaginary > 0) {

			sign = " + "; // Logic for proper sign formatting in expression

		}

		return fmt.format(real) + sign + fmt.format(imaginary) + "i"; // Return formatted complex number expression
	}

	/**
	 * 
	 * This is a method to add two complex numbers together
	 * 
	 * @param other
	 * @return the sum of the complex numbers
	 */

	public ComplexNumber add(ComplexNumber other) {

		ComplexNumber result = new ComplexNumber();

		result.setReal(real + other.getReal());

		result.setImaginary(imaginary + other.imaginary);

		return result;

	}

	/**
	 * 
	 * This is a method to subtract two complex numbers
	 * 
	 * @param other is another complex number object
	 * @return is the difference of the two complex numbers
	 */

	public ComplexNumber subtract(ComplexNumber other) {

		ComplexNumber subtractResult = new ComplexNumber();

		subtractResult.setReal(real - other.getReal());

		subtractResult.setImaginary(imaginary - other.getImaginary());

		return subtractResult;

	}

	/**
	 * 
	 * 
	 * This is a method to multiply two complex numbers
	 * 
	 * @param other is another complex number object
	 * @return is the product of the two complex numbers
	 */

	public ComplexNumber multiply(ComplexNumber other) {

		ComplexNumber multiplyResult = new ComplexNumber();

		multiplyResult.setReal((real * other.real) - (imaginary * other.imaginary));

		multiplyResult.setImaginary((real * other.imaginary) + (imaginary * other.real));

		return multiplyResult;
	}

	/**
	 * 
	 * This is a method to divide two complex numbers
	 * 
	 * @param other is another complex number object
	 * @return is the quotient of the two complex numbers
	 */

	public ComplexNumber divide(ComplexNumber other) {

		ComplexNumber divideResult = new ComplexNumber();

		divideResult.setReal(((real * other.real) + (imaginary * other.imaginary))
				/ (((other.real) * (other.real)) + ((other.imaginary) * (other.imaginary))));

		divideResult.setImaginary((imaginary * other.real - (real * other.imaginary))
				/ ((other.real) * (other.real) + ((other.imaginary) * (other.imaginary))));

		return divideResult;
	}

}
