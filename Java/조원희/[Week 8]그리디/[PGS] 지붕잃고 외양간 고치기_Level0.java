import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M =  Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[C];
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int total = arr[C - 1] - arr[0] + 1;

        int[] board = new int[C - 1];
        for (int i = 1; i < C; i++) {
            board[i - 1] = arr[i] - arr[i - 1] - 1;
        }

        Arrays.sort(board);
        for(int i = 0; i < M - 1; i++) {
            total -= board[board.length - 1 - i];
        }

        System.out.println(total);
        br.close();
    }
}