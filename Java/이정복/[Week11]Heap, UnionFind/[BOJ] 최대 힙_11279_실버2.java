package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Maxheap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int op = 0;

        // 최소힙 문제와 완전히 동일하지만, Collections.reverseOrder()를 줘서 최대힙으로 사용
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<count; i++){
            op = Integer.parseInt(br.readLine());

            if (op == 0) {
                if (heap.isEmpty()){
                    System.out.println(0);
                } else {
                    System.out.println(heap.poll());
                }
            } else {
                heap.add(op);
            }
        }
    }
}
