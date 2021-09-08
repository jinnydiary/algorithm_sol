package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

//백준 1541번 잃어버린 괄호(0908)
public class Main_1541 {

	static ArrayList<String> operator;
	static ArrayList<Integer> number;
	static Stack<Integer> calculate;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		operator = new ArrayList<>();
		number = new ArrayList<>();
		
		//숫자와 연산자 분리
		int i=0, j=0;
		while(true) {
			if(str.charAt(j) == '+' || str.charAt(j) == '-' ) {
				number.add(Integer.parseInt(str.substring(i, j)));
				i = j++;
				operator.add(str.substring(i, j));
				i = j;
			}else {
				j++;
				if(j == str.length()) {
					number.add(Integer.parseInt(str.substring(i, j)));
					break;
				}
			}
		}
		
		calculate = new Stack<>();
		calculate.push(number.remove(0));
		calcPlus(0);

		calcMinus(calculate.size());
		
		System.out.println(calculate.pop());

	}
	
	//뺼셈들 계산
	private static void calcMinus(int size) {
		if(size == 1) return;
		int num1, num2, sum;
		
		//맨 앞 숫자를 제외하고는 다 더해준다.
		if(calculate.size() > 2) {
			num2 = calculate.pop();
			num1 = calculate.pop();	
			sum = num1 + num2;
		}else {
			num2 = calculate.pop();
			num1 = calculate.pop();
			sum = num1 - num2;
		}
		calculate.push(sum);		
		calcMinus(size-1);
	}

	//덧셈 모두 더하기
	private static void calcPlus(int cnt) {
		if(cnt >= operator.size()) return;
		
		int num1 = number.get(cnt);
		String opt = operator.get(cnt);
		
		//덧셈일 경우
		if(opt.equals("+")) {
			int num2 = calculate.pop();
			int sum = num1 + num2;
			calculate.push(sum);
		}else //뺄셈일 경우
			calculate.push(num1);
		
		calcPlus(cnt+1);
	}

}
