import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int year = scr.nextInt();
		int result;
		
		if( ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0) ) {
			result = 1;
		}else {
			result = 0;
		}
		System.out.print(result);
		scr.close();
	}

}
