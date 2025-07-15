import java.util.*;
import java.io.*;

// Node 클래스
class Node {
    int paper;
    int index;
    public Node(int paper, int index) {
        this.paper = paper;
        this.index = index;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // ArrayList
        List<Node> lst = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            lst.add(new Node(Integer.parseInt(st.nextToken()), i + 1));
        }

        // 맨 앞 풍선 부터
        int index = 0;

        // lst가 빌때까지 while 반복
        while(!lst.isEmpty()) {
            Node current = lst.remove(index);

            sb.append(current.index).append(" ");
            if(lst.isEmpty())   break;

            int move = current.paper;
            // 종에 적힌 수 만큼 이동
            if(move > 0) {
                index = (index + move -1) % lst.size();
            } else {
                index = (index + move + lst.size()) % lst.size();
            }
        }

        System.out.println(sb);
    }
}
