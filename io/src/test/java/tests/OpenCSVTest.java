package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileReader;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;

public class OpenCSVTest {
	
  @Test
  public void canCreateHashMapFromCSV() {
	  
	  String fileLocation = "C:\\Users\\brian\\git\\April12Training\\io\\src\\main\\resources\\basses.csv";
	  
	  HashMap<String, String> actualHashMap = new HashMap<String, String>();
	  
	  try {
		  
		  FileReader fileReader = new FileReader(fileLocation);
		  CSVReader csvReader = new CSVReader(fileReader);
		  
		  String[] row = csvReader.readNext();
		  
		  while((row = csvReader.readNext()) != null) {
			  actualHashMap.put(row[1], row[0]);
		  }
		  
		  csvReader.close();
	  
	  } catch(Exception e) {
		  
		  System.out.println(e.toString());
		  
	  }
	  
	  HashMap<String, String> expectedHashMap = new HashMap<String, String>();
	  
	  expectedHashMap.put("Corvette", "Warwick");
	  expectedHashMap.put("Thumb", "Warwick");
	  expectedHashMap.put("Streamer", "Warwick");
	  expectedHashMap.put("Precision", "Fender");
	  expectedHashMap.put("Jazz", "Fender");
	  expectedHashMap.put("BB500", "Yamaha");
	  
	  boolean hashMapsAreEqual = expectedHashMap.equals(actualHashMap);
	  
	  assertTrue(hashMapsAreEqual);
	  
  }
  
}
