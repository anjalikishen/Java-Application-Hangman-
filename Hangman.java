package game;
import java.util.Random;	// import statements
import java.util.Scanner;

public class Hangman
{
	String word[]={"syria","qatar","japan","mongolia","bahrain","india"};//instance variable
   
    public void showMenu()
    {
        int option;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("---------Menu---------");
        System.out.println("1. Play");
        System.out.println("2. Instructions");
        System.out.println("3. Exit");
        System.out.print("\nChoose the option: ");
       
        option = sc.nextInt();
        
	// Switch Case

        switch(option)
        {
            case 1: playGame();
                    break;
            case 2: instructGame();
                    break;
            case 3: exitGame();
                    break;
            default: System.out.println("Incorrect menu option");
                     showMenu();
                    break;
       }
    }
    
    // Method definition

    public void playGame() 
    {
	//playGame functionality
		int len,i,count=0,rnd,flag=0;
		String choice,temp;
		Random rd=new Random();
		Scanner input=new Scanner(System.in);
        rnd=rd.nextInt(6);
		len = word[rnd].length();
		char[] newString =new char[len];
		StringBuffer wrgString=new StringBuffer();
		for(int j=0;j<len;j++)
		{
			System.out.print("_ ");
		}
		System.out.println();
		do
		{
			flag=0;
			System.out.print("\n\nEnter your guess: ");
			String ch = input.nextLine().toLowerCase();
			count++;
			for(i=0;i<len;i++)
			{
				if(word[rnd].charAt(i)==ch.charAt(0))
				{
					newString[i]=word[rnd].charAt(i);
					flag=1;
				}
			}
			if(flag==0)
			{
				flag=1;
				wrgString.append(ch+",");
				System.out.println("\nMisses: "+wrgString);
			}
			System.out.println(newString);
			temp=new String(newString);
			if(word[rnd].equals(temp))
			{
				System.out.println("----------------Congrats :) YOU WON----------------");
				System.out.println("do you want to play again(Y/N)");
				choice=input.nextLine();
				if(choice.equalsIgnoreCase("y"))
				{
					playGame();
				}
				else
				{
					showMenu();
				}
			}
			
		}while(flag!=0);

    }

    public void instructGame() 
    {
        System.out.println("instructGame method is invoked");
    }

    public void exitGame() 
    {
        System.out.println("exitGame method is invoked");
        System.exit(0);
    }    

    public static void main(String[] args) 
    {
        Hangman hg = new Hangman();
	hg.showMenu();
    }	
}
