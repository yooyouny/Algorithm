package java.stack;

import java.util.Scanner;
import java.util.Stack;

public class Boj_9093 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			String s = sc.nextLine() + "\n";
			Stack<Character> stack = new Stack<>();
			for(char input : s.toCharArray()){
				if(input == ' ' || input == '\n') {
					while(!stack.isEmpty())
						sb.append(stack.pop());
					sb.append(input);
				}else
					stack.push(input);
			}
		}
		System.out.println(sb);
	}
}
