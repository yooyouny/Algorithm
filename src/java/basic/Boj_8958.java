package java.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_8958 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());


		for (int i = 0; i < N; i++) {
			String score = br.readLine();
			boolean prev = false;
			int sum = 0;
			int result = 1;

			for (int j = 0; j < score.length(); j++) {
				char input = score.charAt(j);

				if (prev) {
					if (input == 'O') {
						sum += result;
						result++;
						prev = true;
					} else {
						result = 1;
						prev = false;
					}
				} else {
					if (input == 'O') {
						sum += result;
						result++;
						prev = true;
					} else {
						result = 1;
						prev = false;
					}
				}
			}

			System.out.println(sum);
		}
	}
}
