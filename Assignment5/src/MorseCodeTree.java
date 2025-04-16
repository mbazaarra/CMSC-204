/*
 * Montana Bazarragchaa
 * 
 * CMSC 204
 */

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	
	private TreeNode<String> root;
	
	public MorseCodeTree(){
		buildTree();
	}
	
	
	
	public void buildTree() {
		this.root = new TreeNode<>(""); 
		
		insert(".", "e");
		insert("-", "t");
		
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-.-.", "c");
		insert("-..-", "x");
		insert("-.--", "y");
		insert("--.-", "q");
		insert("--..", "z");
	}
	
	@Override
	public void insert(String code, String letter) {
		
		addNode(this.root, code, letter);
		
	}
	
	
	@Override
	public void setRoot(TreeNode<String> newNode) {
		this.root = newNode;
	}
	
	
	@Override
	public TreeNode<String> getRoot() {
		return this.root;
	}
	
	@Override
	public String fetch(String code) {
		return fetchNode(this.root, code);
	}
	
	/*
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		// TODO Auto-generated method stub
		
		int subStringIndex = 1;
		String letterAtNode = "";
		
		// Base Case
		if (code.length() == 1) {
			
			if (code.charAt(0) == '.' && root != null && root.getLeft() != null) {
				
				letterAtNode = root.getLeft().getData();
				
				return letterAtNode;
			}else if (code.charAt(0) == '-' && root != null &&root.getRight() != null) {
				
				letterAtNode = root.getRight().getData();
				
				return letterAtNode;
			}
		}
		
		if (code.length() != 0) {
			
			if (code.charAt(0) == '.') {
				
				if (root != null) {
					
					root = root.getLeft();
				}
				
				letterAtNode = fetchNode(root, code.substring(subStringIndex));
			
			
			}else if (code.charAt(0) == '-') {
				
				if (root != null) {
					
					root = root.getRight();
				}
				
				letterAtNode = fetchNode(root, code.substring(subStringIndex));
			}
			
		}
		
		return letterAtNode;
	}
	
	/**
	 * Adds a letter to the Morse code tree based on the provided code.
	 * Dots ('.') go left and dashes ('-') go right from the current root.
	 *
	 * @param root   the current root node in the tree
	 * @param code   the Morse code string (e.g., ".-" for 'a')
	 * @param letter the letter to insert at the correct position
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter){
		
		if (code.length()==1) {
			
			if (code.equals(".")) {
				
				root.setLeft(new TreeNode<>(letter));
			
			}else if (code.equals("-")) {
	            
				root.setRight(new TreeNode<>(letter));
	        }
		}else {
			
			if (code.charAt(0)=='.') {
				root = root.getLeft(); 
			}
			else if (code.charAt(0)=='-') {
				root = root.getRight();
			}
			
			code = code.substring(1);
			
			addNode(root, code, letter);
		}
	}
	
	/*
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		
		throw new UnsupportedOperationException();
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		
		throw new UnsupportedOperationException();
	}
	
	@Override
	public ArrayList<String> toArrayList(){
	    ArrayList<String> list = new ArrayList<>();
	    LNRoutputTraversal(root, list);
	    return list;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
	    if (root == null) return;

	    LNRoutputTraversal(root.getLeft(), list); 
	    list.add(root.getData());
	    LNRoutputTraversal(root.getRight(), list);
	}



}
