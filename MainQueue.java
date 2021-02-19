package dataStructures;

public class MainQueue {
	
	//static class for Node creation
	static class Node
	{
		int data;
		Node next;
		//Node rear,front;
		//int length=0;
		
		//constructor 
		Node(int data)
		{
			this.data=data;
			this.next=null;
		}
		
	}
	
	//instances of Queue
	static Node rear=null;
	static Node front=null;
	//static int length;
	
	//METHOD TO add the element in FIFO
    void enqueue(int data)
	{
		Node temp=new Node(data);
		System.out.printf("Inserting element %d\n",data );
		
		//IF THE QUEUE IS EMPTY THE ELEMENT IS ADDED AT THE FRONT . SO FRONT AND REAR NODE POINTS TO THE ADDED NODE 
		if(front==null)
		{
			front=temp;
			rear=temp;
		}
		//IF SOME NODES ARE INSERTED INTO QUEUE EARLIER THEN REAR NEXT POINTS TO NEW NODE AND MAKE THE NEW NODE AS REAR
		//UPDATE THE REAR NODES.
		//FROM THIS WE LEARN REAR NODES EXECUTES INSERTION.
		else
		{
			rear.next=temp;
			rear=temp;
		}		
	}
    //METHOD TO REMOVE THE ELEMENT
    static void dequeue()
    {
    	//CHECK FOR UNDERFLOW
    	if(front==null)
    	{
    		System.out.println("UnderFlow Condition");
    		System.exit(0);
    	}
    	
    	// VARIABLE NODE TO  STORES THE FRONT 
    	//PRINT THE FRONT DATA
    	//.UPDATE THE FRONT NODE
    	Node temp=front;
    	System.out.printf("Removing element %d\n ",temp.data);
    	front=front.next;
    	
    	//AFTER UPDATION CHECK WHETHER FRONT NODE REACHES TO REAR NODE WHERE REAR NODE .NEXT IS NULL
    	//INITIAL FRONT AS NULL AND REAR AS NULL
    	//HERE THE QUEUE IS EMPTY . 
    	if(front==null)
    		rear=null;
    	
    //	int item=temp.data;
    //	return item;
    }
    
    //METHOD TO FIND THE PEEK VALUE 
    static void peek()
    {
    	//CHECK IF THE FRONT AND REAR POINTS TO NULL
    	// ie QUEUE IS EMPTY AND RETURN 
    	if(front==null && rear==null)
    	{
    		System.out.println(" NO ELEMENT IN THE QUEUE");
    		System.exit(0);
    	}
    	//PEEK VALUE OF THE QUEUE
    	System.out.printf("Peek Element at this moment %d\n",front.data);
    	//return front.data;
    	
    }
    
    //METHOD TO CHECK WHETHER QUEUE IS EMPTY OR NOT
	static boolean isEmpty()
	{
		return front==null && rear==null;
	}

	public static void main(String[] args) {
		MainQueue queue=new MainQueue();
		
		queue.enqueue(34);
		queue.enqueue(343);
		queue.enqueue(341);
		queue.enqueue(314);
		queue.enqueue(134);
		
		dequeue();
		dequeue();
		peek();
		//System.out.println("PEEK ELEMENT IN THE QUEUE "+peek());
		//queue.dequeue();
		//queue.dequeue();
		//queue.dequeue();
		
		//CHECK WHETHER THE QUEUE IS EMPTY OR NOT
		if(isEmpty())
			System.out.println("Queue is empty ");
		else
			System.out.println(" Queue is not empty");

	}

}
