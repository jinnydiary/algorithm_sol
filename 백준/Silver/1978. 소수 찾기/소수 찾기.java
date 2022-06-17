import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int count = 0;
		
		for(int i=0; i<n; i++) {
			int number = scr.nextInt();
			boolean find = true;
			for(int j=1; j<number; j++) {
				if(number % j == 0 && j != 1) {
					find = false;
					break;
				}
			}
			if(find == true && number != 1)
				count++;
		}
		
		System.out.println(count);
		scr.close();

	}

}
