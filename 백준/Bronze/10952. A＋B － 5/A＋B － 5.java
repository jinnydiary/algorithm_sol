import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int a, b;
		while(true) {
			a = scr.nextInt();
			b = scr.nextInt();
			if( (a == 0) && (b == 0))
				break;
			System.out.println(a+b);
		}
		scr.close();
	}

}
