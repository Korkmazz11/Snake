
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import enigma.console.TextAttributes;

public class Score {

	
	
	static int scorecodon=0;
	private int counter;
	static String[] Points = new String[50];
	private static int index = 0; 
	private static  MultiLinkedList aminoacids;
	
	public Score() 
	{

		
		
		counter = 3;
	}
	
	public static void readAminoacids() throws NumberFormatException, IOException {
		
	
		 aminoacids = new MultiLinkedList();
		
	
		FileReader fileReader = new FileReader("snake.txt");
		
		String line;
		
		BufferedReader br = new BufferedReader(fileReader);
		
		//all lines.
		while ((line = br.readLine()) != null) {
			
			//delete all spaces.
			line=line.trim();
			
			//split by ","
		    String [] split = line.split(",",-1);
		    
		   
		    
		    
		    
		    for (int i = 2; i < split.length; i++) 
		    {
		    	
				String [] extraSplitted = split[i].split("-");
				aminoacids.addCategory(extraSplitted[0]);
				aminoacids.addItem( extraSplitted[0], Integer.parseInt(extraSplitted[1]));
				
			}
		    
		  
		    
		}
	
		br.close();
	   
	}
	public static void givePoint() throws NumberFormatException{
		String codon = "";
		int a=0;
		Node temp = Snake.snake.head;
		
		for (int i = 0; i < 3; i++) {
			Snake_part cc=(Snake_part)(temp.getData());
			codon += Character.toString(cc.getParts());
			temp = temp.getLink();
			
		}
		
	
		String reverseCodon = new StringBuffer(codon).reverse().toString();
		
	
	   	temp =aminoacids.getHead();
		
			while(temp != null)
			{  
				String x=(String) temp.getCategoryName();
				if(reverseCodon.equalsIgnoreCase((String)x.toString()))
				{
					
				scorecodon += temp.getRight().getPoint(); 
					Points[index] = (temp.getCategoryName()+ " - " + ( temp.getRight().getPoint()));
					index++;
					
				}
				temp = (Node) temp.getDown();
			}
			
		}
	
	
	public static void printingCodons(enigma.console.Console console) {
		int i = 4;
		int a = 62;
		console.setTextAttributes(new TextAttributes(Color.RED));
		console.getTextWindow().setCursorPosition(a,i);
	    
	    for (int j = 0; j < Points.length; j++) {
	    	if(j>=17) {
	    		a = 68;
	    		i = 4;
	    		console.getTextWindow().setCursorPosition(a, i);
	    		if(Points[j]!=null)
		    		System.out.print(Points[j]);
	    		i++;
	    	}
	    	else {
	    		//if(Management.score==0)
	    		//	a=62;
	    		  //  i=4;
	    	        i++;
	                if(Points[j]!=null)
		    		System.out.print(Points[j]);
				
				console.getTextWindow().setCursorPosition(a, i);
	    	}
	    	
		}
	}
	
	
	
} 
	
	
	
	
	
	
	
	
	
	
	
	
	


