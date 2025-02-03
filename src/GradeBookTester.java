import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {
	
	private GradeBook test1;
	private GradeBook test2;

	
	/** 3.	In the setUp method of GradebookTester, 
	 * create at least two objects of Gradebook of size 5.  
	 * Call the addScore method for each of the Gradebook classes 
	 * at least twice (but no more than 5 times).
	 */
	@BeforeEach
	void setUp() throws Exception {
		test1 = new GradeBook(5);
		test2 = new GradeBook(5);
		
		test1.addScore(88.5);
		test1.addScore(70.0);
		test1.addScore(92.9);
		
		test2.addScore(87.4);
		test2.addScore(100.0);
		test2.addScore(76.8);
	}

	@AfterEach
	void tearDown() throws Exception {
		
		test1 = null;
		test2 = null;

	}
	
	@Test
	void addScoreTest() {
		// for test1
		assertTrue( test1.toString().equals("88.5 70.0 92.9"));
		assertEquals(3, test1.getscoreSize());

		// for test2 
		assertTrue( test2.toString().equals("87.4 100.0 76.8"));
		assertEquals(3, test2.getscoreSize());
	}

	@Test
	void testSum() {
		assertEquals(251.4 , test1.sum(), 0.0001);
		assertEquals(264.2 , test2.sum(), 0.0001);

	}
	
	@Test
	void testMinumum() {
		assertEquals(70.0 , test1.minimum());
		assertEquals(76.8 , test2.minimum());

	}
	
	@Test
	void finalScoreTest() {
		assertEquals(181.4 , test1.finalScore(), 0.0001);
		assertEquals(187.4 , test2.finalScore(), 0.0001);

	}
	
	

}
