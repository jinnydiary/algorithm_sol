import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int[] m = new int[8];
		for(int i=0; i<m.length; i++)
			m[i] = scr.nextInt();
		
		boolean check1 = false, check2 = false;
		for(int i=0; i<m.length; i++) {
			if(m[i] == i+1)
				continue;
			else {
				check1 = true;
				break;
			}
		}
		
		if(check1) {
			for(int i=m.length-1; i>=0; i--) {
				if(m[i] == m.length-i)
					continue;
				else {
					check2 = true;
					break;
				}
			}
			if(check2)
				System.out.print("mixed");
			else
				System.out.print("descending");
		}else
			System.out.print("ascending");
		scr.close();
	}

}
