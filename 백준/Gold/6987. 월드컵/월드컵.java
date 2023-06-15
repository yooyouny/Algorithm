import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int[][] score = new int[6][3];
	static int[] team1 = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
	static int[] team2 = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
	private static boolean chkScore(int round) {
		if (round == 15)
			return true;
		//승 패
		if (score[team1[round]][0] > 0 && score[team2[round]][2] > 0) {// 승패결과를 가정하고
			score[team1[round]][0]--;
			score[team2[round]][2]--;
			if (chkScore(round + 1))
				return true;
			score[team1[round]][0]++;
			score[team2[round]][2]++;
		}
		//비기는 경우
		if (score[team1[round]][1] > 0 && score[team2[round]][1] > 0) {
			score[team1[round]][1]--;
			score[team2[round]][1]--;
			if (chkScore(round + 1))
				return true;
			score[team1[round]][1]++;
			score[team2[round]][1]++;
		}
		//패 승
		if (score[team1[round]][2] > 0 && score[team2[round]][0] > 0) {// 승패결과를 가정하고
			score[team1[round]][2]--;
			score[team2[round]][0]--;
			if (chkScore(round + 1))
				return true;
			score[team1[round]][2]++;
			score[team2[round]][0]++;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < 4; tc++) {
			StringTokenizer stk = new StringTokenizer(bfr.readLine());
			boolean result = true;
			int total = 0;
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					score[i][j] = Integer.parseInt(stk.nextToken());
					total += score[i][j];
				}
				if (score[i][0] + score[i][1] + score[i][2] != 5) {
					result = false;
					break;
				}
			}
			if(total > 30) {
				result = false;
			}else {
				result = chkScore(0);
			}
			sb.append(result ? 1 : 0);
			sb.append(' ');
		}
		System.out.println(sb.toString());
	}
}