package utils;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class FileReaderTest {
	
	@Test
    public void testFileReader() {
	
		assertEquals(FileReader.readFile("test.txt"), "content");
		
    }
	

}
