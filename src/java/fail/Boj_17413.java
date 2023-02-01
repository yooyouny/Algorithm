package java.fail;

import java.util.Scanner;

public class Boj_17413 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String[] arr = sc.nextLine().split(" ");
		StringBuilder sb = new StringBuilder();
		boolean flag = true;

		for(int i=0; i<arr.length; i++){
			if(check(arr[i])) {
				for(int j=0; j<arr[i].length(); j++){
					sb.append(arr[i].charAt(arr[i].length()-j-1));
				}
			}
			sb.append(" ");
		}

		System.out.println(sb.toString());

	}

	private static boolean check(String s) {
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == '<' || s.charAt(i) == '>')
				return false;
		}
		return true;
	}
}
