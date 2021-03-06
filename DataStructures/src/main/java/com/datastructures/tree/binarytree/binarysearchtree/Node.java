package com.datastructures.tree.binarytree.binarysearchtree;

public class Node {
	private int data;
	private Node leftNode;
	private Node rightNode;

	public Node(int data) {
		this.data = data;
		leftNode = null;
		rightNode = null;
	}

	public Node() {
		leftNode = null;
		rightNode = null;
	}

	// Getters and Setters
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}

	public Node find(int data) {

		if (data == this.data) {
			return this;
		}

		if (data < this.data) {
			if (leftNode == null) {
				return null;
			} else {
				return leftNode.find(data);
			}
		} else {
			if (rightNode == null) {
				return null;
			} else {
				return rightNode.find(data);
			}
		}
	}

	// Insert data - implementation using recursion
	public void insertData(int data) {

		if (data < this.data) {
			// if left node is null, add it there otherwise add the data recursively
			if (leftNode == null) {
				leftNode = new Node(data);
			} else {
				leftNode.insertData(data);
			}
		} else {
			// if right node is null, add it there otherwise add the data recursively
			if (rightNode == null) {
				rightNode = new Node(data);
			} else {
				rightNode.insertData(data);
			}
		}

	}
	
	// Count Number of Leaves - Raghavendra Dixit (Udemy) method
	public long numLeaves() {
		// If current instance of node in this recursion is leaf node, return 1
		if (isLeaf()) return 1;
		long numLeftLeaves = 0;
		long numRightLeaves = 0;
		
		if (this.leftNode != null) {
			numLeftLeaves = leftNode.numLeaves();
		}
		if (this.rightNode != null) {
			numRightLeaves = rightNode.numLeaves();
		}
		return numLeftLeaves + numRightLeaves;
	}
	
	private boolean isLeaf() {
		return this.leftNode == null && this.rightNode == null;
	}
	
	// Height of binary sort tree
	public int height() {
		if (isLeaf()) return 1;
		int left = 0;
		int right = 0;
		if (this.leftNode != null)
			left = this.leftNode.height();
		if (this.rightNode != null)
			right = this.rightNode.height();
		return (left > right) ? (left + 1) : (right + 1);
	}
	
	// Create binary sort tree with a sorted array
	public static Node addSorted(int[] data, int start, int end) {
		if (end >= start) {
			int mid = (start+end)/2;
			Node newNode = new Node(data[mid]);
			newNode.leftNode = addSorted(data, start, mid-1);
			newNode.rightNode = addSorted(data, mid+1, end);
			return newNode;
		}
		return null;
	}

}
