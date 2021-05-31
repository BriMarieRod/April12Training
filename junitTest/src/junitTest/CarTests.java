package junitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTests {
	
	@Test
	void CanSetGetNumberOfSeats() {
		Car testCar = new Car();
		testCar.setNumberOfSeats(4);
		assertEquals(4, testCar.getNumberOfSeats());
	}
	
	@Test
	void CanSetGetNumberOfSeatsOfElectricCar() {
		Car testCar = new ElectricCar();
		testCar.setNumberOfSeats(2);
		assertEquals(2, testCar.getNumberOfSeats());
	}

	@Test
	void CanComputeEconomyImperial() {
		assertEquals((float)31.2, Car.ComputeEconomy((short)312, (short)10));
	}
	
	@Test
	void CanComputeEconomyMetric() {
		assertEquals((float)13.210526, Car.ComputeEconomy(502, 38));
	}

}
