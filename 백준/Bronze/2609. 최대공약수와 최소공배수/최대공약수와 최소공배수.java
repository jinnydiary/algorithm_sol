import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int num1 = scr.nextInt();
		int num2 = scr.nextInt();
		int c1 = (num1<num2) ? num1 : num2, c2 = (num1>num2) ? num1 : num2;
		int temp = c2, check1 = 0, check2 = 0;
		
		while(true) {
			if(num1%c1 == 0 && num2%c1 == 0 && check1 == 0)
				check1 = 1;
			if(c2%num1 == 0 && c2%num2 == 0 && check2 == 0)
				check2 = 1;
			
			if(check1 == 1 && check2 == 1)
				break;
			else if(check1 == 0)
				c1--;
			else if(check2 == 0)
				c2 += temp;
		}
		
		System.out.printf("%d\n%d", c1, c2);
		
		scr.close();

	}

}