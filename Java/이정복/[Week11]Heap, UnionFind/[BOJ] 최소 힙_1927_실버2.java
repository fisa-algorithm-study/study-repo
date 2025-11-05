package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Minheap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int op = 0;

        // PriorityQueue의 Default 설정이 최소힙
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i=0; i<count; i++){
            op = Integer.parseInt(br.readLine());

            // 0이라면 최소값(빈 힙일 때 0) 출력
            if (op == 0) {
                if (heap.isEmpty()){
                    System.out.println(0);
                } else {
                    System.out.println(heap.poll());
                }
            } else {
                // 0이 아니라면 힙에 추가
                heap.add(op);
            }
        }
    }
}
