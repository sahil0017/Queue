package PriorityQueue;

public class MainQueue {
	
	static class Node
	{
		int data;
		int priority;
		Node next;
		
		public Node(int  data,int priority)
		{
			this.data=data;
			this.priority=priority;
			this.next=null;			
		}
	}
	static Node head;
	
	static Node push(Node head,int d,int p)
	{
		Node start =head;
		Node temp=new Node(d,p);
		
		if(head.priority>p)
		{
			temp.next=head;
			head=temp;
		}
		else
		{
			while(start.next!=null && start.next.priority<p)
			{
				start=start.next;
			}
			temp.next=start.next;
			start.next=temp;
		}
		return head;
	}
	
	static boolean isEmpty(Node head)
	{
		return head==null;
	}
	
	static int peek(Node head)
	{
		return head.data;
	}
	
	static void pop()
	{
		Node temp=head;
		System.out.println("Deleted Node is  "+temp.data);
		head=head.next;
		//return head;
	}
	

	public static void main(String[] args) {
		Node pq=new Node(4,1);
		pq=push(pq,5,2);
		pq=push(pq,7,8);
		pq=push(pq,2,3);
		
		while(!isEmpty(pq))
		{
			System.out.printf("%d",peek(pq));
			
		}

	}

}
