import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int a = scr.nextInt();
		int b = scr.nextInt();
		int c = scr.nextInt();
		int abc = a*b*c, temp = abc, cnt;
		
		for(int i=0; i<=9; i++) {
			temp = abc;
			cnt=0;
			while(temp > 0) {
				int num = temp % 10;
				if(num == i) {
					cnt++;
				}
				temp /= 10;
			}
			System.out.println(cnt);
		}
		
		scr.close();

	}

}
