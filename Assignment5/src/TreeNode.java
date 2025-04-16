/*
 * Montana Bazarragchaa
 * 
 * CMSC 204
 */

public class TreeNode<T> {
	private T data;
	private TreeNode<T> left;
	private TreeNode<T> right;
	
	public TreeNode(T dataNode){
		this.data = dataNode;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode(TreeNode<T> node){
		this.data = node.data;
		this.left = new TreeNode<T>(node.left);
		this.right = new TreeNode<T>(node.right);
	}
	
	public T getData(){
		return data;
	}
	
	//setters
	public void setLeft(TreeNode<T> node) {
		this.left = node;
	}
	
	public void setRight(TreeNode<T> node) {
		this.right = node;
	}

	
	//getters
	public TreeNode<T> getLeft() {
		return this.left;
	}		

	public TreeNode<T> getRight() {
		return this.right;
	}
	
	
	
}
