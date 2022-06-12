import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr  = new Scanner(System.in);
		int[] num = new int[10];
		int[] cnt = new int[42];
		for(int i = 0; i < num.length; ++i) {
			num[i] = scr.nextInt();
			++cnt[num[i] % 42];
		}
		
		int count = 0;
		for(int i = 0; i < cnt.length; ++i) {
			if(cnt[i] == 0)
				continue;
			else if(cnt[i] > 0)
				++count;
		}
		System.out.print(count);
		scr.close();
	}

}