import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int t = scr.nextInt();
		for(int i = 0; i < t; ++i) {
			String str = scr.next();
			int sum = 0, point = 0;
			for(int j = 0; j < str.length(); ++j) {
				if(str.charAt(j) == 'X')
					continue;
				else if(j == 0 || str.charAt(j-1) == 'X')
					point = 1;
				else
					++point;
                
				sum += point;
			}
			System.out.println(sum);
		}
		scr.close();
	}
}