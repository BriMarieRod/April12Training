// use what you've learned about Checked/Unchecked Exceptions to make this test pass

package junitTests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class ExceptionsTests {
	// As a SDET
	// I want to ensure that FileReader will throw an Exception when the file does not exist
	// So that we consumers of FileReader can handle the Exception
	@Test()
	void ensureFileReaderThrowsExceptionWhenFileDoesNotExist() {
		Throwable thrownException = null;
		
		try {
			int fileSize = GetFileSize("nonExistentFile.txt");
		}
		catch(IOException ex) {
			thrownException = ex;
		}
		
		assertTrue(thrownException instanceof IOException, "IOException exception should be thrown because the file does not exist.");
	}

	public int GetFileSize(String filePath) throws IOException {
		FileReader reader = new FileReader(filePath);
		
		int charNumber = 0;
		
		while(charNumber != -1) {
			charNumber = reader.read();
		}
		
		reader.close();
		
		return charNumber;
	}
}
