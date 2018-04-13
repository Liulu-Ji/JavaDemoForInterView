package com.ll.test;

public class Tree {
	
	public static void main(String[] args){
		String pre = "ABCDEFGHK";
		String mid = "BDCAEHGKF";
		Node n  = returnToTree(pre,mid);
		System.out.print("先序遍历是");
		preOrder(n);
		System.out.println(" ");
		System.out.print("中序遍历是");
		midOrder(n);
		System.out.println(" ");
		System.out.print("后序遍历是");
		lastOrder(n);
		System.out.println(" ");
		
	}
	
	/**
	 * 根据二叉树还原树结构
	 * @param pre 前序遍历
	 * @param mid 中序遍历 
	 * @return
	 */
	public static Node returnToTree(String pre,String mid){
		if(pre.length() == 0 || mid.length() == 0){
			return null;
		}
		int rootPosInPre = 0;
		Node root = genNode(pre,mid,rootPosInPre);
		return root;
	}
	
	
	public static Node genNode(String pre,String mid,int rootPosInPre){
		if(pre.length() == 0 || mid.length() == 0){
			return null;
		}
		String data = String.valueOf(pre.charAt(rootPosInPre));
		int posInMid = mid.indexOf(data);
		String leftMid = mid.substring(0,posInMid);
		String rightMid = mid.substring(posInMid+1);
		String leftPre = pre.substring(rootPosInPre+1, rootPosInPre+1+leftMid.length());
		String rightPre = pre.substring(rootPosInPre+1+leftPre.length());
		Node result = new Node(data);
		result.left = returnToTree(leftPre,leftMid);
		result.right = returnToTree(rightPre,rightMid);
		return result;
	}
	
	/**
	 * 后序遍历  
	 * @param n 根节点
	 */
	public static void lastOrder(Node n){
		if(n==null){
			return;
		}
		lastOrder(n.left);
		lastOrder(n.right);
		System.out.print(n.data);
	}
	/**
	 * 前序遍历  
	 * @param n 根节点
	 */
	public static void preOrder(Node n){
		if(n==null){
			return;
		}
		System.out.print(n.data);
		preOrder(n.left);
		preOrder(n.right);
	}
	/**
	 * 中序遍历
	 * @param n 根节点
	 */
	public static void midOrder(Node n){
		if(n==null){
			return;
		}
		preOrder(n.left);
		System.out.print(n.data);
		preOrder(n.right);
	}
	
	public static void listElement(){
		
	}
	
	
	
}
