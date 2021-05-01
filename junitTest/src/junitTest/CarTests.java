package junitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTests {

	@Test
	void CanComputeEconomyImperial() {
		assertEquals(31.2, Car.ComputeEconomy((short)312, (short)10));
	}

}
