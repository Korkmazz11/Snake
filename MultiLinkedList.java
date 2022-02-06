

public class MultiLinkedList {
	Node head;	
	public void addCategory(String data) {
		Node temp;
		if (head == null) {
			temp = new Node(data); 
			head = temp;
		}
		else {		     
			temp = head;
			while (temp.getDown() != null)
				temp = (Node) temp.getDown();
			Node newnode = new Node(data);
			temp.setDown(newnode);
		}
	}
	public void addItem(String data, int point) {
		if (head == null)    
			System.out.println("Add a Category before Item");
		else {
			Node temp = head;
			
			while (temp != null)
			{	    	 
				if (data.equals(temp.getCategoryName())) {
					Node temp2 = temp.getRight(); 
					if (temp2 == null) {
						temp2 = new Node(point); 
						temp.setRight(temp2);
					}
					else {				 
						while (temp2.getNext1() != null)
							temp2 = temp2.getNext1();
						Node newnode = new Node(point);
						temp2.setNext1(newnode);
					}			          
				}
				temp = (Node) temp.getDown();
			}
		}
	}

	public int sizeCategory()
	{
		int count = 0;
		if (head == null)
			System.out.println("linked list is empty");
		else {
			Node temp = head;
			while (temp != null)
			{
				count++;
				temp=(Node) temp.getDown();
			}
		}
		return count;   
	}

	public int sizeItem()
	{
		int count = 0;
		if (head == null)
			System.out.println("linked list is empty");
		else {
			Node temp = head;
			while (temp != null)
			{
				Node temp2 = temp.getRight();
				while (temp2 != null)
				{
					count++;
					temp2 = temp2.getNext1();
				}
				temp = (Node) temp.getDown();
			}
		}
		return count;   
	}

	public void display()
	{
		if (head == null)    
			System.out.println("linked list is empty");
		else {
			Object temp = head;
			while (temp != null)
			{
				System.out.print(((Node) temp).getCategoryName() + " --> ");
				Node temp2 = ((Node) temp).getRight();
				while (temp2 != null)
				{
					System.out.print(temp2.getPoint() + " ");
					temp2 = temp2.getNext1();
				}
				temp = ((Node) temp).getDown();
				System.out.println();
			}
		}
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
}