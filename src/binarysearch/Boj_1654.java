package binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1654 {
	static int[] lines;
	static int target;
	static int N;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		lines = new int[N];
		target = in.nextInt();
		for(int i=0; i<N; i++){
			lines[i] = in.nextInt();
		}

		Arrays.sort(lines);

		System.out.println(binarySearch(1, 1000000));
	}
	public static long binarySearch(long left, long right) {
		long result = 0;
		while(left<=right){
			long sum = 0;
			long mid = (left + right) / 2;
			for(int i=0; i<N; i++){
				if(lines[i]>mid){
					sum+= lines[i] / mid;
				}
			}
			if(sum>=target){
				left = mid + 1;
				result = mid;
			}else{
				right = mid;
			}
		}
		return result;

	}
}
