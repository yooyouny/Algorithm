package fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1966 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		int priority[] = new int[N];

		int count = sc.nextInt(); //큐에 들어있는 문서의 개수
		int check = sc.nextInt(); //궁금한 순서

		for(int i=0; i<count; i++) {
			int input = sc.nextInt();
			queue.offer(input);
			priority[i] = input;
		}

		Arrays.sort(priority); //오름차순 정렬


	}

}
