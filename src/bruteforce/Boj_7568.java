package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_7568 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int people[][] = new int[N][2];

		for(int i=0; i<N; i++){
			String[] input = br.readLine().split(" ");
			people[i][0] = Integer.parseInt(input[0]);
			people[i][1] = Integer.parseInt(input[1]);
		}

		for(int i=0; i<N; i++){
			int rank = 1;
			for(int j=0; j<N; j++){
				if(i == j) continue;
				if(people[i][0] < people[j][0] && people[i][1] < people[j][1])
					rank++;
			}
			System.out.print(rank + " ");
		}

	}

}
