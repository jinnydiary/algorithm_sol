import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int[] num = new int[n];
		num[0] = scr.nextInt();
		int min = num[0], max = num[0];
        
		for(int i = 1; i < n; ++i) {
			num[i] = scr.nextInt();
			if(min > num[i])
				min = num[i];
			else if(max < num[i])
				max = num[i];
		}
		System.out.print(min + " " + max);
		scr.close();
	}

}