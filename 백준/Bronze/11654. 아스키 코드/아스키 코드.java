import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		char word = scr.nextLine().charAt(0);
		System.out.println((int)word);
		scr.close();
	}

}