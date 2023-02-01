package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_1620 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		Map<String, Integer> pocketmon = new HashMap<>();
		String[] mapped = new String[n + 1];

		for (int i = 1; i <= n; i++) {
			String name = br.readLine();
			pocketmon.put(name, i); //키가 이름 값이 도감번호
			mapped[i] = name;
		}

		for (int i = 1; i <= r; i++) {
			String input = br.readLine();
			if (isNumber(input)) { // 숫자면 문자
				sb.append(mapped[Integer.parseInt(input)]);
			} else { //문자면 숫자가 나와야함
				sb.append(pocketmon.get(input));
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean isNumber(String input) {
		if (Character.isDigit(input.charAt(0)))
			return true;

		return false;
	}

}
