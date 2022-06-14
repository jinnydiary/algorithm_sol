import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int t = scr.nextInt();
		int h, w, n;
		for(int i=0; i<t; i++) {
			h = scr.nextInt();
			w = scr.nextInt();
			n = scr.nextInt();
			System.out.println(findRoom(h, w, n));
		}
		scr.close();
	}
	
	private static int findRoom(int h, int w, int n) {
		int d, position;
		if(n%h == 0) {
			d = n / h;
			position = h;
		}else {
			d = (n / h) + 1;
			position = n % h;
		}
		position = position * 100 + d;
		return position;
	}

}