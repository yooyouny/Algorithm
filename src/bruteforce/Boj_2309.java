package bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2309 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] height = new int[9];
		int sum = 0;
		for(int i=0; i<9; i++){
			height[i] = sc.nextInt();
			sum += height[i];
		}
		for(int i=0; i<9; i++){
			for(int j=i+1; j<8; j++){
				if(sum - height[i] - height[j] == 100){
					height[i] = 0;
					height[j] = 0;
					Arrays.sort(height);
					for(int k=2; k<9; k++){
						System.out.println(height[k]);
					}
				}
			}
		}
	}
}
