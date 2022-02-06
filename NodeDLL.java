
public class NodeDLL {


	private int point;
	NodeDLL prev; 
	private NodeDLL next;
	private String name;




	public NodeDLL(String name , int point) {
		this.name = name;
		this.point = point;
		prev = null;
		next = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public NodeDLL getNext() {
		return next; 
	}

	public void setNext(NodeDLL next) {
		this.next = next;
	}

	public NodeDLL getPrev() {
		return prev; 
	}

	public void setPrev(NodeDLL tail) {
		this.prev = tail;
	}

	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}
}


