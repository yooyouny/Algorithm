package java.fail;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1966 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		Integer priority[] = new Integer[N];

		int count = sc.nextInt(); //큐에 들어있는 문서의 개수
		int check = sc.nextInt(); //궁금한 문서의 순서

		for (int i = 0; i < count; i++) {
			int input = sc.nextInt();
			queue.offer(input);
			priority[i] = input;
		}

		int print = 0;

		while (true) {

			if (print == check)
				Arrays.sort(priority, Collections.reverseOrder());
			int max = priority[0];

			for (int i = 0; i < count; i++) {
				if (queue.peek() == max) {
					print++;
				} else {
					queue.offer(queue.poll());
				}
			}
		}
	}
}
