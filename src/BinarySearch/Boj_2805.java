package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2805 {
	static int[] trees;
	static int target;
	static int N;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		target = sc.nextInt();

		trees = new int[N];
		for(int i=0; i<N; i++){
			trees[i] = sc.nextInt();
		}

		Arrays.sort(trees);
		StringBuffer sb = new StringBuffer();
		sb.append(binarySearch(0, trees[N-1]));
		System.out.println(sb);

	}
	private static long binarySearch(long left, long right) {
		long mid = 0;
		long result = 0;
		while(left <= right){
			System.out.println(left +" "+ right+" "+mid);
			mid = (left + right) / 2;
			long sum = 0;
			for(int i=0; i<N; i++){
				if(trees[i] > mid){
					sum += trees[i] - mid;
				}
			}
			if(sum >= target){
				left = mid + 1;
				result = mid;
			}else
				right = mid - 1;
		}
		return result;
	}
}
