import java.io.IOException;
import java.util.Scanner;

import enigma.console.Console;
import enigma.core.Enigma;
import java.io.IOException;
import java.util.Scanner;



public class Menu {

	public Menu() throws InterruptedException, IOException {

		Console cn = Enigma.getConsole("HELIX", 100, 35,18);
			
		boolean choose=false;
		while(choose==false) {
			cn.getTextWindow().setCursorPosition(0,0);
			new Game_menu();
			cn.getTextWindow().setCursorPosition(35,25);
			System.out.println("WELCOME TO SNAKE GAME!");
			cn.getTextWindow().setCursorPosition(35,26);
			System.out.println("-----MENU-----");
			cn.getTextWindow().setCursorPosition(35,27);
			System.out.println("1-Play ");	
			cn.getTextWindow().setCursorPosition(35,28);
			System.out.println("2-Exit ");
			
			try {
			Scanner input =new Scanner(System.in);
			int in= input.nextInt();
          
			if (in==1) {
				menuclear();
				Management man= new Management();
				
				choose=true; break;

			}


			else if(in==2) {
				System.exit(0);
			}
			else {
				cn.getTextWindow().setCursorPosition(35,30);
				System.out.println("Wrong Input!");	
				
				choose=false; 
				menuclear();
			}
			}
			catch(Exception e){
				cn.getTextWindow().setCursorPosition(35,30);
				System.out.println("Wrong Input!"); menuclear();
			}
		}
	}
	public static void menuclear()
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

}




