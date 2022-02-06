public class DoubleLinkedList {
	private NodeDLL head;	
	private NodeDLL tail;

	public DoubleLinkedList() {
		head = null;
		tail = null;
	}

	public void add(String name, int score) {
		NodeDLL newnode;
		if (head == null) {  //list is empty
			newnode = new NodeDLL(name,score); 
			head = newnode;
			tail = newnode;	     
		}
		else {   //add to the end
			newnode = new NodeDLL(name,score); 
			newnode.setPrev(tail);
			tail.setNext(newnode);				
			tail=newnode;			
		}
		sort();
	}

	public void  sort ()
	{
		NodeDLL temp = head;

		while(temp != null)
		{NodeDLL curr=temp.getNext();
		while( curr!=null)
		{ 
			if ((int)temp.getPoint()<(int)curr.getPoint()) 
			{				
				int score=(int)temp.getPoint();
				temp.setPoint(curr.getPoint());
				curr.setPoint(score);
				String name=(String)temp.getName();
				temp.setName(curr.getName());
				curr.setName(name);
				
			}
			curr=curr.getNext();
			
		}
		temp=temp.getNext();
		}

	}


	public NodeDLL getHead() {
		return head;
	}

	public void setHead(NodeDLL head) {
		this.head = head;
	}

	public NodeDLL getTail() {
		return tail;
	}

	public void setTail(NodeDLL tail) {
		this.tail = tail;
	}

}
