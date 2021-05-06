// use what you've learned about Checked/Unchecked Exceptions to make this test pass

package junitTests;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class ExceptionsTests2 {
	// As a SDET
	// I want to ensure that dividing by zero will not throw an Exception 
	// So that we consumers can use this method without failures occurring
	@Test()
	void ensureDivideByZeroThrowsNoExceptions() {
		Throwable thrownException = null;

		int number = 10;
		int zero = 0;
		
		try {
			int quotient = Divide(number, zero);
		}
		catch(Throwable ex) {
			thrownException = ex;
		}
		
		assertFalse(thrownException instanceof ArithmeticException, "ArithmeticException should not be thrown because it should be handled in the Divide method.");
	}

	public int Divide(int dividend, int divisor) {
		int result = 0;
		
		if(divisor != 0)
			result = dividend/divisor;
		
		return result;
	}
}
