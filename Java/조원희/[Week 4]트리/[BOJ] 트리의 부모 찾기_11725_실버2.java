import java.io.*;
import java.util.*;

public class Main {
    private static int[] arr;
    private static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N =  Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u =  Integer.parseInt(st.nextToken());
            int v =  Integer.parseInt(st.nextToken());

            map.putIfAbsent(u, new ArrayList<>());
            map.putIfAbsent(v, new ArrayList<>());

            map.get(u).add(v);
            map.get(v).add(u);
        }

        arr = new int[N + 1];

        tree(1, 0);
        for(int i = 2; i <= N; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void tree (int number, int parent_node) {
        arr[number] = parent_node;
        for(int key: map.get(number)) {
            if(arr[key] != 0)   continue;
            tree(key, number);
        }
    }
}