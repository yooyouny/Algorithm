package java.basic;

import java.util.Scanner;

public class Boj_2920 {
	public static boolean check(int[] input, int[] scending){
		for(int i=0; i<8; i++){
			if(input[i] == scending[i])
				continue;
			else
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] scending = new int[8];
		int[] ascending = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
		int[] descending = new int[]{8, 7, 6, 5, 4, 3, 2, 1};

		for(int i=0; i<8; i++){
			scending[i] = sc.nextInt();
		}

		if(check(scending, ascending)){
			System.out.println("ascending");
		}else if (check(scending, descending)) {
			System.out.println("descending");
		}else{
			System.out.println("mixed");
		}

	}
}
