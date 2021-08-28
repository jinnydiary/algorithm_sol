package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

//백준 - 2504번 괄호의 값
public class Main_2504 {
	
	static Stack<Character> stack; //괄호 넣어줄 스택
	static Stack<Integer> num; //슷자 넣어줄 스택
	static HashMap<Character, Character> map = new HashMap<Character, Character>(); //key와 value를 이용해 괄호 짝을 맞춰줌
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] ch = br.readLine().toCharArray();
		map.put(')', '(');
		map.put(']', '[');
		
		stack = new Stack<Character>();
		num = new Stack<Integer>();
		
		calculate(ch, 0);
		
		//스택 크기가 1이고 그 값이 n일 경우(n은 숫자를 의미)
		if(stack.size() == 1 && stack.peek() == 'n') System.out.println(num.pop());
		else System.out.println(0);

	}
	
	private static void calculate(char[] ch, int i) {
		if(i >= ch.length) return; //괄호 모두 끝나면 stop
		int t1 = 0, t2 = 0; //계산 과정 중 스택에서 뽑은 숫자들 잠시 담아둘 변수
		
		//스택이 비워져있을 경우
		if(stack.isEmpty()) {
			stack.push(ch[i]);
		
		//괄호의 짝이 맞을 경우( (), [] )
		}else if(stack.peek() == map.get(ch[i])) {
			char c = stack.pop();
			t1 = (c == '(') ? 2 : 3;
			if(!stack.isEmpty() && stack.peek() == 'n') { //그다음 숫자가 또있을 경우(더해야 하는 경우)
				stack.pop();
				t2 = num.pop();
			}
			num.push(t1+t2);
			stack.push('n'); //n은 괄호 사이에 숫자가 있다는 의미
		
		//닫는 괄호를 넣으려는데 숫자가 있을 경우
		}else if((ch[i] == ')' || ch[i] == ']') && stack.peek() == 'n') {
			stack.pop();
			t1 = num.pop();
			if(!stack.isEmpty() && stack.peek() == map.get(ch[i])) {
				char c = stack.pop();
				t1 *= (c == '(') ? 2 : 3;
				if(!stack.isEmpty() && stack.peek() == 'n') {
					stack.pop();
					t2 = num.pop();
				}
				num.push(t1+t2); //숫자는 숫자 스택에 push
				stack.push('n'); //숫자가 있다는 의미인 n을 stack에 push
			}	
		}else
			stack.push(ch[i]); //위 조건들 모두 해당하지 않는 경우 push
		
		calculate(ch, ++i); //다음 괄호로 넘어가기
		
	}

}
