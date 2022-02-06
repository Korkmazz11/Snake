
public class Snake_part {
	private int x_coord;
	private int y_coord;
	private char parts;
	public static String snakelist = "";
	public static String data_string_by() {
		return snakelist.substring(snakelist.length()-3,snakelist.length());
	}
	public Snake_part(int x_coord, int y_coord, char parts) {
		this.x_coord = x_coord;
		this.y_coord = y_coord;
		this.parts = parts;
		snakelist += this.parts;
	}
	

	public int getX_coord() {
		return x_coord;
	}
	public void setX_coord(int x_coord) {
		this.x_coord = x_coord;
	}
	public int getY_coord() {
		return y_coord;
	}
	public void setY_coord(int y_coord) {
		this.y_coord = y_coord;
	}
	public char getParts() {
		return parts;
	}
	public void setParts(char parts) {
		this.parts = parts;
	}
	
	
}


