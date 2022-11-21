package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 복습
 */
public class Boj_10816 {
	static int[] A;
	static int[] B;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];

		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);	// 이분 탐색을 하기 위해서는 반드시 정렬되어있어야 한다.

		int M = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < M; i++) {
			int key = sc.nextInt();

			//중복 원소에 대한 길이 = 상한 - 하한
			sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
		}
		System.out.println(sb);
	}


	//찾고자 하는 값 이상의 값이 처음으로 나타나는 위치
	private static int lowerBound(int[] arr, int key) {
		int left=0;
		int right=arr.length;

		while(left<right) {
			int mid=(left+right)/2;

			if(key<=arr[mid]) { //상한선 내리기
				right=mid;
			}
			else {
				left=mid+1;
			}
		}

		return left;
	}

	//찾고자 하는 값 초과의 값이 처음으로 나타나는 위치
	private static int upperBound(int[] arr, int key) {
		int left=0;
		int right=arr.length;

		while(left<right) {
			int mid=(left+right)/2;

			if(key<arr[mid]) {
				right=mid;
			}
			else {//하한선 올리기
				left=mid+1;
			}
		}

		return left;
	}
}


