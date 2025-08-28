import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static Set<Integer> list = null;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new HashSet<>();
        for(int i=1; i<=N; i++){
            list.add(i);
        }

        Set<Integer> visited = null;
        List<Integer> list = null;
        for(int i=1; i<=N; i++){
            list = new ArrayList<>();
            visited = new HashSet<>();
            series(i, 0, visited);
        }
    }

    private static void series(int cur, int depth, Set<Integer> visited) {

    }
}
