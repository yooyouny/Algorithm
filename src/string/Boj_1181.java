package string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Boj_1181 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] input = new String[N];
		sc.nextLine(); //nextInt쓰고 nextLine하기전에 개행문자 없애주기
		for(int i=0; i<N; i++){
			input[i] = sc.nextLine();
		}
		Arrays.sort(input, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) { //반환값이 양수면 위치를 바꾸고 음수면 바꾸지않음

				if(o1.length() == o2.length()){//길이가 같으면 사전 순
					return o1.compareTo(o2);
				}else{
					return o1.length()-o2.length();
				}
			}
		});

		System.out.println(input[0]);

		for(int i=1; i<N; i++){
			if(!input[i].equals(input[i-1]))
				System.out.println(input[i]);
		}
	}
}
