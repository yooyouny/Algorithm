package math;

import java.util.Scanner;

public class Boj_1978 {

	static boolean nums[];
	private static boolean isPrime(int n){
		if(n == 1) return false;
		for(int i=2; i<n; i++){
			if(n % i == 0) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = 0;

		for(int i=0; i<N; i++) {
			if (isPrime(sc.nextInt()))
				answer++;
		}
		System.out.println(answer);
	}
}
