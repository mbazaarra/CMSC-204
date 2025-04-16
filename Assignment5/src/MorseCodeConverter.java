/*
 * Montana Bazarragchaa
 * 
 * CMSC 204
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
	
	private static MorseCodeTree tree = new MorseCodeTree();
	
	//constructor
	public MorseCodeConverter() {
	}
	
	
	/**
	 * This method prints the letters in the tree according the LNR traversal order
	 * @return an arrayList of the LNR order
	 */
	public static String printTree(){
		ArrayList<String> list = tree.toArrayList();
		String traversal = "";
		
        for (String s : list) {
        	traversal = traversal + s + " ";
        }
		
		return traversal.substring(0, traversal.length()-1);
	}
	
	/**
	 * Converts Morse code into English
	 * Each letter is delimited by a space (' ')
	 * Each word is delimited by a  '/'
	 * 
	 * @param code the morse code
	 * @return the English translation
	 */
	public static String convertToEnglish(String code) {
		
		String returnString = "";		
		String[] wordArray = code.split("/");
		
		for (int i = 0; i < wordArray.length; i++) {
			
			String[] letterArray = wordArray[i].split(" ");
			
			for (int j = 0; j < letterArray.length; j++){
				
				returnString += tree.fetchNode(tree.getRoot(), letterArray[j]);
			}
			
			if ((wordArray.length - 1) != i){
				
				returnString += " ";
			}
		}
		
		return returnString;
	}
	
	
	/**
	 * Convert a string in morse code read from a file to English
	 * @param file the file to read from
	 * @return the converted English text
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File file) throws FileNotFoundException{
		
		String code = "";
		
		try (Scanner inputFile = new Scanner(file)){
		
			while(inputFile.hasNext()){
				 code = code + inputFile.next() + " ";
			}
			
		}catch (FileNotFoundException e){
			e.printStackTrace();
		} 

		return convertToEnglish(code);
	}
	
	
}
