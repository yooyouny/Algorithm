package java.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Boj_2869 {

	public static void main(String[] args) throws IOException { //scanner쓰면 무조건 오류
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int up = Integer.parseInt(st.nextToken());
		int down = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());

		int day = (length - down) / (up - down);
		if ((length - down) % (up - down) != 0)
			day++;

		System.out.println(day);
	}


		/*
		int height = 0;
		int oneday = up - down;
		int day=0;
		while(height < V){
			day++;
			height += up;
			if(height >= V) break;
			height -= down;
		}
		System.out.println(day);
		 */
	}


