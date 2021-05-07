// use what you know about collections to complete the following tests
package junitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class arrayTests {

	// As a SDET 
	// I want to create a native string array 
	// With the elements "Cessna"; "Piper"; "Beechcraft"; and "Cessna"
	// And print (System.out.println) each item in the collection using a For loop 
	@Test
	void canIterateNativeArray() {
		String[] airplaneMakes = { "Cessna", "Piper", "Beechcraft", "Cessna" };
		
		for(String s : airplaneMakes) {
			System.out.println(s);
		}

		assertEquals(4, airplaneMakes.length, "the array should have 4 items.");
	}

	// As a SDET 
	// I want to create a ArrayList
	// With the elements "Cessna"; "Piper"; "Beechcraft"; and "Cessna"
	// And print (System.out.println) each item in the collection using a For loop 
	@Test
	void canIterateList() {
		ArrayList<String> airplaneMakes = new ArrayList<>();
		airplaneMakes.add("Cessna");
		airplaneMakes.add("Piper");
		airplaneMakes.add("Beechcraft");
		airplaneMakes.add("Cessna");
		
		for(String s : airplaneMakes) {
			System.out.println(s);
		}
		
		assertEquals(4, airplaneMakes.size(), "the list should have 4 items.");
	}

	// As a SDET 
	// I want to create a HashSet
	// With the elements "Cessna"; "Piper"; "Beechcraft"; and "Cessna"
	// And print (System.out.println) each item in the collection using a For loop 
	@Test
	void canIterateSet() {
		HashSet<String> airplaneMakes = new HashSet<>();
		airplaneMakes.add("Cessna");
		airplaneMakes.add("Piper");
		airplaneMakes.add("Beechcraft");
		airplaneMakes.add("Cessna");
		
		for(String s : airplaneMakes) {
			System.out.println(s);
		}
		
		assertEquals(3, airplaneMakes.size(), "the set should have 3 items.");
	}

	// As a SDET 
	// I want to create a HashMap
	// With the elements "Cessna","150; "Piper","PA28"; "Beechcraft","G50"; and "Cessna","150"
	// And print (System.out.println) each item in the collection using a For loop 
	@Test
	void canIterateMap() {
		HashMap<String, String> airplaneModelsByMake = new HashMap<>();
		airplaneModelsByMake.put("Cessna", "150");
		airplaneModelsByMake.put("Piper", "PA28");
		airplaneModelsByMake.put("Beechcraft", "G50");
		airplaneModelsByMake.put("Cessna", "150");
		
		for(String key : airplaneModelsByMake.keySet()) {
			System.out.println(key + ", " + airplaneModelsByMake.get(key));
		}
		
		assertEquals(3, airplaneModelsByMake.size(), "the map should have 3 items.");
	}
}
