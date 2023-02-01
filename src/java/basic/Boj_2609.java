package java.basic;

import java.util.Scanner;

public class Boj_2609 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();

		int result = gcd(A, B);

		System.out.println(result);
		System.out.println(A*B / result);
	}

	private static int gcd(int A, int B){
		if(B == 0) return A;
		return gcd(B, A % B);
	}

}
