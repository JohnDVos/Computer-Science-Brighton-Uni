import java.util.Scanner;

public class Main {
	
	public static void main(String args[]){
	    
	    System.out.println("Enter desired integer (must be between 1 & 25):");
	    Scanner sc = new Scanner(System.in);
	    int numb = sc.nextInt();
	    
	    while (numb < 1 || numb > 25) {
	    	System.out.println("number was not between 1 & 25:");
	    	System.out.println("please enter a number between 1 & 25:");
	    	numb = sc.nextInt();
	    }
	    
	    for(int i = 1; i <= 12; i++) {
	    	System.out.printf("%2d * %1d = %3d \n",i, numb, i*numb);
	    }
	    
	  }
}
