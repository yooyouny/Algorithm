package java.basic;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_3052 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] left = new int[1000];
		for(int i=0; i<10; i++){
			left[in.nextInt() % 42]++;
		}
		Arrays.sort(left);
		int result = 0;
		for(int a : left){
			if(a == 0) continue;
			else
				result++;
		}
		System.out.println(result);
	}
}
