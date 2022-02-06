import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import enigma.core.Enigma;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import enigma.console.Console;
import enigma.console.TextAttributes;
public class Management {

	private static int level =0;
	public static Console cn = Enigma.getConsole("HELIX", 80, 30,15);
	char [] letters= {'A','T','C','G'};
	public static char [][] screen=new char[25][60];
	public static 	int time=0;
	public static String name="";
	public static DoubleLinkedList top10=new DoubleLinkedList();
	Random rnd=new Random();
	public KeyListener klis; 
	public int keypr;   // key pressed?
	public int rkey;    // key   (for press/release)
	
	static int velocity;
	static int speed;
	static int score=0;
	static int direction=3;
	static int direction_up=1;
	static int direction_down=2;
	static int direction_right=3;
	static int direction_left=4;
	static int counter=3;
	boolean flag=true;
	public Management() throws InterruptedException, IOException
	{
		klis=new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				if(keypr==0) {
					keypr=1;
					rkey=e.getKeyCode();
				}
			}
			public void keyReleased(KeyEvent e) {}
		};
		cn.getTextWindow().addKeyListener(klis);
		boolean choose=false;
		while(choose==false) {
			Enigma.getConsole().getTextWindow().setCursorPosition(30,12);
			System.out.println("1-EASY");
			Enigma.getConsole().getTextWindow().setCursorPosition(30,13);
			System.out.println("2-INTERMEDIA		+ ");
			Enigma.getConsole().getTextWindow().setCursorPosition(30,14);
			System.out.println("3-HARD");
			try {
			Scanner scan=new Scanner(System.in);
			Enigma.getConsole().getTextWindow().setCursorPosition(30,16);
			System.out.print("CHOOSE DIFFICULTY LEVEL : ");
			velocity=scan.nextInt();
			if(velocity==1)
			{
				speed=100;choose=true;break;
			}
			else if(velocity==2) {
				speed=250;choose=true;break;}
			else if(velocity==3) {
				speed=500;choose=true;break;}
			else
				Enigma.getConsole().getTextWindow().setCursorPosition(30,19);
			System.out.println("Wrong Choose Again");
			choose=false;
			}
			catch(Exception e){
				Enigma.getConsole().getTextWindow().setCursorPosition(30,19);
				System.out.println("Wrong Choose Again");
			}
		
			
    	
		}
		 play();


	}	               

	public void play() throws InterruptedException, IOException{

		initializeboard();
		printboard();
		Score.readAminoacids();
		Score.givePoint();
		Score.printingCodons(Management.cn);
		boolean wallflag=true;
		while(flag) {
			score=(Snake.snake.size()-3)*5;
			score+=Score.scorecodon;
			Enigma.getConsole().getTextWindow().setCursorPosition(63,2);
			System.out.println("Score : "+score);
			Enigma.getConsole().getTextWindow().setCursorPosition(63,3);
			System.out.println("------------");
			Enigma.getConsole().getTextWindow().setCursorPosition(63,20);
			System.out.println("Level : "+level);
			Enigma.getConsole().getTextWindow().setCursorPosition(63,21);
			if(speed==100)
			{
				System.out.print("Time : "+time/10);
				time++;TimeUnit.SECONDS.sleep(0);
				if(time %200==0&&time!=0)
				{

					while(wallflag==true)
					{

						int random_x=rnd.nextInt(23)+1;
						int random_y=rnd.nextInt(58)+1;
						if(screen[random_x][random_y]==' ') {
							screen[random_x][random_y]='#';
							wallflag=true; break;}
						else {
							wallflag=false;
							break;}

					}level++; 
		     	}}
				if(speed==500)
				{
					System.out.print("Time : "+time/2);
					time++;TimeUnit.SECONDS.sleep(0);
					if(time %40==0&&time!=0)
					{

						while(wallflag==true)
						{

							int random_x=rnd.nextInt(23)+1;
							int random_y=rnd.nextInt(58)+1;
							if(screen[random_x][random_y]==' ') {
								screen[random_x][random_y]='$';
								wallflag=true; break;}
							else {
								wallflag=false;
								break;}

						}level++; 
				}
					}
					if(speed==250)
					{
						System.out.print("Time : "+time/4);
						time++;TimeUnit.SECONDS.sleep(0);
						if(time %80==0&&time!=0)
						{

							while(wallflag==true)
							{

								int random_x=rnd.nextInt(23)+1;
								int random_y=rnd.nextInt(58)+1;
								if(screen[random_x][random_y]==' ') {
									screen[random_x][random_y]='$';
									wallflag=true; break;}
								else {
									wallflag=false;
									break;}

							}level++; 
					}
			
			
			}
			if(keypr==1) 
			{   
				if(rkey==KeyEvent.VK_LEFT && direction!=3) 
				{
					direction = 4;   
				}
				if(rkey==KeyEvent.VK_RIGHT&&direction!=4) {
					direction = 3;
				}
				if(rkey==KeyEvent.VK_UP&&direction!=2) {
					direction = 1;
				}
				if(rkey==KeyEvent.VK_DOWN&&direction!=1) {
					direction = 2;
				}
				keypr=0;
			}

			if(direction == 1)  
			{
				Snake.moveToUp();

			}
			else if(direction == 2)
			{
				Snake.moveToDown();

			}
			else if(direction==3)
			{
				Snake.moveToRight();

			}
			else if(direction==4)
			{
				Snake.moveToLeft();

			}

			if(flag==true) {
				Snake.cheakEat();
				clearscreen();     
				printboard();
				flag = walls();
				

			}

			
			try {
				Thread.sleep(speed);

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		
			int count=0;
			while(count<=1) {
			
			count++;
			}
			
		}
	
		if(flag == false) {	
			Scanner sca=new Scanner(System.in);
			System.out.print("CHOOSE: ");
			int pla=sca.nextInt();
			if(pla==3) {
		    readHighScoreTable();
			creatScoreTable();
			HighScoreTable();
			}
			
			
			else if(pla==4) {
				readHighScoreTable();
				creatScoreTable();
			Scanner scan=new Scanner(System.in);
			Enigma.getConsole().getTextWindow().setCursorPosition(35,16);

			System.out.println("Play again?");
			Enigma.getConsole().getTextWindow().setCursorPosition(35,17);
			System.out.println("1-YES");

			Enigma.getConsole().getTextWindow().setCursorPosition(35,18);
			System.out.println("2-EXIT");
			Enigma.getConsole().getTextWindow().setCursorPosition(35,19);
			System.out.print("CHOOSE a: ");
			int play=scan.nextInt();
			if(play==1)
			{flag=true;
			newplay();
			
			}
			else if(play==2) {
				System.exit(0);}
			
		}}
		
		
	}
	    


	public void initializeboard()
	{

		for(int i=0;i<25;i++)
		{
			for(int j=0;j<60;j++)
			{
				if(i==0||i==24 || j==0 || j==59)
				{
					screen[i][j]='#';
				}

				else {
					screen[i][j]=' ';
				}	

			}
		}

		Randomletters();	
		Snake.snake();
	}
	public void printboard()
	{
		for(int i=0;i<60;i++)
		{
			for(int j=0;j<25;j++)
			{
				cn.getTextWindow().setCursorPosition(i,j);
				System.out.print(screen[j][i]);
			}
			System.out.println();
		}
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 60; j++) {
				cn.getTextWindow().setCursorPosition(j,i);
				if(screen[i][j]=='A') {
					cn.setTextAttributes(new TextAttributes(Color.GREEN));

				}
				else if(screen[i][j]=='T') {
					cn.setTextAttributes(new TextAttributes(Color.ORANGE));
				}
				else if(screen[i][j]=='C') {
					cn.setTextAttributes(new TextAttributes(Color.CYAN));
				}
				else if(screen[i][j]=='G') {
					cn.setTextAttributes(new TextAttributes(Color.BLUE));
				}
				else if(screen[i][j]=='#') {
					cn.setTextAttributes(new TextAttributes(Color.RED));
				}
				else {
					cn.setTextAttributes(new TextAttributes(new Color(150,150,150),new Color(150,150,100)));
				}
				System.out.print(screen[i][j]);


			}
			System.out.println();
		}
	}
	public void clearscreen()
	{
		for(int i=0;i<60;i++)
		{
			for(int j=0;j<25;j++)
			{
				cn.getTextWindow().setCursorPosition(i,j);
				System.out.print(' ');
			}
			System.out.println();
		}

	}
	public static void Randomletters() {
		char [] letters= {'A','T','C','G'};
		int x_pos;
		int y_pos;
		int randomForLetter;
		char randomLetter;

		for(int j=0;j<counter;j++) {
			randomForLetter = ((int)(Math.random()*4));
			randomLetter=letters[randomForLetter];
			x_pos = ((int)(Math.random()*23+1));
			Snake.locFood.push(x_pos);
			y_pos = ((int)(Math.random()*58+1));
			Snake.locFood.push(y_pos);
			Management.screen[x_pos][y_pos]=randomLetter;
			Snake.locFood.push(randomLetter);





		}

	}
	@SuppressWarnings("resource")
	public boolean walls() throws IOException {
		Node snakeTemp=Snake.snake.head;

		Snake_part parça=(Snake_part)(snakeTemp.getData());



		if (direction==1&&screen[parça.getX_coord()-1][parça.getY_coord()]=='#') {
			direction=0;


			System.out.println("Game Over!");

			System.out.println("Your name: ");
			Scanner input=new Scanner(System.in);
			name= input.nextLine()+" ";


			return false;
		}

		else if (direction==2&&screen[parça.getX_coord()+1][parça.getY_coord()]=='#') {
			direction=0;


			System.out.println("Game Over!");

			System.out.println("Your name: ");
			Scanner input=new Scanner(System.in);
			name+= input.nextLine()+" ";

			return false;
		}
		else if (direction==3&&screen[parça.getX_coord()][parça.getY_coord()+1]=='#') {
			direction=0;


			System.out.println("Game Over!");

			System.out.println("Your name: ");
			Scanner input=new Scanner(System.in);
			name+= input.nextLine()+" ";

			return false;

		}
		else if (direction==4&&screen[parça.getX_coord()][parça.getY_coord()-1]=='#') {
			direction=0;


			System.out.println("Game Over!");

			System.out.println("Your name: ");
			Scanner input=new Scanner(System.in);
			name+= input.nextLine()+" ";

			return false;


		}
		else
		{for(int i=1;i<Snake.snake.size();i++)
		{
			Node snkf=Snake.snake.getNthElem(1);
			Snake_part rtf=(Snake_part)(snkf.getData());
			Node snk=Snake.snake.getNthElem(i);
			Snake_part rt=(Snake_part)(snk.getData());
			if((i>2)&&(rtf.getX_coord()==rt.getX_coord()&&rtf.getY_coord()==rt.getY_coord()))
			{
				direction=0;
				System.out.println("Game Over!");
				System.out.println("Your name: ");
				@SuppressWarnings("resource")
				Scanner input=new Scanner(System.in);
				name+= input.nextLine()+" ";
				return false;
			}

		}}

		return true;
	}
	//////////////////////////////////////////////////////////////

	public void readHighScoreTable() throws IOException {

		try{

			File file = new File("HighScoreTable.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String list;

			while((list=reader.readLine())!=null) {

				String []split=list.split(";");
				top10.add(split[0],Integer.parseInt(split[1]));

			}
			reader.close();	



		} catch (ArrayIndexOutOfBoundsException ex) {}
	}
	public void HighScoreTable() throws IOException {

		try{
			int i=0;
			File file = new File("HighScoreTable.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			clearall();
			String list;

			while((list=reader.readLine())!=null) {
				cn.getTextWindow().setCursorPosition(65, 4);
				System.out.println("-----TOP 10 LIST-----");
				cn.getTextWindow().setCursorPosition(65, 5+i);
				System.out.println(list);
				i++;

			}
			reader.close();	



		} catch (ArrayIndexOutOfBoundsException ex) {}
	}

	public  void creatScoreTable() throws IOException {
		top10.add(name,score);		

		File file=new File("HighScoreTable.txt");
		FileWriter fw=new FileWriter(file);   
		int count=1;

		NodeDLL temp=top10.getHead();		

		while(temp!=null) {

			fw.write((String) temp.getName()+";"+(int) temp.getPoint()+ "\r\n"); 
			count++;
			temp=temp.getNext();
			if(count==11)
				break;
		}fw.close(); 
	}
	public static void clearall()
	{
		for(int i=0; i<50; i++)
		{
			for(int j=0;j<70;j++)
			{

				System.out.print(' ');
			}
			System.out.println();

		}
	}
	public void newplay() throws InterruptedException, IOException {
		
		Node temp_snake=Snake.snake.head;
		 
		while(temp_snake!=null) {
			Snake_part temp=(Snake_part)(temp_snake.getData());
			Snake.snake.remove(temp);
			temp_snake=temp_snake.getLink();
			System.out.print(Snake.snake.display());
		}
		while(!Snake.locFood.isEmpty()) {
			Snake.locFood.pop();
		}
		for(int i=0;i<Score.Points.length;i++) {
			if(Score.Points[i]!=null)
			Score.Points[i]=null;
		}
		
		
		
		Score.scorecodon=0;
		clearall();
		counter=3;
		score=0;
		level=0;
		time=0;
		new Menu();
	
		
	}




}

