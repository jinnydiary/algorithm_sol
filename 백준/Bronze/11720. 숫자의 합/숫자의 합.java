import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n1 = scr.nextInt();
		String num = scr.next();
		int sum = 0;
		for(int i=0; i<n1; i++)
			sum += Integer.parseInt(num.substring(i,i+1));
		System.out.println(sum);
		scr.close();
	}

}
