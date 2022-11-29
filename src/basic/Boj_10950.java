package basic;

import java.io.IOException;
import java.util.Scanner;

public class Boj_10950 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while(N-- > 0){
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(a+b);
		}
	}

}
