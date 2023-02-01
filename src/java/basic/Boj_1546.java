package java.basic;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1546 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		double score[] = new double[N];
		for(int i=0; i<N; i++){
			score[i] = in.nextDouble();
		}
		Arrays.sort(score);
		double max = score[N-1];
		double result = 0;
		for(int i=0; i<N; i++){
			result += ((score[i]/max)*100);
		}
		System.out.println(result/N);
	}
}
