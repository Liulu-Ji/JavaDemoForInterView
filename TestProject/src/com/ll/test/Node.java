package com.ll.test;


public class Node{
		public String data;
		public Node left;
		public Node right;
		
		public Node(String data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
	}
