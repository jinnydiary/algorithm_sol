package bj;

//백준 15596번 정수 N개의 합(1010)
public class Main_15596 {
	long sum(int[] a) {
        long ans = 0;
        for(int i=0; i<a.length; i++)
        	ans += a[i];
        return ans;
    }
}
