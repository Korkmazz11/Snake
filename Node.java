

public class Node {
 
	  // sll
	   Object data;
	    Node link; 

	   //mll pro
	   private String CategoryName;
	   private Node down;
	   private Node right;
	   
	   //mll point
	   private int point;   
	   private Node next1;
		
	
	   
	   //sll con
	   public Node(Object dataToAdd) {
		     data = dataToAdd;
		     link = null;
	   }
	   
	  // mll pro con
	   public Node(String dataToAdd) {
			CategoryName = dataToAdd;
			down = null;
			right = null;
		}
	   
	   //mll point 
	   public Node(int point) {
		     this.point = point;
		     next1 = null;
	   }
	   
	
      //sll
	public Object getData() { return data; }
	   public void setData(Object data) { this.data = data;  }

	   public Node getLink() { return link;  }
	   public void setLink(Node link) { this.link = link;   }

	   //mll
	    public String getCategoryName() { return CategoryName; }
		public void setCategoryName(String data) { this.CategoryName = data;  }
		public Object getDown() { return down;  }
		public void setDown(Node down) { this.down = down;   }
		public Node getRight() { return right;  }
		public void setRight(Node right) { this.right = right;   }
		
	    public int getPoint() { return point; }
	    public void setPoint(int point) { this.point = point;  }
	    public Node getNext1() { return next1;  }
		public void setNext1(Node next1) { this.next1 = next1;   }
		
		
		
		
		   
	 
		   
		   
		   
}

