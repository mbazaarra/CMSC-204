import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
class CourseDBManager_STUDENT_Test {

	ArrayList<String> testList = new ArrayList<String>();
	CourseDBStructure structure;
	CourseDBElement courseOne;
	CourseDBElement courseTwo;
	CourseDBElement courseThree;
	CourseDBElement courseFour;

	@BeforeEach
	void setUp() throws Exception {
		structure = new CourseDBStructure(12);
		courseOne = new CourseDBElement("ENGL102", 30454, 3, "CS201", "Mesfin Hailegebriel"); 
        courseTwo = new CourseDBElement("CMSC141", 31278, 1, "DL WEB", "Ashish Shah"); 
        courseThree = new CourseDBElement("CMSC204", 31645, 4, "DL WEB", "Huseyin Aygun"); 	 
		courseFour = new CourseDBElement("CMSC207", 32717, 4, "DL WEB", "Koorosh Azhandeh"); 
	}

	@AfterEach
	void tearDown() throws Exception {
		structure = null;
		courseOne = null;
		courseTwo = null;
		courseThree = null;
		courseFour = null;
	}

	@Test
	public void testCompareTo() {
		assertTrue(courseOne.compareTo(courseTwo) < 0);
		assertTrue(courseTwo.compareTo(courseThree) < 0);
		assertTrue(courseThree.compareTo(courseFour) < 0);
		assertNotEquals(0, courseOne.compareTo(courseFour));
	}

	@Test
	public void testAdd() {
		structure.add(courseOne);
		assertTrue(structure.showAll().contains(courseOne.toString()));
		structure.add(courseOne);
		assertTrue(structure.showAll().contains(courseOne.toString()));
		structure.add(courseTwo);
		assertTrue(structure.showAll().contains(courseTwo.toString()));
		structure.add(courseThree);
		assertTrue(structure.showAll().contains(courseThree.toString()));
		structure.add(courseFour);
		assertTrue(structure.showAll().contains(courseFour.toString()));
	}

	@Test
	public void testGetCRN() {
		structure.add(courseOne);
		structure.add(courseTwo);
		structure.add(courseThree);
		structure.add(courseFour);

		try {
			assertEquals(courseOne, structure.get(30454));
			assertEquals(courseTwo, structure.get(31278));
			assertEquals(courseThree, structure.get(31645));
			assertEquals(courseFour, structure.get(32717));
		} catch (IOException e) {
			fail("Should not throw IOException");
		}
	}

	@Test
	public void testShowAll() {
		structure.add(courseOne);
		structure.add(courseTwo);
		structure.add(courseThree);

		ArrayList<String> courses = structure.showAll();

		assertTrue(courses.contains(courseOne.toString()));
		assertTrue(courses.contains(courseTwo.toString()));
		assertTrue(courses.contains(courseThree.toString()));
	}

}
