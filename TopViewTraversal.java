package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

//import Trees.VerticalOrderTraversal.Node;

public class TopViewTraversal {
	
	static class Node
	{
		int data;
		Node left,right;
		
		Node(int data)
		{
			this.data=data;
			left=right=null;
		}
	}
	
	static Node root;
	
	static class Qobj
	{
		int hd;
		Node node;
		
		Qobj(int hd,Node node)
		{
			this.hd=hd;
			this.node=node;	
		}
	}
	
	static void topView(Node root)
	{
		if(root==null)
			return;
		
		TreeMap<Integer,ArrayList<Integer>>map=new TreeMap<>();
		
		Queue<Qobj>queue=new LinkedList<>();
		
		queue.add(new Qobj(0,root));
		int hd=0;
		
		while(!queue.isEmpty())
		{
			Qobj temp=queue.poll();
			
			hd=temp.hd;
			Node node=temp.node;
			
			if(map.containsKey(hd))
			{
				continue;
			}else
			{
				ArrayList<Integer>al=new ArrayList<>();
				al.add(node.data);
				map.put(hd, al);
			}
			
			if(node.left!=null)
				queue.add(new Qobj(hd-1,node.left));
			
			if(node.right!=null)
				queue.add(new Qobj(hd+1,node.right));
		}
		
		for(Map.Entry<Integer,ArrayList<Integer>>m:map.entrySet())
		{
			ArrayList<Integer>al=m.getValue();
			for(Integer i:al)
				System.out.print(i+" ");
			System.out.println();
		}	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		root.left.left.left=new Node(8);
		root.left.left.right=new Node(9);
		root.left.right.left=new Node(10);
		root.left.right.right=new Node(11);
		root.right.left.right=new Node(12);
		
		topView(root);

	}

}
