import java.util.Scanner;

public class Main {

	//you had a random extra scanner usage bro
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter two integers:");
		int a = scan.nextInt();
		int b = scan.nextInt();
		System.out.println("The average is: " + ((double) (a+b))/2);
	}

}
