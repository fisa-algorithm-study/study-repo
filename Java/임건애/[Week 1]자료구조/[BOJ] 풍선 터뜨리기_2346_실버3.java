import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // LinkedList로 구현했는데 메모리 초과... 검색해보니 ArrayDeque로 생성하면 괜찮음(포인터, 노드 X)
        // [index, move]
        Deque<int[]> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int move = Integer.parseInt(st.nextToken());
            deque.add(new int[]{i, move});
        }

        StringBuilder result = new StringBuilder();

        while (!deque.isEmpty()) {
            int[] first = deque.pollFirst();
            result.append(first[0]);

            if (!deque.isEmpty()) {
                result.append(" ");
            }

            int move = first[1];
            if (deque.isEmpty()) break;

            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < -move; i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }

        System.out.println(result.toString().trim());
    }
}