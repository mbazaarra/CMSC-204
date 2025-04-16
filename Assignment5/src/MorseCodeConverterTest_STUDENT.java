import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;

class MorseCodeConverterTest_STUDENT {

	@BeforeEach
	public void setUp() throws Exception {
	}


	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testConvertToEnglishString() {
		assertEquals("montana bazarragchaa", MorseCodeConverter.convertToEnglish("-- --- -. - .- -. .- / -... .- --.. .- .-. .-. .- --. -.-. .... .- .-"));
		assertEquals("computer science", MorseCodeConverter.convertToEnglish("-.-. --- -- .--. ..- - . .-. / ... -.-. .. . -. -.-. ."));
		assertEquals("discrete math", MorseCodeConverter.convertToEnglish("-.. .. ... -.-. .-. . - . / -- .- - ...."));
	}
	
	@Test
	public void testConvertToEnglishFile() {
		File file = new File("src/DaisyDaisy.txt");
		try {
			assertEquals("im half crazy all for the love of you", MorseCodeConverter.convertToEnglish(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		file = new File("src/Daisy.txt");
		try {
			assertEquals("give me your answer do", MorseCodeConverter.convertToEnglish(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		file = new File("src/LoveLooksNot.txt");
		try {
			assertTrue(MorseCodeConverter.convertToEnglish(file)
					.equalsIgnoreCase("LOVE LOOKS NOT WITH THE EYES BUT WITH THE MIND"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
