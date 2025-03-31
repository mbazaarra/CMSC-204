import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{
	
	private int size;
	private LinkedList<CourseDBElement>[] hashTable;
	
    // Constructor to initialize with estimated number of courses
    public CourseDBStructure(int n) {
        
    	int prime = (int) (n / 1.5);
        
    	while (((prime - 3) % 4 != 0) || !isPrime(prime)) {
        
    		prime++;
        }
        
    	this.size = prime;
        hashTable = new LinkedList[size];
    }

    // Constructor used for testing
    public CourseDBStructure(String string, int n) {
        this.size = n;
        hashTable = new LinkedList[size];
    }
	
	
	private boolean isPrime(int num) {
		
		if (num <= 1)
			return false;
		
		if (num == 2)
			return true;
		
		if (num % 2 == 0)
			return false;
		
		for(int i = 3 ; i * i <= num ; i+=2) {
			if (num % i == 0)
				return false;
		}
		
		return true;
	}	
	
    // Add a CourseDBElement to the hash table
    @Override
    public void add(CourseDBElement element) {
        int index = Math.abs(element.hashCode()) % size;

 
        if (hashTable[index] == null) {
            hashTable[index] = new LinkedList<>();
        }

        LinkedList<CourseDBElement> bucket = hashTable[index];


        for (CourseDBElement existing : bucket) {
            if (existing.equals(element)) {
                return; 
            }
            if (existing.getCRN() == element.getCRN()) {
                bucket.remove(existing);
                break;
            }
        }

        bucket.add(element);
    }
    // Retrieve a CourseDBElement by CRN
    @Override
    public CourseDBElement get(int crn) throws IOException {
        
    	CourseDBElement course = null;
        int hashIndex = Math.abs(Integer.toString(crn).hashCode()) % size;
        
        if (hashTable[hashIndex] != null) {
           
        	for (int i = 0; i < hashTable[hashIndex].size(); i++) {
                if (hashTable[hashIndex].get(i).getCRN() == crn) {
                   
                	course = hashTable[hashIndex].get(i);
                    break;
                }
            }
        }
        if (course != null)
            return course;
        else
            throw new IOException();
    }

    // Return list of all courses as strings
    @Override
    public ArrayList<String> showAll() {
        
    	ArrayList<String> courseList = new ArrayList<>();
        
    	for (int i = 0; i < this.size; i++) {
            if (hashTable[i] != null) {
                
            	for (int j = 0; j < hashTable[i].size(); j++) {
                    
            		courseList.add(hashTable[i].get(j).toString());
                }
            }
        }
        return courseList;
    }

    // Return hash table size
    @Override
    public int getTableSize() {
        return size;
    }
	
}
