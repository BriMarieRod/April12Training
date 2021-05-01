package junitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTests {

	@Test
	void CanComputeEconomyImperial() {
		assertEquals(31.2, Car.ComputeEconomy((short)312, (short)10));
	}
	
	@Test
	void CanComputeEconomyMetric() {
		assertEquals(13.210526, Car.ComputeEconomy(502, 38));
	}

}