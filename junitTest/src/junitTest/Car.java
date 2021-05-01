package junitTest;

public class Car {

	static float ComputeEconomy(short milesDriven, short gallonsConsumed) {
		return milesDriven / gallonsConsumed;
	}
	
	static float ComputeEconomy(int kilometersDriven, int litersConsumed) {
		return kilometersDriven / litersConsumed;
	}
	
}
