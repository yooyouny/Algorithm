package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_4153 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String input= br.readLine();
			if(input.equals("0 0 0"))
				return;

			StringTokenizer st = new StringTokenizer(input);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			double powA = Math.pow(a,2);
			double powB = Math.pow(b,2);
			double powC = Math.pow(c,2);

			if(powA + powB == powC || powC + powB == powA || powA+powC == powB){
				System.out.println("right");
			}else{
				System.out.println("wrong");
			}
		}
	}
}
