import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		String str = scr.next();
		int[] alpa = new int[26];
		for(int i=0; i<alpa.length; i++)
			alpa[i] = -1;
		for(int i=0; i<str.length(); i++) {
			int position = (int)str.charAt(i) - 97;
			if(alpa[position] == -1)
				alpa[position] = i;
		}
		for(int i=0; i<alpa.length; i++)
			System.out.print(alpa[i]+ " ");
		scr.close();
	}

}