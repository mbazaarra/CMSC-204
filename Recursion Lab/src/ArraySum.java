/*
 * CMSC 204
 * 
 * Montana Bazarragchaa
 * 
 */

public class ArraySum {
	
	public ArraySum(){
		
	}
	
	public int sumOfArray(Integer[] a,int index) {
		
		
		int sum = 0;
		
		if (index == 0) {
			return a[index]; //base case
		}

		sum = a[index] + sumOfArray( a, index - 1); //calculates the sum 

		return sum;
		
	
	}

}

