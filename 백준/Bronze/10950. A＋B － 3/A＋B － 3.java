import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int t = scr.nextInt();
		int a, b;
		for(int i = 0; i < t; i++) {
			a = scr.nextInt();
			b = scr.nextInt();
			System.out.println(a+b);
		}
		scr.close();

	}

}
