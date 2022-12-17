package stack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Boj_10773 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int result = 0;
		Stack<Integer> stack = new Stack<>();

		for(int i=0; i<N; i++){
			int input = sc.nextInt();
			if(input == 0) stack.pop();
			else
				stack.push(input);
		}

		for(int value : stack){
			result += value;
		}

		System.out.println(result);
	}

}
