package java.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_2146 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> cards = new LinkedList<>();
		for(int i=1; i<=N; i++){
			cards.offer(i);
		}
		while(!cards.isEmpty()){
			if (cards.size() == 1) {
				System.out.println(cards.peek());
				break;
			}

			cards.poll();

			cards.offer(cards.poll());
		}
	}
}
