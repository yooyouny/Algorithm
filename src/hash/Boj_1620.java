package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_1620 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		Map<String, Integer> pocketmon = new HashMap<>();
		String[] mapped = new String[n + 1];

		for (int i = 1; i <= n; i++) {
			String input = br.readLine();
			pocketmon.put(input, i);
			mapped[i] = input;
		}

		for (int i = 1; i <= r; i++) {
			String input = br.readLine();
			if (isNumber(input)) {
				System.out.println(mapped[i]);
			} else {
				System.out.println(pocketmon.get(input));
			}
		}
	}

	private static boolean isNumber(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i)))
				return false;
		}
		return true;
	}

}
