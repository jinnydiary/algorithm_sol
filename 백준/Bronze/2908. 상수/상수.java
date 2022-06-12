import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n1 = scr.nextInt(), n2 = scr.nextInt();
		int num = 0, t1 = n1, t2 = n2;
		for(int i=1; i<3; i++) {
			if( (t1 % 10) != (t2 % 10) ) {
				num = ((t1 % 10) > (t2 % 10)) ? n1 : n2;
				break;
			}
			t1 /= 10;
			t2 /= 10;
		}
		num = (num%10)*100 + (num%100-num%10) + (num/100);
		System.out.print(num);
		scr.close();
	}

}