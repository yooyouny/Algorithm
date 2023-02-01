package java.bruteforce;

import java.util.Scanner;

public class Boj_2798 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int cards[] = new int[N];
		int target = in.nextInt();
		for(int i=0; i<N; i++){
			cards[i] = in.nextInt();
		}

		int result = 0;
		for(int i=0; i<N; i++){
			for(int j=i+1; j<N; j++){
				for(int k=j+1; k<N; k++){
					int plus = cards[i] + cards[j] + cards[k];
					if(plus <= target && result < plus) //블랙잭보다 작거나 같고 근사치보다 큰것
						result = plus;
				}
			}
		}
		System.out.println(result);
	}
}
