import java.io.*;
import java.util.*;

public class CourseDBManager implements CourseDBManagerInterface{

	private CourseDBStructure data;

	
	// Initialize manager with default table size
    public CourseDBManager() {
    	
    	data = new CourseDBStructure(100);
    }

    // Add course data to structure
    @Override
    public void add(String id, int crn, int credits, String roomNum, String instructor) {
        
    	CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
        data.add(element);
    }

    // Get course by CRN
    @Override
    public CourseDBElement get(int crn) {
        
    	try {
           
    		return data.get(crn);
        } catch (IOException e) {
            
        	return null;
        }
    }

    // Read course data from file
	@Override
	public void readFile(File input) throws FileNotFoundException {

		try (Scanner inputFile = new Scanner(input)) {
			
			while (inputFile.hasNextLine()) {
				
				String courseDesc = inputFile.nextLine();
				
				// use the split function to tokenize the string
				String[] courseElements = courseDesc.split(" ");
				
				CourseDBElement course = new CourseDBElement
						(courseElements[0], 
						Integer.parseInt(courseElements[1]), 
						Integer.parseInt(courseElements[2]), 
						courseElements[3], 
						courseElements[4]);
				
				data.add(course);
				
			}
		}
		
		catch (IOException e) {
			e.getMessage();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

    // Show all course data as strings
    @Override
    public ArrayList<String> showAll() {
        return data.showAll();
    }
}


