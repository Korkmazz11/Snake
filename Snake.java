
import java.io.IOException;
import java.util.Random;
public class Snake {
	
	static Random rand=new Random();
	public static SingleLinkedList snake=new SingleLinkedList();
	public static Stack locFood=new Stack(9);
	public static Stack tempFood=new Stack(9);
	
	
	
	
	
	public static char Randomletters()
	{
		int b=0;
		char letter =' ';
		char[]letters= {'A','T','G','C'};
			 b=rand.nextInt(4);
			letter=letters[b]; 
		return letter;
	}
	
	

	
	public static void createsnake()
	{
		for(int i=0; i<3;i++)
		{
			Snake_part temp_part=new Snake_part(12,26+i,Randomletters());
			snake.addFront(temp_part);
		}
		
	}
    public static void snake()
	
	{
	    createsnake();
		Node snakeTemp=Snake.snake.head;
	
		
	    while(snakeTemp!=null)
		{
	    	Snake_part parça=(Snake_part)(snakeTemp.getData());
	    	Management.screen[parça.getX_coord()][parça.getY_coord()]=parça.getParts();
	    	snakeTemp=snakeTemp.getLink();
		}    	 
	}
   
    public static  void cheakEat() throws NumberFormatException, IOException {
    	
        Node temp_snake=Snake.snake.head;
    	Snake_part temp=(Snake_part)(temp_snake.getData());
    	
    	int x=temp.getX_coord();
    	int y=temp.getY_coord();


    	while(!locFood.isEmpty()) {
    		
    	char Food=(char) locFood.pop();tempFood.push(Food);
        int y_food=(int) locFood.pop();tempFood.push(y_food);
        int x_food=(int) locFood.pop();tempFood.push(x_food);	
        
        if(Management.direction==1&&x==x_food&&y==y_food) {
        	Snake_part temp_part=new Snake_part(x-1,y,Food);
        	 Snake.snake.addFront(temp_part);
        	
            temp.setX_coord(temp.getX_coord()-1);
    	        temp.setY_coord(temp.getY_coord());
    	      Management.screen[temp.getX_coord()][temp.getY_coord()]=temp.getParts();
    	      Management.screen[x_food][y_food]=' ';
          	  tempFood.pop();
          	  tempFood.pop();
          	  tempFood.pop();
          	  Management.counter=1;Management.Randomletters();
          	if(Management.score==0&&Snake.snake.size()%3==0) {
          		Score.readAminoacids();
				Score.givePoint();
				Score.printingCodons(Management.cn);
          	}
          	if(Snake.snake.size()%3==0) {
	          	Score.readAminoacids();
				Score.givePoint();
				Score.printingCodons(Management.cn);}
          	
          	}
        
        if(Management.direction==2&&x==x_food&&y==y_food) {
        	
        	Snake_part temp_part=new Snake_part(x+1,y,Food);
        	Snake.snake.addFront(temp_part);
        	temp.setX_coord(temp.getX_coord()+1);
      	    temp.setY_coord(temp.getY_coord());
      	  Management.screen[temp.getX_coord()][temp.getY_coord()]=temp.getParts();
      	 Management.screen[x_food][y_food]=' ';
     	  tempFood.pop();
     	  tempFood.pop();
     	  tempFood.pop();
     	 Management.counter=1;Management.Randomletters();
     	if(Management.score==0&&Snake.snake.size()%3==0) {
      		Score.readAminoacids();
			Score.givePoint();
			Score.printingCodons(Management.cn);
      	}
     	if(Snake.snake.size()%3==0) {
          	Score.readAminoacids();
			Score.givePoint();
			Score.printingCodons(Management.cn);}
        	
        } 
        if(Management.direction==3&&x==x_food&&y==y_food) {
        	Snake_part temp_part=new Snake_part(x,y+1,Food);
        	Snake.snake.addFront(temp_part);
        	
        	temp.setX_coord(temp.getX_coord());
      	    temp.setY_coord(temp.getY_coord()+1);
      	  Management.screen[temp.getX_coord()][temp.getY_coord()]=temp.getParts();
      	  
      	 Management.screen[x_food][y_food]=' ';
      	  tempFood.pop();
      	  tempFood.pop();
      	  tempFood.pop();
      	Management.counter=1;Management.Randomletters();
    	if(Management.score==0&&Snake.snake.size()%3==0) {
      		Score.readAminoacids();
			Score.givePoint();
			Score.printingCodons(Management.cn);
      	}
      	if(Snake.snake.size()%3==0) {
          	Score.readAminoacids();
			Score.givePoint();
			Score.printingCodons(Management.cn);}
        
        }
        if(Management.direction==4&&x==x_food&&y==y_food) {
        	
        	Snake_part temp_part=new Snake_part(x,y-1,Food);
        	Snake.snake.addFront(temp_part);
        	temp.setX_coord(temp.getX_coord());
      	    temp.setY_coord(temp.getY_coord()-1);
      	  Management.screen[temp.getX_coord()][temp.getY_coord()]=temp.getParts();
      	 Management.screen[x_food][y_food]=' ';
     	  tempFood.pop();
     	  tempFood.pop();
     	  tempFood.pop();
     	 Management.counter=1;Management.Randomletters();
     	if(Management.score==0&&Snake.snake.size()%3==0) {
      		Score.readAminoacids();
			Score.givePoint();
			Score.printingCodons(Management.cn);
      	}
     	if(Snake.snake.size()%3==0) {
          	Score.readAminoacids();
			Score.givePoint();
			Score.printingCodons(Management.cn);}
        }
      
    	}
    
    	while(!tempFood.isEmpty()) {
    		locFood.push(tempFood.pop());
    	}
    	
	
	}
	
	
	
	

public static void moveToRight()
{
	  Node temp_snake=Snake.snake.head;
	  Snake_part temp=(Snake_part)(temp_snake.getData());
	  int temp_öndeki_x;
	  int temp_öndeki_y;
	  int temp_arkadaki_x;
	  int temp_arkadaki_y;
	  temp_öndeki_x=temp.getX_coord();
	  temp_öndeki_y=temp.getY_coord();
	 // Management.screen[temp.getX_coord()][temp.getY_coord()]=temp.getParts();
	  temp.setX_coord(temp.getX_coord());
	  temp.setY_coord(temp_öndeki_y+1);
	 Management.screen[temp.getX_coord()][temp.getY_coord()]=temp.getParts();
	  temp_snake=temp_snake.getLink();
	
	  while(temp_snake!=null)
	  {
		  temp=(Snake_part)(temp_snake.getData());
		  temp_arkadaki_x=temp.getX_coord();
		  temp_arkadaki_y=temp.getY_coord();
		  temp.setX_coord(temp_öndeki_x);
        temp.setY_coord(temp_öndeki_y);	  
		  Management.screen[temp.getX_coord()][temp.getY_coord()]=temp.getParts();
		  temp_snake=temp_snake.getLink();
		  
		
		  if(temp_snake==null)
		  {   
			 Management.screen[temp_arkadaki_x][temp_arkadaki_y]=' ';
			 Management.screen[temp_öndeki_x][temp_öndeki_y]=temp.getParts();
		  }
		  temp_öndeki_x=temp_arkadaki_x;
		  temp_öndeki_y=temp_arkadaki_y;
		  
	  } 
	 
	 
}
public static void moveToLeft()
{
	Node temp_snake=Snake.snake.head;
	  Snake_part temp=(Snake_part)(temp_snake.getData());
	  int temp_öndeki_x;
	  int temp_öndeki_y;
	  int temp_arkadaki_x;
	  int temp_arkadaki_y;
	  temp_öndeki_x=temp.getX_coord();
	  temp_öndeki_y=temp.getY_coord();
	 // Management.screen[temp.getX_coord()][temp.getY_coord()]=temp.getParts();
	  temp.setX_coord(temp.getX_coord());
	  temp.setY_coord(temp_öndeki_y-1);
	 Management.screen[temp.getX_coord()][temp.getY_coord()]=temp.getParts();
	  temp_snake=temp_snake.getLink();
	
	  while(temp_snake!=null)
	  {
		  temp=(Snake_part)(temp_snake.getData());
		  temp_arkadaki_x=temp.getX_coord();
		  temp_arkadaki_y=temp.getY_coord();
		  temp.setX_coord(temp_öndeki_x);
      temp.setY_coord(temp_öndeki_y);	  
		  Management.screen[temp.getX_coord()][temp.getY_coord()]=temp.getParts();
		  temp_snake=temp_snake.getLink();
		  
		
		  if(temp_snake==null)
		  {   
			 Management.screen[temp_arkadaki_x][temp_arkadaki_y]=' ';
			 Management.screen[temp_öndeki_x][temp_öndeki_y]=temp.getParts();
		  }
		  temp_öndeki_x=temp_arkadaki_x;
		  temp_öndeki_y=temp_arkadaki_y;
		  
	  } 

	   
	 
	  
}
public static void moveToUp()
{
	  Node temp_snake=Snake.snake.head;
	  Snake_part temp=(Snake_part)(temp_snake.getData());
	  int temp_öndeki_x;
	  int temp_öndeki_y;
	  int temp_arkadaki_x;
	  int temp_arkadaki_y;
	  temp_öndeki_x=temp.getX_coord();
	  temp_öndeki_y=temp.getY_coord();
	 // Management.screen[temp.getX_coord()][temp.getY_coord()]=temp.getParts();
	  temp.setX_coord(temp_öndeki_x-1);
	  temp.setY_coord(temp.getY_coord());
	 Management.screen[temp.getX_coord()][temp.getY_coord()]=temp.getParts();
	  temp_snake=temp_snake.getLink();
	
	  while(temp_snake!=null)
	  {
		  temp=(Snake_part)(temp_snake.getData());
		  temp_arkadaki_x=temp.getX_coord();
		  temp_arkadaki_y=temp.getY_coord();
		  temp.setX_coord(temp_öndeki_x);
        temp.setY_coord(temp_öndeki_y);	  
		  Management.screen[temp.getX_coord()][temp.getY_coord()]=temp.getParts();
		  temp_snake=temp_snake.getLink();
		  
		
		  if(temp_snake==null)
		  {   
			 Management.screen[temp_arkadaki_x][temp_arkadaki_y]=' ';
			 Management.screen[temp_öndeki_x][temp_öndeki_y]=temp.getParts();
		  }
		  temp_öndeki_x=temp_arkadaki_x;
		  temp_öndeki_y=temp_arkadaki_y;
		  
	  } 
	  
}
public static void moveToDown()
{
	  Node temp_snake=Snake.snake.head;
	  Snake_part temp=(Snake_part)(temp_snake.getData());
	  int temp_öndeki_x;
	  int temp_öndeki_y;
	  int temp_arkadaki_x;
	  int temp_arkadaki_y;
	  temp_öndeki_x=temp.getX_coord();
	  temp_öndeki_y=temp.getY_coord();
	 // Management.screen[temp.getX_coord()][temp.getY_coord()]=temp.getParts();
	  temp.setX_coord(temp_öndeki_x+1);
	  temp.setY_coord(temp.getY_coord());
	 Management.screen[temp.getX_coord()][temp.getY_coord()]=temp.getParts();
	  temp_snake=temp_snake.getLink();
	
	  while(temp_snake!=null)
	  {
		  temp=(Snake_part)(temp_snake.getData());
		  temp_arkadaki_x=temp.getX_coord();
		  temp_arkadaki_y=temp.getY_coord();
		  temp.setX_coord(temp_öndeki_x);
        temp.setY_coord(temp_öndeki_y);	  
		  Management.screen[temp.getX_coord()][temp.getY_coord()]=temp.getParts();
		  temp_snake=temp_snake.getLink();
		  
		
		  if(temp_snake==null)
		  {   
			 Management.screen[temp_arkadaki_x][temp_arkadaki_y]=' ';
			 Management.screen[temp_öndeki_x][temp_öndeki_y]=temp.getParts();
		  }
		  temp_öndeki_x=temp_arkadaki_x;
		  temp_öndeki_y=temp_arkadaki_y;
		  
	  } 
	 
	 }





	
		  
		  
}

 
	
	
		

	 
	
