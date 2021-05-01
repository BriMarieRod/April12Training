package junitTest;

public class Car {
	
	private int NumberOfSeats;

	int getNumberOfSeats() {
		return NumberOfSeats;
	}

	void setNumberOfSeats(int numberOfSeats) {
		NumberOfSeats = numberOfSeats;
	}

	static float ComputeEconomy(short milesDriven, short gallonsConsumed) {
		return milesDriven / gallonsConsumed;
	}
	
	static float ComputeEconomy(int kilometersDriven, int litersConsumed) {
		return kilometersDriven / litersConsumed;
	}
	
}
