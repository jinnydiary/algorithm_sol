import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int[] num = new int[9];
		for(int i = 0; i < num.length; ++i) {
			num[i] = scr.nextInt();
		}
		int max = num[0], position = 1;
		for(int i = 1; i < num.length; ++i) {
			if(max < num[i]) {
				max = num[i];
				position = i+1;
			}
		}
		System.out.printf("%d\n%d", max, position);
		scr.close();
	}

}
