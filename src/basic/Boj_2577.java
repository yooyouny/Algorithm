package basic;

import java.util.Scanner;

public class Boj_2577 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] num = new int[10];
		int A = in.nextInt();
		int B = in.nextInt();
		int C = in.nextInt();

		String s = String.valueOf(A*B*C);

		for(int i=0; i<s.length(); i++){
			num[s.charAt(i) - '0']++;
		}
		for(int result : num){
			System.out.println(result);
		}
	}
}
