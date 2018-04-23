package com.ll.test;

import java.util.ArrayDeque;
import java.util.LinkedList;
/**
 * 二叉树的一些方法
 * @author N-LiuLu
 *
 */
public class Tree {
	
	//private static final BY_
	
	
	public static void main(String[] args){
		String pre = "ABDC";
		String mid = "DBAC";
		Node n  = returnToTree(pre,mid);
		/*System.out.print("先序遍历是");
		preOrder(n);
		System.out.println(" ");
		System.out.print("中序遍历是");
		midOrder(n);
		System.out.println(" ");
		System.out.print("后序遍历是");
		lastOrder(n);
		System.out.println(" ");
		listElement(n);*/
		//listElementDeep(n);
		System.out.println(isAVL(n));
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
		Node root = genNode(pre,mid);
		return root;
	}
	
	
	public static Node genNode(String pre,String mid){
		if(pre.length() == 0 || mid.length() == 0){
			return null;
		}
		int rootPosInPre = 0;
		String data = String.valueOf(pre.charAt(rootPosInPre));
		int posInMid = mid.indexOf(data);
		String leftMid = mid.substring(0,posInMid);
		String rightMid = mid.substring(posInMid+1);
		String leftPre = pre.substring(rootPosInPre+1, rootPosInPre+1+leftMid.length());
		String rightPre = pre.substring(rootPosInPre+1+leftPre.length());
		Node result = new Node(data);
		result.left = genNode(leftPre,leftMid);
		result.right = genNode(rightPre,rightMid);
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
		midOrder(n.left);
		System.out.print(n.data);
		midOrder(n.right);
	}
	/**
	 * 广度优先遍历   利用了先进先出的原理
	 * @param n
	 */
	public static void listElement(Node n){
		if(n == null){
			return ;
		}
		System.out.print("按照每层的顺序遍历一棵树");
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(n);
		Node current = n;
		while(current != null){
			Node temp = list.poll();
			System.out.print(temp.data);
			if(current.left !=null){
				list.add(current.left);
			}
			
			if(current.right !=null){
				list.add(current.right);
			}
			
			if(list.size()>0){
				current = list.getFirst();
			}else{
				current = null;
			}
		}
		System.out.println("  ");
	}
	
	/**
	 * 深度优先策略遍历   栈的先进后出
	 * @param n
	 */
	public static void listElementDeep(Node n){
		if(n == null){
			return ;
		}
		System.out.print("按照从左至右深度优先的方式遍历一棵树");
		 ArrayDeque<Node> stack = new  ArrayDeque<Node>();
		stack.push(n);
		
		while(!stack.isEmpty()){
			Node curr = stack.getFirst();
			System.out.print(stack.pop().data);
			if(curr.right!=null){
				stack.push(curr.right);
			}
			if(curr.left!=null){
				stack.push(curr.left);
			}
			
		}
	}
	
	/**
	 * 判断是不是平衡二叉树（所有节点的左右子树都是一棵平衡二叉树，且左右子数的高度差不大于1）
	 * 为了减少每个节点被遍历的次数，采用后序遍历的思想，先计算左右子树的深度，在计算根节点的深度
	 */
	public static boolean isAVL(Node n){
		if(getDepthForIsAVL(n) == -1){
			return false;
		}else{
			return true;
		}
	}
	//-1表示不是平衡二叉树
	public static int getDepthForIsAVL(Node n){
		if(n == null){
			return 0;
		}
		int left = getDepthForIsAVL(n.getLeft());
		int right = getDepthForIsAVL(n.getRight());
		
		if(left == -1){
			return -1;
		}
		
		if(right == -1){
			return -1;
		}
		
		if(Math.abs(left-right)>1){
			return -1;
		}
		//return Math.max(left, right)+1;
		return left>right?left+1:right+1;
	}
	
}
