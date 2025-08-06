import java.io.*;
import java.util.*;

class Node {
    char type;
    Long amount;
    int island;

    public Node(char type, Long amount, int island) {
        this.type = type;
        this.amount = amount;
        this.island = island;
    }
}

public class Main {
    private static Map<Integer, ArrayList<Node>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =  Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            char type = st.nextToken().charAt(0);
            Long amount = Long.parseLong(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            map.putIfAbsent(p, new ArrayList<>());
            map.putIfAbsent(i, new ArrayList<>());

            map.get(p).add(new Node(type, amount, i));
        }


        System.out.println(DFS(1));
        br.close();
    }


    // 일단 DFS 확정
    public static long DFS(int island) {
        // 양 수
        long total= 0;

        // 전 섬 돌기
        for (Node node : map.get(island)) {
            long prvTotal = DFS(node.island);
            // 양
            if (node.type == 'S') {
                prvTotal += node.amount;
            } else { // 늑대
                prvTotal -= node.amount;
                if (prvTotal < 0) prvTotal = 0;
            }

            total += prvTotal;
        }

        return total;
    }
}