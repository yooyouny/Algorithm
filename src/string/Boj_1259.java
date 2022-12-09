package string;

import java.util.Scanner;

public class Boj_1259 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true){
			String input = sc.nextLine();
			int N = input.length();
			boolean result = true;
			if(input.equals("0")) break;

			for(int i=0; i<N/2; i++){
				if(input.charAt(i) != input.charAt(N-i-1)) {
					result = false;
					break;
				}
			}

			if (result) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}

}
