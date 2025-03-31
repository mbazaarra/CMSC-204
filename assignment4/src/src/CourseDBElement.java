
public class CourseDBElement implements Comparable<CourseDBElement> {
    private String courseID;
    private int crn;
    private int credits;
    private String room;
    private String instructor;

    public CourseDBElement() {
    	
    }
	/**
	 * @param courseID - the course ID
	 * @param lectureRoomNum - the lecture room number
	 * @param professorName - the name of the Professor
	 * @param courseCRN - CRN of the course
	 * @param numOfCredits - the number of credits for the course
	 */
    public CourseDBElement(String courseID, int crn, int credits, String room, String instructor) {
        this.courseID = courseID;
        this.crn = crn;
        this.credits = credits;
        this.room = room;
        this.instructor = instructor;
    }
    
	/**
	 * 
	 * @param courseID set course Id
	 */
	public void setID(String courseID) {
		
		this.courseID = courseID;
	}
	
	/**
	 * 
	 * @param lectureRoomNum set lecture room number
	 */
	public void setRoomNum(String lectureRoomNum) {
		
		this.room = lectureRoomNum;
	}
	
	/**
	 * 
	 * @param professorName set the Professor name
	 */
	public void setInstructor(String professorName) {
		
		this.instructor = professorName;
	}
	
	/**
	 * 
	 * @param courseCRN set the CRN
	 */
	public void setCRN(int courseCRN) {
		
		this.crn = courseCRN;
	}
	
	/**
	 * 
	 * @param numOfCredits set the number of credits
	 */
	public void setCredits (int numOfCredits) {
		
		this.credits = numOfCredits;
	}
	
	/**
	 * ACCESSORS/GETTERS
	 */
	
	/**
	 * 
	 * @return the Id
	 */
	public String getID() {
		
		return courseID;
	}
	
	/**
	 * 
	 * @return the room number
	 */
	public String getRoomNum() {
		
		return room;
	}
	
	/**
	 * 
	 * @return the instructor
	 */
	public String getInstructor() {
		
		return instructor;
	}
	
	/**
	 * 
	 * @return the CRN
	 */
	public int getCRN() {
		
		return crn;
	}
	
	/**
	 * 
	 * @return the number of credits
	 */
	public int getCredits() {
		
		return credits;
	}
    
	@Override
	public int compareTo(CourseDBElement o) {
		// TODO Auto-generated method stub		
		CourseDBElement tempElement = (CourseDBElement) o;
		int returnValue = 0;		
		
		if (o == null) {			
			
			throw new NullPointerException();
		}else {

			if (crn == tempElement.getCRN()) {
				
				returnValue = 0;
			
			}else if (crn > tempElement.getCRN()) {
				
				returnValue = 1;
			
			}else if (crn < tempElement.getCRN()) {
				
				returnValue = -1;
			}
			
		}
		
		return returnValue;
	}
    @Override
    public int hashCode() {
        return String.valueOf(crn).hashCode();
    }
    
    @Override
    public String toString() {
        return "\nCourse:" + courseID + " CRN:" + crn + " Credits:" + credits + " Instructor:" + instructor + " Room:" + room;
    }
}
