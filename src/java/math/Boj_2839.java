package java.math;

import java.util.Scanner;

public class Boj_2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		while(true){
			if(N % 5 == 0) {
				int value = N / 5;
				cnt += value;
				N -= value;
			}else if(N % 3 == 0){
				int value = N / 3;
				cnt += value;
				N -= value;
			}
			else{
				System.out.println(-1);
				break;
			}
		}
	}

}
