import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int h = scr.nextInt();
		int m = scr.nextInt();
		int alarmH = h;
		int alarmM = m - 45;
		
		if(alarmM < 0) {
			--alarmH;
			alarmM += 60;
			if(alarmH < 0)
				alarmH = 23;
		}
		
		System.out.print(alarmH + " " +alarmM);
		scr.close();
	}

}
